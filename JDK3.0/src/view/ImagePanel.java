package view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImagePanel extends JPanel{
	
	private BufferedImage image = null;
	private JLabel lbl;
	
	public ImagePanel(){
		lbl = new JLabel();
		this.setLayout(new BorderLayout());
		this.add(lbl,BorderLayout.CENTER);		
	}

	public void greyUp(){
		int k=0;
		int w = image.getWidth();
		int h = image.getHeight();
		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++){
				int a = image.getRGB(j, i);
				//System.out.println(a);
				k++;
			}
		System.out.println(k);
	}
	
	public void setImage(String path){
		try {
			this.remove(lbl);
			image = ImageIO.read(new File(path));
			lbl=new JLabel(new ImageIcon(image));
			this.add(lbl,BorderLayout.CENTER);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
