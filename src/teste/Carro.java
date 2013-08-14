package teste;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Carro extends JPanel implements MouseListener{
	
	ImageIcon carro = new ImageIcon(getClass().getResource("../imagens/coche_antiguo.gif"));
	private int velocidade;
	
	public Carro(){
		setSize(100, 50);
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(carro.getImage(), 0, 0, null);
        g.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		velocidade = Integer.parseInt(JOptionPane.showInputDialog("Determine a velocidade (V)"));
		
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

	public int getVelocidade() {
		return velocidade;
	}
}
