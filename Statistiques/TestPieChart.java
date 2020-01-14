		package Statistiques;

		import java.awt.*; 
		import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*; 
		import org.jfree.chart.*; 
		import org.jfree.data.general.DefaultPieDataset; 

		public class TestPieChart extends JFrame { 
		  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		private JPanel pnl; 

		  @SuppressWarnings("deprecation")
		public TestPieChart() throws FileNotFoundException { 
			addWindowListener(new WindowAdapter() { 
			  public void windowClosing(WindowEvent e) { 
//				dispose(); 
//				System.exit(0); 
			  }   
			}); 
			pnl = new JPanel(new BorderLayout()); 
			setContentPane(pnl); 
			setSize(800, 500); 
			setDefaultCloseOperation(HIDE_ON_CLOSE);

			DefaultPieDataset pieDataset = new DefaultPieDataset(); 
			int nbrFemme = 0 , nbrHomme = 0;
			/*------------------------------------------------------------------------------------*/
			List<String> result = null ;
		    try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Patients"))) {

	    		result = walk.filter(Files::isRegularFile)
	    				.map(x -> x.toString()).collect(Collectors.toList());
	    		//file_names.forEach(System.out::println);

	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	        //--------------  loop throw the files  ----------------------------
	          
	        for (int i = 0; i < result.size(); i++) {
	        	 File file = new File((String) result.get(i)); 
	             Scanner sc = new Scanner(file); 
	             int k= 0;
	             for (String data : sc.nextLine().split("-")) {
//	            	  System.out.println( k +" - "+data);
	            	  if(k== 3) {
	            		  if(data.trim().equals("Femme"))nbrFemme++;
	            		  if(data.trim().equals("Homme"))nbrHomme++;
	            	  }
	            	  k++;
				}
	             sc.close();
	        }
			/*************************************************************************************/
			pieDataset.setValue("Femme", new Integer(nbrFemme)); 
			pieDataset.setValue("Homme", new Integer(nbrHomme)); 
 
			JFreeChart pieChart = ChartFactory.createPieChart("pourcentage des hommes et des femmes dans notre cabinet", 
			  pieDataset, true, true, true); 
			ChartPanel cPanel = new ChartPanel(pieChart); 
			pnl.add(cPanel); 
		  } 

		}