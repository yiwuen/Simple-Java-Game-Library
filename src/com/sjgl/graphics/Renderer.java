package com.sjgl.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import com.sjgl.Application;
import com.sjgl.physics.collision.CollisionBound;

/**
 * <strong>The default and general class for general graphics rendering. Simple helper class to render more complex and flexible shapes and additional 
 * useful graphics methods.</strong>
 * 
 * <p>This class stores relevant methods to render graphics.
 * 
 * <p>Shapes such as quads, triangles, circles, and circles can be drawn. Other graphics could be drawn as well (you can do some of the same things as in the
 * Graphics2D class).
 * 
 * <p>Methods should be called within any method that is able to render graphics such as
 * {@code Application.render()}. This way, the object used to draw graphics {@link Graphics2D} can be initialized.
 * 
 * <p>However, you can also access the Graphics2D {@code g} from {@code Application} for more methods to use.
 * 
 * @author yiwuen
 * 
 * @see Graphics2D
 *
 */
public class Renderer {
	
	/**
	 * Sets the font of the current string graphic.
	 * @param font Font
	 * 
	 * @see Font
	 */
	public static final void SJGL_Font(Font font) {
		Application.g.setFont(font);
	}
	
	/**
	 * Returns the graphic's font metrics.
	 * 
	 * @return FontMetrics
	 * 
	 * @see FontMetrics
	 */
	public static final FontMetrics SJGL_FontMetrics() {
		return Application.g.getFontMetrics();
	}
	
	/**
	 * Returns the graphic's font metrics.
	 * @param font Font used to get the font metrics
	 * 
	 * @return FontMetrics
	 * 
	 * @see FontMetrics
	 * @see Font
	 */
	public static final FontMetrics SJGL_FontMetrics(Font font) {
		return Application.g.getFontMetrics(font);
	}
	
	/**
	 * Returns the current font.
	 * @return Font
	 * 
	 * @see Font
	 */
	public static final Font SJGL_CurrentFont() {
		return Application.g.getFont();
	}
	
	/**
	 * Renders a string based on the given string.
	 * @param str String, or text
	 * @param font Font of the text
	 * @param x X position of the string graphic
	 * @param y Y position of the string graphic
	 */
	public static final void SJGL_DrawString(String str, Font font, int x, int y) {
		SJGL_Font(font);
		Application.g.drawString(str, x, y);
	}
	
	/**
	 * Returns the current color of the graphics context.
	 * @return Color
	 * 
	 * @see Color
	 */
	public static final Color SJGL_CurrentColor() {
		return Application.g.getColor();
	}
	
	/**
	 * Sets the color (hex) of the current graphic.
	 * @param v Hex value of color
	 * 
	 * @see Color
	 */
	public static final void SJGL_Colori(int v) {
		Application.g.setColor(new Color(v));
	}
	
	/**
	 * Sets the color (int RGB) of the current graphic. The max value is 255.
	 * @param r Red
	 * @param g Green
	 * @param b Blue
	 * 
	 * @see Color
	 */
	public static final void SJGL_Color3i(int r, int g, int b) {
		Application.g.setColor(new Color(r, g, b));
	}
	
	/**
	 * Sets the color with alpha (int RGBA) of the current graphic. The max value is 255.
	 * @param r Red
	 * @param g Green
	 * @param b Blue
	 * 
	 * @see Color
	 */
	public static final void SJGL_Color4i(int r, int g, int b, int a) {
		Application.g.setColor(new Color(r, g, b, a));
	}
	
	/**
	 * Sets the color (float RGB) of the current graphic. The max value is 1.0.
	 * @param r Red
	 * @param g Green
	 * @param b Blue
	 * 
	 * @see Color
	 */
	public static final void SJGL_Color3f(float r, float g, float b) {
		Application.g.setColor(new Color(r, g, b));
	}
	
	/**
	 * Sets the color with alpha (float RGBA) of the current graphic. The max value is 1.0.
	 * @param r Red
	 * @param g Green
	 * @param b Blue
	 * 
	 * @see Color
	 */
	public static final void SJGL_Color4f(float r, float g, float b, float a) {
		Application.g.setColor(new Color(r, g, b, a));
	}
	
