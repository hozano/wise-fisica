package teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

public class Layout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layout frame = new Layout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Layout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		Bar bar = new Bar ("");
		Bar bar2 = new Bar ("");
		
		Board board = new Board(bar,bar2);
		splitPane_2.setLeftComponent(board);
		
		Palette palette = new Palette(board,bar,bar2);
		palette.setBackground(Color.getHSBColor(7, 32, 121));
		
		JPanelBotao botoes = new JPanelBotao(board,palette);
		
		
		splitPane_2.setRightComponent(botoes);
		splitPane_1.setRightComponent(palette);
		
		Titulo titulo = new Titulo();
		splitPane.setLeftComponent(titulo);
		
		splitPane.setEnabled(false);
		splitPane_1.setResizeWeight(0.75);
		splitPane_1.setOneTouchExpandable(true);
		splitPane_2.setResizeWeight(1);
	}

}
