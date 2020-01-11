package javaBeans;

import java.util.Date;

public class RendezVous {
   private int id;
   private int numero;
   private Date date;
   private int heure;
   
   //getters - setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getHeure() {
			return heure;
		}
		public void setHeure(int heure) {
			this.heure = heure;
		}
		//constructor
		public RendezVous(int id, int numero, Date date, int heure) {
			this.id = id;
			this.numero = numero;
			this.date = date;
			this.heure = heure;
		}

}