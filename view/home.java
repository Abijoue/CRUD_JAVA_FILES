package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class home extends JFrame implements ActionListener  {
	/**
	 * author : ABIJOUE MOHAMED 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame cadre ;
	JButton  List_pat , List_rv , list_stat ;
 	JPanel Paneau_Center,Paneau_West,Paneau_North , Paneau_Titile ,Paneau_buttons , Paneau_infoArea ,Paneau_infoArea_title , Paneau_infoArea_list,Paneau_bottom;
 	JLabel image_Title;
 	JTextArea Student , Professors , Administrator;
 	
 	
 	public void initPanel() {
 		
 		Paneau_North = new JPanel();	
 		Paneau_West = new JPanel();	
 		Paneau_Center = new JPanel();

 		
//title panel
 		Paneau_Titile = new JPanel();
 		Paneau_North.add(Paneau_Titile);
 		Paneau_North.setBackground(new Color(238,238,238));
//button panel
 		Paneau_buttons = new JPanel();
 		Paneau_buttons.setLayout(new GridLayout(3, 1 , 5 ,9));
 		Paneau_West.add(Paneau_buttons);
 		//Paneau_West.setBackground(new Color(0,0,0));

//filed  panel 	
 		Paneau_infoArea = new JPanel();
 		Paneau_infoArea.setLayout(new BorderLayout());
 		Paneau_infoArea_title = new JPanel();
 		Paneau_infoArea_title.setLayout(new GridLayout(1,3));
 		//list
 		Paneau_infoArea_list  = new JPanel();
 //		Paneau_infoArea_list.setLayout(new GridLayout(10,3,9,9));
/*
 		Paneau_infoArea.add(Paneau_infoArea_title,BorderLayout.NORTH);
 		Paneau_infoArea.add(Paneau_infoArea_list,BorderLayout.CENTER);
 */	
 		Paneau_Center.add(Paneau_infoArea);
 		Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
 		
 	}
 	public void initLabel() {
 		ImageIcon image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
 		image_Title = new JLabel(image);
 		Paneau_Titile.add(image_Title);
 	}
 	
 	public void initButtons() {
 		ImageIcon pat_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_pat.jfif");
 		List_pat = new JButton("Liste des patients",pat_img);		
 		List_pat.setPreferredSize(new Dimension(200, 90)); 
 		List_pat.setForeground(Color.BLACK);
 		List_pat.setBackground(Color.WHITE);
 		List_pat.addActionListener(this);
 		//
 		ImageIcon cal_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_cal.PNG");
 		List_rv = new JButton("Liste des rendez-vous",cal_img);		
 		List_rv.setForeground(Color.BLACK);
 		List_rv.setBackground(Color.WHITE);
 		List_rv.addActionListener(this);

 		//
 		ImageIcon cal_stat = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_stat.PNG");
 		list_stat = new JButton("      Statistiques",cal_stat);		
 		list_stat.setForeground(Color.BLACK);
 		list_stat.setBackground(Color.WHITE);
 		list_stat.addActionListener(this);


 		Paneau_buttons.add(List_pat); 
 		Paneau_buttons.add(List_rv);
 		Paneau_buttons.add(list_stat); 	
 	}
 
 	public home() {
 	
 		Dimension Ecran = Toolkit.getDefaultToolkit().getScreenSize();
 		
		this.setTitle("projet Cabinet Dentaire - JAVA -");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Ecran.width-250,Ecran.height-250);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		//panel
		initPanel();
		this.getContentPane().add(Paneau_North,BorderLayout.NORTH);
		this.getContentPane().add(Paneau_West,BorderLayout.WEST);
		this.getContentPane().add(Paneau_Center,BorderLayout.CENTER);
		initLabel();
		initButtons();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == List_pat) {
			System.out.println("list patients");
			try {
				Liste_patientes L = new Liste_patientes();
				L.setVisible(true);
				this.dispose();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

}
