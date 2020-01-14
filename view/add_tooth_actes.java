package view;

	import java.awt.Container;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;

	import javax.swing.*;

	@SuppressWarnings("serial")
	public class add_tooth_actes extends JFrame implements ActionListener {
		Container container = getContentPane();
		JLabel ActesLabel ;

		String tooth[] = {
				"1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26",
				"27","28","29","30","31","32"
				}; 
		
		JButton saveButton , cancelButton ;
		@SuppressWarnings({"rawtypes"})
		JComboBox tooth_list ;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		void initJComboBox() {
			 tooth_list = new JComboBox(tooth); 
			 tooth_list.setVisible(true);
			 container.add(tooth_list);
			 
			 tooth_list.setBounds(50, 80, 70, 30);

		}
		
		void initJlabel() {
			ActesLabel = new JLabel("liste des actes");
			container.add(ActesLabel);
			ActesLabel.setBounds(50, 40, 100, 30);

		}

		public void iniButton(String cin , String acts) {
			
			saveButton = new JButton("Enregistrer - ");
			cancelButton = new JButton("cancel");
			saveButton.setBounds(50, 140, 120, 30);
			cancelButton.setBounds(90, 180, 120, 30);

			saveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == saveButton) {
						try {
							FileWriter( cin ,tooth_list.getSelectedItem().toString(), acts)	;
							System.out.println(cin+tooth_list.getSelectedItem().toString()+acts);
						} catch (IOException e1) {
							e1.printStackTrace();
						}	
						dispose();
						}
				}
			});
			cancelButton.addActionListener(this);
			
			container.add(saveButton);
			container.add(cancelButton);

		}

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == cancelButton){
				this.dispose();			
				}
			
		}
		
		public void setLayoutManager() {
		container.setLayout(null);
		}
				
	public void FileWriter(String cin ,String tooth , String Acte) throws IOException{
		
	    String fileContent = "btnDent"+tooth + " | " + Acte + "\n";

	    File file_tooth = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+cin+"\\tooth.txt");
	    file_tooth.createNewFile();

	    try {
	            //Write Content actes
	            FileWriter writer = new FileWriter(file_tooth,true);
	            writer.write(fileContent);
	            writer.flush(); // empty buffer in the file
	            writer.close(); // close the file to allow opening by others applications
	            
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	  
	}

		public add_tooth_actes(String cin, String acts){
			iniButton(cin,acts);
			initJComboBox();
			setLayoutManager();
			setTitle("ajouter tooth info");
			setVisible(true);
		    setBounds(20, 70, 300, 300);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
		}


	}