	/**
	 * Renders a triangle based on the given x and y coordinates (3 vertices).
	 * @param x Array of x positions for each point
	 * @param y Array of y positions for each point
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_DrawTriangle(int[] x, int[] y) {
		Application.g.drawPolygon(x, y, 3);
	}
	
	/**
	 * Renders a color-filled triangle based on the given x and y coordinates (3 vertices).
	 * @param x Array of x positions for each point
	 * @param y Array of y positions for each point
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_Triangle(int[] x, int[] y) {
		Application.g.fillPolygon(x, y, 3);
	}
	
	/**
	 * Renders a quad based on the given x and y coordinates (4 vertices).
	 * 
	 * <p>The left side of the quad labels up to down and on the right side labels down to up.
	 * 
	 * @param x Array of x positions for each point
	 * @param y Array of y positions for each point
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_DrawQuad(int[] x, int[] y) {
		Application.g.drawPolygon(x, y, 4);
	}
	
	/**
	 * Renders a color-filled quad based on the given x and y coordinates (4 vertices).
	 * 
	 * <p>The left side of the quad labels up to down and on the right side labels down to up.
	 * 
	 * @param x Array of x positions for each point
	 * @param y Array of y positions for each point
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_Quad(int[] x, int[] y) {
		Application.g.fillPolygon(x, y, 4);
	}
	
	/**
	 * Renders a circle based on the given x and y coordinates and radius.
	 * @param x X position of the circle
	 * @param y Y position of the circle
	 * @param radius Radius of the circle
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_DrawCircle(int x, int y, int radius) {
		int d = radius * 2;
		Application.g.drawOval(x - radius, y - radius, d, d);
	}
	
	/**
	 * Renders a color-filled circle based on the given x and y coordinates and radius.
	 * @param x X position of the circle
	 * @param y Y position of the circle
	 * @param radius Radius of the circle
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_Circle(int x, int y, int radius) {
		int d = radius * 2;
		Application.g.fillOval(x - radius, y - radius, d, d);
	}
	
	/**
	 * Renders a color-filled rectangle based on the given x, y, width, and height.
	 * @param x X position of the rectangle
	 * @param y Y position of the rectangle
	 * @param w Width of the rectangle
	 * @param h Height of the rectangle
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_Rect(int x, int y, int w, int h) {
		Application.g.fillRect(x, y, w, h);
	}
	
	/**
	 * Renders a rectangle based on the given x, y, width, and height.
	 * @param x X position of the rectangle
	 * @param y Y position of the rectangle
	 * @param w Width of the rectangle
	 * @param h Height of the rectangle
	 * 
	 * @see Graphics2D
	 * @see Application
	 */
	public static final void SJGL_DrawRect(int x, int y, int w, int h) {
		Application.g.drawRect(x, y, w, h);
	}
	
	/**
	 * Renders the collision bounds.
	 * @param bound Collision bound
	 * 
	 * @see CollisionBound
	 */
	public static final void SJGL_DrawBounds(CollisionBound bound) {
		Application.g.draw(bound.getBounds());
	}
	
	/**
	 * Graphics int translation.
	 * @param x X translation
	 * @param y Y translation
	 * 
	 * @see Graphics2D
	 */
	public static final void SJGL_Translatei(int x, int y) {
		Application.g.translate(x, y);
	}
	
	/**
	 * Graphics float translation.
	 * @param x X translation
	 * @param y Y translation
	 * 
	 * @see Graphics2D
	 */
	public static final void SJGL_Translatef(float x, float y) {
		Application.g.translate(x, y);
	}

	/**
	 * Scales the graphics size.
	 * @param sx Scale X (int)
	 * @param sy Scale Y (int)
	 * 
	 * @see Graphics2D
	 */
	public static final void SJGL_Scalei(int sx, int sy) {
		Application.g.scale(sx, sy);
	}
	
	/**
	 * Scales the graphics size.
	 * @param sx Scale X (float)
	 * @param sy Scale Y (float)
	 * 
	 * @see Graphics2D
	 */
	public static final void SJGL_Scalef(float sx, float sy) {
		Application.g.scale(sx, sy);
	}
	
}
