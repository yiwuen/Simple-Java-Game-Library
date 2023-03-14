package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.sjgl.Application;
import com.sjgl.animation.SpriteAnimation;
import com.sjgl.graphics.sprite.Spritesheet;
import com.sjgl.graphics.window.SimpleWindow;
import com.sjgl.input.SimpleKey;
import com.sjgl.input.SimpleMouse;
import com.sjgl.utils.MouseUtils;
import com.sjgl.utils.WindowUtils;

public class Test extends Application {
	
	private class MyMouse extends SimpleMouse {
		
		@Override
		public void buttonPressed(int button) {
			if (button == MouseUtils.LEFT_BUTTON) {
				x = getMouseX() - 20;
				y = getMouseY() - 20;
			}
		}
		
	}

	private static final long serialVersionUID = 1L;

	private int x = 200, y = 100, velX = 5, velY = 5;
	
	private Spritesheet sheet = new Spritesheet("/test/Food.png", true);
	
	private SpriteAnimation spriteAnimation = new SpriteAnimation(10, sheet.split());
	
	public Test() {
		SimpleWindow myWindow = new SimpleWindow(850, 580, "My SJGL Demo", this);
		myWindow.createWindow(WindowUtils.TERMINATE_WINDOW, true, true);
		setMainWindow(myWindow);
		
		MyMouse mouse = new MyMouse();
		addMouseInput(mouse);
		addMouseMotionInput(mouse);
		
		setMainApplicationIcon("C:/Users/lmlfg/Desktop/java/SJGL-Icon.png");

		enableLog(false);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		spriteAnimation.getCurrentSprite().render(x, y, 50, 50);
		
		g.setColor(Color.white);
		g.setFont(new Font("Balloons!", 0, 40));
		g.drawString("SJGL Demo", getWidth() / 2 - 100, 50);
	}
	
	@Override
	public void update() {
		setQuitKey(0);
		
		spriteAnimation.update();
		
		if (SimpleKey.getKeyPressed(KeyEvent.VK_W) | SimpleKey.getKeyPressed(KeyEvent.VK_UP)) y -= velY;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_S) | SimpleKey.getKeyPressed(KeyEvent.VK_DOWN)) y += velY;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_A) | SimpleKey.getKeyPressed(KeyEvent.VK_LEFT)) x -= velX;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_D) | SimpleKey.getKeyPressed(KeyEvent.VK_RIGHT)) x += velX;
	}
	
	public static void main(String[] args) {
		new Test().launch(args);
	}
	
}
