package pl.thejakubx.paperman;

import java.util.Random;

import android.app.Activity;

public class match {
	public static Activity x;
	public static int Rand(int x, int y){
		Random r = new Random(); 
		return r.nextInt(y-x+1)+x;
	}
	
	public static int bez(int i){
		if(i<0)i = -i;
		return i;
	}
}
