package javaBeans;

public class Acte {
   private String libelle;
   private double prix;
   
   //getters & setters
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	//constructor
	public Acte(String libelle, double prix) {
		this.libelle = libelle;
		this.prix = prix;
	}
	@Override
	public String toString() {
		return  libelle + " | " + prix + " DH" ;
	}
	

   
}