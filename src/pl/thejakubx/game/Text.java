package pl.thejakubx.game;

import pl.thejakubx.paperman.Image;



public class Text {

	public static void Draw(String Text, int x, int y){
		int line = 0;
		int zn = 0;
		for(int i = 0;i<Text.length();i++){
			zn++;
			if(Text.toCharArray()[i] == '$'){
				line++;
				zn=0;
			}
			if(Text.toCharArray()[i] == 'a')Image.Draw(Material.a, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'b')Image.Draw(Material.b, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'c')Image.Draw(Material.c, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'd')Image.Draw(Material.d, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'e')Image.Draw(Material.e, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'f')Image.Draw(Material.f, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'g')Image.Draw(Material.g, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'h')Image.Draw(Material.h, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'i')Image.Draw(Material.i, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'j')Image.Draw(Material.j, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'k')Image.Draw(Material.k, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'l')Image.Draw(Material.l, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'm')Image.Draw(Material.m, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'n')Image.Draw(Material.n, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'o')Image.Draw(Material.o, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'p')Image.Draw(Material.p, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'r')Image.Draw(Material.r, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 's')Image.Draw(Material.s, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 't')Image.Draw(Material.t, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'u')Image.Draw(Material.u, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'w')Image.Draw(Material.w, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'x')Image.Draw(Material.x, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'y')Image.Draw(Material.y, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'z')Image.Draw(Material.z, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == 'v')Image.Draw(Material.v, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == ':')Image.Draw(Material.DK, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '.')Image.Draw(Material.KR, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '1')Image.Draw(Material.JE, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '2')Image.Draw(Material.DW, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '3')Image.Draw(Material.TR, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '4')Image.Draw(Material.CZ, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '5')Image.Draw(Material.PI, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '6')Image.Draw(Material.SZ, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '7')Image.Draw(Material.SI, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '8')Image.Draw(Material.OS, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '9')Image.Draw(Material.DZ, x+44*zn, y+64*line);
			if(Text.toCharArray()[i] == '0')Image.Draw(Material.ZR, x+44*zn, y+64*line);
			
			
		}
	}
}
