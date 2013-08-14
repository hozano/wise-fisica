package teste;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

public class AttCarro extends JPanel {
	
	JLabel lblTempo;
	JLabel lblVelocidade;
	JLabel lblEspaco;
	private Carro carro;
	private Trena trena;
	private Board board;
	

	/**
	 * Create the panel.
	 */
	public AttCarro(Carro carro,Trena trena, Board board) {
		setBorder(new TitledBorder(null, "Característica carro MRU", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setBounds(20, 20, 200, 200);
		setBackground(Color.getHSBColor(7, 32, 121));
		setLayout(null);
		
		lblTempo = new JLabel();
		lblVelocidade = new JLabel();
		lblEspaco = new JLabel();
		
		this.carro = carro;
		this.trena = trena;
		this.board = board;
		
		atualizar();
	}
	
	public void atualizar(){
		lblTempo.setText("Tempo:............ "+String.format("%.2f",board.getTempo())+" s");
		lblTempo.setBounds(12, 56, 176, 15);
		add(lblTempo);
		
		lblVelocidade.setText("Velocidade:..... "+carro.getVelocidade()+" m/s");
		lblVelocidade.setBounds(12, 98, 176, 15);
		add(lblVelocidade);
		
		lblEspaco.setText("Espaço:........... "+String.format("%.2f",trena.getEspacoCorrente())+" m");
		lblEspaco.setBounds(12, 139, 176, 15);
		add(lblEspaco);
	}

}
