package fr.encheres.bo;

public class Autentification {
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String pseudo;
	private String password;
	@Override
	public String toString() {
		return "Autentification [pseudo=" + pseudo + ", password=" + password + "]";
	}
	public Autentification(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}
	public Autentification() {
		super();
	}
	

}
