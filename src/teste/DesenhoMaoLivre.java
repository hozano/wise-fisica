package teste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class DesenhoMaoLivre {
	
	private ArrayList<Point> points;
        private Color cor;
        private int espessura;
	
	public DesenhoMaoLivre() {
		this.points = new ArrayList();
	}
	
	public void repaint(Graphics g) {
	    for (int i = 0; i < this.points.size() - 2; i++)
	    {
	        Point p1 = points.get(i);
	        Point p2 = points.get(i + 1);
	        
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(cor);
            g2d.setStroke(new BasicStroke(espessura, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        	g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
	    }
	}
	
	public void add(Point point) {
		this.points.add(point);
	}
        
        public void setCor(Color cor){
            this.cor = cor;
        }
        
        public void setEspessura(int espessura){
            this.espessura = espessura;
        }

}
