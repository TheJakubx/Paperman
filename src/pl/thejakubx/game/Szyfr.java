package pl.thejakubx.game;

public class Szyfr {
	private static final String ALF = "ABCDEFGHIJKLMNOPRSTUWXYZ abcdefghijklmnoprstuwxyz 1234567890";
	private static int GetNumber(char a){
		for(int i = 0;i<ALF.length();i++){
			if(a == ALF.toCharArray()[i]){
				return i;
			}
		}
		return 0;
	}
	private static char GetChar(int a){
		while(a<0)a = a+ALF.length();
		return ALF.toCharArray()[a%ALF.length()];
	}
	public static String Szyfruj(String text, String haslo){
		String ret = "";
		for(int i = 0;i<text.length();i++){

			
			ret = ret + GetChar(GetNumber(text.toCharArray()[i]) + (GetNumber(haslo.toCharArray()[(i*i)%haslo.length()])+i*i));
			
		}
		return ret;
		
	}
	public static String DeSzyfruj(String text, String haslo){
		String ret = "";
		for(int i = 0;i<text.length();i++){

			
			ret = ret + GetChar(GetNumber(text.toCharArray()[i]) - (GetNumber(haslo.toCharArray()[(i*i)%haslo.length()])+i*i));
			
		}
		return ret;
		
	}
}
