package com.sjgl;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

import com.sjgl.graphics.window.SimpleWindow;
import com.sjgl.input.SimpleKey;

/**
 * <strong>Packaged class containing main game loop, graphics rendering, thread handling, etc.</strong>
 * 
 * The most important class for {@code SJGL} programs.
 * 
 * <p>The main {@code Application}. This class sets up an application layer containing essential features such as rendering graphics, game loop,
 * thread handling, etc. Every class that has the main method should at least extend the application class. In order to successfully run
 * an {@code Application} class, there should be a main window initialized and created (context should be set up as the last argument).
 * 
 * <p>To draw graphics using {@link Graphics2D}, override the {@code render(Graphics2D g)} method. To update the program every specified frames
 * per second, override the {@code tick()} method.
 * 
 * <p> To safely terminate the application, set the close operation of the window {@link SimpleWindow} to {@code WindowUtils.TERMINATE_WINDOW}.
 * When the window gets closed, the program will safely close.
 * 
 * <p><STRONG>Note:</STRONG> {@code Application} inherits from {@link Canvas} so be sure not to override or call any super methods.
 * Additionally, it implements {@link Runnable} interface.
 * 
 * @author yiwuen
 *
 */

@SuppressWarnings("serial")
public class Application extends Canvas implements Runnable {
	
	private SimpleWindow mainWindow;
	
	static {
		System.out.println("Version: " + Version.getVersion() + "\n");
	}
	
	private boolean running = false;
	private Thread thread;
	
	private boolean enableLog = true;
	
	/**
	 * Program exit status.
	 */
	public static int exitStatus;

	/**
	 * Accesses the {@link Graphics2D} object {@code g}. This {@link Graphics2D} object is initialized once {@code Application} is initialized. Otherwise
	 * it will result in null errors.
	 */
	public static Graphics2D g;

	/**
	 * This method can optionally be overrided. Overriding this method requires a return value of any. The value determines how many frames
	 * is updated per second. By default, it is 60.
	 * @return int Frames per second.
	 */
	public double frames() {
		return 60.0;
	}
	
	/**
	 * Returns whether or not to immediately request focus of the window. By default, this method returns true.
	 * @return <STRONG>boolean</STRONG> Enable request focus
	 */
	public boolean enableRequestFocus() {
		return true;
	}
	
	/**
	 * Enables or disables the frames and updates log. By default, it is enabled.
	 * 
	 * @param enable
	 */
	public final void enableLog(boolean enable) {
		enableLog = enable;
	}
	
	/**
	 * Sets the application icon for the window {@link SimpleWindow}. This accesses the display {@link JFrame} and sets the icon for it.
	 * @param absolutePath Absolute path to the icon image
	 * @param simpleWindow Window
	 */
	public final void setApplicationIcon(String absolutePath, SimpleWindow simpleWindow) {
		ImageIcon img = new ImageIcon(absolutePath);
		simpleWindow.getDisplay().setIconImage(img.getImage());
	}
	
	/**
	 * Sets the <strong>main</strong> application icon for the <strong>main</strong> window {@link SimpleWindow}.
	 * This accesses the display {@link JFrame} and sets the icon for it. If the main window is not initialized, declare the
	 * {@code setApplicationIcon(String, SimpleWindow)} method to set the icon of a specified window.
	 * @param absolutePath Absolute path to the icon image
	 */
	public final void setMainApplicationIcon(String absolutePath) {
		ImageIcon img = new ImageIcon(absolutePath);
		mainWindow.getDisplay().setIconImage(img.getImage());
	}
	
