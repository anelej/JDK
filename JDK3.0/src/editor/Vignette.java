package editor;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import rafgfxlib.Util;

public class Vignette {

	private BufferedImage image = null;

	public Vignette(BufferedImage image) {
		image = Skaliranje.scale(image, 1000, 450);
		this.image = image;
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().getWidth() + ","
				+ Toolkit.getDefaultToolkit().getScreenSize().getHeight());

	}

	public BufferedImage getBufferedImage() {
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getWidth(), false);
		for (int y = 0; y < source.getHeight(); y++) {
			for (int x = 0; x < source.getWidth(); x++) {
				int niz[] = new int[3];
				source.getPixel(x, y, niz);
				int distance = (int) Math.sqrt((x - source.getWidth() / 2) * (x - source.getWidth() / 2)
						+ (y - source.getHeight() / 2) * (y - source.getHeight() / 2));
				distance += 200;
				if (distance > source.getWidth() / 2) {
					niz[0] -= distance - source.getWidth() / 2;
					if (niz[0] < 0)
						niz[0] = 0;
					niz[1] -= distance - source.getWidth() / 2;
					if (niz[1] < 0)
						niz[1] = 0;
					niz[2] -= distance - source.getWidth() / 2;
					if (niz[2] < 0)
						niz[2] = 0;

				}

				target.setPixel(x, y, niz);
			}
		}
		return Util.rasterToImage(target);

	}

}
