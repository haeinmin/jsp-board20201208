package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import member.service.InvalidPasswordException;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW="deleteArticleForm";
	private DeleteArticleService deleteArticleService = new DeleteArticleService();
	private ReadArticleService readService = new ReadArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String ,Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		// 현재 로그인한 사용자와 삭제하려는 게시물의 작성자가 같은지 확인 
		User authUser = (User) req.getSession().getAttribute("authUser");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String password = req.getParameter("password");
		ArticleData articleData = readService.getArticle(no, false);

		// 작성자와 사용자 같지 않을 시 throw exception
		if (!authUser.getId().equals(articleData.getArticle().getWriter().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			deleteArticleService.delete(no, authUser, password); //서비스에서 암호 일치하는지 확인 			
		} catch (PermissionDeniedException e) {
			errors.put("invalidPassword", true);
			return FORM_VIEW;
		} catch (Exception e) {
			throw new RuntimeException(e);			
		}
		
		return "deleteArticleSuccess";
		
		
		
//		User authUser = (User) req.getSession().getAttribute("authUser");
//		String password = req.getParameter("password");
//		
//		String noVal = req.getParameter("no");
//		int no = Integer.parseInt(noVal);
//		
//		DeleteRequest deleteReq = new DeleteRequest(authUser.getId(), password, no);
//		
//		Map<String, Boolean> errors = new HashMap<>();
//		req.setAttribute("errors", errors);
//		deleteReq.validate(errors);
//		
//		if (!errors.isEmpty()) {
//			return FORM_VIEW;
//		}
//		
//		try {
//			deleteService.remove(deleteReq);
//			return "deleteArticleSuccess";
//		} catch (InvalidPasswordException e) {
//			errors.put("wrongPw", true);
//			return FORM_VIEW;
//		} catch (ArticleNotFoundException e) {
//			res.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return null;
//		} catch (PermissionDeniedException e) {
//			res.sendError(HttpServletResponse.SC_FORBIDDEN);
//			return null;
//		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		try {
//			String password = req.getParameter("password");
//			String noVal = req.getParameter("no");
//			int no = Integer.parseInt(noVal);
//			
//			ArticleData articleData = readService.getArticle(no, false);
//			User authUser = (User) req.getSession().getAttribute("authUser");
//			if (!canDelete(authUser, articleData)) {
//				res.sendError(HttpServletResponse.SC_FORBIDDEN);
//				return null;
//			}
//			
//			DeleteRequest deleteReq = new DeleteRequest(authUser.getId(), password, no);
//			
//			req.setAttribute("deleteReq", deleteReq);
//			return FORM_VIEW;
//			
//		} catch (ArticleNotFoundException e) {
//			res.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return null;
//		}
		return FORM_VIEW;
	}
	
//	private boolean canDelete(User authUser, ArticleData articleData) {
//		String writerId = articleData.getArticle().getWriter().getId();
//		return authUser.getId().equals(writerId);
//	}
}
