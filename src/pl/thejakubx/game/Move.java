package pl.thejakubx.game;

import pl.thejakubx.paperman.Image;
import pl.thejakubx.paperman.Touch;

public class Move extends Thread{
	static int Sx = 200;
	static int Sy = 200;
	static int x = Sx;
	static int y = Sy;
	static int deaths = 0;
	static boolean jump = false;
	static double jump_power = 0;
	public static Obiekty Obj[] = new Obiekty[1024];
	
	static float Yspeed = 0;
	static float Xspeed = 0;
	static boolean Yczy = true;
	private static void Death(){
		x = Sx;
		y = Sy;
		Yspeed = 0;
		Xspeed = 0;
		deaths++;
		Core.POINTS = 0;
		Core.map = true;
	}
	public synchronized void run(){
		
		while(true){
			try {
				Thread.sleep(1000/30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean moveX = false;
			if(Core.SCREEN == Core.GAME && Core.map == false){
				
				if(Touch.Event == 1){
					if(Touch.x0 > 0 && Touch.x0 < 270 && Touch.y0 > 1280-300){
						if(Move.Xspeed > -20)Move.Xspeed = Move.Xspeed -4f;
						moveX = true;
					}
					else if(Touch.x0 > 260 && Touch.x0 < 520 && Touch.y0 >  1280-300){
						if(Move.Xspeed < 20)Move.Xspeed = Move.Xspeed +4f;
						moveX = true;
					}
					else if(Touch.x0 > 1920-350 && Touch.y0 < 155 ){
						Core.SCREEN = Core.MENU;
					}
					else if(Touch.x0 > 1920-300 && Touch.y0 > 1280-300 && Move.Yspeed == 0 && !Move.jump){
						Move.Yspeed = -40;
						Move.jump = true;
					}
				
				}
				if(Touch.Event == 2){
					if(Touch.x0 > 0 && Touch.x0 < 270 && Touch.y0 > 1280-300){
						if(Move.Xspeed > -20)Move.Xspeed = Move.Xspeed -2f;
						moveX = true;
					}
					else if(Touch.x0 > 260 && Touch.x0 < 520 && Touch.y0 >  1280-300){
						if(Move.Xspeed < 20)Move.Xspeed = Move.Xspeed +2f;
						moveX = true;
					}
					else if(Touch.x0 > 1920-300 && Touch.y0 > 1280-300 && Move.Yspeed == 0 && !Move.jump){
						Move.Yspeed = -40;
						Move.jump = true;
					}
					if(Touch.x1 > 0 && Touch.x1 < 270 && Touch.y1 > 1280-300){
						if(Move.Xspeed > -20)Move.Xspeed = Move.Xspeed -2f;
						moveX = true;
					}
					else if(Touch.x1 > 260 && Touch.x1 < 520 && Touch.y1 > 1280-300){
						if(Move.Xspeed < 40)Move.Xspeed = Move.Xspeed +2f;
						moveX = true;
					}
					else if(Touch.x1 > 1920-300 && Touch.y1 > 1280-300 && Move.Yspeed == 0 && !Move.jump){
						Move.Yspeed = -40;
						Move.jump = true;
					}
				}
				Yspeed = Yspeed + 2;
				
				if(!moveX)Xspeed = 0;
				for(int i = 0;i<1024;i++){
					if(Move.Obj[i] != null){
						if(Move.Obj[i].klatki >1){
							Move.Obj[i].klatka++;
							Move.Obj[i].klatka =Move.Obj[i].klatka%Move.Obj[i].klatki;
						}
					}
				}
				
				
				
				int XX = 50;
				int YY = 30;
				for(int i = 0;i<1024;i++){
					if(Obj[i] != null){
						if(Obj[i].TextID[0] == Material.mag_p_d){
							if(Obj[i].x-XX-30< x && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY-2000-50< y && Obj[i].y_len+Obj[i].y> y){
										if(Yspeed <-20)Yspeed = Yspeed - 1;
										else Yspeed = - 20;
										
							}
						}
						if(Obj[i].TextID[0] == Material.mag_m_d){
							if(Obj[i].x-XX-30< x && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY-2000-50< y && Obj[i].y_len+Obj[i].y> y){
										if(Yspeed <+20)Yspeed = Yspeed + 1;
										else Yspeed = + 20;
										
							}
						}
						if(Obj[i].TextID[0] == Material.mag_p_u){
							if(Obj[i].x-XX-30< x && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY< y-50&& Obj[i].y_len+Obj[i].y+2000> y){
										if(Yspeed <+20)Yspeed = Yspeed + 1;
										else Yspeed = + 20;
										
							}
						}
						if(Obj[i].TextID[0] == Material.mag_m_u){
							if(Obj[i].x-XX-30< x && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY< y-50 && Obj[i].y_len+Obj[i].y+2000> y){
										if(Yspeed <-20)Yspeed = Yspeed -1;
										else Yspeed = - 20;
										
							}
						}
						
						
						
					/*	if(Obj[i].TextID[0] == Material.mag_m_l){
							if(Obj[i].x-XX-30-2000< x && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY< y-50 && Obj[i].y_len+Obj[i].y> y){
										if(Xspeed <-20)Xspeed = Xspeed -1;
										else Xspeed = - 20;	
							}
						}
						if(Obj[i].TextID[0] == Material.mag_m_r){
							if(Obj[i].x-XX-30< x && Obj[i].x_len+Obj[i].x+2000> x+20
									&& Obj[i].y-YY< y-50 && Obj[i].y_len+Obj[i].y> y){
										Xspeed = Xspeed +1;
										if(Xspeed > 20)Xspeed = 20;	
							}
						}
						if(Obj[i].TextID[0] == Material.mag_p_r){
							if(Obj[i].x-XX-30< x+2000 && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY< y-50 && Obj[i].y_len+Obj[i].y> y){
										if(Xspeed <-20)Xspeed = Xspeed -1;
										else Xspeed = - 20;	
							}
						}
						if(Obj[i].TextID[0] == Material.mag_p_l){
							if(Obj[i].x-XX-30< x+2000 && Obj[i].x_len+Obj[i].x> x+20
									&& Obj[i].y-YY< y-50 && Obj[i].y_len+Obj[i].y> y){
										if(Xspeed <20)Xspeed = Xspeed +1;
										else Xspeed =  20;	
							}
						}*/
						
						
					}
					
					
					
				}
				boolean XD = true;
				for(int i = 0;i<1024;i++){
					if(Obj[i] != null){
						if(Obj[i].x-XX-30< x && Obj[i].x_len+Obj[i].x> x+20
						&& Obj[i].y-YY< y+Yspeed+40 && Obj[i].y_len+Obj[i].y> y+Yspeed+10){
							if(Obj[i].Przenik){
								Yspeed = 0;
								if(y<Obj[i].y)jump = false;
								XD = false;
							}
							if(Obj[i].Dead)Death();
							if(Obj[i].TextID[0] == Material.point && Obj[i].pick==false)Core.POINTS++;
							if(Obj[i].TextID[0] == Material.end)Core.EndLvl();
							if(Obj[i].tp){
								x = Obj[Obj[i].Dir].x;
								y = Obj[Obj[i].Dir].y;
							}
							if(Obj[i].pickable && Obj[i].pick == false)Obj[i].pick = true;
						}
					}
					if(Obj[i] != null){
						if(Obj[i].x-XX-30< x+Xspeed&& Obj[i].x_len+Obj[i].x> x+Xspeed+20
						&& Obj[i].y-YY< y+40 && Obj[i].y_len+Obj[i].y> y+10){
							if(Obj[i].Przenik){
								Xspeed = 0;
								XD = false;
							}
							if(Obj[i].Dead)Death();
							if(Obj[i].TextID[0] == Material.point && Obj[i].pick==false)Core.POINTS++;
							if(Obj[i].TextID[0] == Material.end)Core.EndLvl();
							if(Obj[i].tp){
								x = Obj[Obj[i].Dir].x;
								y = Obj[Obj[i].Dir].y;
							}
							if(Obj[i].pickable && Obj[i].pick == false)Obj[i].pick = true;
						}
					}

				}
				if(XD && Core.SCREEN != Core.ENDLVL){
					for(int i = 0;i<1024;i++){
						if(Obj[i] != null){
							if(Obj[i].x-XX-30< Xspeed+x && Obj[i].x_len+Obj[i].x> Xspeed+x+20
							&& Obj[i].y-YY< y+Yspeed+40 && Obj[i].y_len+Obj[i].y> y+Yspeed+10){
								if(Obj[i].Przenik){
									Yspeed = 0;
									Xspeed = 0;
									if(y<Obj[i].y)jump = false;
								}
								if(Obj[i].Dead)Death();
								if(Obj[i].TextID[0] == Material.point && Obj[i].pick==false)Core.POINTS++;
								if(Obj[i].TextID[0] == Material.end)Core.EndLvl();
								if(Obj[i].tp){
									x = Obj[Obj[i].Dir].x;
									y = Obj[Obj[i].Dir].y;
								}
								if(Obj[i].pickable && Obj[i].pick == false)Obj[i].pick = true;
							}
						}
					}
				}
				y = (int) (y + Yspeed);
				x = (int) (x+Xspeed);
					
			}
		}
	}
}
