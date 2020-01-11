package collections;

import java.util.ArrayList;

public class liste_globale {
	private ArrayList<dossier_patient> global_info ;

	public liste_globale(ArrayList<dossier_patient> global_info) {
		super();
		this.global_info = global_info;
	}

	public ArrayList<dossier_patient> getGlobal_info() {
		return global_info;
	}

	public void setGlobal_info(ArrayList<dossier_patient> global_info) {
		this.global_info = global_info;
	}
	
}
