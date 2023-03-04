# Simple Java Game Library (SJGL)
Simple Java Game Library (SJGL) is a game library that uses native Java libraries. This library serves as a helper library containing and providing helper classes. Its main purpose is to speed up the game development of Java games programmed using native Java libraries.

## Setting up the library
SJGL is packaged into one .jar file. Head to the release page and install the latest .jar file.
1. Launch your preferred IDE
2. Create a new Java Project and set the .jar file in the build path > classpath
3. Create a main class. Paste the following code to create a simple window:

### Creating a simple window
1. Inside of the main class, paste the following code: 
```
public class Test extends Application {

	public Test() {
		SimpleWindow simpleWindow = new SimpleWindow(850, 580, "My SJGL Window", this);
		simpleWindow.createWindow(WindowUtils.TERMINATE_WINDOW, true, true);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public static void main(String[] args) {
		new Test().launch(args);
	}
	
}
```
