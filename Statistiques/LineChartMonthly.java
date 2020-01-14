package Statistiques;

import org.jfree.chart.ChartPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartMonthly extends ApplicationFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public LineChartMonthly( String applicationTitle , String chartTitle ) throws FileNotFoundException {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Jours","Revenue",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      
   }

   private DefaultCategoryDataset createDataset( ) throws FileNotFoundException {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      /*
      /*------------------------------------------------------------------------------------*/
		List<String> result = null ;
	    try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\The_ghost\\eclipse-workspace\\Cabinet dentaire\\src\\DB\\Revenus"))) {

  		result = walk.filter(Files::isRegularFile)
  				.map(x -> x.toString()).collect(Collectors.toList());
  		//file_names.forEach(System.out::println);

  	} catch (IOException e) {
  		e.printStackTrace();
  	}
      //--------------  loop throw the files  ----------------------------
	     LocalDate lt = LocalDate.now();
//	     String temp = Integer.toString(lt.getMonthValue());
	     
	     ArrayList<String> days = new ArrayList<>();
	     ArrayList<String> values = new ArrayList<>();

        System.out.println(lt.getMonthValue());
        Collections.sort(result);
        System.out.println(result);
      for (int i = 0; i < result.size(); i++) {
      	 File file = new File((String) result.get(i)); 
           Scanner sc = new Scanner(file); 
           String name = file.getName().replaceFirst("[.][^.]+$", "");
           for (String data : sc.nextLine().split("-")) {
          	 	if(Integer.valueOf(name.split("-")[1]) == lt.getMonthValue()) {
          	 			values.add(data);
          	 			days.add(name.split("-")[2]);
          	 	}
			}
           sc.close();
      }
		/*************************************************************************************/

      for (int i = 0; i < values.size(); i++) {
    	  dataset.addValue( Integer.parseInt(values.get(i)) , "revenu" , days.get(i) );
	}
          return dataset;
   }
   
}