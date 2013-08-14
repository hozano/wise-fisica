package teste;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class JPanelBotao extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JPanelBotao(final Board board, final Palette palette) {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		
		JButton btnPay = new JButton("");
		btnPay.setIcon(new ImageIcon(Layout.class.getResource("/imagens/play.png")));
		//btnPay.setBounds(20, 25, 32, 32);
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				board.setPlayCarro(true);
			}
		});
		add(btnPay);
		//..............................
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Layout.class.getResource("/imagens/pause.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				board.pausar();
			}
		});
		//btnNewButton.setBounds(62, 25, 32, 32);
		add(btnNewButton);
		//......................................
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Layout.class.getResource("/imagens/parar.png")));
		//btnNewButton_1.setBounds(104, 25, 32, 32);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				board.reiniciar();
				//board.painel.setTempo(palette.getSpinnerTempo());
			}
		});
		add(btnNewButton_1);
		
		JButton btnLapis = new JButton("");
		btnLapis.setIcon(new ImageIcon(Layout.class.getResource("/imagens/lapis.png")));
		//btnNewButton_1.setBounds(104, 25, 32, 32);
		btnLapis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				board.adicionarEventoDesenharMaoLivre();
			}
		});
		add(btnLapis);
		
		JButton btnEraser = new JButton("");
		btnEraser.setIcon(new ImageIcon(Layout.class.getResource("/imagens/eraser.png")));
		//btnNewButton_1.setBounds(104, 25, 32, 32);
		btnEraser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				board.apagarDesenhoMaoLivre();
			}
		});
		add(btnEraser);
	}

}
