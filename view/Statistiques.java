package view;

	import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

import Statistiques.LineChartMonthly;
import Statistiques.TestPieChart;

import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

	public class Statistiques extends JFrame implements ActionListener  {
		/**
		 * author : ABIJOUE MOHAMED 
		 */
		private static final long serialVersionUID = 1L;
		
		JFrame cadre ;
		JButton  home , type , monthly , annually;
	 	JPanel Paneau_Center,Paneau_West,Paneau_North , Paneau_Titile ,Paneau_buttons , Paneau_infoArea ;
	 	JLabel image_Title;

	 	
	 	
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
	 		
	 		Paneau_Center.setLayout(new GridLayout(1, 2 , 20 , 20));
	 		Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
	 		


	 	}
	 	public void initLabel() {
	 		ImageIcon image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
	 		image_Title = new JLabel(image);
	 		Paneau_Titile.add(image_Title);
	 	}
	 	
	 	public void initButtons() {
	 		ImageIcon home_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\home.jpg");
	 		home = new JButton("",home_img);		
	 		home.setBackground(Color.WHITE);
	 		home.addActionListener(this);
	 		
	 		Paneau_buttons.add(home);
	 		
	 		ImageIcon type_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\gender.jpg");
	 		type = new JButton("",type_img);		
	 		type.setBackground(Color.WHITE);
	 		type.addActionListener(this);
	 		
	 		ImageIcon monthly_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\monthly.png");
	 		monthly = new JButton("",monthly_img);		
	 		monthly.setBackground(Color.WHITE);
	 		monthly.addActionListener(this);
	 		
	 		ImageIcon annually_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\annually.png");
	 		annually = new JButton("",annually_img);		
	 		annually.setBackground(new Color(200,240,244));
	 		annually.addActionListener(this);
	 		
	 		Paneau_Center.add(type);
	 		Paneau_Center.add(monthly);

	 	}
	 
	 	public Statistiques() {
	 	
	 		Dimension Ecran = Toolkit.getDefaultToolkit().getScreenSize();
	 		
			this.setTitle("Statistiques");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(Ecran.width-250,Ecran.height-240);
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
			if(e.getSource() == home) {
				home h = new home();
				h.setVisible(true);
				this.dispose();
			}
			if(e.getSource() == type) {
				TestPieChart pie;
				try {
					pie = new TestPieChart();
					pie.setVisible(true);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			if(e.getSource() == monthly) {
				 LineChartMonthly chart;
				try {
					chart = new LineChartMonthly(
					         " " ,
					         "Jours Vs Reverue");
					chart.pack( );
				      RefineryUtilities.centerFrameOnScreen( chart );
				      chart.setVisible( true );
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				      
			}
			
			
		}

	}
