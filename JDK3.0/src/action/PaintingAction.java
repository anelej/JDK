package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.AppCore;
import editor.Negative;
import editor.Painting;
import rafgfxlib.Util;

public class PaintingAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Painting painting = new Painting(Util.loadImage(AppCore.getInstance().getImagePath()));
		AppCore.getInstance().setImage(painting.getBufferedImage());
	}

}
