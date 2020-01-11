package javaBeans;

import java.util.Date;

public class Tresorie {
   private double profit;
   private double depenses;
   private Date dateDep;
   
   //getters é setters
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getDepenses() {
		return depenses;
	}
	public void setDepenses(double depenses) {
		this.depenses = depenses;
	}
	public Date getDateDep() {
		return dateDep;
	}
	public void setDateDep(Date dateDep) {
		this.dateDep = dateDep;
	}
	//constructor
	public Tresorie(double profit, double depenses, Date dateDep) {
		this.profit = profit;
		this.depenses = depenses;
		this.dateDep = dateDep;
	}


   
}