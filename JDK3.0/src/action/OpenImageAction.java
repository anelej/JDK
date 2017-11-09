package action;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import editor.AppCore;

public class OpenImageAction extends AbstractAction{
	
	JFrame parent;
	
	public OpenImageAction(JFrame frame) {
		putValue(NAME, "Open Image");
		parent = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//AppCore.getInstance().loadImagePath("C:\\Users\\Lenka\\Pictures\\tiger.jpg");
		//return;
		
		JFileChooser fc = new JFileChooser();
		//fc.setApproveButtonText("Ok");
		int returnValue = fc.showOpenDialog(parent);
		System.out.println("Test");
		
		
		if(returnValue == JFileChooser.APPROVE_OPTION){
			String path = fc.getSelectedFile().getPath();
			AppCore.getInstance().loadImagePath(path);
		}
		
	}

}
