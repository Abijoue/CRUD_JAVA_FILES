package view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class progress_bar extends JFrame{
	
	/**
	 * The Ghost was here
	 */
	private static final long serialVersionUID = 1L;private Thread t;
	private JProgressBar bar;
 	ImageIcon image ;
    private JLabel image_Title;


   void init(){
	     t = new Thread(new Traitement()); 
		 bar = new JProgressBar();
	 	 image = new ImageIcon("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\img\\Dental-logo.jpg");
	     image_Title  = new JLabel(image);

    }

	 public progress_bar()
	 {
		 init();
 
		 this.setSize(300,120); 
		 this.setLocationRelativeTo(null);
		 this.setUndecorated(true);

		 bar.setMaximum(500);
		 bar.setMinimum(0);
		 bar.setStringPainted(true);
		 
		 this.getContentPane().add(bar, BorderLayout.SOUTH);
		 this.getContentPane().add(image_Title, BorderLayout.CENTER);
		 t.start();
		 
	 }
	 class Traitement implements Runnable
	 {
		 @SuppressWarnings("static-access")
		public void run()
		 {
			 for(int val = 0; val <= 500; val++)
			 {
				 bar.setValue(val);
				 try
				 {
					 t.sleep(10);
				 }catch (InterruptedException e){e.printStackTrace(); }
			 }		      
			 
		 }
	 }
	 
}