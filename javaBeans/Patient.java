package javaBeans;

public class Patient implements Comparable<Patient> {
   private String cin;
   private String nom;
   private String prenom;
   private String sexe;
   private int age;
   private String tel;
   private String email;
   /*
   private RendezVous[] rvs;
   private Acte[] actes;
   private Antecedents[] antecedents;
   private Certificat[] certificats;
   private Consultation[] consultations;
   private SalleD_attente salle;
   private Avance[] avances ;
*/

   
   
   //Getters -- Setters
		public String getCin() {
			return cin;
		}
		public void setCin(String cin) {
			this.cin = cin;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getSexe() {
			return sexe;
		}
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		//constructor
		public Patient(String cin, String nom, String prenom, String sexe, int age, String tel, String email) {
			this.cin = cin;
			this.nom = nom;
			this.prenom = prenom;
			this.sexe = sexe;
			this.age = age;
			this.tel = tel;
			this.email = email;
		}
		
		public Patient() {
		}
		/*
		public RendezVous[] getRvs() {
			return rvs;
		}
		public void setRvs(RendezVous[] rvs) {
			this.rvs = rvs;
		}
		
		public Acte[] getActes() {
			return actes;
		}
		public void setActes(Acte[] actes) {
			this.actes = actes;
		}
		public Antecedents[] getAntecedents() {
			return antecedents;
		}
		public void setAntecedents(Antecedents[] antecedents) {
			this.antecedents = antecedents;
		}
		public Certificat[] getCertificats() {
			return certificats;
		}
		public void setCertificats(Certificat[] certificats) {
			this.certificats = certificats;
		}
		public Consultation[] getConsultations() {
			return consultations;
		}
		public void setConsultations(Consultation[] consultations) {
			this.consultations = consultations;
		}
		public SalleD_attente getSalle() {
			return salle;
		}
		public void setSalle(SalleD_attente salle) {
			this.salle = salle;
		}
		public Avance[] getAvances() {
			return avances;
		}
		public void setAvances(Avance[] avances) {
			this.avances = avances;
		}
		*/
		//Comparable
		@Override
		public int compareTo(Patient o) {
			return this.cin.compareTo(o.cin);
		}
		@Override
		public String toString() {
			return cin +" - "+ nom +" - "+ prenom +" - "+ sexe +" - "+ age
					+" - "+ tel + " - "+ email +" - ";
		}
		

}