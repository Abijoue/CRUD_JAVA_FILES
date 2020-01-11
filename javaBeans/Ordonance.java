package javaBeans;

import java.util.Date;

public class Ordonance {
   private int numero;
   private String traitement;
   private String observation;
   private Date date;
   	
   	//getters é setters
		public int getNumero() {
			return numero;
		}
		
		
		public void setNumero(int numero) {
			this.numero = numero;
		}
		
		
		public String getTraitement() {
			return traitement;
		}
		
		
		public void setTraitement(String traitement) {
			this.traitement = traitement;
		}
		
		
		public String getObservation() {
			return observation;
		}
		
		
		public void setObservation(String observation) {
			this.observation = observation;
		}
		
		
		public Date getDate() {
			return date;
		}
		
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		//constructor

		public Ordonance(int numero, String traitement, String observation, Date date) {
			this.numero = numero;
			this.traitement = traitement;
			this.observation = observation;
			this.date = date;
		}

}