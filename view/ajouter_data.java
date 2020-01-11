package view;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JPanel;
	import javax.swing.JTextArea;


import javaBeans.Patient;


public class ajouter_data extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * comment
	 * directed by : Abijoue
	 */
	
		JFrame cadre ;
		JButton  add , add_money , detail , home , decore , add_ordonance , add_certeficat ;
	 	JPanel Paneau_Center,Paneau_West,Paneau_North , Paneau_Titile ,Paneau_buttons , Paneau_infoArea ,Paneau_south;
	 	JLabel image_Title , textId , textFname , textLname ,textAge ,textEmail ,textSexe ,textTel;
	 	JTextArea textActes , textpaiment , textHistorique , textcerteficat;
	 	
	 	
	 	public void initPanel() {
	 		
	 		Paneau_North = new JPanel();	
	 		Paneau_West = new JPanel();	
	 		Paneau_Center = new JPanel();
	 		Paneau_south = new JPanel();

	 		
	//title panel
	 		Paneau_Titile = new JPanel();
	 		Paneau_North.add(Paneau_Titile);
	 		Paneau_North.setBackground(new Color(238,238,238));
	//button panel
	 		Paneau_buttons = new JPanel();
	 		Paneau_buttons.setLayout(new GridLayout(6, 1 , 2 ,4));
	 		Paneau_West.add(Paneau_buttons);
	 //jlabekArea panel
	 		//-------------------------
	 		Paneau_south.setLayout(new GridLayout(1, 8));
	 		Paneau_south.setBackground(Color.WHITE); //Soft green color


	//filed  panel 
	 		
//	 		Paneau_infoArea = new JPanel();
//	 		Paneau_infoArea.setBackground(new Color(0,0,0));
	 		//Paneau_infoArea.setPreferredSize(new Dimension(600, 500));

	 		Paneau_Center.setSize(new Dimension(600, 500));
			Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
			Paneau_Center.setLayout(new GridLayout(2, 2));
			//Paneau_Center.add(Paneau_infoArea);

	 		
	 	}
	 	@SuppressWarnings("resource")
		public void initJTextArea(Patient p) throws IOException {
		 	 textActes = new JTextArea() ; textActes.setBackground(new Color(229,255,204));
		 	 textHistorique= new JTextArea() ; textHistorique.setBackground(new Color(204,229,255));
		 	File file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Actes.txt");
		 	//System.out.println(file.getAbsolutePath());
		 	String temp = "List des actes avec les prix ";
		 	file.createNewFile();
		 		    Scanner sc = new Scanner(file); 
		 		    while (sc.hasNextLine()) {
			 		 	temp = temp +"\n"+sc.nextLine();
		 		    }
		 		    textActes.setText(temp);
		 		    textActes.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		 		    sc.close();
		 		    
		 	 textpaiment = new JTextArea() ; textpaiment.setBackground(new Color(229,204,255));
		 	 file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Paiments.txt");
		     file.createNewFile();

		 	 temp = "Informations sur les paiements";
		 		    sc = new Scanner(file); 
		 		    while (sc.hasNextLine()) {
			 		 	temp = temp +"\n"+sc.nextLine();
		 		    }
		 	sc.close();
			file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Paiments.txt");
	 		    sc = new Scanner(file); 
	 		    ArrayList<String> List = new ArrayList<String>();
	 		    String temp2 = "";
	 		    int i = 0;
				while (sc.hasNext()) {
	 		    	temp2 = sc.next();
		 		    	if(i%10 == 0){
			 		    	List.add(temp2);
		 		    	}
		 		    	i++;
	 		    }
				Double somme = 0.0 ;
				for (String s : List) {
						somme = somme + Double.parseDouble(s);
					}
					temp = temp + "\n *  Le Montant totale\t"+somme+" DH";
				sc.close();
//----------------------------------------------------------------------------------------
					file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Avance.txt");
				    file.createNewFile();
		 		    sc = new Scanner(file); 
		 		    
		 		    List.clear();
		 		    temp2 = "";
		 		    i = 0;
					while (sc.hasNext()) {
		 		    	temp2 = sc.next();
			 		    	if(temp != ""){
				 		    	List.add(temp2);
			 		    	}
			 		    	i++;
		 		    }
					Double somme2 = 0.0 ;
					for (String s : List) {
							System.out.println(s);
							somme2 = somme2 + Double.parseDouble(s);
						}
		 		    sc.close();

//----------------------------------------------------------
					temp = temp + "\n *  L'avance \t"+somme2+" DH";
					temp = temp + "\n *  Le rest \t"+(somme-somme2)+" DH";

		 		    textpaiment.setText(temp);
		 		    textpaiment.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 15));
