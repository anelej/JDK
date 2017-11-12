package editor;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javafx.scene.image.WritableImage;
import rafgfxlib.Util;

public class Komadici implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		WritableRaster wr = AppCore.getInstance().getbImage().getRaster();
		WritableRaster wr2 = Util.createRaster(40, 40, false);
		for (int y = -20; y < 20; y++) {
			for (int x = -20; x < 20; x++) {
				if (x + e.getX() >= 0 && x + e.getX() < wr.getWidth() && y + e.getY() >= 0
						&& y + e.getY() < wr.getHeight()) {
					int color[] = new int[3];
					wr.getPixel(x + e.getX(), y + e.getY(), color);
					wr2.setPixel(x + 20, y + 20, color);
					wr.setPixel(x + e.getX(), y + e.getY(), new int[] { 0, 0, 0 });
				}

			}
		}
		AppCore.getInstance().setImage(Util.rasterToImage(wr));
		kreniDaPadas(Util.rasterToImage(wr2), e.getX() - 20, e.getY() - 20);

	}

	public void kreniDaPadas(BufferedImage bufferImage, int x, int y) {
		new Thread(new Runnable() {
			public void run() {
				int y1 = y;
				while (y1 < 500) {
					y1++;
					Graphics gf = AppCore.getInstance().getMainFrame().getPanelSlika().getGraphics();
					BufferedImage pozadina = AppCore.getInstance().getbImage();
					gf.drawImage(pozadina, 0, 0, null);
					gf.drawImage(bufferImage, x, y1, null);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