	/**
	 * When this method is called preferably in the {@code update()} or {@code tick()} method, pressing the escape key will safely terminate 
	 * the program.
	 * 
	 * @param exitStatus Exit status code. If {@code exitStatus} was any number besides 0, the program will fail to terminate safely. Otherwise, the program
	 * will successfully terminate safely.
	 */
	public final void setQuitKey(int exitStatus) {
		Application.exitStatus = exitStatus;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_ESCAPE)) {
			if (Application.exitStatus == 0)
				System.out.println("[TERMINATED SUCCESSFULLY] Program terminated safely.");
			else
				System.out.println("[TERMINATED UNSUCCESSFULLY] Program failed to terminate safely.");
			terminate(Application.exitStatus);
		}
	}
	
	/**
	 * Terminates the program. Equivalent to {@code System.exit(n)}.
	 * @param exitStatus Exit status code. If {@code exitStatus} was any number besides 0, the program will fail to terminate safely. Otherwise, the program
	 * will successfully terminate safely.
	 */
	public void terminate(int exitStatus) {
		Application.exitStatus = exitStatus;
		Runtime.getRuntime().exit(Application.exitStatus);
	}
	
	protected final void checkArguments(String[] args) {
		if (args.length == 0)
			System.out.println("[LAUNCHED SUCCESSFULY] Program launched with no arguments.");
		else if (args.length > 0)
			System.out.println("[LAUNCHED SUCCESSFULY] Program launched with arguments.");
		for (String arg : args) {
			switch(arg) {
				case "sjgl-printSecret":
					System.out.println("source code: https://github.com/yiwuen/Simple-Java-Game-Library-SJGL");
					break;
				default:
					System.err.println("[ARGUMENT ERROR] Program launched with unknown program arguments.");
					break;
			}
		}
	}
	
	/**
	 * <strong>Synchronized</strong>
	 * 
	 * <p>Launches the main thread with arguments. This enables rendering graphics and updating. To ensure there aren't any errors, 
	 * call this method after the main window has been initialized (recommended to call this method in the {@code main(String[])} method. 
	 * Pass {@code args} as the arguments in the {@code main(String[])} method.
	 * 
	 * <p> To add extra functionality to your program, you can add program arguments. Every program argument for SJGL begins with the prefix
	 * "sjgl" followed by a hyphen and the command name. Program arguments should only be added when necessary. Program argument commands
	 * can be found on the official documentation. Inputting no program arguments doesn't return an error and the launch will still be
	 * successful.
	 * 
	 * @param args Program arguments
	 */
	public final synchronized void launch(String[] args) {
		checkArguments(args);
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * <strong>Synchronized</strong>
	 * 
	 * <p>Stops the main thread. If the thread is running while other process are running, surround this method with try and catch to prevent
	 * any errors. {@code stop()} method should be used once the main thread isn't processing/synchronized.
	 * 
	 * <p> <strong>This method shouldn't be used as it isn't safe thread-handling. The game loop handles stopping thread
	 * in the {@code run()} method implemented from the {@link Runnable} interface.</strong> Use when necessary.
	 */
	public final synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public final void run() {
		if (enableRequestFocus())
			requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ticks = 1000000000.0 / frames();
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ticks;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			draw();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				if (enableLog)
					System.out.println("FPS: " + frames + "; updates: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	private final void tick() {
		update();
	}
	
	private final void draw() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		Application.g = g;
		
		render(g);
		
		g.dispose();
		bs.show();
	}
	
	/**
	 * To be overrided. Implementing this method will draw graphics onto the screen using Graphics2D. The game loop and rendering context
	 * is already set up so drawing graphics can easily be done with a couple of lines.
	 * 
	 * <p> <strong>Note:</strong> Any rendering should be done in {@code render(Graphics2D)} method.
	 * 
	 * @param g {@link Graphics2D} reference object
	 */
	public void render(Graphics2D g) {
	}

	/**
	 * To be overrided. Implementing this method will update the program every frame.
	 */
	public void update() {
	}
	
	/**
	 * Adds a keyboard input listener {@link KeyAdapter} to {@code Application} class.
	 * 
	 * @param keyInput Keyboard input reference
	 */
	public final void addKeyInput(KeyAdapter keyInput) {
		addKeyListener(keyInput);
	}
	
	/**
	 * Adds a mouse input listener {@link MouseAdapter} to {@code Application} class.
	 * 
	 * @param mouseInput Mouse input reference
	 */
	public final void addMouseInput(MouseAdapter mouseInput) {
		addMouseListener(mouseInput);
	}
	
	/**
	 * Adds a mouse motion input listener {@link MouseAdapter} to {@code Application} class.
	 * 
	 * @param mouseInput Mouse motion input reference
	 */
	public final void addMouseMotionInput(MouseAdapter mouseInput) {
		addMouseMotionListener(mouseInput);
	}
	
	/**
	 * Adds a mouse wheel input listener {@link MouseAdapter} to {@code Application} class.
	 * 
	 * @param mouseInput Mouse wheel input reference
	 */
	public final void addMouseWheelInput(MouseAdapter mouseInput) {
		addMouseWheelListener(mouseInput);
	}
	
	/**
	 * Returns the main thread.
	 * @return <strong>thread</strong> Main thread
	 */
	public final Thread getThread() {
		return thread;
	}
	
	/**
	 * Returns if the thread/program is running.
	 * @return <strong>boolean</strong> running
	 */
	public final boolean isRunning() {
		return running;
	}
	
	/**
	 * Sets the main window of the {@code Application}.
	 * @param mainWindow Main window {@link SimpleWindow}
	 */
	public void setMainWindow(SimpleWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	/**
	 * Returns the main window of the {@code Application}.
	 */
	public SimpleWindow getMainWindow() {
		return mainWindow;
	}
	
}
