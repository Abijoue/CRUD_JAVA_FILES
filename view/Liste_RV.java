package view;

    import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

	public class Liste_RV extends JFrame implements ActionListener  {
		/**
		 * author : ABIJOUE MOHAMED 
		 */
		private static final long serialVersionUID = 1L;
		
		JButton  home , set ;
	 	JPanel Paneau_Center,Paneau_West,Paneau_North , Paneau_Titile ,Paneau_buttons , Paneau_infoArea ,Paneau_label_soir , Paneau_label_mat ,Paneau_South ;
	 	JLabel image_Title;
	 	JLabel L1 , L2 ,L3 ,L4 ,L5 ,L6 ,L7 ,L8 ,L9 ,L10 ,
	 		   L11 ,L12 ,L13 ,L14 ,L15 ,L16 ,L17 ,L18 ,L19,L20;
	 	UtilDateModel model ;
	 	Properties p ;
	 	JDatePickerImpl datePicker ;
	 	
	 	
	 	public void initPanel() {
	 		
	 		Paneau_North = new JPanel();	
	 		Paneau_West = new JPanel();	
	 		Paneau_Center = new JPanel();
	 		Paneau_South = new JPanel();

	 		
	//title panel
	 		Paneau_Titile = new JPanel();
	 		Paneau_North.add(Paneau_Titile);
	 		Paneau_North.setBackground(new Color(238,238,238));
	//button panel
	 		Paneau_buttons = new JPanel();
	 		Paneau_buttons.setLayout(new GridLayout(2, 1 , 5 ,9));
	 		Paneau_West.add(Paneau_buttons);

	//filed  panel 	
	 		Paneau_infoArea = new JPanel();
	 		Paneau_label_mat = new JPanel();
	 		Paneau_label_soir = new JPanel();

	 		Paneau_label_mat.setLayout(new GridLayout(10, 1));
	 		Paneau_label_soir.setLayout(new GridLayout(10, 1));

	 		Paneau_infoArea.setLayout(new BorderLayout());
//	 		Paneau_Center.add(Paneau_infoArea);
	 		
	 		Paneau_Center.setBackground(new Color(240,250,240)); //Soft green color
	 		Paneau_Center.setLayout(new GridLayout(1,2));
	 		
	 	}

	 	public void initLabel() {
	 		ImageIcon image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
	 		image_Title = new JLabel(image);
	 		Paneau_Titile.add(image_Title);
	 		
	 		L1 = new JLabel("8:00 - Libre -");	Paneau_label_mat.add(L1);
	 		L2 = new JLabel("8:30 - Libre -");	Paneau_label_mat.add(L2);
	 		L3 = new JLabel("9:00 - Libre -");	Paneau_label_mat.add(L3);
	 		L4 = new JLabel("9:30 - Libre -");	Paneau_label_mat.add(L4);
	 		L5 = new JLabel("10:00 - Libre -");	Paneau_label_mat.add(L5);
	 		L6 = new JLabel("10:30 - Libre -");	Paneau_label_mat.add(L6);
	 		L7 = new JLabel("11:00 - Libre -");	Paneau_label_mat.add(L7);
	 		L8 = new JLabel("11:30 - Libre -");	Paneau_label_mat.add(L8);
	 		L9 = new JLabel("12:00 - Libre -");	Paneau_label_mat.add(L9);
	 		L10= new JLabel("12:30 - Libre -");	Paneau_label_mat.add(L10);
	 		
	 		L11 = new JLabel("14:00 - Libre -");	Paneau_label_soir.add(L11);
	 		L12 = new JLabel("14:30 - Libre -");	Paneau_label_soir.add(L12);
	 		L13 = new JLabel("15:00 - Libre -");	Paneau_label_soir.add(L13);
	 		L14 = new JLabel("15:30 - Libre -");	Paneau_label_soir.add(L14);
	 		L15 = new JLabel("16:00 - Libre -");	Paneau_label_soir.add(L15);
	 		L16= new JLabel("16:30 - Libre -");		Paneau_label_soir.add(L16);
	 		L17= new JLabel("17:00 - Libre -");		Paneau_label_soir.add(L17);
	 		L18 = new JLabel("17:30 - Libre -");	Paneau_label_soir.add(L18);
	 		L19= new JLabel("18:00 - Libre -");		Paneau_label_soir.add(L19);
	 		L20= new JLabel("18:30 - Libre -");		Paneau_label_soir.add(L20);
	 		
	 		Paneau_Center.add(Paneau_label_mat);
	 		Paneau_Center.add(Paneau_label_soir);
	 		
	 		//edit Label
	      //  List file_names = new ArrayList<>() ;
	        LocalDate d = LocalDate.now();
	        String date = d.toString();

	 		 try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous\\"+date))) {

	     		List<String> result = walk.filter(Files::isRegularFile)
	     				.map(x -> x.toString()).collect(Collectors.toList());
	     		//file_names = result;
	     		//result.forEach(x -> System.out.println(x));
	     		
	     		for (int i = 0; i < result.size(); i++) {
		        	 File file = new File((String) result.get(i)); 
		             Scanner sc = new Scanner(file); 
		             String name = sc.next();
		             switch (file.getName()) {
					 case "8.00.txt": L1.setText("8:00  :   -    "+name);L1.setForeground (Color.red); break;
					 case "8.30.txt": L2.setText("8:30  :   -    "+name);L2.setForeground (Color.red);break;
					 case "9.00.txt": L3.setText("9:00  :   -    "+name);L3.setForeground (Color.red);break;
					 case "9.30.txt": L4.setText("9:30  :   -    "+name);L4.setForeground (Color.red);break;
					 case "10.00.txt": L5.setText("10:00  :   -    "+name);L5.setForeground (Color.red);break;
					 case "10.30.txt": L6.setText("10:30  :   -    "+name);L6.setForeground (Color.red);break;
					 case "11.00.txt": L7.setText("11:00  :   -    "+name);L7.setForeground (Color.red);break;
					 case "11.30.txt": L8.setText("1:30  :   -    "+name);L8.setForeground (Color.red);break;
					 case "12.00.txt": L9.setText("12:00  :   -    "+name);L9.setForeground (Color.red);break;
					 case "12.30.txt": L10.setText("12:30  :   -    "+name);L10.setForeground (Color.red);break;
					 
					 case "14.00.txt": L11.setText("14:00  :   -    "+name);L11.setForeground (Color.red);break;
					 case "14.30.txt": L12.setText("14:30  :   -    "+name);L12.setForeground (Color.red);break;
					 case "15.00.txt": L13.setText("15:00  :   -    "+name);L13.setForeground (Color.red);break;
					 case "15.30.txt": L14.setText("15:30  :   -    "+name);L14.setForeground (Color.red);break;
					 case "16.00.txt": L15.setText("16:00  :   -    "+name);L15.setForeground (Color.red);break;
					 case "16.30.txt": L16.setText("16:30  :   -    "+name);L16.setForeground (Color.red);break;
					 case "17.00.txt": L17.setText("17:00  :   -    "+name);L17.setForeground (Color.red);break;
					 case "17.30.txt": L18.setText("17:30  :   -    "+name);L18.setForeground (Color.red);break;
					 case "18.00.txt": L19.setText("18:00  :   -    "+name);L19.setForeground (Color.red);break;
					 case "18.30.txt": L20.setText("18:30  :   -    "+name);L20.setForeground (Color.red);break;
					}
		             sc.close();
		        }
	     	} catch (IOException e) {
	     		e.printStackTrace();
	     	}
	 		
	 	}
	 	
	 	
	 	
	 	public void initButtons() {
	 		ImageIcon home_img = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\home.jpg");
	 		home = new JButton("",home_img);		
	 		home.setBackground(Color.WHITE);
	 		home.addActionListener(this);
	 		
	 		Paneau_buttons.add(home); 	

	 		set = new JButton("Search");		
	 		set.addActionListener(this);
	 		
	 		Paneau_South.add(set); 	

	 	}
	 	void initJdatePicker() {
 			model = new UtilDateModel();
 			model.setSelected(true);
 			Properties p = new Properties();
 			p.put("text.today", "Today");
 			p.put("text.month", "Month");
 			p.put("text.year", "Year");
 			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
 	        
 	        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
 	        Paneau_South.add(datePicker);

 	} 
	 
	 	public Liste_RV() {
	 	
	 		Dimension Ecran = Toolkit.getDefaultToolkit().getScreenSize();
	 		
			this.setTitle("projet Cabinet Dentaire - JAVA -");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(Ecran.width-600,Ecran.height-250);
			this.setLocationRelativeTo(null);
			this.getContentPane().setLayout(new BorderLayout());
			//panel
			initPanel();
			this.getContentPane().add(Paneau_North,BorderLayout.NORTH);
			this.getContentPane().add(Paneau_West,BorderLayout.WEST);
			this.getContentPane().add(Paneau_Center,BorderLayout.CENTER);
			this.getContentPane().add(Paneau_South,BorderLayout.SOUTH);

			initLabel();
			initButtons();
			initJdatePicker();

		}
		@Override
		public void actionPerformed(ActionEvent e) {
				if(e.getSource() == home) {
					home h = new home();
					h.setVisible(true);
					this.dispose();
				}
				if (e.getSource() == set) {
					
					L1.setText("8:00 - Libre -");	L1.setForeground(Color.black);
			 		L2.setText("8:30 - Libre -");	L2.setForeground(Color.black);
			 		L3.setText("9:00 - Libre -");	L3.setForeground(Color.black);
			 		L4.setText("9:30 - Libre -");	L4.setForeground(Color.black);
			 		L5.setText("10:00 - Libre -");	L5.setForeground(Color.black);
			 		L6.setText("10:30 - Libre -");	L6.setForeground(Color.black);
			 		L7.setText("11:00 - Libre -");	L7.setForeground(Color.black);
			 		L8.setText("11:30 - Libre -");	L8.setForeground(Color.black);
			 		L9.setText("12:00 - Libre -");	L9.setForeground(Color.black);
			 		L10.setText("12:30 - Libre -");	L10.setForeground(Color.black);
			 		
			 		L11.setText("14:00 - Libre -");	L11.setForeground(Color.black);
			 		L12.setText("14:30 - Libre -");	L12.setForeground(Color.black);
			 		L13.setText("15:00 - Libre -");	L13.setForeground(Color.black);
			 		L14.setText("15:30 - Libre -");	L14.setForeground(Color.black);
			 		L15.setText("16:00 - Libre -");	L15.setForeground(Color.black);
			 		L16.setText("16:30 - Libre -");	L16.setForeground(Color.black);
			 		L17.setText("17:00 - Libre -");	L17.setForeground(Color.black);
			 		L18.setText("17:30 - Libre -");	L18.setForeground(Color.black);
			 		L19.setText("18:00 - Libre -");	L19.setForeground(Color.black);
			 		L20.setText("18:30 - Libre -");	L20.setForeground(Color.black);
			 		
					String picked = datePicker.getJFormattedTextField().getText();
//					System.out.println(" TEST ------ DATE -------"+picked);

			 		 try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Rendez-vous\\"+picked))) {

			     		List<String> result = walk.filter(Files::isRegularFile)
			     				.map(x -> x.toString()).collect(Collectors.toList());
			     		//file_names = result;
//			     		result.forEach(x -> System.out.println(x));
			     		
			     		for (int i = 0; i < result.size(); i++) {
				        	 File file = new File((String) result.get(i)); 
				             Scanner sc = new Scanner(file); 
				             String name = sc.next();
				             System.out.println(file.getName());
				             switch (file.getName()) {
								 case "8.00.txt": L1.setText("8:00  :   -    "+name);L1.setForeground (Color.red); break;
								 case "8.30.txt": L2.setText("8:30  :   -    "+name);L2.setForeground (Color.red);break;
								 case "9.00.txt": L3.setText("9:00  :   -    "+name);L3.setForeground (Color.red);break;
								 case "9.30.txt": L4.setText("9:30  :   -    "+name);L4.setForeground (Color.red);break;
								 case "10.00.txt": L5.setText("10:00  :   -    "+name);L5.setForeground (Color.red);break;
								 case "10.30.txt": L6.setText("10:30  :   -    "+name);L6.setForeground (Color.red);break;
								 case "11.00.txt": L7.setText("11:00  :   -    "+name);L7.setForeground (Color.red);break;
								 case "11.30.txt": L8.setText("1:30  :   -    "+name);L8.setForeground (Color.red);break;
								 case "12.00.txt": L9.setText("12:00  :   -    "+name);L9.setForeground (Color.red);break;
								 case "12.30.txt": L10.setText("12:30  :   -    "+name);L10.setForeground (Color.red);break;
								 
								 case "14.00.txt": L11.setText("14:00  :   -    "+name);L11.setForeground (Color.red);break;
								 case "14.30.txt": L12.setText("14:30  :   -    "+name);L12.setForeground (Color.red);break;
								 case "15.00.txt": L13.setText("15:00  :   -    "+name);L13.setForeground (Color.red);break;
								 case "15.30.txt": L14.setText("15:30  :   -    "+name);L14.setForeground (Color.red);break;
								 case "16.00.txt": L15.setText("16:00  :   -    "+name);L15.setForeground (Color.red);break;
								 case "16.30.txt": L16.setText("16:30  :   -    "+name);L16.setForeground (Color.red);break;
								 case "17.00.txt": L17.setText("17:00  :   -    "+name);L17.setForeground (Color.red);break;
								 case "17.30.txt": L18.setText("17:30  :   -    "+name);L18.setForeground (Color.red);break;
								 case "18.00.txt": L19.setText("18:00  :   -    "+name);L19.setForeground (Color.red);break;
								 case "18.30.txt": L20.setText("18:30  :   -    "+name);L20.setForeground (Color.red);break;
							}
				             sc.close();
				        }
			     	} catch (IOException ex) {
			     		ex.printStackTrace();
			     	}
				}
		}

	}
