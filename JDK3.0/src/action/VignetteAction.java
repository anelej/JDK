package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;

import editor.AppCore;
import editor.GrayScale;
import editor.Vignette;
import rafgfxlib.Util;

public class VignetteAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Vignette vignette = new Vignette(Util.loadImage(AppCore.getInstance().getImagePath()));
		AppCore.getInstance().setImage(vignette.getBufferedImage());
	}

}
