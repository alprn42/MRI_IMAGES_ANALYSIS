import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYBarDataset;

public class Analyze {
	public static void main(String[] args) {
		double[] xvalues = new double[]{1,2,3,4};
		double[] yvalues = new double[4];
		yvalues[0]=SelectedArea.values[0];
		yvalues[1]=SelectedArea.values[1];
		yvalues[2]=SelectedArea.values[2];
		yvalues[3]=SelectedArea.values[3];
		
		double[][] valuepairs = new double[2][];
		valuepairs[0] =  xvalues;
		valuepairs[1] = yvalues;
		DefaultXYDataset set = new DefaultXYDataset();
		set.addSeries("MR PHOTOS",valuepairs);		
		XYBarDataset barset = new XYBarDataset(set,0.8);
		JFreeChart chart = ChartFactory.createXYBarChart(
			"INTENSITY GRAPH OF SELECTED AREAS","",false,"INTENSITY VALUES",
			barset,PlotOrientation.VERTICAL,true, true, false);
		JFrame frame = new JFrame("Test");
		frame.setContentPane(new ChartPanel(chart));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}