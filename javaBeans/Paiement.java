package javaBeans; 

import java.util.Date;

public class Paiement {
   private double montantaPaye;
   private Date date;
   
   //getters and setters
	public double getMontantPaye() {
		return montantaPaye;
	}
	
	
	public void setMontantPaye(double montantPaye) {
		this.montantaPaye = montantPaye;
	}
		
	public Date getDate() {
		return date;
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	//constructor
	public Paiement(double montantPaye, Date date) {
		this.montantaPaye = montantPaye;
		this.date = date;
	}

	//methods
	public double calcReste() {
	      return 0;
	   }


	@Override
	public String toString() {
		return montantaPaye + " | " + date ;
	}


	
}