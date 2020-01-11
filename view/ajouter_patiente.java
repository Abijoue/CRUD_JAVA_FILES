package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import javaBeans.Patient;


@SuppressWarnings("serial")
public class ajouter_patiente extends JFrame implements ActionListener {
	
	Object[] elements = new Object[]{"Homme", "Femme"};	
	Container container = getContentPane();
	JLabel cinLabel = new JLabel("CIN");
	JLabel nomLabel = new JLabel("Nom");
	JLabel prenomLabel = new JLabel("Prenom");
	JLabel emailLabel = new JLabel("E-mail");
	JLabel sexeLabel = new JLabel("Sexe");
	JLabel telLabel = new JLabel("Tel");
	JLabel ageLabel = new JLabel("Age");


	JTextField nomTextField = new JTextField();
	JTextField prenomTextField = new JTextField();
	JTextField ageTextField = new JTextField(); 
	JTextField emailTextField = new JTextField(); 
	JTextField cinTextField = new JTextField(); 
	JTextField telTextField = new JTextField(); 
	JTextField sexeTextField = new JTextField(); 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox sexe = new JComboBox(elements); 

	JButton saveButton = new JButton("Enregistrer");
	JButton resetButton = new JButton("Effacer");
	JCheckBox showPassword = new JCheckBox("Afficher");
	
	public void setLayoutManager() {
	container.setLayout(null);
	}
	public void setLocationAndSize() {
		
	nomLabel.setBounds(50, 40, 100, 30);
	nomTextField.setBounds(150, 40, 150, 30);
	
	prenomLabel.setBounds(50, 80, 100, 30);
	prenomTextField.setBounds(150, 80, 150, 30);
	
	sexeLabel.setBounds(50, 120, 100, 30);
	sexe.setBounds(150, 120, 150, 30);
	
	emailLabel.setBounds(50, 160, 100, 30);
	emailTextField.setBounds(150, 160, 150, 30);
	
	
	cinLabel.setBounds(50, 200, 100, 30);
	cinTextField.setBounds(150, 200, 150, 30);
	
	
	
	ageLabel.setBounds(50, 240, 100, 30);
	ageTextField.setBounds(150, 240, 150, 30);
	
	
	telLabel.setBounds(50, 280, 100, 30);
	telTextField.setBounds(150, 280, 150, 30);
	
	showPassword.setBounds(150, 200, 150, 30);
	saveButton.setBounds(50, 320, 100, 30);
	resetButton.setBounds(200, 320, 100, 30);

ageTextField.addKeyListener(new KeyAdapter() {
   public void keyPressed(KeyEvent ke) {
  //    String value = ageTextField.getText();
     // int l = value.length();
      if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
   	   ageTextField.setEditable(true);
       
      } else {
   	   ageTextField.setEditable(false);
        
      }
   }
});




}
	public void addComponentsToContainer() {
	
		container.add(nomLabel);
		container.add(nomTextField);
		container.add(prenomLabel);
		container.add(prenomTextField);
		
		container.add(sexeLabel);
		container.add(sexe);
		
		container.add(emailLabel);
		container.add(emailTextField);
		
		container.add(cinLabel);
		container.add(cinTextField);
		
		container.add(ageLabel);
		container.add(ageTextField);
		
		container.add(telLabel);
		container.add(telTextField);
		container.add(saveButton);
		container.add(resetButton);
		
	}

	public void addActionEvent() {
		saveButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == resetButton) {
			
			nomTextField.setText("");
			prenomTextField.setText("");
			emailTextField.setText("");
			cinTextField.setText("");
			telTextField.setText("");
			ageTextField.setText("");
			
			}
		
		
		
		if (e.getSource() == saveButton) {
			
				String nom = nomTextField.getText().trim();
				String prenom = prenomTextField.getText().trim();
				String email = emailTextField.getText().trim();
				String cin = cinTextField.getText().trim();
				String age = ageTextField.getText().trim();
				String tel = telTextField.getText().trim();
				String sexe_v = (String)sexe.getSelectedItem();
				Patient patient = new Patient() ;
	
				if (nom.equals("")||prenom.equals("")||email.equals("")||cin.equals("")||age.equals("")||tel.equals("")) {
					JOptionPane.showMessageDialog(this, "remplir tous les champs SVP");
					
				}if (tel.length()!= 10) {
					JOptionPane.showMessageDialog(this, "Saisir un numero de tel valide SVP");
				}/*
				else {
					/*
					boolean existe=patient.elementExists(cin, Patient.getList());
					
					if(existe) {
						JOptionPane.showMessageDialog(this, "patient deja existe dans la base");
					
				}*/
				else {
					
					patient.setNom(nom);
					patient.setPrenom(prenom);
					patient.setCin(cin);
					patient.setEmail(email);
					patient.setAge(Integer.parseInt(age));
					patient.setTel(tel);
					patient.setSexe(sexe_v);
				
					try {
						FileWriter(patient);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
		           this.dispose(); 			
				 
				}
			
			}
		}
	
	
public void FileWriter(Patient p) throws IOException 
{
    String fileContent = p.toString();
    File file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Patients\\"+p.getCin()+".txt");
    
    //Create the file
    try {
        if (file.createNewFile()) {
            //Write Content
            FileWriter writer = new FileWriter(file);
            writer.write(fileContent);
            writer.close();
        } else {
        	JOptionPane.showMessageDialog(this, "patient deja existe");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
  
}

	public ajouter_patiente(){
		addComponentsToContainer();
		setLayoutManager();
		setLocationAndSize();
		addActionEvent();
		setTitle("ajouter_patient");
		setVisible(true);
	    setBounds(300, 100, 500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
	}
@SuppressWarnings("unused")
public static void main(String[] args) {
	
	ajouter_patiente p = new ajouter_patiente();
	
}
}
