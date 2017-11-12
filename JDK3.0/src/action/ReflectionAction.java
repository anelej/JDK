package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.AppCore;
import editor.Negative;
import editor.Reflection;
import rafgfxlib.Util;

public class ReflectionAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Reflection reflection = new Reflection(Util.loadImage(AppCore.getInstance().getImagePath()));
		AppCore.getInstance().setImage(reflection.getBufferedImage());
	}

}
