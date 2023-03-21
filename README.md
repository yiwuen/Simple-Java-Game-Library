# Simple Java Game Library (SJGL)
Simple Java Game Library (SJGL) is an open-source game library that uses native Java libraries and some OpenGL/GLFW for developing simple graphics engines. This tool serves as a helper library containing and providing helper classes/methods. Its main purpose is to speed up the game development of Java games programmed using built-in Java libraries. Additionally, it also serves as an alternative to LWJGL for simple 2D Java games.

## Setting up the library
SJGL is packaged into one .jar file. Head to the release page and install the latest .jar.
1. Launch your preferred IDE (Eclipse IDE is recommended)
2. Create a new Java Project and set the .jar file in the ```Build Path > Classpath```

### Creating a simple window
Creating a window in SJGL is as simple as copying and pasting code ;).
1. Inside of the main class, paste the following code: 
```java
import java.awt.*;

import com.sjgl.*;
import com.sjgl.utils.*;

public class MySJGLDemo extends Application {

    public MySJGLDemo() {
        SJGL_CreateWindow(850, 580, "My SJGL Window", this).display(WindowUtils.TERMINATE_WINDOW, true, true);
    }

    public void render(Graphics2D g) {
        g.setColor(Color.black);
	g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new MySJGLDemo().launch(args);
    }

}
```
This creates a window 850x580 using Java's JFrame class put together into one simple class SimpleWindow using a method from the Application class ```SJGL_WINDOW()``` to construct it. Graphics2D is used to render graphics such as rendering the black background shown above. Additionally, you can set the amount of BufferStrategy to create using ```setNumBuffers(n)``` (2-3 is recommended).
 Project Manager, however, is still in current development and will be released as soon as SJGL is released and fully developed.

### Install via package manager
Installing the library can either be downloading ```SJGL-{version}.jar``` or can be installed using third-party package managers such as Homebrew and Scoop. Run this in Terminal or cmd.

```
scoop install sjgl        # Windows
brew install sjgl         # MacOS
```

However, downloading the .jar file is preferred over package managers.
