package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import reply.service.ReplyAddService;

public class ReplyAddHandler implements CommandHandler{
	private ReplyAddService addService = new ReplyAddService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");
		
		int articleNo = Integer.parseInt(req.getParameter("no"));
		String userId = user.getId();
		String body = req.getParameter("body");
		addService.add(userId, articleNo, body);
		
		
		return "replyAddSuccess";
	}
}
