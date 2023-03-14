package com.sjgl.graphics.sprite;

import java.awt.image.BufferedImage;

import com.sjgl.Application;
import com.sjgl.utils.PathUtils;

/**
 * The sprite class renders an image based on the path given or image loaded.
 * 
 * @author yiwuen
 *
 */

public class Sprite {

	private BufferedImage sprite;
	
	private int x, y, width, height;

	/**
	 * Creates a sprite based on the path given.
	 * 
	 * @param path
	 */
	public Sprite(String path) {
		sprite = PathUtils.GetImage(path);
	}

	/**
	 * Creates a sprite based on the BufferedImage loaded.
	 * 
	 * @param sprite
	 */
	public Sprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * Creates a sprite based on the dimensions.
	 * 
	 * @param x X position of the sprite
	 * @param y Y position of the sprite
	 * @param width Width of the sprite
	 * @param height Height of the sprite
	 */
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Horizontally flips the sprite.
	 * 
	 * @return
	 */
	public Sprite getHorizontalFlipped() {
		BufferedImage img = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for (int xx = sprite.getWidth() - 1; xx > 0; xx--) {
			for (int yy = 0; yy < sprite.getHeight(); yy++) {
				img.setRGB(sprite.getWidth() - xx, yy, sprite.getRGB(xx, yy));
			}
		}
		Sprite newSprite = new Sprite(img);

		return newSprite;
	}

	/**
	 * Renders the sprite ({@link BufferedImage}) using {@code Graphics2D.drawImage()}.
	 * 
	 * @param x X position of the sprite
	 * @param y Y position of the sprite
	 * @param width Width of the sprite
	 * @param height Height of the sprite
	 * @param g Graphics2D object used to render the sprite ({@link BufferedImage})
	 */
	public void render(int x, int y, int width, int height) {
		Application.g.drawImage(sprite, x, y, width, height, null);
	}

	/**
	 * Returns the sprite loaded.
	 * @return BufferedImage sprite
	 */
	public BufferedImage getSprite() {
		return sprite;
	}

	/**
	 * Returns the x position of the sprite.
	 * 
	 * @return int x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y position of the sprite.
	 * 
	 * @return int y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Returns the width of the sprite.
	 * 
	 * @return int width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of the sprite.
	 * 
	 * @return int width
	 */
	public int getHeight() {
		return height;
	}

}
