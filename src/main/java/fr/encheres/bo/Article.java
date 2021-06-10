package fr.encheres.bo;

import java.sql.Timestamp;

public class Article {
	private int idArticle;
	

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDebuEnchere() {
		return debuEnchere;
	}

	public void setDebuEnchere(Timestamp debuEnchere) {
		this.debuEnchere = debuEnchere;
	}

	public Timestamp getFinEnchere() {
		return finEnchere;
	}

	public void setFinEnchere(Timestamp finEnchere) {
		this.finEnchere = finEnchere;
	}

	public int getMise_a_prix() {
		return mise_a_prix;
	}

	public void setMise_a_prix(int mise_a_prix) {
		this.mise_a_prix = mise_a_prix;
	}

	public int getPrix_de_vente() {
		return prix_de_vente;
	}

	public void setPrix_de_vente(int prix_de_vente) {
		this.prix_de_vente = prix_de_vente;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

	public int getIdAcheteur() {
		return idAcheteur;
	}

	public void setIdAcheteur(int idAcheteur) {
		this.idAcheteur = idAcheteur;
	}

	public Article(String nomArticle, String description, Timestamp finEnchere, int prix_de_vente, int idCategorie,
			int idVendeur) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.finEnchere = finEnchere;
		this.prix_de_vente = prix_de_vente;
		this.idCategorie = idCategorie;
		this.idVendeur = idVendeur;

	}
	public Article(String nomArticle, String description, Timestamp finEnchere, int prix_de_vente, int idCategorie,
			String  pseudo, String image ) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.finEnchere = finEnchere;
		this.prix_de_vente = prix_de_vente;
		this.idCategorie = idCategorie;
		this.setPseudo(pseudo);
		this.image = image;

	}

	public Article(String nomArticle, String description, Timestamp debuEnchere, Timestamp finEnchere, int mise_a_prix,
			int prix_de_vente, int idCategorie, int idVendeur) {
		this(nomArticle, description, finEnchere, prix_de_vente, idCategorie, idVendeur);
		this.debuEnchere = debuEnchere;
		this.mise_a_prix = mise_a_prix;
	}

	public Article() {
	}

	private String nomArticle;
	private String description;
	private Timestamp debuEnchere;
	private Timestamp finEnchere;
	private int mise_a_prix;
	private int prix_de_vente;
	private int idCategorie;
	private int idVendeur;
	private int idAcheteur;
	private String image;
	private String pseudo;

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", debuEnchere=" + debuEnchere + ", finEnchere=" + finEnchere + ", mise_a_prix=" + mise_a_prix
				+ ", prix_de_vente=" + prix_de_vente + ", idCategorie=" + idCategorie + ", idVendeur=" + idVendeur
				+ ", idAcheteur=" + idAcheteur + ", image=" + image + "]";
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

}
