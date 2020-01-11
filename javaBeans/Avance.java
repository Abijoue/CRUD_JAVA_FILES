package javaBeans;

import java.util.Date;

public class Avance {
   private double somme;
   private Date date;
   
   //getters & setters
	public double getSomme() {
		return somme;
	}
	public void setSomme(double somme) {
		this.somme = somme;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	//constructor
	public Avance(double somme, Date date) {
		this.somme = somme;
		this.date = date;
	}
	

   
}