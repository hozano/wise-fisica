package teste;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JInternalFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
    
public class Bar extends JInternalFrame {     
    
	XYSeries series;
	
	private static final long serialVersionUID = 1L;
	public Bar(final String title) {     
    
        super(title);     
        series = new XYSeries("Movimento");
        series.add(0,0);
        
        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart("Gráfico", "TEMPO", "DISTANCIA",     
        data,PlotOrientation.VERTICAL , true,true, false);
        final ChartPanel chartPanel = new ChartPanel(chart);     
        chartPanel.setPreferredSize(new java.awt.Dimension (500, 270));
        chart.setBackgroundPaint(Color.getHSBColor(7, 32, 121));
        setContentPane(chartPanel);
 
    }
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	public XYSeries getSeries(){
		return series;
	}  
  
}    
