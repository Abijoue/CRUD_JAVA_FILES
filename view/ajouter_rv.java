package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ajouter_rv extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton  add , close ;
 	JPanel Pcenter , Psouth;
 	/* JdatePicker Component
	****
	****
	*--- https://www.programcreek.com/java-api-examples/?api=org.jdatepicker.impl.JDatePickerImpl*/ 
 	UtilDateModel model ;
 	Properties p ;
 	JDatePickerImpl datePicker ;
	String[] elements = {}; 
	@SuppressWarnings("rawtypes")
	JComboBox hours_list ; 
	
 	
 	void initPanel(){
 		Pcenter = new JPanel();
 		Psouth = new JPanel();
 		
 		Pcenter.setBackground(new Color(135,238,238));
 		//Pcenter.setLayout(new GridLayout(2, 1));
 		Psouth.setBackground(new Color(196,196,196));

 		Pcenter.setSize(200, 150);
 	}
 	void initButton(String s){
 		add = new JButton("add");
 		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == add) {
					LocalDate now = LocalDate.now();
					String picked = datePicker.getJFormattedTextField().getText();
					if(picked.compareTo(now.toString()) == -1) {
					    JOptionPane.showMessageDialog(new Frame(), "inter futur date plz", "Realy my friend ", JOptionPane.ERROR_MESSAGE);
					}else {
						new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous\\"+picked.trim()).mkdir();
					}
					String hour = hours_list.getSelectedItem().toString();
					File hours = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous\\"+picked.trim()+"\\"+hour+".txt");
					if(hours.exists()) {
						JOptionPane.showMessageDialog(new Frame(), "le rendez-vous est pris" , " Soory ",JOptionPane.ERROR_MESSAGE);
					}else {
						try {
							FileWriter(s ,picked.trim(),hour); // create a file hour in the folder pickedDate with the value Cin = s ;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}				
			}
		});
 		
 		
 		close = new JButton("close");
 		close.addActionListener(this);

 		Psouth.add(add);
 		Psouth.add(close);

 	}

 	void initJdatePicker() {
 			model = new UtilDateModel();
 			//model.setDate(1990, 8, 24);
 			model.setSelected(true);
 			Properties p = new Properties();
 			p.put("text.today", "Today");
 			p.put("text.month", "Month");
 			p.put("text.year", "Year");
 			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
 	        
 	        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
 	        Pcenter.add(datePicker);

 	} 
 	@SuppressWarnings({ "rawtypes", "unchecked" })
	void initHours() {
 		 elements= new String[] {
 				"8.00","8.30","9.00","9.30","10.00","10.30","11.00","11.30","12.00","12.30",
 				"14.00","14.30","15.00","15.30","16.00","16.30","17.00","17.30","18.00","18.30"
 				}; 
 		hours_list = new JComboBox(elements); 
 		Pcenter.add(hours_list);
 	 	
 	}

	public ajouter_rv(String s) {
 		
		this.setTitle("Ajouter Rendez_Vous");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,200);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		initPanel();
		this.getContentPane().add(Pcenter,BorderLayout.CENTER);
		this.getContentPane().add(Psouth,BorderLayout.SOUTH);

		initJdatePicker();
		initButton(s);
		initHours();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == close) {
				this.dispose();
			}
	}
	
	public void FileWriter(String cin , String date, String hour) throws IOException 
	{
	    String fileContent_cin = cin.trim();
	    hour = hours_list.getSelectedItem().toString();
		File file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous\\"+date+"\\"+hour+".txt");
		
	    //System.out.println(file.getAbsolutePath());
		file.createNewFile();
	    //Create the file
	    try {
	            FileWriter writer = new FileWriter(file);
	            writer.write(fileContent_cin);
	            writer.close();
	        	JOptionPane.showMessageDialog(this, " Le rendez vouz a ete ajoute avec succes ");
	               
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+fileContent_cin).mkdir();
		File Pat_file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+fileContent_cin+"\\RV.txt");

	    Pat_file.getAbsolutePath();
	    Pat_file.createNewFile();
	    
	    String fileContent_pat = "Le Rendez-vous est le "+date+" au "+hour+" .";
	    //Create the file
	    try {
	    	    FileWriter writer2 = new FileWriter(Pat_file,true);
	            writer2.write(fileContent_pat);
	            writer2.close();
	               
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	  
	}



}
