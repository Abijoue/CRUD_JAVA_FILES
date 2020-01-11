package collections;

import javaBeans.*;
import java.util.*;

public class dossier_patient {
	
	private Patient patient ;
	private List<Acte> list_acte;
	private List<Avance> list_avance;
	private List<Certificat> list_certificat;
	private List<Consultation> list_consultation;
	private List<Ordonance> list_ordonance;
	private List<Paiement> list_paiment;
	private static int order; //order de patient dans la salle d'attente
	
	
	public dossier_patient(Patient patient, List<Acte> list_acte, List<Avance> list_avance,
			List<Certificat> list_certificat, List<Consultation> list_consultation, List<Ordonance> list_ordonance,
			List<Paiement> list_paiment) {
		this.patient = patient;
		this.list_acte = list_acte;
		this.list_avance = list_avance;
		this.list_certificat = list_certificat;
		this.list_consultation = list_consultation;
		this.list_ordonance = list_ordonance;
		this.list_paiment = list_paiment;
		order++;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Acte> getList_acte() {
		return list_acte;
	}
	public void setList_acte(List<Acte> list_acte) {
		this.list_acte = list_acte;
	}
	public List<Avance> getList_avance() {
		return list_avance;
	}
	public void setList_avance(List<Avance> list_avance) {
		this.list_avance = list_avance;
	}
	public List<Certificat> getList_certificat() {
		return list_certificat;
	}
	public void setList_certificat(List<Certificat> list_certificat) {
		this.list_certificat = list_certificat;
	}
	public List<Consultation> getList_consultation() {
		return list_consultation;
	}
	public void setList_consultation(List<Consultation> list_consultation) {
		this.list_consultation = list_consultation;
	}
	public List<Ordonance> getList_ordonance() {
		return list_ordonance;
	}
	public void setList_ordonance(List<Ordonance> list_ordonance) {
		this.list_ordonance = list_ordonance;
	}
	public List<Paiement> getList_paiment() {
		return list_paiment;
	}
	public void setList_paiment(List<Paiement> list_paiment) {
		this.list_paiment = list_paiment;
	}
	
	public static int getOrder() {
		return order;
	}

	public static void setOrder(int order) {
		dossier_patient.order = order;
	}




}
