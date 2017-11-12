package action;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

import view.GameView;

public class GameAction extends JComponent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JFrame window = new JFrame("igrica");
		GameView game = new GameView();
		window.add(game);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setAlwaysOnTop(true);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);

		Timer timer = new Timer(150, game);
		timer.start();

		window.addMouseMotionListener(game);

	}

}
