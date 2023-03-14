package com.sjgl.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Simple and basic helper class for detecting mouse inputs. External mouse classes should inherit from this class and override 
 * the {@code buttonPressed(int button)} method. Super methods can be added and modified in external classes to have more mouse
 * functionality.
 * 
 * @author yiwuen
 *
 */

public class SimpleMouse extends MouseAdapter {
	
	private int mouseX, mouseY;
	private int button = -1;
	
	@Override
	public void mousePressed(MouseEvent e) {
		button = e.getButton();
		buttonPressed(button);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		button = -1;
		buttonReleased(e.getButton());
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	/**
	 * To check mouse button clicks, override this method.
	 * {@link MouseEvent} or {@link MouseUtils} can be used to check for different mouse buttons.
	 * 
	 * <p>Example:
	 * <p>{@code
	 * if (button == MouseUtils.LEFT_BUTTON)}
	 * 
	 * @param button mouse button
	 */
	public void buttonPressed(int button) {
	}
	
	/**
	 * To detect if a mouse button was released, override this method.
	 * {@link MouseEvent} or {@link MouseUtils} can be used to check for different mouse buttons.
	 * 
	 * <p>Example:
	 * <p>{@code
	 * if (button == MouseUtils.LEFT_BUTTON)}
	 * 
	 * @param button mouse button
	 */
	public void buttonReleased(int button) {
	}

	/**
	 * Returns the mouse x position.
	 * @return mouseX
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * Returns the mouse y position.
	 * @return mouseY
	 */
	public int getMouseY() {
		return mouseY;
	}

	/**
	 * Returns the mouse button.
	 * @return button
	 */
	public int getButton() {
		return button;
	}
	
}
