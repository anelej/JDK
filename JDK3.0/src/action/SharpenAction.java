package action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class SharpenAction extends AbstractAction {

	public SharpenAction() {
		// TODO Auto-generated constructor stub
		try {
			putValue(Action.SMALL_ICON,
					new ImageIcon(ImageIO.read(getClass().getResourceAsStream(("/images/Pencil.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		putValue(Action.NAME, "Sharpen");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// menjanje ostrine slike

	}

}
