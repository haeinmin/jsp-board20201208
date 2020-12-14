package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "loginForm";
	private LoginService loginService = new LoginService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password==null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			User user = loginService.login(id, password);
			req.getSession().setAttribute("authUser", user);      //서블릿에서는 세션 바로사용불가. req에서 받아와야함. 로그아웃하려면 authUser 삭제하거나,세션 자체를 없애야. 
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			return null;
		} catch (LoginFailException e) {
			e.printStackTrace();
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str==null? null : str.trim();
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return FORM_VIEW;
	}
	
	
	

}
