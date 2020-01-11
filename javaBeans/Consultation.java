package javaBeans;

import java.util.Date;

public class Consultation {
   private int id;
   private Date date ;
   private String observation;
   private String docName;
   
   //g é s
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	//constructor

	public Consultation(int id, Date date, String observation, String docName) {
		this.id = id;
		this.date = date;
		this.observation = observation;
		this.docName = docName;
	}
		
   
}