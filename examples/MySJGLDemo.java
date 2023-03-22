import java.awt.*;

import com.sjgl.*;
import com.sjgl.utils.*;

public class MySJGLDemo extends Application {

	private static final long serialVersionUID = -1L;

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