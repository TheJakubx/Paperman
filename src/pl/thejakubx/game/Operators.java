package pl.thejakubx.game;
import bsh.EvalError;
import bsh.Interpreter;


public class Operators {
	public static String ToChar(String Text,char a){
		String b = "";
		for(int i = 0;i<Text.length();i++){
			if(Text.toCharArray()[i] == a){
				return b;
			}
			b = b+Text.toCharArray()[i];
		}
		return b;
	}
	public static String FromChar(String Text,char a){
		String b = "";
		boolean czy = false;
		for(int i = 0;i<Text.length();i++){
			if(czy)b = b+Text.toCharArray()[i];
			if(Text.toCharArray()[i] == a)czy = true;
		}
		return b;
	}
	static double Calcule(String a) throws EvalError{
		 Interpreter interpreter = new Interpreter();
		 interpreter.eval("result = "+a );
		 
		return  Double.parseDouble(interpreter.get("result").toString());
	}
	static boolean condition(String line) throws EvalError{
		if(line.contains("==")){
			String left = Operators.ToChar(line, '=');
			String rigth = Operators.FromChar(line, '=');
			left = left.replaceAll("=", "");
			rigth = rigth.replaceAll("=", "");
			
			if(!(Operators.Calcule(left)==Operators.Calcule(rigth)))
				return false;
		}
		else if(line.contains("!=")){
			String left = Operators.ToChar(line, '!');
			String rigth = Operators.FromChar(line, '=');
			left = left.replaceAll("!", "");
			rigth = rigth.replaceAll("=", "");
			
			if(!(Operators.Calcule(left)!=Operators.Calcule(rigth)))
				return false;
		}
		else if(line.contains(">=")){
			String left = Operators.ToChar(line, '>');
			String rigth = Operators.FromChar(line, '=');
			left = left.replaceAll(">", "");
			rigth = rigth.replaceAll("=", "");
			
			if(!(Operators.Calcule(left)>=Operators.Calcule(rigth)))
				return false;
		}
		else if(line.contains("<=")){
			String left = Operators.ToChar(line, '<');
			String rigth = Operators.FromChar(line, '=');
			left = left.replaceAll("<", "");
			rigth = rigth.replaceAll("=", "");
			
			if(!(Operators.Calcule(left)<=Operators.Calcule(rigth)))
				return false;
		}
		else if(line.contains(">")){
			String left = Operators.ToChar(line, '>');
			String rigth = Operators.FromChar(line, '>');
			left = left.replaceAll(">", "");
			rigth = rigth.replaceAll(">", "");
			
			if(!(Operators.Calcule(left)>Operators.Calcule(rigth)))
				return false;
		}
		else if(line.contains("<")){
			String left = Operators.ToChar(line, '<');
			String rigth = Operators.FromChar(line, '<');
			left = left.replaceAll("<", "");
			rigth = rigth.replaceAll("<", "");
			
			if(!(Operators.Calcule(left)<Operators.Calcule(rigth)))
				return false;
		}
		return true;
	}
}
