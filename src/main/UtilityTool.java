package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/**
 * This class scales up the image taken as input
 * @author Oomar
 *
 */
public class UtilityTool {
	/**
	 * scales up image to desired height and width
	 * @param original original image
	 * @param width desired height
	 * @param height desired width
	 * @return scaled image
	 */
	public BufferedImage scaleImage(BufferedImage original, int width, int height) {
		
		BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, width, height, null);
		g2.dispose();
		
		
		return scaledImage;
	
	}
}
