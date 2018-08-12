// A Pie-Chart instance represnts a JPannel that display a PieChart of the 
// spendings of the given user of the current month
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
    // Class Variables.
    int user_id;
    ChartPanel CP;
   
    // Constructor
    public PieChart( String title, int user_id) 
    {
      super( title ); 
      this.user_id = user_id;
      CP = createDemoPanel( );
    }
   
    // createDataSet: void -> PieDataSet
    // returns: a PieDataSet instance with with users current spendings.
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
   
    // createChart: PieDataSet -> JFreeChart
    // input: a PieDataSet instance representing a dataset for a Pie-Chart.
    // output: A JfreeChart instance to add to a JPannel
    private JFreeChart createChart( PieDataset dataset ) 
    {
      JFreeChart chart = ChartFactory.createPieChart(      
         "This Months Spending",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
    }
   
    // ChartPannel: void -> ChartPannel
    // Returns : a ChartPannel instance with the Pie-Chart.
    public ChartPanel createDemoPanel( ) 
    {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
    }
}