package editor;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import rafgfxlib.Util;

public class GrayScale {

	private BufferedImage image = null;

	public GrayScale(BufferedImage image) {
		image = Skaliranje.scale(image, 1000, 500);
		this.image = image;

	}

	public BufferedImage getBufferedImage() {
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getWidth(), false);
		for (int y = 0; y < source.getHeight(); y++) {
			for (int x = 0; x < source.getWidth(); x++) {
				int niz[] = new int[3];
				source.getPixel(x, y, niz);
				int color = niz[0] + niz[1] + niz[2];
				niz[0] = color / 3;
				niz[1] = color / 3;
				niz[2] = color / 3;

				target.setPixel(x, y, niz);
			}
		}
		return Util.rasterToImage(target);

	}

}
