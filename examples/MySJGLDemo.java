import static com.sjgl.graphics.Renderer.*;

import com.sjgl.*;
import com.sjgl.utils.*;

public class MySJGLDemo extends Application {

	public MySJGLDemo() {
		SJGL_CreateWindow(850, 580, "My SJGL Window", this).display(WindowUtils.TERMINATE_WINDOW, true, true);
	}

	@Override
	public void render() {
		SJGL_Color3f(0.0f, 0.0f, 0.0f);
		SJGL_Background();
	}
	
	public static void main(String[] args) {
		new MySJGLDemo().launch(args);
	}

}
