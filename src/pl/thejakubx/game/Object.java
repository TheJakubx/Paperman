package pl.thejakubx.game;

public class Object {

	public static Obiekty L_Wall(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 40, 40, Material.l_wall, 0, 0, 0, 0, 0, false, true, false, false, 0);
		return obiekt;
	}
	public static Obiekty R_Wall(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 40, 40, Material.r_wall, 0, 0, 0, 0, 0, false, true, false, false, 0);
		return obiekt;
	}
	public static Obiekty Wall(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 40, 40, Material.wall, 0, 0, 0, 0, 0, false, true, false, false, 0);
		return obiekt;
	}
	public static Obiekty Roof(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 40, 40, Material.roof, 0, 0, 0, 0, 0, false, true, false, false, 0);
		return obiekt;
	}
	public static Obiekty Floor(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 40, 40, Material.floor, 0, 0, 0, 0, 0, false, true, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Point(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 60, 60, Material.point, 0, 0, 0, 0, 0, false, false, true, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_P_d(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_p_d, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_P_u(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_p_u, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_P_l(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_p_l, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_P_r(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_p_r, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}

	public static Obiekty Mag_M_d(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_m_d, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_M_u(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_m_u, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_M_l(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_m_l, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	public static Obiekty Mag_M_r(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 100, Material.mag_m_r, 0, 0, 0, 0, 0, false, false, false, false, 0);
		return obiekt;
	}
	
	
	
	
	
	
	
	
	public static Obiekty Saw(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 150, 150, Material.saw,
				 Material.saw2,
				 Material.saw3,
				 Material.saw4,
				 Material.saw4,
				 Material.saw5,
				 true,false,false,false,0);
		return obiekt;
	}
	public static Obiekty Spikes_Down(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 75, 20, Material.spike_down,true,false);
		return obiekt;
	}
	public static Obiekty Spikes_Up(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 75, 20, Material.spike_up,true,false);
		return obiekt;
	}
	public static Obiekty Spikes_Left(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 20, 75, Material.spike_left,true,false);
		return obiekt;
	}
	public static Obiekty Spikes_Rigth(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 20, 75, Material.spike_rigth,true,false);
		return obiekt;
	}
	public static Obiekty End(int x, int y){
		Obiekty obiekt = new Obiekty(x, y, 100, 75, Material.end,false,false);
		return obiekt;
	}
}