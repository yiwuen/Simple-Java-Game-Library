package com.sjgl.graphics.window;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.sjgl.Application;

/**
 * Default window for SJGL. {@code SimpleWindow} should be used with the {@link Application} class.
 * 
 * @author yiwuen
 *
 */

public class SimpleWindow {
	
	private JFrame display;
	
	private int width, height;
	private String title;
	
	private Application application;
	
	/**
	 * Constructs and initializes the window.
	 * @param width Width of the window
	 * @param height Height of the window
	 * @param title Title of the window
	 * @param application {@code Application} reference and context for rendering and updating
	 */
	public SimpleWindow(int width, int height, String title, Application application) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.application = application;
		
		display = new JFrame(this.title);
		display.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				SimpleWindow.this.windowClosing();
			}
		});
	}
	
	/**
	 * Sets the window's position.
	 * 
	 * <p> <strong>Note:</strong> setting the window position is recommended to call after 
	 * {@code createWindow(int closeOperation, boolean visible, boolean center)} unless {@code center} is set to false.
	 * 
	 * @param x X position of the window
	 * @param y Y position of the window
	 */
	public void setWindowPos(int x, int y) {
		display.setBounds(x, y, width, height);
	}
	
	/**
	 * 
	 * Creates the window.
	 * 
	 * @param closeOperation Default close operation when closing window.
	 * @param visible Visibility of the window.
	 * @param center Centers the window.
	 */
	public void createWindow(int closeOperation, boolean visible, boolean center) {
		display.add(application);
		
		Dimension size = new Dimension(width, height);
		
		display.setPreferredSize(size);
		display.setMaximumSize(size);
		display.setMinimumSize(size);
		
		display.setDefaultCloseOperation(closeOperation);
		display.setResizable(false);
		display.pack();
		if (center)
			display.setLocationRelativeTo(null);
		display.setVisible(visible);
	}
	
	/**
	 * 
	 * Sets the window's resizable property. The window's resizable is set to false by default.
	 * 
	 * @param resizable The window's resizable property.
	 */
	public void setResizable(boolean resizable) {
		display.setResizable(resizable);
	}
	
	/**
	 * Sets the window's visibility.
	 * @param visible Visibility of the window.
	 */
	public void setVisible(boolean visible) {
		display.setVisible(visible);
	}
	
	/**
	 * Returns the display {@link JFrame} of the window. This reference should not be used at all unless changes are needed.
	 * @return
	 */
	public final JFrame getDisplay() {
		return display;
	}
	
	/**
	 * Implemented method but can be overrided. This method checks if the main window is currently closing. Logs a message if the program was safely
	 * terminated (requires to call super method).
	 */
	public void windowClosing() {
		if (Application.exitStatus == 0)
			System.out.println("[TERMINATED SUCCESSFULLY] Program terminated safely.");
		else
			System.out.println("[TERMINATED UNSUCCESSFULLY] Program failed to terminate safely.");
	}
	
}
