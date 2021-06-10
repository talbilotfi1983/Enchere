package fr.encheres.bo;

public class Category {
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", libelle=" + libelle + "]";
	}
	private int idCategory;
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Category(int idCategory, String libelle) {
		super();
		this.idCategory = idCategory;
		this.libelle = libelle;
	}
	public Category() {
		
	}
	private String libelle;

}
