package teste;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import org.jfree.ui.RefineryUtilities;

public class Palette extends JPanel implements ChangeListener,Cloneable{
	
	JSpinner spinnerTempo;
	JSpinner spinnerVelocidade;
	JSpinner spinnerEspaco;
	AttCarro atributosCarro;
	Board board;
	Bar demo;
	Bar demo2;
	
	public Palette(Board board, Bar bar, Bar bar2) {
		this.atributosCarro=board.getAttCarro();
		this.board=board;
		
		setBorder(new TitledBorder(null, "Palette", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setBackground(Color.getHSBColor(7, 32, 121));
		setBackground(Color.WHITE);
		setSize(200,650);
		setLayout(null);
		
		JLabel label = new JLabel("Variáveis Iniciais");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(50, 48, 138, 15);
		add(label);
		
		JLabel lblNewLabel = new JLabel("tempo:");
		lblNewLabel.setBounds(20, 89, 70, 15);
		add(lblNewLabel);
		
		spinnerTempo = new JSpinner();
		spinnerTempo.setValue(1);
		spinnerTempo.addChangeListener(this);
		spinnerTempo.setBounds(80, 89, 60, 20);
		add(spinnerTempo);
		
		JLabel lblS = new JLabel("s");
		lblS.setBounds(145, 89, 24, 15);
		add(lblS);
		
		JLabel lblVelocidade = new JLabel("velocidade:");
		lblVelocidade.setBounds(20, 120, 88, 15);
		add(lblVelocidade);
		
		spinnerVelocidade = new JSpinner();
		spinnerVelocidade.setValue(1);
		spinnerVelocidade.setBounds(105, 120, 60, 20);
		spinnerVelocidade.addChangeListener(this);
		add(spinnerVelocidade);
		
		JLabel lblMs = new JLabel("m/s");
		lblMs.setBounds(170, 120, 33, 15);
		add(lblMs);
		
		JLabel lblEspao = new JLabel("espaço: ");
		lblEspao.setBounds(20, 150, 70, 15);
		add(lblEspao);
		
		spinnerEspaco = new JSpinner();
		spinnerEspaco.setValue(1);
		spinnerEspaco.setBounds(89, 150, 60, 20);
		spinnerEspaco.addChangeListener(this);
		add(spinnerEspaco);
		
		JLabel label_1 = new JLabel("m");
		label_1.setBounds(153, 150, 24, 15);
		add(label_1);
		
		JLabel lblFrmulas = new JLabel("Fórmulas");
		lblFrmulas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFrmulas.setBounds(80, 265, 70, 15);
		add(lblFrmulas);
		
		demo = bar;
		demo2 = bar2;
		
		demo.setBounds(10, 400, 200, 150);
		demo.setBackground(Color.BLACK);
		((BasicInternalFrameUI)demo.getUI()).setNorthPane(null);
		demo.setBorder(null);
		demo.setVisible(true);
		add(demo);
		
		demo2.setBounds(250, 10, 750, 550);
		((BasicInternalFrameUI)demo2.getUI()).setNorthPane(null);
		demo2.setBorder(null);
		demo2.setVisible(true);
		add(demo2);
		
		demo.getSeries().clear();
		demo2.getSeries().clear();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner selecionado = (JSpinner) e.getSource();
		int v = (int) spinnerVelocidade.getValue();
		int t = (int) spinnerTempo.getValue();
		int s = (int) spinnerEspaco.getValue();
		if(selecionado==spinnerEspaco){
			t = s/v;
			v = s/t;
			spinnerTempo.setValue(t);
			spinnerVelocidade.setValue(v);
		}else if(selecionado==spinnerTempo){
			s = v*t;
			v = s/t;
			spinnerEspaco.setValue(s);
			spinnerVelocidade.setValue(v);
		}else{
			s = v*t;
			t = s/v;
			spinnerEspaco.setValue(s);
			spinnerTempo.setValue(t);
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawString("V=ΔS/ΔT", 30, 320);
		g.drawString("S=So+VT", 30, 340);
	}

	public Bar getDemo() {
		return demo;
	}

	public Bar getDemo2() {
		return demo2;
	}

	
	
}
