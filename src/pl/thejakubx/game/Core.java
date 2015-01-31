package pl.thejakubx.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import android.util.Log;
import pl.thejakubx.paperman.Image;
import pl.thejakubx.paperman.Touch;

public class Core {
	static boolean frist = true;
	static boolean map = true;
	static int POINTS = 0;
	static int MENU = 0;
	static int GAME = 1;
	static int CHOOSELVL = 2;
	static int OPTIONS = 3;
	static int ABOUT = 4;
	static int ENDLVL = 5;
	static int SCREEN = MENU;
	static Move thread = new Move();
	static Exec thread2 = new Exec();
	
	static boolean image = false;
	static boolean threa = false;
	static boolean ChangeScreen = false;
	static int Points[] = new int[1000];
	static int SELECTLVL = 0;
	static boolean CLEAR = false;
	static boolean SAVE = false;
	static boolean LOAD = true;
	static int PAGE = 0;
	static int POZ = 30 * 10;
	static int PAGES = 6;
	static int FPS = 30;
	static boolean OPT = false;
	static boolean Handled = false;
	static int END = 0;
	static boolean Ad = true;
	static boolean Ad2 = true;
	static boolean DEBUG = false;
	static boolean STR = false;
	public static void EndLvl() {
		if (Points[SELECTLVL] < POINTS)
			Points[SELECTLVL] = POINTS;
		if (Points[SELECTLVL] > 5)
			Points[SELECTLVL] = 5;
		// SELECTLVL = 0;
		END = POINTS;
		POINTS = 0;
		Move.deaths = 0;
		SCREEN = ENDLVL;
		Log.d("END", "LVL");
		// for(int i = 0;i<1024;i++)Move.Obj[i] = null;
		SAVE = true;
		STR = false;
	}

	static int last = 0;
	public static long SCRIPT;

