package fr.encheres.bo;

public class Adresse {
	private String adresse;
	public Adresse(String adress, String ville2, String codePostal2) {
		this.adresse = adress;
		this.ville = ville2;
		this.codePostal = codePostal2;
	}
	@Override
	public String toString() {
		return "Adresse [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	private String codePostal;
	private String ville;
	

}
