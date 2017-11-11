package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.AppCore;
import editor.GrayScale;
import editor.Negative;
import rafgfxlib.Util;

public class GrayscaleAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GrayScale grayScale = new GrayScale(Util.loadImage(AppCore.getInstance().getImagePath()));
		AppCore.getInstance().setImage(grayScale.getBufferedImage());
	}

}
