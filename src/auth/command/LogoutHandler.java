package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false); //getSession()에 파라미터가 있을 경우 항시 세션 생성되는 것이 아님. 세션이 있는 경우 생성 안 함.
		if (session != null) {     //최초 로그인했을 때는 로그인하지 않은 상태. 
			session.invalidate();    //세션 자체를 없애버리면서 정보를 날림 
		}
		res.sendRedirect(req.getContextPath()+"/index.jsp");
		return null;
	}
}
