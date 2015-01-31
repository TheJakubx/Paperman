package pl.thejakubx.paperman;

import android.graphics.Color;
import android.graphics.Paint;

public class Line {
	
  public static void Draw(int x, int y, int xx, int yy, int color) {
      Paint paint = new Paint();
	    paint.setAntiAlias(true);
	    float a = 1;
		paint.setStrokeWidth(a );
	    paint.setColor(color);
	    paint.setStyle(Paint.Style.STROKE);
	    paint.setStrokeJoin(Paint.Join.ROUND);
      Image.canvas.drawLine(x*Scale.X, y*Scale.Y, xx*Scale.X, yy*Scale.Y, paint);
  }
}
