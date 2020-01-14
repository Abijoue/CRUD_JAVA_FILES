package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javaBeans.Patient;

import java.util.Scanner; 


public class Liste_patientes extends JFrame implements ActionListener, MouseListener {
	/**
	 * *
	 *   Comments
	 * *
	 * *
	 *  author : ABIJOUE MOHAMED 
	 * *
	 * *
	 * *
	 * *
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame cadre ;
	JButton  add , modify , deleat , home , detail ,add_detail , add_rv;
 	JPanel Paneau_Center,Paneau_West,Paneau_North , Paneau_Titile ,Paneau_buttons , Paneau_infoArea ,Paneau_East;
 	JLabel image_Title;
 	JTable table;
 	JScrollPane sp;
 	DefaultTableModel  tablemodel;
    JTextField textId , textFname , textLname ,textAge ,textEmail ,textSexe ,textTel ;
    
 	
 	
 	public void initPanel() {
 		
 		Paneau_North = new JPanel();	
 		Paneau_West = new JPanel();	
 		Paneau_Center = new JPanel();
 		Paneau_East = new JPanel();

 		
//title panel
 		Paneau_Titile = new JPanel();
 		Paneau_North.add(Paneau_Titile);
 		Paneau_North.setBackground(new Color(238,238,238));
//button panel
 		Paneau_buttons = new JPanel();
 		Paneau_buttons.setLayout(new GridLayout(4, 1 , 5 ,9));
 		Paneau_West.add(Paneau_buttons);
 //jtextArea panel
 		//-------------------------
 		Paneau_East.setLayout(new GridLayout(1, 8));
 		Paneau_East.setBackground(new Color(0,0,0)); 

//filed  panel 
 		
 		Paneau_infoArea = new JPanel();
 	//	Paneau_infoArea.setBackground(new Color(153,204,255));
 		Paneau_infoArea.setPreferredSize(new Dimension(600, 500));

 		Paneau_Center.setSize(new Dimension(600, 500));
		Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
		Paneau_Center.add(Paneau_infoArea);

 		
 	}
 	public void initLabel() {
 		ImageIcon image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
 		image_Title = new JLabel(image);
 		Paneau_Titile.add(image_Title);
 	}
 	public void initJTextField() {
 		
         textId = new JTextField();
         textFname = new JTextField();
         textLname = new JTextField();
         textSexe = new JTextField();
         textAge = new JTextField();
         textTel = new JTextField();
         textEmail = new JTextField();

         
         Paneau_East.add(textId);
         Paneau_East.add(textFname);
         Paneau_East.add(textLname);
         Paneau_East.add(textSexe);
         Paneau_East.add(textAge);
         Paneau_East.add(textTel);
         Paneau_East.add(textEmail);

         
 	}
 	
 	public void initButtons() {
 		ImageIcon add_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\ajouter.png");
 		add = new JButton("",add_img);		
 		add.setPreferredSize(new Dimension(200, 90)); 
 		add.setBackground(Color.WHITE);
 		add.addActionListener(this);
 		//
 		ImageIcon modify_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\modify.png");
 		modify = new JButton("",modify_img);		
 		modify.setBackground(Color.WHITE);
 		modify.addActionListener(this);

 		//
 		ImageIcon deleat_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\remove.png");
 		deleat = new JButton("",deleat_img);		
 		deleat.setBackground(Color.WHITE);
 		deleat.addActionListener(this);

 		//
 		ImageIcon home_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\home.jpg");
 		home = new JButton("",home_img);		
 		home.setBackground(Color.WHITE);
 		home.addActionListener(this);
 		
 		//
 		ImageIcon det_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\det_img.jpg");
 		detail = new JButton("",det_img);	
 		detail.setBackground(Color.WHITE);
 		detail.setPreferredSize(new Dimension(60, 60)); 
 		detail.addActionListener(this);
 		
 		ImageIcon img_rv_add = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_rv_add.jpg");
 		add_rv = new JButton("",img_rv_add);	
 		add_rv.setBackground(Color.WHITE);
 		add_rv.addActionListener(this);
 		
 		Paneau_buttons.add(add); 
 		Paneau_buttons.add(modify);
 		Paneau_buttons.add(deleat); 
 		Paneau_buttons.add(home); 
 		//
 		Paneau_East.add(detail);
 		Paneau_East.add(add_rv);
 		Paneau_East.setVisible(false);

 	}
 	
 	void initTable() {
		sp = new JScrollPane();
 		table = new JTable();
 		table.setSize(500, 600);
 		tablemodel = new DefaultTableModel(
				   new Object[][] {},
				   new String[] { "CIN", "Nom", "Prenom","Sexe", "Age", "Tel","E-mail"}
	);
 		table.setModel(tablemodel);
 		table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.addMouseListener(this);

        
 		sp.setViewportView(table);
 		
 	}
 	@SuppressWarnings({ "rawtypes", "resource" })
	void initPatientElements() throws FileNotFoundException {

        List file_names = new ArrayList<>() ;
   
        //---------------------------------
        //-- extract files path
        //---------------------------------
        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Patients"))) {

    		List<String> result = walk.filter(Files::isRegularFile)
    				.map(x -> x.toString()).collect(Collectors.toList());
    		file_names = result;
    		//file_names.forEach(System.out::println);

    	} catch (IOException e) {
    		e.printStackTrace();
    	}
        //--------------  loop throw the files  ----------------------------
        //  Paneau_Center.setLayout(new GridLayout(file_names.size()+2, 1));  
          initTable();
          
        for (int i = 0; i < file_names.size(); i++) {
        	 File file = new File((String) file_names.get(i)); 
             Scanner sc = new Scanner(file); 
             Object[] line = new Object[8];
             int k=0;
             for (String data : sc.nextLine().split("-")) {
            	  line[k++] = data;
			}
             tablemodel.addRow(line);
             sc.close();
        }
        Paneau_infoArea.add(sp);
      //  Paneau_infoArea.setSize(200,500);

              
      }
        

 	
 
 	public Liste_patientes() throws FileNotFoundException {
 	
 		Dimension Ecran = Toolkit.getDefaultToolkit().getScreenSize();
 		
		this.setTitle("Liste patientes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Ecran.width-150,Ecran.height-120);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		//panel
		initPanel();
		initJTextField();
		initPatientElements(); 
		this.getContentPane().add(Paneau_North,BorderLayout.NORTH);
		this.getContentPane().add(Paneau_Center,BorderLayout.CENTER);
		this.getContentPane().add(Paneau_East,BorderLayout.SOUTH);
		this.getContentPane().add(Paneau_West,BorderLayout.WEST);

		initLabel();
		initButtons();

	}
 	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			new ajouter_patiente();
		}
		if(e.getSource() == home) {
			home h = new home();
			h.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource() == deleat) {
			int column = 0;
			int row = table.getSelectedRow();
			String value = table.getModel().getValueAt(row, column).toString().trim();

			//file to be delete 
			//File deleatingFile= new File("");
	            if(table.getSelectedRow() != -1) {
	            	tablemodel.removeRow(table.getSelectedRow());
	            	
	            //	System.out.println(deleatingFile.getAbsolutePath());
	            	            		
	            		File file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Patients\\"+value+".txt");
	            		File directory = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+value);

	            		System.out.println(file.getAbsolutePath());
	            		if(file.delete()){
	            			System.out.println(file.getName() + " is deleted!");
	            		}else{
	            			System.out.println("Delete operation is failed.");
	            		}
	                	//System.out.println(file.exists());
	            		try {
							delete(directory);
						} catch (IOException e1) {
							e1.printStackTrace();
						}

	               JOptionPane.showMessageDialog(null, "La ligne sélectionnée a été supprimée");
	            }else {
		            JOptionPane.showMessageDialog(null, "sélectionnée une ligne svp");
	            }  
		}
		
		if(e.getSource() == modify) {
			 int i = table.getSelectedRow();
			 String temp;
             if(i >= 0) 
             {
                tablemodel.setValueAt(tablemodel.getValueAt(i, 0), i, 0);
                tablemodel.setValueAt(textFname.getText(), i, 1);
                tablemodel.setValueAt(textLname.getText(), i, 2);
                if(textSexe.getText() == "Homme" ||textSexe.getText() == "Femme") {
                    tablemodel.setValueAt(textSexe.getText(), i, 3);
                }
                tablemodel.setValueAt(textAge.getText(), i, 4);
                tablemodel.setValueAt(textTel.getText(), i, 5);
                tablemodel.setValueAt(textEmail.getText(), i, 6);
                temp = textId.getText()+"-"+textFname.getText() +"-"+
                	   textLname.getText()+"-"+ textSexe.getText() +"-"+
                	   textAge.getText() +"-"+ textTel.getText()+"-"+textEmail.getText() +"-";
                
                 File file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Patients\\"+textId.getText().trim()+".txt");
                    
                   System.out.println(file.delete()); 
                    //Create the file
                        try {
							if (file.createNewFile()) {
							    //Write Content
							    FileWriter writer = new FileWriter(file,true);
							    System.out.println("file updated");
							    writer.write(temp);
							    writer.close();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
                
             }
             else{
		            JOptionPane.showMessageDialog(null, "sélectionnée une ligne svp","Errrreur", JOptionPane.ERROR_MESSAGE);
             }
	
		}
		if(e.getSource() == detail) {
			int temp_age = Integer.parseInt(textAge.getText().trim());
			
			Patient p = new Patient(textId.getText(), textFname.getText() , textLname.getText() ,
					textEmail.getText() ,temp_age ,textSexe.getText() ,textTel.getText());
			/***** create patient folder if not exist *****/
			
