package splitwise;

import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart extends ApplicationFrame 
{
    int user_id;
    ChartPanel CP;
   
   public PieChart( String title, int user_id) {
      super( title ); 
      this.user_id = user_id;
      CP = createDemoPanel( );
   }
   
   private PieDataset createDataset( ) 
   {
       api a = new api();
       List<DataSetItem> DSItems = a.getDataSetFor(user_id);
       DefaultPieDataset dataset = new DefaultPieDataset( );
       for(int i=0;i<DSItems.size();i++)
       {
        dataset.setValue( DSItems.get(i).getName(), DSItems.get(i).getCost());
       }
       a.closeConnection();
       return dataset;         
   }
   
   private JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "This Months Spending",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public ChartPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
}