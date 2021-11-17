package models;

public class User {

	private String name;
	private String email;
	private int nombreArticle;
	private String role;
	
	public User(String name, String email, int nombreArticle, String role) {
		this.name = name;
		this.email = email;
		this.nombreArticle = nombreArticle;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNombreArticle() {
		return nombreArticle;
	}

	public void setNombreArticle(int nombreArticle) {
		this.nombreArticle = nombreArticle;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	} 
	
	
}
