# Simple Java Game Library (SJGL)
Simple Java Game Library (SJGL) is a game library that uses native Java libraries. This library serves as a helper library containing and providing helper classes. Its main purpose is to speed up the game development of Java games programmed using native Java libraries.

## Setting up the library
SJGL is packaged into one .jar file. Head to the release page and install the latest .jar file.
1. Launch your preferred IDE
2. Create a new Java Project and set the .jar file in the build path > classpath

### Creating a simple window
1. Inside of the main class, paste the following code: 
```
import java.awt.Color;
import java.awt.Graphics2D;

import com.sjgl.*;
import com.sjgl.graphics.window.*;
import com.sjgl.utils.*;

public class MySJGLDemo extends Application {

	public MySJGLDemo() {
		SimpleWindow simpleWindow = new SimpleWindow(850, 580, "My SJGL Window", this);
		simpleWindow.createWindow(WindowUtils.TERMINATE_WINDOW, true, true);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public static void main(String[] args) {
		new MySJGLDemo().launch(args);
	}
	
}
```
This creates a window 850x580 using Java's ```JFrame``` class put together into one simple class ```SimpleWindow```. ```Graphics2D``` is used to render graphics such as rendering the black background shown above.
