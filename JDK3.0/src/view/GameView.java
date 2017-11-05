package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameView extends JFrame {
	
	public GameView() {
		// TODO Auto-generated constructor stub
	
		setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.setTitle("igrica");
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/gameicon.png"));
		this.setIconImage(icon.getImage());
		
		this.setVisible(true);
	}
	

}