	public static void Main() throws IllegalArgumentException,
			SecurityException, IllegalStateException, IOException {
		long start = System.currentTimeMillis();
		if (SAVE) {
			// String save = 0;
			PrintWriter zapis = new PrintWriter("/mnt/sdcard/data.save");
			String a = "";
			for (int i = 0; i < 1000; i++) {
				a = a + Points[i];
			}
			zapis.println(a);
			zapis.println("");
			zapis.close();

			zapis = new PrintWriter("/mnt/sdcard/fps.opt");
			zapis.println(FPS);
			zapis.close();
			SAVE = false;
		}
		if (LOAD) {
			File file = new File("/mnt/sdcard/data.save");
			if (file.exists()) {
				Scanner in = new Scanner(file);
				String zdanie = in.nextLine();
				for (int i = 0; i < 1000; i++)
					Points[i] = Integer.parseInt(zdanie.toCharArray()[i] + "");
			}
			LOAD = false;
			file = new File("/mnt/sdcard/fps.opt");
			if (file.exists()) {
				Scanner in = new Scanner(file);
				String zdanie = in.nextLine();
				FPS = Integer.parseInt(zdanie);
			}

		}
		if (!image) {
			Images.Load();
			image = true;
		}
		Image.Draw(Material.bg, 0, 0);
		for (int i = 0; i < 48 / 2; i++) {
			for (int j = 0; j < 36 / 2; j++) {
				Image.Draw(Material.kr, i * 80, j * 80);
			}
		}
		if (SCREEN == ENDLVL && !Core.ChangeScreen) {
			if(DEBUG)Text.Draw(Core.END+"", 64, 64);
			if (Core.END == 0) {
				if (Touch.Event == 1 && Touch.type == Touch.ACTION_UP
						&& !Core.ChangeScreen && !Handled) {
					if (Touch.x0 > (1920 - 900) / 2
							&& Touch.x0 < (1920 - 900 / 2) + 300
							&& Touch.y0 > 55 + 400 && Touch.y0 < 55 + 500) {
						Core.map = true;
						Core.SCREEN = Core.GAME;
						Core.ChangeScreen = true;
						Handled = true;
					}
					if (Touch.x0 > (1920 - 900) / 2
							&& Touch.x0 < (1920 - 900 / 2) + 500
							&& Touch.y0 > 55 + 600 && Touch.y0 < 55 + 800) {
						Core.SCREEN = Core.MENU;
						Core.ChangeScreen = true;
						Handled = true;
					}
				}

			}
			if (Core.END > 0) {
				int GW = 0;
				for (int i = 0; i < 300; i++) {
					GW = GW + Core.Points[i];
				}
				int wym = 0;
				wym = ((Core.SELECTLVL / 20)) * 70;
				boolean czy = true;
				if (GW < wym) {
					if (Core.SELECTLVL % 20 == 0)
						czy = false;
				}
				if (!Handled) {
					if (Touch.Event == 1 && Touch.type == Touch.ACTION_UP) {
						if (Touch.x0 > (1920 - 900) / 2
								&& Touch.x0 < (1920 - 900 / 2) + 450
								&& Touch.y0 > 55 + 400 && Touch.y0 < 55 + 500) {
							Core.map = true;
							Core.SCREEN = Core.GAME;
							Core.ChangeScreen = true;
							Handled = true;
						}
						if (czy)
							if (Touch.x0 > (1920 - 900) / 2 + 400
									&& Touch.x0 < (1920 - 900 / 2) + 550
									&& Touch.y0 > 55 + 400
									&& Touch.y0 < 55 + 500) {
								Core.SELECTLVL++;
								Core.map = true;
								Core.SCREEN = Core.GAME;
								Core.ChangeScreen = true;
								Handled = true;
							}
						if (Touch.x0 > (1920 - 900) / 2
								&& Touch.x0 < (1920 - 900 / 2) + 700
								&& Touch.y0 > 55 + 600 && Touch.y0 < 55 + 800) {
							Core.SCREEN = Core.MENU;
							Core.ChangeScreen = true;
							Handled = true;
						}
					}
				}
			}
			if (END > 0) {
				int GW = 0;
				for (int i = 0; i < 300; i++) {
					GW = GW + Points[i];
				}
				int wym = 0;
				wym = ((SELECTLVL / 20)) * 70;
				boolean czy = true;
				if (GW < wym) {
					if (SELECTLVL % 20 == 0)
						czy = false;
				}
				Image.Draw(Material.EndC, (1920 - 900) / 2, 55);
				Image.Draw(Material.tryy, (1920 - 900) / 2, 55 + 400);
				if (czy)
					Image.Draw(Material.BNex, (1920 - 900) / 2 + 450, 55 + 400);
				Image.Draw(Material.menu, (1920 - 900) / 2, 55 + 600);
			}
			if (END == 0) {
				Image.Draw(Material.EndF, (1920 - 900) / 2, 55);
				Image.Draw(Material.tryy, (1920 - 900) / 2, 55 + 400);
				Image.Draw(Material.menu, (1920 - 900) / 2, 55 + 600);
			}
		}
		if (SCREEN == ABOUT && !Core.ChangeScreen) {
			Image.Draw(Material.BBack, 1920 - 350, 55);
			if (Touch.Event == 1 && Touch.type == Touch.ACTION_UP
					&& !ChangeScreen && !Handled) {
				if (Touch.x0 > 1920 - 350 && Touch.y0 < 180) {
					SCREEN = MENU;
					ChangeScreen = true;
				}
			}
			String text = "about:$$" + " programing: thejakubx$"
					+ " graphics: igulapp$" + " maps: thejakubx, madzia3366$"
					+ "$$" + "$$$" + "all rights reserved";
			Text.Draw(text, 50, 50);
		}
		if (SCREEN == OPTIONS && !Core.ChangeScreen) {
			if (Touch.Event == 1 && !Core.ChangeScreen) {
				if (Touch.type == Touch.ACTION_UP) {
					if (Touch.x0 > 1920 - 350 && Touch.y0 < 180) {
						Core.SCREEN = Core.MENU;
						Core.ChangeScreen = true;
						Touch.Event = 0;
					}
					if (Touch.x0 > 50 - 64 && Touch.x0 < 50 + 64 && !Handled) {
						if (Touch.y0 > 900 - 64 && Touch.y0 < 900 + 64) {
							DEBUG = !DEBUG;
							Handled = true;
						}
					}
					Core.OPT = false;
				}

				if (Touch.x0 > 200 - 64 && Touch.x0 < 1200 + 64
						&& Touch.y0 > 300 - 64 && Touch.y0 < 600 + 64) {
					Core.OPT = true;
				}
				if (Core.OPT) {
					Core.POZ = (int) (Touch.x0 - 200);
					if (Core.POZ > 1170 - 210)
						Core.POZ = 1170 - 210;
					if (Core.POZ < 10)
						Core.POZ = 10;
					Core.FPS = (Core.POZ / 10) + 4;
				}
			}
			Image.Draw(Material.BBack, 1920 - 350, 55);
			Image.Draw(Material.choose1, 200, 420);
			Text.Draw("fps", 10, 340);
			Text.Draw(FPS + "", 10, 400);
			Image.Draw(Material.choose2, 200 + POZ - 50, 410);

			Text.Draw("warning:$" + "     greater number of fps increases$"
					+ "                 battery consumption.", 10, 600);
			String text = "options";
			Text.Draw(text, 50, 50);

			if (!DEBUG)
				Image.Draw(Material.check1, 50, 900);
			else
				Image.Draw(Material.check2, 50, 900);
			Text.Draw("debug. only for developer!", 100, 900);

		}
		if (SCREEN == MENU && !Core.ChangeScreen) {
			Ad = true;
			POINTS = 0;
			if (Touch.Event > 0 && !Handled) {
				if (Touch.x0 > (1920 - 900) / 2
						&& Touch.x0 < (1920 - 900) / 2 + 900 && Touch.y0 > 500
						&& Touch.y0 < 700) {
					Core.SCREEN = Core.CHOOSELVL;
					Core.ChangeScreen = true;
					Handled = true;
				}
				if (Touch.x0 > (1920 - 900) / 2
						&& Touch.x0 < (1920 - 900) / 2 + 900 && Touch.y0 > 700
						&& Touch.y0 < 900) {
					Core.SCREEN = Core.OPTIONS;
					Core.ChangeScreen = true;
					Handled = true;
				}
				if (Touch.x0 > (1920 - 900) / 2
						&& Touch.x0 < (1920 - 900) / 2 + 900 && Touch.y0 > 900
						&& Touch.y0 < 1100) {
					Core.SCREEN = Core.ABOUT;
					Core.ChangeScreen = true;
					Handled = true;
				}
				if (Core.SELECTLVL > 0) {
					if (Touch.x0 > (1920 - 900) / 2
							&& Touch.x0 < (1920 - 900) / 2 + 900
							&& Touch.y0 > 300 && Touch.y0 < 500) {
						Core.SCREEN = Core.GAME;
						Core.ChangeScreen = true;
						Handled = true;
					}
				}
			}
			if (SELECTLVL > 0)
				Image.Draw(Material.BBtg, (1920 - 900) / 2, 300);
			Image.Draw(Material.BStart, (1920 - 900) / 2, 500);
			Image.Draw(Material.options, (1920 - 900) / 2, 700);
			Image.Draw(Material.about, (1920 - 900) / 2, 900);
			Image.Draw(Material.logo, (1920 - 920) / 2, 100);
			Text.Draw("v1.3.1", 1920 - 64 * 5, 1280 - 64);
		}
		if (SCREEN == CHOOSELVL && !Core.ChangeScreen) {
			int GW = 0;
			for (int i = 0; i < 1000; i++) {
				GW = GW + Points[i];
			}
			Image.Draw(Material.point, 1920 - 350, 270);

			Text.Draw(GW + "", 1920 - 350 + 50, 270);

			Image.Draw(Material.BBack, 1920 - 350, 55);

			if (PAGE < PAGES - 1) {
				if (GW >= 70 * (PAGE + 1))
					Image.Draw(Material.BNex, 1920 - 440, 400);
				else {
					Image.Draw(Material.BEmpty, 1920 - 440, 400);
					Text.Draw(70 * (PAGE + 1) + "", 1920 - 440 + 150, 450);
					Image.Draw(Material.point, 1920 - 440 + 100, 450);
				}
			}

			if (PAGE > 0)
				Image.Draw(Material.BPrv, 1920 - 440, 600);

			// if(!ChangeScreen){
			if (Touch.Event == 1 && Touch.type == Touch.ACTION_UP
					&& !ChangeScreen && !Handled) {
				if (Touch.x0 > 1920 - 440) {
					if (PAGE < PAGES - 1) {
						if (Touch.y0 > 380 && Touch.y0 < 400 + 150 + 20) {
							if (GW >= 70 * (PAGE + 1))
								PAGE++;
							Handled = true;
						}
					}
					if (PAGE > 0) {
						if (Touch.y0 > 580 && Touch.y0 < 600 + 150 + 20) {
							PAGE--;
							Handled = true;
						}
					}
				}
				if (Touch.x0 > 1920 - 350 && Touch.y0 < 155) {
					SCREEN = MENU;
				}
				int line = -1;
				for (int i = 1; i <= 20; i++) {
					if ((i - 1) % 5 == 0)
						line++;
					int xx = 300 * ((i - 1) % 5);
					int yy = (300 * line);
					if (Touch.x0 > xx && Touch.x0 < xx + 300 && Touch.y0 > yy
							&& Touch.y0 < yy + 300) {
						if (Points[i - 1 + (PAGE * 20)] > 0
								|| i + (PAGE * 20) == 1) {
							map = true;
							SELECTLVL = i + (PAGE * 20);
							SCREEN = GAME;
							Log.d("SELECT", SELECTLVL + "");
						}

					}
				}

				// }
			}
			// Points[1] = 5;
			int line = -1;
			for (int i = 1 + (PAGE * 20); i <= 20 + (PAGE * 20); i++) {
				if ((i - 1) % 5 == 0)
					line++;
				int xx = 300 * ((i - 1) % 5);
				int yy = (300 * line);
				if (Points[i - 1] == 0 && i != 1) {
					Image.Draw(Material.Ilock, xx + 75, yy + 50);
				} else {
					if (i <= 9)
						Text.Draw(i + "", xx + 75, yy + 50 + 32);
					else if (i >= 10)
						Text.Draw(i + "", xx + 75 - 32, yy + 50 + 32);
					else if (i >= 100)
						Text.Draw(i + "", xx + 75 - 64, yy + 50 + 32);

				}
				if (Points[i] == 0 || i == 1)
					Image.Draw(Material.Ilvl0, xx, yy);
				if (Points[i] == 1)
					Image.Draw(Material.Ilvl1, xx, yy);
				if (Points[i] == 2)
					Image.Draw(Material.Ilvl2, xx, yy);
				if (Points[i] == 3)
					Image.Draw(Material.Ilvl3, xx, yy);
				if (Points[i] == 4)
					Image.Draw(Material.Ilvl4, xx, yy);
				if (Points[i] == 5)
					Image.Draw(Material.Ilvl5, xx, yy);
			}

		}
		if (SCREEN == GAME) {
			Ad2 = true;
			// CLEAR = true;
			if (!threa) {
				thread.start();
				thread2.start();
				threa = true;
			}
			synchronized(Core.thread2){
				if (map) {
					int Ob = 0;
					try {
						for (int i = 0; i < 1024; i++)
							Move.Obj[i] = null;
						InputStream i = Core.class.getResourceAsStream("map"
								+ SELECTLVL + ".pmap");
						BufferedReader r = new BufferedReader(
								new InputStreamReader(i));
	
						// reads each line
						String a = "";
						while ((a = r.readLine()) != null) {
							int i1 = 0;
							String temp = "";
							for (; i1 < a.length(); i1++) {
								if (a.toCharArray()[i1] == ',')
									break;
								temp = temp + a.toCharArray()[i1];
							}
							int x = Integer.parseInt(temp);
							temp = "";
							i1++;
							for (; i1 < a.length(); i1++) {
								if (a.toCharArray()[i1] == ',')
									break;
								temp = temp + a.toCharArray()[i1];
							}
							int y = Integer.parseInt(temp);
							temp = "";
							i1++;
							for (; i1 < a.length(); i1++) {
								if (a.toCharArray()[i1] == ',')
									break;
								temp = temp + a.toCharArray()[i1];
							}
							int id = Integer.parseInt(temp);
							x = x * 2;
							y = y * 2;
							if (id == 1)
								Move.Obj[Ob] = Object.Wall(x, y);
							if (id == 2)
								Move.Obj[Ob] = Object.R_Wall(x, y);
							if (id == 3)
								Move.Obj[Ob] = Object.L_Wall(x, y);
							if (id == 4)
								Move.Obj[Ob] = Object.Roof(x, y);
							if (id == 5)
								Move.Obj[Ob] = Object.Floor(x, y);
							if (id == 6) {
								Move.Sx = x;
								Move.Sy = y;
								Move.x = x;
								Move.y = y;
							}
							if (id == 7)
								Move.Obj[Ob] = Object.End(x, y);
							if (id == 8)
								Move.Obj[Ob] = Object.Saw(x, y);
							if (id == 9)
								Move.Obj[Ob] = Object.Point(x, y);
							if (id == 10)
								Move.Obj[Ob] = Object.Spikes_Down(x, y);
							if (id == 11)
								Move.Obj[Ob] = Object.Spikes_Up(x, y);
							if (id == 12)
								Move.Obj[Ob] = Object.Spikes_Left(x, y);
							if (id == 13)
								Move.Obj[Ob] = Object.Spikes_Rigth(x, y);
	
							if (id == 14)
								Move.Obj[Ob] = Object.Mag_M_d(x, y);
							if (id == 15)
								Move.Obj[Ob] = Object.Mag_M_u(x, y);
							if (id == 16)
								Move.Obj[Ob] = Object.Mag_M_l(x, y);
							if (id == 17)
								Move.Obj[Ob] = Object.Mag_M_r(x, y);
	
							if (id == 18)
								Move.Obj[Ob] = Object.Mag_P_d(x, y);
							if (id == 19)
								Move.Obj[Ob] = Object.Mag_P_u(x, y);
							if (id == 20)
								Move.Obj[Ob] = Object.Mag_P_l(x, y);
							if (id == 21)
								Move.Obj[Ob] = Object.Mag_P_r(x, y);
	
							Ob++;
	
						}
						i.close();
						run.Load(SELECTLVL);
					} catch (Exception e) {
						Log.d("XD", "Error");
					}
					map = false;
					
				}
			}
			try {
				int a = (1000 / FPS)-last;
				if(a>0)Thread.sleep(a);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int z = 1000/last;
			if(z>FPS)z=FPS;
			String DEB = "debug:" + "$ jump: " + Move.jump + "$ vector x: "
					+ Move.Xspeed + "$ vector y: " + Move.Yspeed
					+ "$ select lvl: " + SELECTLVL + "$ touch: " + Touch.Event
					+ "$ points: " + Core.POINTS + "$ fps max: " + Core.FPS
					+ "$ fps: " + z
					+ "$ scripts ms: " + SCRIPT
					
					

			;

			if (DEBUG)
				Text.Draw(DEB, 50, 50);
			Image.Draw(Material.arrows, 10, 1280 - 300);
			if (Move.deaths == 0)
				Image.Draw(Material.Paperman_happy, Move.x, Move.y);
			if (Move.deaths == 1)
				Image.Draw(Material.Paperman_smiley, Move.x, Move.y);
			if (Move.deaths == 2)
				Image.Draw(Material.Paperman_neutral, Move.x, Move.y);
			if (Move.deaths == 3)
				Image.Draw(Material.Paperman_confused, Move.x, Move.y);
			if (Move.deaths == 4)
				Image.Draw(Material.Paperman_sad, Move.x, Move.y);
			if (Move.deaths >= 5)
				Image.Draw(Material.Paperman_vsad, Move.x, Move.y);

			for (int i = 0; i < 1024; i++) {
				if (Move.Obj[i] != null && Move.Obj[i].pick==false) {
					Image.Draw(Move.Obj[i].TextID[Move.Obj[i].klatka],
							Move.Obj[i].x, Move.Obj[i].y);
				}
			}

			Image.Draw(Material.BBack, 1920 - 350, 55);
			Image.Draw(Material.BJump, 1920 - 300, 1280 - 300);
		}
		ChangeScreen = false;
		if (Touch.Event == 0)
			Handled = false;
		long stop = System.currentTimeMillis();
		last = (int) (stop - start);
	}
}
