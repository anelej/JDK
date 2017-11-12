package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameView extends JComponent implements ActionListener, MouseMotionListener {

	private int x = 400;
	private int y = 150;
	private int xMove = 8;
	private int yMove = 8;
	private int crtaX = 0;
	// int crtaY = 0;

	// public GameView() {
	// // TODO Auto-generated constructor stub
	//
	// ImageIcon icon = new
	// ImageIcon(getClass().getResource("/images/gameicon.png"));
	// // setIconImage(icon.getImage());
	// setVisible(true);
	// }

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(700, 500);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 700, 500);

		// lopta
		g.setColor(Color.darkGray);
		g.fillOval(x, y, 25, 25);

		// crta
		g.setColor(Color.yellow);
		g.fillRect(crtaX, 410, 150, 15);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		x = x + xMove;
		y = y+ yMove;
		if (x >= crtaX && x <= crtaX + 150 && y >= 390) {
			yMove = -8;
			System.out.println("nestoo u gameview ");
		}
		if (x >= 700 - 25) {
			xMove = -8;
		}
		if (x <= 0) {
			xMove = 8;
		}
		if (y <= 0) {
			yMove = 8;
		}
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		crtaX = e.getX() - 75;
		repaint();

	}

}
