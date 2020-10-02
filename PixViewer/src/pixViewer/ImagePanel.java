package pixViewer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * This class writes and updates the image, and handles the effects.
 */

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = -3325842388419507333L;
	private static BufferedImage image = null;

	// The Constructor (image)
	// public ImagePanel(BufferedImage image) {
	// this.image = image;
	// }

	public BufferedImage getImage() {
		return image;
	}

	public void doClear() {
		image = null;
	}

	/*
	 * Draws and adjusts window size to picture at all times.
	 */
	public void paint(Graphics g) {

		super.paintComponent(g); // clears the background/refreshes.

		g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, null);
	}

	public void loadImage(File file) {
		try {
			image = ImageIO.read(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Draws a new image that's rotated 45 degrees to the right, by going through
	 * every pixel line with a nested for-loop.
	 */
	public void doRotate() {

		BufferedImage newImage = new BufferedImage(image.getHeight(), image.getWidth(), image.getType());

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				newImage.setRGB(image.getHeight() - 1 - j, i, image.getRGB(i, j));
			}
		}
		image = newImage;
	}

	/*
	 * Gets the RGB value of a pixel and converts it to the corresponding negative
	 * value.
	 */
	public void doNegative() {

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int pixelValue = image.getRGB(x, y);
				int a = (pixelValue >> 24) & 0xff;
				int r = (pixelValue >> 16) & 0xff;
				int g = (pixelValue >> 8) & 0xff;
				int b = pixelValue & 0xff;
				r = 255 - r;
				g = 255 - g;
				b = 255 - b;
				pixelValue = (a << 24) | (r << 16) | (g << 8) | b;
				image.setRGB(x, y, pixelValue);
			}
		}
	}

	/*
	 * Uses a nested for-loop to create a mirrored image by rewriting every pixel in
	 * the opposite place.
	 */
	public void doMirror() {

		int height = image.getHeight();
		int width = image.getWidth();

		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int j = 0; j < height; j++) {
			for (int i = 0, w = width - 1; i < width; i++, w--) {
				int p = image.getRGB(i, j);

				newImage.setRGB(w, j, p);
			}
		}
		image = newImage;
	}

}
