package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javaBeans.Patient;


public class ajouter_ordo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton  add , reseat , close ;
	JTextArea textord ;
	JLabel title ;
 	JPanel Pcenter , Psouth;
 	
 	void initPanel(){ 
 		Pcenter = new JPanel();
 		Psouth = new JPanel();
 		
 		Pcenter.setBackground(new Color(204,204,255));
 		
 		Psouth.setBackground(new Color(196,196,196));

 		Pcenter.setSize(200, 150);
 	}
 	void initButton(Patient p){
 		add = new JButton("add");
 		reseat = new JButton("Reseat");
 		close = new JButton("close");
 		
 		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == add) {
					String text = textord.getText();
					String name = p.getNom() + " " + p.getPrenom() + "\n" + p.getAge() + "\n \n \n";
					String cin = p.getCin();
				try {
					FileWriter( cin ,name ,  text);
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					try {
						Create_PDF(cin);
					} catch (IOException | DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
				        JOptionPane.showMessageDialog(null, "ordonnanes added");
					}
			}
		});
 		reseat.addActionListener(this);
 		close.addActionListener(this);

 		Psouth.add(add);
 		Psouth.add(reseat);
 		Psouth.add(close);

 	}
 	void initJlabel() {
 		title = new JLabel("Ordonnance");
 		Pcenter.add(title);

 	}
 	void initJTextField(){
 		textord = new JTextArea();
 		textord.setLocation(150, 100);
 		Pcenter.add(textord);
 	}
 	


	public ajouter_ordo(Patient p) {

		this.setTitle("Ajouter Ordonnance");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		initPanel();
		initJlabel();
		this.getContentPane().add(Pcenter,BorderLayout.CENTER);
		this.getContentPane().add(Psouth,BorderLayout.SOUTH);
		initButton(p);
		initJTextField();
	}
@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == reseat) {
				textord.setText("");
			}
			if(e.getSource() == close) {
				this.dispose();
			}
	}
	
	public void FileWriter(String cin , String name , String text) throws IOException 
	{
	    String fileContent_ord = " \n"+name+"\n"+text+"\n\n\n";

	    File file_ord = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+cin.trim()+"\\Ordonnance.txt");
	    file_ord.createNewFile();

	    //Create the file
	    try {
	            FileWriter writer = new FileWriter(file_ord);
	            writer.write(fileContent_ord);
	            writer.close();
	        	JOptionPane.showMessageDialog(this, "the ordonnance added");
	               
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	  
		}
	
	@SuppressWarnings({ "unused", "resource" })
	public void Create_PDF(String cin) throws MalformedURLException, IOException, DocumentException {
	    //Creat PDF ------------------------------ ITEXT -------------------------------
	    
		   String currentDirectory = System.getProperty("user.dir");
		   String chemin_pdf="C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+cin.trim();
		   String chemin_texts="C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+cin.trim()+"\\Ordonnance.txt";
		   
		   Document doc = new Document();
		   File file_pdf = new File(chemin_pdf, "Ordonnance.pdf");
		   FileOutputStream fOut = new FileOutputStream(file_pdf);
		   try {
			PdfWriter writer = PdfWriter.getInstance(doc, fOut);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	       doc.setMargins(50, 50, 50, 50);
	       doc.open();
	       
	       // Creating an Image object        
	   
	       Image image = Image.getInstance(currentDirectory+"\\src\\img\\ordonnancier-neutre.png");
	       try {
			doc.add(image);
			} catch (DocumentException e) {
				e.printStackTrace();
			}    
	    // Setting font of the text PdfFont 
	       Font largeBold = new Font(Font.FontFamily.TIMES_ROMAN, 32,Font.BOLD);
	       Paragraph title = new Paragraph("\n Ordonnance \n \n",largeBold);
	       title.setAlignment(Element.ALIGN_CENTER);
	       title.setFont(largeBold);
	       try {
			doc.add(title);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	       
	       File file = new File(chemin_texts);
	       FileReader fr = new FileReader(file);
	       BufferedReader br = new BufferedReader(fr);
	       String line;
	       while((line = br.readLine()) != null){
	    	   try {
				doc.add(new Paragraph(line));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	       
	       Paragraph date_p = new Paragraph();
	       Date date = new Date();
	       date_p.add("Le "+date+"\n Signature \n");
	       date_p.setAlignment(Element.ALIGN_BOTTOM);
	       date_p.setAlignment(Element.ALIGN_RIGHT);

	       doc.add(date_p);    

		   doc.close();
		   
		   File myFile = new File("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Dossier\\"+cin.trim()+"\\Ordonnance.pdf");
	        Desktop.getDesktop().open(myFile);

	}
	
	}
	



