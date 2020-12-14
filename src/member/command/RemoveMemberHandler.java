package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import member.service.RemoveMemberService;
import mvc.command.CommandHandler;

public class RemoveMemberHandler implements CommandHandler {
	private static final String FORM_VIEW = "removeMemberForm";
	private RemoveMemberService removeMemberSvc = new RemoveMemberService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// fetch PASSWORD parameter
		String password = req.getParameter("password");
		
		// create Map errors, put it in request attribute
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		// if password==null || password.isEmpty()
		// put (code, true) in errors map
		if (password==null || password.isEmpty())
			errors.put("emptyPw", Boolean.TRUE);
		
		// return FORM_VIEW
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		// in order to fetch user from session, use attribute "authUser" (logged in user cf. LoginHandler)
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		// hand it to service & run removeMemberSvc.removeMember(user, password)
		try {
			removeMemberSvc.removeMember(user, password);
			
			//invalidate session
			session.invalidate();
			
			//return "removeMemberSuccess";
			return "removeMemberSuccess";			
		} catch (InvalidPasswordException e) {
			errors.put("wrongPw", true);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		// use try-catch block for in case of error
		// need two catch blocks (1. no such user 2. wrong password)
		// in catch block,
		// put code in errors map
		// return view name to make it forward to form
		
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
}
