# Welcome to Simple Java Game Library (SJGL)!
Simple Java Game Library (SJGL) is an open-source game library that uses native Java libraries. This tool serves as a helper library containing and providing helper classes and methods. Its main purpose is to speed up the game development of Java games programmed using built-in libraries. As of right now, SJGL only supports Windows and MacOS. However, in the future, there will be many more platforms that this library will support.

Every now and then, there will be updates and bug fixes as the development of this project continues.

**Note**: Javadoc is downloadable through the releases!

## Setting up the library
SJGL is packaged into one .jar file. Head to the release page and install the latest .jar.
1. Launch your preferred IDE (Eclipse IDE is recommended)
2. Create a new Java Project and set the .jar file in the ```Build Path > Classpath```

### Creating a simple window
Creating a window in SJGL is as simple as copying and pasting code ;).
1. Once the library is set up, paste the following code inside of the main class: 
```java
import static com.sjgl.graphics.Renderer.*;

import com.sjgl.*;
import com.sjgl.utils.*;

public class MySJGLDemo extends Application {

    public MySJGLDemo() {
        SJGL_CreateWindow(850, 580, "My SJGL Window", this).display(WindowUtils.TERMINATE_WINDOW, true, true);
    }

    public void render() {
        SJGL_Color3f(0.0f, 0.0f, 0.0f);
	SJGL_Rect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new MySJGLDemo().launch(args);
    }

}
```
This creates a window 850x580 using Java's JFrame class put together into one simple class SimpleWindow using a method from the Application class ```SJGL_WINDOW()``` to construct it (note that this will automatically create the MAIN window). ```Renderer``` is used to render graphics such as rendering the black background shown above. Additionally, you can set the amount of BufferStrategy to create using ```setNumBuffers(n)``` (2-3 is recommended).

### Configuring the window
```SimpleWindow``` has many properties you can edit to enhance the window. Properties such as the window icon, functionality to resize, window termination, input handling (mouse and keyboard), add program arguments to enhance (window) game functionality, etc. A few examples to configure a window in code would be:
```java
public MySJGLDemo() {
    SJGL_CreateWindow(850, 580, "My SJGL Window", this).display(WindowUtils.TERMINATE_WINDOW, true, true); // to access this window, getMainWindow()
    getMainWindow().setResizable(true); // false by default
    
    setMainApplicationIcon("relative/path/to/project"); // sets the main window's application icon
}
```

### Rendering graphics
Rendering graphics onto a window can be done in two ways:
1. Render using Graphics2D OR...
2. Render using SJGL's built-in helper class ```Renderer```

```Renderer``` contains similar methods to Graphics2D (native Java class). It is the default class for rendering more complex and flexible shapes (in general, it's used for graphics rendering in SJGL). This helper class is recommended to use since it contains simple, necessary, and relevant methods to help ease rendering. However, the reference Graphics2D object ```g``` from ```Application``` can be accessed and directly used in any ```render()``` methods.

This class can be used to draw shapes such as quads, triangles, and circles. Quads and triangles are the fundamental shapes for developing simple 2D graphics engine/games, which SJGL has support for.

## Install via package manager
Installing the library can either be downloading ```SJGL-{version}.jar``` or can be installed using third-party package managers such as Homebrew and Scoop. Run this in Terminal or cmd.

```
scoop install sjgl        # Windows
brew install sjgl         # MacOS
```

However, downloading the .jar file is preferred over package managers.

## About the project
SJGL is developed by yiwuen who decided to create a simple library to create Java 2D games without having to switch between projects and copy and paste code for game loop and thread handling. Hope this project speeds up the game development of others!
