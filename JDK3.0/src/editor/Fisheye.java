package editor;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import rafgfxlib.Util;

public class Fisheye {

	// ekstremniji fisheye je u pitanju, zbog powera
	private BufferedImage image = null;

	public Fisheye(BufferedImage image) {
		image = Skaliranje.scale(image, 1000, 500);
		this.image = image;
	}

	public BufferedImage getBufferedImage() {
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getHeight(), false);
		int boje[] = new int[3];

		int udaljenostOdStrane = image.getWidth() / 2;
		int udaljenostOdGore = image.getHeight() / 2;

		float najmanjaUdaljenostodC = udaljenostOdGore; // uvek ce biti jer je visina manja kod nas nego sirina zbog
														// skalliranja

		float power = 0.6f;

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {

				double ugao = Math.atan2(y - udaljenostOdGore, x - udaljenostOdStrane);
				double udaljenost = Math.sqrt((x - udaljenostOdStrane) * (x - udaljenostOdStrane)
						+ (y - udaljenostOdGore) * (y - udaljenostOdGore));

				udaljenost = Math.pow(udaljenost / najmanjaUdaljenostodC, power) * najmanjaUdaljenostodC;

				float srcX = udaljenostOdStrane + (float) (Math.cos(ugao) * udaljenost);
				float srcY = udaljenostOdGore + (float) (Math.sin(ugao) * udaljenost);

				Util.bilSample(source, srcX, srcY, boje);

				target.setPixel(x, y, boje);

			}
		}

		return Util.rasterToImage(target);
	}

}
