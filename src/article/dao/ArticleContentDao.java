package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import article.model.ArticleContent;

public class ArticleContentDao {
	public ArticleContent insert(Connection con, ArticleContent content) throws SQLException {
		String sql = "INSERT INTO article_content (article_no, content) VALUES (?,?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				return content;
			} else {
				return null;
			}
			
			
		}
	}
}
