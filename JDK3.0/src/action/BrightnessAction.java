package action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class BrightnessAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		// osvetljenje i potamnjenje

	}

	public BrightnessAction() {
		// TODO Auto-generated constructor stub
		try {
			putValue(Action.SMALL_ICON,
					new ImageIcon(ImageIO.read(getClass().getResourceAsStream(("/images/brightness.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		putValue(Action.NAME, "Brightness");
	}

}
