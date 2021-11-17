package models;

public class Article {

	private String title;
	private User author;
	private String text;
	
	public Article() {
	}

	public Article(String title, User author, String text) {
		super();
		this.title = title;
		this.author = author;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", author=" + author + ", text=" + text + "]";
	}
	
	
}
