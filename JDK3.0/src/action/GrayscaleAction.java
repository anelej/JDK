package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.AppCore;

public class GrayscaleAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		AppCore.getInstance().getMainFrame().getPanelSlika().greyUp();
	}

}
