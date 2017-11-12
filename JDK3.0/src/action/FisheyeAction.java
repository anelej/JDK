package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;

import editor.AppCore;
import editor.Fisheye;
import editor.GrayScale;
import rafgfxlib.Util;

public class FisheyeAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		Fisheye fisheye = new Fisheye(Util.loadImage(AppCore.getInstance().getImagePath()));
		AppCore.getInstance().setImage(fisheye.getBufferedImage());
	}

}
