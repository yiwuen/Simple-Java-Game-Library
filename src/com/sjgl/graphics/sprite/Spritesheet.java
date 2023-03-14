package com.sjgl.graphics.sprite;

import java.awt.image.BufferedImage;

import com.sjgl.utils.PathUtils;

/**
 * Simple spritesheet class. Contains important spritesheet methods such as splitting spritesheets into individual sprites and getting 
 * a specific sprite from the sheet.
 * 
 * @author yiwuen
 *
 */

public class Spritesheet {
	
	private BufferedImage sheet;
	
	private int width, height;
	private int spriteWidth, spriteHeight;
	
	/**
	 * Creates a spritesheet using {@link BufferedImage} loaded based on the given path.
	 * @param path Path to the loaded image
	 * @param setSpriteSize Set this to false if errors have occurred. Setting this to true will automatically determine the sprite size if
	 * width and height are both present (based on values of 8).
	 */
	public Spritesheet(String path, boolean setSpriteSize) {
		sheet = PathUtils.GetImage(path);
		
		width = sheet.getWidth();
		height = sheet.getHeight();
		
		int cols = ((sheet.getWidth() * sheet.getHeight()) / 8) >> 8;
		int rows = ((sheet.getWidth() * sheet.getHeight()) / 8) >> 8;
		if (setSpriteSize) {
			spriteWidth = sheet.getWidth() / rows;
			spriteHeight = sheet.getHeight() / cols;
		}
	}
	
	/**
	 * Creates a spritesheet using {@link BufferedImage} loaded based on loaded BufferedImage.
	 * @param sheet BufferedImage
	 * @param setSpriteSize Set this to false if errors have occurred. Setting this to true will automatically determine the sprite size if
	 * width and height are both present (based on values of 8).
	 */
	public Spritesheet(BufferedImage sheet, boolean setSpriteSize) {
		this.sheet = sheet;
		
		width = sheet.getWidth();
		height = sheet.getHeight();
		
		int cols = ((sheet.getWidth() * sheet.getHeight()) / 8) >> 8;
		int rows = ((sheet.getWidth() * sheet.getHeight()) / 8) >> 8;
		if (setSpriteSize) {
			spriteWidth = sheet.getWidth() / rows;
			spriteHeight = sheet.getHeight() / cols;
		}
	}
	
	/**
	 * Constructs a spritesheet based on the loaded BufferedImage.
	 * 
	 * @param sheet Loaded BufferedImage of the spritesheet
	 * @param spriteWidth Width of a individual sprite
	 * @param spriteHeight Height of a individual sprite
	 */
	public Spritesheet(BufferedImage sheet, int spriteWidth, int spriteHeight) {
		this.sheet = sheet;
		
		width = sheet.getWidth();
		height = sheet.getHeight();
		
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}
	
	/**
	 * Constructs a spritesheet based on the given path.
	 * 
	 * @param path Path to the sheet
	 * @param spriteWidth Width of a individual sprite
	 * @param spriteHeight Height of a individual sprite
	 */
	public Spritesheet(String path, int spriteWidth, int spriteHeight) {
		sheet = PathUtils.GetImage(path);
		
		width = sheet.getWidth();
		height = sheet.getHeight();
		
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}
	
	/**
	 * Gets an individual sprite from the spritesheet.
	 * @param x Tile X
	 * @param y Tile Y
	 * @param w Sprite width
	 * @param h Sprite height
	 * @return Sprite sprite
	 */
	public Sprite getSprite(int x, int y, int w, int h) {
		return new Sprite(sheet.getSubimage(x * w, y * w, w, h));
	}
	
	/**
	 * Gets an individual sprite from the spritesheet with the specified size in constructor.
	 * @param x Tile X
	 * @param y Tile Y
	 * @return Sprite sprite
	 */
	public Sprite getSprite(int x, int y) {
		return new Sprite(sheet.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight));
	}
	
	/**
	 * Returns an array of {@link Sprite} in the loaded spritesheet. This method splits the spritesheet into individual sprites with the 
	 * correct size (if {@code setSpriteSize} is set to true or in other words, if the spritesheet is automatically determining the
	 * sprite size).
	 * @return Sprite[] sprites
	 */
	public Sprite[] split() {
		Spritesheet newSheet = new Spritesheet(sheet, true);
		int sheetWidth = newSheet.getWidth();
		int sheetHeight = newSheet.getHeight();
		int index = 0;
		Sprite[] sprites = new Sprite[(sheetWidth / spriteWidth) * (sheetHeight / spriteHeight)];
		for (int ya = 0; ya < sheetHeight / spriteHeight; ya++) {
			for (int xa = 0; xa < sheetWidth / spriteWidth; xa++) {
				sprites[index++] = newSheet.getSprite(xa, ya, spriteWidth, spriteHeight);
			}
		}
		
		return sprites;
	}
	
	/**
	 * Returns an array of {@link Sprite} in the loaded spritesheet. This method splits the spritesheet into individual sprites with the
	 * specified size (if {@code setSpriteSize} is set to false or in other words, if the spritesheet isn't automatically determining the
	 * sprite size).
	 * 
	 * @param spriteWidth Width of sprite
	 * @param spriteHeight Height of sprite
	 * 
	 * @return Sprite[] sprites
	 */
	public Sprite[] split(int spriteWidth, int spriteHeight) {
		Spritesheet newSheet = new Spritesheet(sheet, false);
		int sheetWidth = newSheet.getWidth();
		int sheetHeight = newSheet.getHeight();
		int index = 0;
		Sprite[] sprites = new Sprite[(sheetWidth / spriteWidth) * (sheetHeight / spriteHeight)];
		for (int ya = 0; ya < sheetHeight / spriteHeight; ya++) {
			for (int xa = 0; xa < sheetWidth / spriteWidth; xa++) {
				sprites[index++] = newSheet.getSprite(xa, ya, spriteWidth, spriteHeight);
			}
		}
		
		return sprites;
	}
	
	/**
	 * Returns the loaded {@link BufferedImage} image.
	 * @return BufferedImage image
	 */
	public BufferedImage getSheetImage() {
		return sheet;
	}
	
	/**
	 * Returns the individual sprite width.
	 * @return int width
	 */
	public int getSpriteWidth() {
		return spriteWidth;
	}

	/**
	 * Returns the individual sprite height.
	 * @return int height
	 */
	public int getSpriteHeight() {
		return spriteHeight;
	}

	/**
	 * Returns the spritesheet's width.
	 * @return int width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the spritesheet's height.
	 * @return int height
	 */
	public int getHeight() {
		return height;
	}

}
