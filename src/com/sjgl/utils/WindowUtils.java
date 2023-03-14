package com.sjgl.utils;

import javax.swing.JFrame;

import com.sjgl.graphics.window.SimpleWindow;

/**
 * Utilities class for {@link SimpleWindow}.
 * 
 * @author yiwuen
 *
 */

public class WindowUtils {

	/**
	 * Terminates the program/window on window close.
	 */
	public static final int TERMINATE_WINDOW = JFrame.EXIT_ON_CLOSE;
	
	/**
	 * Hides the window on window close.
	 */
	public static final int HIDE_WINDOW = JFrame.HIDE_ON_CLOSE;
	
	/**
	 * Disposes the program/window on window close.
	 */
	public static final int DISPOSE_WINDOW = JFrame.DISPOSE_ON_CLOSE;
	
	/**
	 * Does nothing on window close.
	 */
	public static final int NOTHING = JFrame.DO_NOTHING_ON_CLOSE;
	
}
