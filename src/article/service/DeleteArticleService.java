package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import auth.service.User;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class DeleteArticleService {
	private MemberDao memberDao = new MemberDao();
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao articleContentDao = new ArticleContentDao();
	
	public void delete(int no, User authUser, String password) {
		Connection con = ConnectionProvider.getConnection();
		
		try {
			con.setAutoCommit(false);
			Member member = memberDao.selectById(con, authUser.getId());
			
			// 같지 않으면
			// throw exception
			if (!member.getPassword().equals(password)) {
				throw new PermissionDeniedException();
			}
			
			// password, user password 같으면
			// articleDao.delete, articleContentDao.delete
			articleDao.delete(con, no);
			articleContentDao.delete(con, no);
			con.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		}
	}
	
	
//	public void remove(DeleteRequest deleteReq) {
//		Connection con = null;
//		
//		try {
//			con = ConnectionProvider.getConnection();
//			con.setAutoCommit(false);
//			
//			Article article = articleDao.selectById(con, deleteReq.getArticleNumber());
//			
//			if (article == null) {
//				throw new ArticleNotFoundException();
//			}
//			
//			if (!canDelete(deleteReq.getId(), article)) {
//				throw new PermissionDeniedException();
//			}
//			
//			articleDao.delete(con, deleteReq.getArticleNumber());
//			con.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			JdbcUtil.rollback(con);
//			throw new RuntimeException(e);
//		} finally {
//			JdbcUtil.close(con);
//		}
//	}
//
//	private boolean canDelete(String deleteUserId, Article article) {
//		return article.getWriter().getId().equals(deleteUserId);
//	}
	
	
}
