package teste;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jfree.data.xy.XYSeries;

public class Board extends JPanel implements MouseMotionListener, MouseListener{
	
	Carro carro;
	private Timer timer;
	private Temporizador temporizador;
	boolean playCarro=false;
	AttCarro painel;
	private java.util.List<DesenhoMaoLivre> desenhos = new ArrayList<DesenhoMaoLivre>();
	DesenhoMaoLivre desenhoCorrente;
	private boolean apagar = false;
	private Trena trena;
	float tempo = 0;
	private Bar bar;
	private Bar bar2;
	private Cronometro cronometro;
	float tempoParaPercorrer;
	int x = 25;
	
	public Board(Bar bar,Bar bar2) {
		setBorder(new TitledBorder(null, "Quadro", TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		setBackground(new Color(85, 107, 47));
		setSize(1000, 570);
		setLayout(null);
		
		carro = new Carro();
		add(carro);
		
		trena = new Trena(this);
		add(trena);
		
		painel = new AttCarro(carro,trena,this);
		add(painel);
		
		timer = new Timer();
		temporizador = new Temporizador();
		timer.scheduleAtFixedRate(temporizador, 80, 1000);
		
		repaint();
		
		this.bar = bar;
		this.bar2 = bar2;
		
		cronometro = new Cronometro();
		cronometro.start();
	}
	
	public void setPlayCarro(boolean g){
		if(carro.getVelocidade()==0){
			JOptionPane.showMessageDialog(null, "O carro nao apresenta velocidade!");
		}else if(trena.getEspacoTotal()==0){
			JOptionPane.showMessageDialog(null, "Não existe espaço a ser percorrido");
		}else{
			this.playCarro=g;
		}
		tempoParaPercorrer = (int)(trena.getEspacoTotal()-trena.getEspacoInicial())/carro.getVelocidade();
		if(tempoParaPercorrer<1){
			tempoParaPercorrer=1;
		}
		timer.cancel();
		timer = new Timer();
		temporizador = new Temporizador();
		timer.scheduleAtFixedRate(temporizador, 80, (int)tempoParaPercorrer);
		
		//repaint();
	}
	
	public void pausar(){
		this.playCarro=false;
	}
	
	public void reiniciar(){
		this.x=25;;
		tempo=0;
		trena.setEspacoCorrente(0);
		painel.atualizar();
		playCarro=false;
		bar.getSeries().clear();
		bar2.getSeries().clear();
	}
	
	public Temporizador getTemporizador(){
		return temporizador;
	}
	
	public float getTempo(){
		return tempo;
	}
	
	class Temporizador extends TimerTask {
        public void run() {	
        	if(playCarro){
        		if(x%10==0||tempo==0){
        			bar.getSeries().add(tempo,trena.getEspacoCorrente());
        			bar2.getSeries().add(tempo,trena.getEspacoCorrente());
        		}
        		x+=1;
        		//tempo+=0.01;
        		trena.setEspacoCorrente(carro.getVelocidade()*tempo);
        		painel.atualizar();
        	}
            carro.setLocation(x, 500); 
            if(tempo>=tempoParaPercorrer){
            	playCarro=false;
            }
        }
        
        
    }
	
	public void setX(int x){
    	this.x = x;
    }
	
	public AttCarro getAttCarro(){
		return painel;
	}
	
	protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    for (DesenhoMaoLivre desenho : this.desenhos) {
			desenho.repaint(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.desenhoCorrente = null;		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(!apagar){
			if (this.desenhoCorrente == null) {
				this.desenhoCorrente = new DesenhoMaoLivre();
				this.desenhoCorrente.setCor(Color.WHITE);
				this.desenhoCorrente.setEspessura(3);
				this.desenhos.add(this.desenhoCorrente);
			
			}
			this.desenhoCorrente.add(e.getPoint());
		}
		repaint(); //request Swing to refresh display as soon as it can
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void adicionarEventoDesenharMaoLivre() {
		addMouseMotionListener(this);
		addMouseListener(this);
		apagar=false;
		
	}

	public void apagarDesenhoMaoLivre() {
		apagar=true;
		//setCursor(new Cursor(Cursor.HAND_CURSOR));
		desenhos=new ArrayList<>();
		repaint();
	}
	public class Cronometro extends Thread{
		
		@Override
		public void run() {
			try {
				while(true){
					if(playCarro){
						tempo+=0.01;
					}
					Thread.sleep(9);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
