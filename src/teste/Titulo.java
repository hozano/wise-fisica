package teste;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;

public class Titulo extends JPanel {

	/**
	 * Create the panel.
	 */
	public Titulo() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		
		JLabel labelTitulo = new JLabel("Movimento Retilínio Uniforme");
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 38));
		labelTitulo.setBounds(107, 20, 974, 45);
		add(labelTitulo);
	}

}
