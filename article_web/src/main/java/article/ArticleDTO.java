package article;

public class ArticleDTO {
	private int articleId;
	private String articleTitle;
	private String articleBody;
	
	
	public ArticleDTO() {}
	
	public ArticleDTO(int articleId, String articleTitle, String articleBody) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleBody = articleBody;
	}


	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}


	public String getArticleTitle() {
		return articleTitle;
	}


	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}


	public String getArticleBody() {
		return articleBody;
	}


	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}
	
	
	
	
}
