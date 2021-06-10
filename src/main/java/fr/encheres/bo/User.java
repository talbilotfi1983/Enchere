package fr.encheres.bo;

public class User {
	private int idUser;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String numero;
	private String adresse;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean admin;
	private String civilite;
	private boolean active;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", telephone=" + telephone + ", numero=" + numero + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit + ", admin="
				+ admin + ", civilite=" + civilite + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public User(String civilite, String pseudo, String nom, String prenom, String email, String telephone,
			String numero, String adresse, String codePostal, String ville, String motDePasse, int credit,
			boolean admin,boolean active) {
		super();
		this.civilite = civilite;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.numero = numero;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.admin = admin;
		this.active=active;
	}

	public User(int idUser, String civilite, String pseudo, String nom, String prenom, String email, String telephone,
			String numero, String adresse, String codePostal, String ville, String motDePasse, int credit,
			boolean admin,boolean active) {
		this(civilite, pseudo, nom, prenom, email, telephone, numero, adresse, codePostal, ville, motDePasse, credit,
				admin,active);
		this.idUser = idUser;

	}

	public User() {
		super();
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
