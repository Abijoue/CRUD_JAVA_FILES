package view;

	import javax.swing.*;

import java.awt.*;
	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


	public class tooth_list extends JFrame implements ActionListener {
		/**
		 * author : ABIJOUE MOHAMED 
		 */
		private static final long serialVersionUID = 1L;
		
		JFrame cadre ;
		JButton btnDent16, btnDent15, btnDent14, btnDent13, btnDent12, btnDent11, btnDent10, btnDent9, btnDent8, btnDent7, btnDent6, btnDent5, btnDent4, btnDent3, btnDent2, btnDent1,
		btnDent17, btnDent18, btnDent19, btnDent20, btnDent21, btnDent22, btnDent23, btnDent24, btnDent25, btnDent26, btnDent27, btnDent28, btnDent29, btnDent30, btnDent31, btnDent32;
		JPanel Paneau_Center,Paneau_East;
	 	JLabel image_Title , lblDents;
	 	JTextArea output ;
	 	
	 	
	 	public void initPanel() {
	 		
	 		Paneau_East = new JPanel();	
	 		Paneau_Center = new JPanel();

	 		
	
	 		Paneau_Center.setLayout(null);
	 		Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
	 		
	 		Paneau_East = new JPanel();
	 		Paneau_East.setLayout(null);
	 		Paneau_East.setPreferredSize(new Dimension(350, 190));
	 		Paneau_East.setBackground(new Color(240,250,240)); //Soft green color


	 	}
	 	public void initlabel() {
	 		lblDents = new JLabel("");
			lblDents.setBounds(35, -11, 420, 535);
			String imgPath = "C:/Users/The_ghost/eclipse-workspace/dentaire/src/view/img/backup/meryem.jpg";
			lblDents.setIcon(new ImageIcon(imgPath));
			Paneau_Center.add(lblDents);
	 	}
	 	public void initJtextarea() {
	 		output = new JTextArea();
	 		output.setBackground(new Color(238,194,194));
	 		Paneau_East.add(output);
	 		
	 	}

	 	
	 	public void initButtons() {
	 		btnDent16 = new JButton("9");
	 		btnDent16.setVisible(false);
			btnDent16.setBounds(329, 209, 32, 32);
			btnDent16.addActionListener(this);

			
			btnDent15 = new JButton("15");
	 		btnDent15.setVisible(false);
			btnDent15.setBounds(329, 174, 32, 23);
			btnDent15.addActionListener(this);

			
			btnDent14 = new JButton("14");
	 		btnDent14.setVisible(false);
			btnDent14.setBounds(329, 136, 32, 23);
			btnDent14.addActionListener(this);

			
			btnDent13 = new JButton("13");				btnDent13.setVisible(false);
			btnDent13.setBounds(315, 101, 32, 23);
			btnDent13.addActionListener(this);

			
			btnDent12 = new JButton("12"); 				btnDent12.setVisible(false);
			btnDent12.setBounds(315, 74, 32, 23);
			btnDent12.addActionListener(this);

			
			btnDent11 = new JButton("11");				btnDent11.setVisible(false);
			btnDent11.setBounds(299, 48, 32, 23);
			btnDent11.addActionListener(this);

			
			btnDent10 = new JButton("10");				btnDent10.setVisible(false);
			btnDent10.setBounds(280, 27, 32, 23);
			btnDent10.addActionListener(this);

			
			btnDent9 = new JButton("9"); 				btnDent9.setVisible(false);
			btnDent9.setBounds(246, 27, 32, 23);
			btnDent9.addActionListener(this);

			
			btnDent8 = new JButton("8");				btnDent8.setVisible(false);
			btnDent8.setBounds(214, 27, 32, 23);
			btnDent8.addActionListener(this);

			
			btnDent7 = new JButton("7");				btnDent7.setVisible(false);
			btnDent7.setBounds(184, 27, 32, 23);
			btnDent7.addActionListener(this);

			
			btnDent6 = new JButton("6");				btnDent6.setVisible(false);
			btnDent6.setBounds(157, 48, 32, 23);
			btnDent6.addActionListener(this);

			
			btnDent5 = new JButton("5");				btnDent5.setVisible(false);
			btnDent5.setBounds(142, 74, 32, 23);
			btnDent5.addActionListener(this);

			
			btnDent4 = new JButton("4");				btnDent4.setVisible(false);
			btnDent4.setBounds(142, 101, 32, 23);
			btnDent4.addActionListener(this);

			
			
			btnDent3 = new JButton("3");				btnDent3.setVisible(false);
			btnDent3.setBounds(129, 136, 32, 23);
			btnDent3.addActionListener(this);

			
			
			btnDent2 = new JButton("2");				btnDent2.setVisible(false);
			btnDent2.setBounds(129, 174, 32, 23);
			btnDent2.addActionListener(this);

			
			btnDent1 = new JButton("1");				btnDent1.setVisible(false);
			btnDent1.setBounds(129, 209, 32, 23);
			btnDent1.addActionListener(this);

			
			btnDent17 = new JButton("17");				btnDent17.setVisible(false);
			btnDent17.setBounds(329, 282, 32, 23);
			btnDent17.addActionListener(this);

			
			btnDent18 = new JButton("18");				btnDent18.setVisible(false);
			btnDent18.setBounds(329, 316, 32, 23);
			btnDent18.addActionListener(this);

			
			btnDent19 = new JButton("19");				btnDent19.setVisible(false);
			btnDent19.setBounds(315, 363, 32, 23);
			btnDent19.addActionListener(this);

			
			btnDent20 = new JButton("20");				btnDent20.setVisible(false);
			btnDent20.setBounds(299, 397, 32, 23);
			btnDent20.addActionListener(this);

			
			btnDent21 = new JButton("21");				btnDent21.setVisible(false);
			btnDent21.setBounds(299, 420, 32, 23);
			btnDent21.addActionListener(this);

			
			btnDent22 = new JButton("22");				btnDent22.setVisible(false);
			btnDent22.setBounds(299, 443, 32, 23);
			btnDent22.addActionListener(this);

			
			btnDent23 = new JButton("23");				btnDent23.setVisible(false);
			btnDent23.setBounds(268, 465, 32, 23);
			btnDent23.addActionListener(this);

			
			btnDent24 = new JButton("24");				btnDent24.setVisible(false);
			btnDent24.setBounds(246, 465, 32, 23);
			btnDent24.addActionListener(this);

			
			btnDent25 = new JButton("25");				btnDent25.setVisible(false);
			btnDent25.setBounds(214, 465, 32, 23);
			btnDent25.addActionListener(this);

			
			btnDent26 = new JButton("26");				btnDent26.setVisible(false);
			btnDent26.setBounds(184, 465, 32, 23);
			btnDent26.addActionListener(this);

			
			btnDent27 = new JButton("27");				btnDent27.setVisible(false);
			btnDent27.setBounds(157, 454, 32, 23);
			btnDent27.addActionListener(this);

			
			btnDent28 = new JButton("28");				btnDent28.setVisible(false);
			btnDent28.setBounds(157, 420, 32, 23);
			btnDent28.addActionListener(this);

			
			btnDent29 = new JButton("29");				btnDent29.setVisible(false);
			btnDent29.setBounds(142, 397, 32, 23);
			btnDent29.addActionListener(this);

			
			btnDent30 = new JButton("30");				btnDent30.setVisible(false);
			btnDent30.setBounds(142, 363, 32, 23);
			btnDent30.addActionListener(this);

			
			btnDent31 = new JButton("31");				btnDent31.setVisible(false);
			btnDent31.setBounds(129, 326, 32, 23);
			btnDent31.addActionListener(this);

			
			btnDent32 = new JButton("32");				btnDent32.setVisible(true);
			btnDent32.setBounds(129, 282, 32, 23);
			btnDent32.addActionListener(this);

			
			Paneau_Center.add(btnDent16);
			Paneau_Center.add(btnDent15);
			Paneau_Center.add(btnDent14);
			Paneau_Center.add(btnDent13);
			Paneau_Center.add(btnDent12);
			Paneau_Center.add(btnDent11);
			Paneau_Center.add(btnDent10);
			Paneau_Center.add(btnDent9);
			Paneau_Center.add(btnDent8);
			Paneau_Center.add(btnDent7);
			Paneau_Center.add(btnDent6);
			Paneau_Center.add(btnDent5);
			Paneau_Center.add(btnDent4);
			Paneau_Center.add(btnDent3);
			Paneau_Center.add(btnDent2);
			Paneau_Center.add(btnDent1);
			Paneau_Center.add(btnDent17);
			Paneau_Center.add(btnDent18);
			Paneau_Center.add(btnDent19);
			Paneau_Center.add(btnDent20);
			Paneau_Center.add(btnDent21);
			Paneau_Center.add(btnDent22);
			Paneau_Center.add(btnDent23);
			Paneau_Center.add(btnDent24);
			Paneau_Center.add(btnDent25);
			Paneau_Center.add(btnDent26);
			Paneau_Center.add(btnDent27);
			Paneau_Center.add(btnDent28);
			Paneau_Center.add(btnDent29);
			Paneau_Center.add(btnDent30);
			Paneau_Center.add(btnDent31);
			Paneau_Center.add(btnDent32);

	 	}
	 	void editButtons(String cin) throws IOException {
	 		File file = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+cin.trim()+"\\tooth.txt");
	 		System.out.println(file.getAbsolutePath());
	 		ArrayList<String> btn = new ArrayList<>();
	 		ArrayList<String> acte = new ArrayList<>();
 
		    file.createNewFile();
		 		    Scanner sc = new Scanner(file); 
		 		    while (sc.hasNext()) {
			 		 	btn.add(sc.next());
			 		 	sc.next();
			 		 	acte.add(sc.next());
//			 		 	System.out.println("1 - "+sc.next());
//			 		 	sc.next();
//			 		 	System.out.println("1 - "+sc.next());		 		    	
		 		    }
		 		    sc.close();
		 		    for (String value : btn) {
		 		
		 		if(value.equals("btnDent1")) {
		 			btnDent1.setVisible(true);
		 		}
		 		if(value.equals("btnDent2")) {
		 			btnDent2.setVisible(true);
		 		}
		 		if(value.equals("btnDent3")) {
		 			btnDent3.setVisible(true);
		 		}
		 		if(value.equals("btnDent4")) {
		 			btnDent4.setVisible(true);
		 		}
		 		if(value.equals("btnDent5")) {
		 			btnDent5.setVisible(true);
		 		}
		 		if(value.equals("btnDent6")) {
		 			btnDent6.setVisible(true);
		 		}
		 		if(value.equals("btnDent7")) {
		 			btnDent7.setVisible(true);
		 		}
		 		if(value.equals("btnDent8")) {
		 			btnDent8.setVisible(true);
		 		}
		 		if(value.equals("btnDent9")) {
		 			btnDent9.setVisible(true);
		 		}
		 		if(value.equals("btnDent10")) {
		 			btnDent10.setVisible(true);
		 		}
		 		if(value.equals("btnDent11")) {
		 			btnDent11.setVisible(true);
		 		}
		 		
		 		if(value.equals("btnDent12")) {
		 			btnDent12.setVisible(true);
		 		}
		 		if(value.equals("btnDent13")) {
		 			btnDent13.setVisible(true);
		 		}
		 		if(value.equals("btnDent14")) {
		 			btnDent14.setVisible(true);
		 		}
		 		if(value.equals("btnDent15")) {
		 			btnDent15.setVisible(true);
		 		}
		 		if(value.equals("btnDent16")) {
		 			btnDent16.setVisible(true);
		 		}
		 		if(value.equals("btnDent17")) {
		 			btnDent17.setVisible(true);
		 		}
		 		if(value.equals("btnDent18")) {
		 			btnDent18.setVisible(true);
		 		}
		 		if(value.equals("btnDent19")) {
		 			btnDent19.setVisible(true);
		 		}
		 		if(value.equals("btnDent20")) {
		 			btnDent20.setVisible(true);
		 		}
		 		if(value.equals("btnDent21")) {
		 			btnDent21.setVisible(true);
		 		}
		 		
		 		if(value.equals("btnDent22")) {
		 			btnDent22.setVisible(true);
		 		}
		 		if(value.equals("btnDent23")) {
		 			btnDent23.setVisible(true);
		 		}
		 		if(value.equals("btnDent24")) {
		 			btnDent24.setVisible(true);
		 		}
		 		if(value.equals("btnDent25")) {
		 			btnDent25.setVisible(true);
		 		}
		 		if(value.equals("btnDent26")) {
		 			btnDent26.setVisible(true);
		 		}
		 		if(value.equals("btnDent27")) {
		 			btnDent27.setVisible(true);
		 		}
		 		if(value.equals("btnDent28")) {
		 			btnDent28.setVisible(true);
		 		}
		 		if(value.equals("btnDent29")) {
		 			btnDent29.setVisible(true);
		 		}
		 		if(value.equals("btnDent30")) {
		 			btnDent30.setVisible(true);
		 		}
		 		if(value.equals("btnDent31")) {
		 			btnDent31.setVisible(true);
		 		}
		 		if(value.equals("btnDent32")) {
		 			btnDent32.setVisible(true);
		 		}
		 		if(value.equals("btnDent33")) {
		 			btnDent1.setVisible(true);
		 		}
			}
	 	}
	 
	 	public tooth_list(String cin) {
	 	
	 		
			this.setTitle("Show dents");
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setSize(900,600);
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(new BorderLayout());
			//panel
			initPanel();

			this.getContentPane().add(Paneau_Center,BorderLayout.CENTER);
			this.getContentPane().add(Paneau_East,BorderLayout.EAST);

			initButtons();
			initlabel();
			try {
				editButtons(cin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		 		   		}
	}