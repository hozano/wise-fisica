package teste;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Trena extends JPanel implements MouseListener{
	
	private ImageIcon trena = new ImageIcon(getClass().getResource("../imagens/trena.png"));
	private int espacoFinal=0;
	private float espacoCorrente=0;
	private int espacoInicial=0;
	private Graphics2D g2d;
	private Board board;
	
	public Trena(Board board){
		setSize(1000,30 );
		setLocation(120, 550);
		addMouseListener(this);
		this.board=board;
	}
	
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    	g2d.drawLine(1, 15, 899, 15);
    	g2d.drawLine(0, 0, 0, 30);
    	g2d.drawLine(900, 0, 900, 30);
    	g2d.drawLine(450, 0, 450, 30);
    	g2d.drawLine(225, 0, 225, 30);
    	g2d.drawLine(675, 0, 675, 30);
    	int delta = (espacoFinal-espacoInicial)/4;
    	g2d.drawString(" "+espacoInicial, 5, 30);
    	g2d.drawString(" "+(espacoInicial+delta), 230, 30);
    	g2d.drawString(" "+(espacoInicial+2*delta), 455, 30);
    	g2d.drawString(" "+(espacoInicial+3*delta), 680, 30);
    	g2d.drawString(" "+espacoFinal, 905, 30);
	}
	
	public Graphics2D getG2d(){
		return g2d;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		espacoInicial = Integer.parseInt(JOptionPane.showInputDialog("Determine o espaço inicial (S0)"));
		espacoCorrente=espacoInicial;
		espacoFinal = Integer.parseInt(JOptionPane.showInputDialog("Determine o espaço final (S)"));
		board.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getEspacoTotal() {
		return espacoFinal;
	}
	
	public float getEspacoCorrente() {
		return espacoCorrente;
	}
	
	public float getEspacoInicial() {
		return espacoInicial;
	}
	
	public void setEspacoCorrente(float x) {
		espacoCorrente=espacoInicial+x;
	}
}
