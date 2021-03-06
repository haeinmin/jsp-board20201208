package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {
	private int total; // total article number
	private int currentPage;
	private List<Article> content; //selected data
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if (total != 0) {
			this.totalPages = total / 5;
			if (total % 5 > 0) {
				totalPages++;
			}
			
			this.startPage = (currentPage-1) / 5 * 5 + 1 ;
			this.endPage = Math.min(startPage+5-1, totalPages);
			
		}
	}
	
	public int getTotal() {
		return total;
	}
	public boolean hasArticles() {
		return total > 0;
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<Article> getContent() {
		return content;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	
}
