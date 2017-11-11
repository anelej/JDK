package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.AppCore;
import editor.Negative;
import rafgfxlib.Util;

public class NegativeAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Negative negative = new Negative(Util.loadImage(AppCore.getInstance().getImagePath()));
		AppCore.getInstance().setImage(negative.getBufferedImage());
		

	}

}
