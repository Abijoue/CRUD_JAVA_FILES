package javaBeans;

import java.util.Date;

public class Certificat {
   private int numero;
   private Date date;
   private int nbrjour;
   
   //getters and setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbrjour() {
		return nbrjour;
	}
	public void setNbrjour(int nbrjour) {
		this.nbrjour = nbrjour;
	}
	//constructor
	public Certificat(int numero, Date date, int nbrjour) {
		this.numero = numero;
		this.date = date;
		this.nbrjour = nbrjour;
	}


   

}