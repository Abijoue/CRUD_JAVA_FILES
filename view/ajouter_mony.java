package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import javaBeans.Patient;

public class ajouter_mony extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton  add , reseat , close ;
 	JTextField textMoney ;
 	JPanel Pcenter , Psouth;
 	
 	void initPanel(){
 		Pcenter = new JPanel();
 		Psouth = new JPanel();
 		
 		Pcenter.setBackground(new Color(255,94,94));
 		Psouth.setBackground(new Color(196,196,196));

 		Pcenter.setSize(200, 150);
 	}
 	void initButton(String s){
 		add = new JButton("add");
 		reseat = new JButton("Reseat");
 		close = new JButton("close");
 		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == add) {
					String somme = textMoney.getText();
					if (somme.length()>0) {
						try {
							FileWriter(s ,  somme);
							System.out.println("Le patien "+s+"Montant"+somme);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}else {
				        JOptionPane.showMessageDialog(null, "remplire le champ SVP");

					}
				}
			}
		});
 		
 		reseat.addActionListener(this);
 		close.addActionListener(this);

 		Psouth.add(add);
 		Psouth.add(reseat);
 		Psouth.add(close);

 	}
 	void initJTextField(){
 		textMoney = new JTextField(10);
 		textMoney.addKeyListener(new KeyAdapter() {
 		   public void keyPressed(KeyEvent ke) {
 		      if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
 		    	 textMoney.setEditable(true);
 		      } else {
 		    	 textMoney.setEditable(false);
 		      }
 		   }
 		});
 		textMoney.setLocation(150, 100);
 		Pcenter.add(textMoney);
 	}

	public ajouter_mony(Patient p) {
 		
		this.setTitle("Ajouter Money");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,120);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		initPanel();
		this.getContentPane().add(Pcenter,BorderLayout.CENTER);
		this.getContentPane().add(Psouth,BorderLayout.SOUTH);
		initButton(p.getCin());
		initJTextField();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == reseat) {
				textMoney.setText("");
			}
			if(e.getSource() == close) {
				this.dispose();
			}
	}
	
	public void FileWriter(String name , String somme) throws IOException 
	{
	    String fileContent_avance = somme;

	    File file_avance = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+name.trim()+"\\Avance.txt");
	    file_avance.createNewFile();

	    //Create the file
	    try {
	            FileWriter writer = new FileWriter(file_avance,true);
			    if (!file_avance.createNewFile()) writer.write("\n");
	            writer.write(fileContent_avance);
	            writer.close();
	        	JOptionPane.showMessageDialog(this, "the Money added ");
	               
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	  
	}



}
