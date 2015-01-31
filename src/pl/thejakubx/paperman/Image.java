package pl.thejakubx.paperman;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;

public class Image {
	public static Canvas canvas;
	public static Resources Res;
	public static Bitmap Textures[] = new Bitmap[4096];
	public static Object a;
	public static void Add(int Material, int Dra){
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
		Textures[Material] = BitmapFactory.decodeResource(Res, Dra, opts);
		Textures[Material] = Scale(Textures[Material]);
	}
	public static void Draw(int id, int x, int y){
		if(id>=0)canvas.drawBitmap(Textures[id], x*Scale.X,y*Scale.Y,null);
	}
    public static Bitmap Scale(Bitmap arg){
        int sizeX = arg.getWidth();
        int sizeY = arg.getHeight();
        sizeX *= Scale.X;
        sizeY *= Scale.Y;
        arg = Bitmap.createScaledBitmap(arg, sizeX, sizeY, true);
        return arg;
    }
    
}