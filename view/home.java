package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class home extends JFrame implements ActionListener  {
	/**
	 * author : ABIJOUE MOHAMED 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame cadre ;
	JButton  List_pat , List_rv , list_stat , nbr_rdv , date_disp , rev;
 	JPanel Paneau_Center,Paneau_West,Paneau_North , Paneau_Titile ,Paneau_buttons , Paneau_infoArea ,Paneau_South;
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
 		Paneau_infoArea = new JPanel();
 		Paneau_infoArea.setLayout(new BorderLayout());
 		
 		
 		Paneau_Center.add(Paneau_infoArea);
 		Paneau_Center.setLayout(new BorderLayout());
 		Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
 		
 		Paneau_South = new JPanel();
 		Paneau_South.setLayout(new GridLayout(1, 2));
 		Paneau_South.setBackground(new Color(240,250,240)); //Soft green color


 	}
 	public void initLabel() {
 		ImageIcon image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
 		image_Title = new JLabel(image);
 		Paneau_Titile.add(image_Title);
 	}
 	
 	public void initButtons() throws IOException {
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
 		//
		LocalDate now = LocalDate.now();
		String d = now.toString();
		List<String> result = null;
		 try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous\\"+d))) {

	     		 result = walk.filter(Files::isRegularFile)
	     				.map(x -> x.toString()).collect(Collectors.toList());
	     		
		 } catch (IOException e) {
			e.printStackTrace();
		}
		 int size = result.size();
 		ImageIcon nbr_rdv_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_pat.jfif");
 		nbr_rdv = new JButton("Nombre des rendez vour Aujourd'hui : "+size,nbr_rdv_img);		
 		nbr_rdv.setForeground(Color.BLACK);
 		nbr_rdv.setBackground(Color.WHITE);
 		////
 		ImageIcon img_date = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\img_date.PNG");
 		date_disp = new JButton("La date d'aujourd'hui :"+d,img_date);	
 		date_disp.setForeground(Color.BLACK);
 		date_disp.setBackground(Color.WHITE);
 		////
 		
 		File file_rev = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Revenus\\"+now.toString()+".txt");
 		file_rev.createNewFile();
 		String mony = "0";
 		Scanner sc;
 		if(file_rev.exists() == true) {
 			sc = new Scanner(file_rev); 
 		    while (sc.hasNext()) {
 		    	mony =sc.next();
 		    	System.out.println(mony);

 		    }
 		 	sc.close(); 
	 	 }
 		ImageIcon img_revenu = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\revenue.PNG");
 		rev = new JButton("Le revenue d'aujourd'hui :"+mony+" DH",img_revenu);	
 		rev.setForeground(Color.BLACK);
 		rev.setBackground(Color.WHITE);

 		Paneau_buttons.add(List_pat); 
 		Paneau_buttons.add(List_rv);
 		Paneau_buttons.add(list_stat); 	
 		
 		Paneau_Center.add(date_disp,BorderLayout.PAGE_START);
// 		Paneau_South.add(nbr_rdv,BorderLayout.LINE_END);
 		Paneau_South.add(rev);
 		Paneau_South.add(nbr_rdv);

 	}
 
 	public home() {
 	
 		Dimension Ecran = Toolkit.getDefaultToolkit().getScreenSize();
 		
		this.setTitle("projet Cabinet Dentaire - JAVA -");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Ecran.width-250,Ecran.height-220);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		//panel
		initPanel();
		this.getContentPane().add(Paneau_North,BorderLayout.NORTH);
		this.getContentPane().add(Paneau_West,BorderLayout.WEST);
		this.getContentPane().add(Paneau_Center,BorderLayout.CENTER);
		this.getContentPane().add(Paneau_South,BorderLayout.SOUTH);

		initLabel();
		try {
			initButtons();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		if(e.getSource() == List_rv) {
			Liste_RV lrv = new Liste_RV();
			lrv.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == list_stat) {
			Statistiques st = new Statistiques();
			st.setVisible(true);
			this.dispose();
		}
		
	}

}
