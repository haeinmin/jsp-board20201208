package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.User;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class RemoveMemberService {
	private MemberDao memberDao = new MemberDao();
	
	public void removeMember(User user, String password)  {
		
		Connection con = null;
		
		// 0. fetch connection
		// 1. fetch member object by using selecyById
		try {
			con = ConnectionProvider.getConnection();
			Member member = memberDao.selectById(con, user.getId());
			// 2. if there's no such member, throw MemberNotFoundException
			if (member == null) {
				throw new MemberNotFoundException();
			}
			// 3. if member exists, proceed
			// 4. check if password and member.password match
			if (!member.matchPassword(password)) {
				// 5. if not, throw InvalidPasswordException
				throw new InvalidPasswordException();
			}
			// 6. run delete()
			memberDao.delete(con, member.getId());
//			con.commit();             // unnecessary cause there's only one dml
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
//			JdbcUtil.rollback(con);
		} finally {
			JdbcUtil.close(con);
		}
		
		
		
	
	}
}
