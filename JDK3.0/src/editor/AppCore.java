package editor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.nio.Buffer;

import rafgfxlib.Util;
import view.MainView;

public class AppCore {

	private static AppCore instance = null;

	private MainView mainFrame = null;

	private String imagePath = null;

	private BufferedImage bImage = null;
	
	private AppCore() {

	}

	public static AppCore getInstance() {
		if (instance == null) {
			instance = new AppCore();
			instance.init();
		}
		return instance;
	}

	private void init() {
		mainFrame = new MainView();
	}

	public MainView getMainFrame() {
		return mainFrame;
	}

	public void loadImagePath(String path) {
		imagePath = path;
		BufferedImage bi = Util.loadImage(path);
		bi = Skaliranje.scale(bi, 1000, 500);
		Graphics gf = mainFrame.getPanelSlika().getGraphics();
		gf.drawImage(bi, 0, 0, null);
		bImage = bi;
		

	}
	
	public void setImage(BufferedImage bufferImage){
		Graphics gf = mainFrame.getPanelSlika().getGraphics();
		gf.drawImage(bufferImage, 0, 0, null);
		bImage = bufferImage;
		
	}

	public String getImagePath() {
		return imagePath;
	}
	
	public BufferedImage getbImage() {
		return bImage;
	}
}
