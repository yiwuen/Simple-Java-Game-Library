# Simple Java Game Library (SJGL)
Simple Java Game Library (SJGL) is a game library that uses native Java libraries. This library serves as a helper library containing and providing helper classes. Its main purpose is to speed up the game development of Java games programmed using native Java libraries.

## Setting up the library
SJGL is packaged into one .jar file. Head to the release page and install the latest .jar file.
1. Launch your preferred IDE
2. Create a new Java Project and set the .jar file in the build path > classpath
3. Create a main class. Paste the following code to create a simple window:

```
public class Test extends Application {

	private static final long serialVersionUID = 1L;
	
	private int x = 200, y = 100, velX = 5, velY = 5;
	
	private Spritesheet sheet = new Spritesheet("/Food.png", true);
	private Sprite[] sprites = sheet.split();
	
	private Animation animation = new Animation(10, sprites);
	
	public Test() {
		SimpleWindow simpleWindow = new SimpleWindow(850, 580, "My SJGL Demo", this);
		simpleWindow.createWindow(WindowUtils.TERMINATE_WINDOW, true, true);
		
		SimpleMouse mouse = new SimpleMouse() {
			@Override
			public void buttonPressed(int button) {
				if (button == MouseUtils.LEFT_BUTTON)
					System.out.println("Pressed");
			}
			
			@Override
			public void buttonReleased(int button) {
				if (button == MouseUtils.LEFT_BUTTON)
					System.out.println("Released");
			}
		};
		addMouseInput(mouse);
		
		setApplicationIcon("C:/Users/lmlfg/Desktop/SJGL-Icon.png", simpleWindow);
		
		enableLog(false);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		animation.getCurrentSprite().render(x, y, 50, 50);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("SJGL Demo", getWidth()/2-50, 50);
	}
	
	@Override
	public void tick() {
		setQuitKey(0);
		
		animation.update();
		
		if (SimpleKey.getKeyPressed(KeyEvent.VK_W)) y -= velY;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_S)) y += velY;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_A)) x -= velX;
		if (SimpleKey.getKeyPressed(KeyEvent.VK_D)) x += velX;
	}
	
	public static void main(String[] args) {
		new Test().launch(args);
	}
	
}
```