		     String directoryPath = "C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+textId.getText();

		        File file = new File(directoryPath);
//		        System.out.println(file.getAbsolutePath());
		        if (file.mkdir()) {
//					System.out.println("directory created ***");
				} else {
					System.out.println("folder already exist");
				}
		        
			System.out.println(p);
			ajouter_data d;
			try {
				d = new ajouter_data(p);
				d.setVisible(true);
				this.dispose();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == add_rv) {
			String cin = textId.getText().trim();
			
			/***** create patient folder if not exist *****/
			
		     String directoryPath = "C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous";

		        File file = new File(directoryPath);
		        file.mkdir();
		    /*******************************************/
		        System.out.println("Add appointment");
			ajouter_rv rv = new ajouter_rv(cin);
			rv.setVisible(true);

		}
	}
	
    public static void delete(File file) throws IOException{
			 
	    	if(file.isDirectory()){
	    		//directory is empty, then delete it
	    		if(file.list().length==0){
	    			
	    		   file.delete();
	    		   System.out.println("Directory is deleted : "+ file.getAbsolutePath());
	    			
	    		}else{
	    			
	    		   //list all the directory contents
	        	   String files[] = file.list();
	     
	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);
	        	      //recursive delete
	        	     delete(fileDelete);
	        	   }
	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length==0){
	           	     file.delete();
	        	     System.out.println("Directory is deleted : "+ file.getAbsolutePath());
	        	   }
	    		}
	    	}else{
	    		//if file, then delete it
	    		file.delete();
	    		System.out.println("File is deleted : " + file.getAbsolutePath());
	    	}
	 }
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Paneau_East.setVisible(true);
		int i = table.getSelectedRow();
		Font f = new Font("Serif", Font.BOLD, 15); 
		textFname.setForeground(Color.RED);
		textLname.setForeground(Color.RED);
		textSexe.setForeground(Color.BLUE);
		textAge.setForeground(Color.darkGray);
		textTel.setForeground(Color.magenta);
		textEmail.setForeground(Color.black);

		textId.setFont(f); 
        textId.setText(tablemodel.getValueAt(i, 0).toString());
        textFname.setText(tablemodel.getValueAt(i, 1).toString());
        textLname.setText(tablemodel.getValueAt(i, 2).toString());
        textSexe.setText(tablemodel.getValueAt(i, 3).toString());
        textAge.setText(tablemodel.getValueAt(i, 4).toString());	
        textTel.setText(tablemodel.getValueAt(i, 5).toString());
        textEmail.setText(tablemodel.getValueAt(i, 6).toString());

	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {		
	}
	@Override
	public void mouseEntered(MouseEvent e) {		
	}
	@Override
	public void mouseExited(MouseEvent e) {		
	}
}
