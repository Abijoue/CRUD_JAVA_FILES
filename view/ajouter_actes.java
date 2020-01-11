package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;

import javaBeans.Acte;
import javaBeans.Paiement;
import javaBeans.Patient;


@SuppressWarnings("serial")
public class ajouter_actes extends JFrame implements ActionListener {
	Container container = getContentPane();
	JLabel ActesLabel = new JLabel("liste des actes");
	String elements[] = {
			"SOINS DENTAIRES de CONSERVATEURS",
			"SOINS DENTAIRES de PROPHYLAXIE BUCCO-DENTAIRE",
			"SOINS DENTAIRES - ENDODONTIE",
			"CHIRURGIE BUCCALE - Extractions de dents temporaires",
			"CHIRURGIE BUCCALE - Extractions de dents permanentes",
			"RADIOGRAPHIES - Radios diagnostic de la bouche",
			"Gouttières, contentions",
			"Prothèses conjointes",
			"Prothèses adjointes",
			"Parodontologie",
			"Implantologie"
			};
	JButton saveButton , cancelButton ;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox Actes_list = new JComboBox(elements); 
	@SuppressWarnings("unused")
	public void iniButton(String s) {
		saveButton = new JButton("Enregistrer - "+s);
		cancelButton = new JButton("cancel");
		saveButton.setBounds(100, 140, 100, 30);
		cancelButton.setBounds(250, 140, 100, 30);

		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		container.add(saveButton);
		container.add(cancelButton);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == cancelButton) {
			this.dispose();			
			}
		if (e.getSource() == saveButton) {
			String s = e.getActionCommand();
			System.out.println("----Save Acte -----"+s.split("-", 2)[1]);
			
			Date date = new Date();
			Paiement pai = new Paiement(prix(), date);
			Acte c = new Acte((String) Actes_list.getSelectedItem(), prix());
		try {
			FileWriter(s.split("-", 2)[1].trim(),c,pai);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	           this.dispose(); 		
	           
	}
	

		
	}
	
	public void setLayoutManager() {
	container.setLayout(null);
	}
	public void setLocationAndSize() {
			
	
	ActesLabel.setBounds(50, 40, 100, 30);
	Actes_list.setBounds(50, 80, 400, 30);
	

}
	public void addComponentsToContainer() {
	
		container.add(ActesLabel);
		container.add(Actes_list);
				
		
	}

	public double prix() {
		String selected = (String) Actes_list.getSelectedItem();
		if (selected.equals(elements[0]) || selected.equals(elements[1]) || selected.equals(elements[2])) {
			return 200;
		}else if (selected.equals(elements[3])) {
			return 250;
		}else if (selected.equals(elements[4])) {
			return 300;
		}else if (selected.equals(elements[5])) {
			return 500;
		}else if (selected.equals(elements[6])) {
			return 5000;
		}else if (selected.equals(elements[7])) {
			return 3000;
		}else if (selected.equals(elements[8])) {
			return 4000;
		}else if (selected.equals(elements[9])) {
			return 6000;
		}
		return 10000;
	}
	
		
	
	
@SuppressWarnings("resource")
public void FileWriter(String s ,Acte c , Paiement pai) throws IOException 
{
    String fileContent_actes = c.toString();
    String fileContent_paiement = pai.toString();

    File file_actes = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+s+"\\Actes.txt");
    File file_paiement = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+s+"\\Paiments.txt");
    file_actes.createNewFile();
    file_paiement.createNewFile();

    //Create the file
    try {
            //Write Content actes
            FileWriter writer = new FileWriter(file_actes,true);
		    if (!file_actes.createNewFile()) writer.write("\n");
            writer.write(fileContent_actes);
            writer.flush(); // empty buffer in the file
            writer.close(); // close the file to allow opening by others applications
            
            //Write Content Paiments
            writer = new FileWriter(file_paiement,true);
		    if (!file_paiement.createNewFile()) writer.write("\n");
            writer.write(fileContent_paiement);

            writer.flush(); // empty buffer in the file
            writer.close(); // close the file to allow opening by others applications
        	JOptionPane.showMessageDialog(this, "the act and paiement are added ");
               
    } catch (IOException e) {
        e.printStackTrace();
    }
  
}

	public ajouter_actes(Patient p){
		String s = p.getCin();
		addComponentsToContainer();
		iniButton(s);
		setLayoutManager();
		setLocationAndSize();
		setTitle("ajouter actes");
		setVisible(true);
	    setBounds(20, 70, 500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}


}
