package editor;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import rafgfxlib.Util;

public class Painting {

	/// duplikat
	private BufferedImage image = null;

	public Painting(BufferedImage image) {
		image = Skaliranje.scale(image, 1000, 500);
		this.image = image;
	}

	public BufferedImage getBufferedImage() {
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(image.getWidth(), image.getHeight(), false);
		int boje[] = new int[3];

		for (int y = 0; y < source.getHeight(); y++) {
			for (int x = 0; x < source.getWidth(); x++) {
				if (x <= 500) {
					source.getPixel(x, y, boje);
					target.setPixel(x, y, boje);
				} else {
					source.getPixel(x - 500, y, boje);
					target.setPixel(x, y, boje);
				}
			}
		}
		return Util.rasterToImage(target);

	}

}
