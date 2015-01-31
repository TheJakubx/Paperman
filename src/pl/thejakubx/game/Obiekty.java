package pl.thejakubx.game;

public class Obiekty {
	//Okiekty FLOR = new Obiekty()
	public int x;
	public int y;
	public int x_len;
	public int y_len;
	public int TextID[] = new int[10];
	public int TextIDSIZE;
	public boolean Dead;
	public boolean Przenik;
	public boolean pickable = false;
	public boolean Animowany;
	public boolean tp= false;
	public int Dir = 0;
	public int klatka = 0;
	public int klatki = 0;
	public int Time = 0;
	public boolean pick = false;
	
	
	
	Obiekty(int X, int Y, int XL, int YL, int TID, boolean ded, boolean vis){
		x = X;
		y = Y;
		x_len = XL;
		y_len = YL;
		TextID[0] = TID;
		Dead = ded;
		Przenik = vis;
		klatki = 1;
	}
	
	Obiekty(int X, int Y, int XL, int YL, int TID, boolean ded, boolean vis,boolean picabl){
		x = X;
		y = Y;
		x_len = XL;
		y_len = YL;
		TextID[0] = TID;
		Dead = ded;
		Przenik = vis;
		klatki = 1;
		pickable = picabl;
	}
	Obiekty(int X, int Y, int XL, int YL, int TID, int TID2,int TID3,int TID4,int TID5,int TID6,boolean ded, boolean vis,boolean picabl,boolean t, int Di){
		x = X;
		y = Y;
		x_len = XL;
		y_len = YL;
		TextID[0] = TID;
		TextID[1] = TID2;
		TextID[2] = TID3;
		TextID[3] = TID4;
		TextID[4] = TID5;
		TextID[5] = TID6;
		Dead = ded;
		Przenik = vis;
		int a = 0;
		for(int i = 0;i<5;i++)if(TextID[i] != 0)a++;
		klatki = a;
		pickable = picabl;
		Dir = Di;
		tp = t;
		
	}
}