//-----------------------------------------------------------------------------------------------------------		 		    
		 		    if((somme-somme2) <= 0 ) {
		 		  //  Date date = new Date();
		 		    String archive_string = "";
		 		    File file_archive = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\archive.txt");
		 		    file_archive.createNewFile();
		 		    File file2 = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Actes.txt");
		 		    File file3 = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Paiments.txt");
		 		 		    sc = new Scanner(file2); 
		 		 		    Scanner sc2 = new Scanner(file3);
		 		 		    while (sc.hasNextLine()) {
		 		 		    	archive_string = archive_string +"\n"+sc.nextLine()+"-"+sc2.nextLine();
		 		 		    }
		 		 			try {
			 		             //Write Content Archive
			 		             FileWriter writer = new FileWriter(file_archive,true);
			 		 		   // if (!file_archive.createNewFile()) writer.write("\n");
			 		             writer.write(archive_string);
			 		             writer.flush(); // empty buffer in the file
			 		             writer.close(); // close the file to allow opening by others applications
			 		          
				 		     } catch (IOException e) {
				 		         e.printStackTrace();
				 		     }
		 		 		  
		 		 		  
		 		 		  sc.close();
		 		    sc2.close();
		 		    	temp = "Toutes les factures a été payées";
//---------------------------------------------------------------------------------------------------------------
		 		    	file_archive = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\archive.txt");
		 		    	archive_string = "";
		 		    	sc = new Scanner(file_archive); 
			 		    while (sc.hasNextLine()) {
			 		    	archive_string = archive_string+sc.nextLine() + "\n";
			 		    }
			 		   textHistorique.setText(archive_string);
			 		  textHistorique.setFont(new Font("SansSerif", Font.PLAIN, 9));
			 		    sc.close();
//-/-----------------/-/-/-/-----------------------------------------------------------------------------------------
		 		    	Files.deleteIfExists(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Avance.txt")); 
		 		    	Files.deleteIfExists(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Actes.txt"));
		 		    	Files.deleteIfExists(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+p.getCin().trim()+"\\Paiments.txt"));
//----------------------------------------------------------------//--------------------------------/-/-/-/----------
		 		    }

			 textcerteficat = new JTextArea() ;  textcerteficat.setBackground(new Color(255,255,204));
			 Paneau_Center.add(textActes); 
			 Paneau_Center.add(textpaiment);
			 Paneau_Center.add(textHistorique);
			 Paneau_Center.add(textcerteficat);
	 	}
	 	public void initLabel(Patient p) {
	 		ImageIcon image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
	 		image_Title = new JLabel(image);
	 		Paneau_Titile.add(image_Title);
	 		textId = new JLabel(p.getCin()); 
	 		textId.setPreferredSize(new Dimension(60, 50)); 				Paneau_south.add(textId);
	 		textFname  = new JLabel(p.getNom()); 		Paneau_south.add(textFname);
			textLname = new JLabel(p.getPrenom());		Paneau_south.add(textLname);
			textAge = new JLabel(""+p.getAge()); 		Paneau_south.add(textAge);
			textSexe = new JLabel(p.getSexe());		    Paneau_south.add(textSexe);
			textEmail = new JLabel(p.getEmail());		Paneau_south.add(textEmail);
			textTel = new JLabel(p.getTel());			Paneau_south.add(textTel);
	 	}

	 	public void initButtons(Patient p) {
	 		ImageIcon acte_image_add = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\acte_image_add.png");
	 		add = new JButton("",acte_image_add);		
	 		add.setPreferredSize(new Dimension(200, 50)); 
	 		add.setBackground(Color.WHITE);
	 		add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == add) {
						 new ajouter_actes(p);
					}
				}
			});
	 		//
	 		ImageIcon money_image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\money.png");
	 		add_money = new JButton("",money_image);		
	 		add_money.setBackground(Color.WHITE);
	 		add_money.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			 		if(e.getSource() == add_money) {
					   ajouter_mony m = new ajouter_mony(p);
					   m.setVisible(true);
		        }
				}
			});
	 		

	 		//
	 		ImageIcon acte_image_delete = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\zoom.png");
	 		detail = new JButton("",acte_image_delete);		
	 		detail.setBackground(Color.WHITE);
	 		detail.addActionListener(this);

	 		//
	 		ImageIcon home_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\home.jpg");
	 		home = new JButton("",home_img);		
	 		home.setBackground(Color.WHITE);
	 		home.addActionListener(this);
	 		//
	 		ImageIcon img_ord = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\imf_ord.png");
	 		add_ordonance = new JButton("",img_ord);
	 		add_ordonance.setBackground(Color.WHITE);
	 		add_ordonance.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			 		if(e.getSource() == add_ordonance) {
			 			ajouter_ordo or = new ajouter_ordo(p);
						or.setVisible(true);
		        }
				}
			});
	 		//
	 		
	 		ImageIcon img_cert = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_cert.jpg");
	 		add_certeficat = new JButton("",img_cert);
	 		add_certeficat.setBackground(Color.WHITE);
	 		add_certeficat.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			 		if(e.getSource() == add_certeficat) {
			 			
			 			ajouter_cert cert = new ajouter_cert(p);
			 			cert.setVisible(true);
			 		
		        }
				}
			});
	 		ImageIcon img_pat = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_pat.jfif");
	 		decore = new JButton("",img_pat);
	 		decore.setBackground(Color.WHITE);
	 		decore.setBorder(null);
	 		decore.addActionListener(this);

	 		//
	 		Paneau_south.add(decore);
	 		//
	 		Paneau_buttons.add(add); 
	 		Paneau_buttons.add(add_money);
	 		Paneau_buttons.add(detail); 
	 		Paneau_buttons.add(add_ordonance); 
	 		Paneau_buttons.add(add_certeficat); 
	 		Paneau_buttons.add(home); 
	 		
	 	}

		public ajouter_data(Patient p) throws IOException {
	 		Dimension Ecran = Toolkit.getDefaultToolkit().getScreenSize();

			this.setTitle("information sur le patiente");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(Ecran.width,Ecran.height-33);
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(new BorderLayout());
			//panel
			initPanel();
			initButtons(p);
			initLabel(p);
			initJTextArea(p);
			this.getContentPane().add(Paneau_North,BorderLayout.NORTH);
			this.getContentPane().add(Paneau_Center,BorderLayout.CENTER);
			this.getContentPane().add(Paneau_south,BorderLayout.SOUTH);
			this.getContentPane().add(Paneau_West,BorderLayout.WEST);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == home) {
				home h = new home();
				h.setVisible(true);
				this.dispose();
			}
			
			if(e.getSource() == decore) {
				Liste_patientes listP;
				try {
					listP = new Liste_patientes();
					listP.setVisible(true);

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				this.dispose();

			}
			
		}
	}
