package javaBeans;

import java.util.Date;

public class Antecedents {
   private String libelle;
   private Date date;
   
   //getters and setters
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	//constructor
	
	public Antecedents(String libelle, Date date) {
		this.libelle = libelle;
		this.date = date;
	}
	
}