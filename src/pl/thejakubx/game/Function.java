package pl.thejakubx.game;
import java.util.Vector;

import pl.thejakubx.game.Move;

import android.util.Log;
import bsh.EvalError;


public class Function extends Thread{
	public boolean START = false;
	int Nam;
	Vector<String> Line = new Vector<String>();
	Vector<String> VarName = new Vector<String>();
	Vector<Double> VarInt = new Vector<Double>();
	
	
	
	private double GetVariable(String Name){
		for(int i = 0;i<VarName.size();i++){
			if(VarName.get(i).equals(Name)){
				return VarInt.get(i);
			}
		}
		return 0.0;
	}
	private boolean CheckVariable(String Name){
		for(int i = 0;i<VarName.size();i++){
			if(VarName.get(i).equals(Name)){
				return true;
			}
		}
		return false;
	}
	private void DropVariable(String Name){
		for(int i = 0;i<VarName.size();i++){
			if(VarName.get(i).equals(Name)){
				VarName.remove(i);
				VarInt.remove(i);
				
			}
		}
	}
	private void SetVariable(String Name, double Value){
		if(Name.equals("Object.PosX")){ Move.Obj[Nam].x = (int) Value; return;}
		if(Name.equals("Object.PosY")){ Move.Obj[Nam].y = (int) Value; return;}
		if(Name.equals("Player.PosX")){ Move.x = (int) Value; return;}
		if(Name.equals("Player.PosY")){ Move.y= (int) Value; return;}
		for(int i = 0;i<VarName.size();i++){
			if(VarName.get(i).equals(Name)){
				VarInt.set(i, Value);
				return;
			}
		}
		VarInt.add(Value);
		VarName.add(Name);
	}
	boolean RUN = true;
	int ifle = 0;
	public void run(){
		START = true;
		RUN = true;
		for(int linei = 0;linei<Line.size();linei++){
			String line = Line.get(linei);
			if(RUN && Move.Obj[Nam] != null){
				line = line.replaceAll("	", "");
				if(line.equals("break"))break;
				if(line.contains("ifdef ")){
					ifle++;
					line = line.replaceAll("ifdef","");
					line = line.replaceAll(" ","");
					if(!CheckVariable(line)){
						RUN = false;
					}
				}
				else if(line.contains("ifnotdef ")){
					ifle++;
					line = line.replaceAll("ifnotdef","");
					line = line.replaceAll(" ","");
					if(CheckVariable(line)){
						RUN = false;
					}
				}
				else if(line.contains("if ")){
					ifle++;
					line = line.replaceAll("if ","");
					line = line.replaceAll(" ","");
					for(int i = 0;i<VarName.size();i++){
						line = line.replaceAll(VarName.get(i), GetVariable(VarName.get(i))+"");
					}
					line = line.replaceAll("Object.PosX", Move.Obj[Nam].x+"");
					line = line.replaceAll("Object.PosY", Move.Obj[Nam].y+"");
					line = line.replaceAll("Player.PosX", Move.x+"");
					line = line.replaceAll("Player.PosY", Move.y+"");
					
					try {
						RUN = Operators.condition(line);
					} catch (EvalError e) {
					}
					
				}
				else if(line.contains("drop ")){
					line = line.replaceAll("drop ","");
					DropVariable(line);
					
					
				}
				else if(line.contains("debug ")){
					line = line.replaceAll("debug ","");
					Log.d("DEBUG ",this.GetVariable(line)+"");
					
					
				}
				else if(line.contains("=") && RUN){
					line = line.replaceAll(" ","");
					String Name = Operators.ToChar(line, '=');
					String Row = Operators.FromChar(line, '=');
					for(int i = 0;i<VarName.size();i++){
						Row = Row.replaceAll(VarName.get(i), GetVariable(VarName.get(i))+"");
					}
					Row = Row.replaceAll("Object.PosX", Move.Obj[Nam].x+"");
					Row = Row.replaceAll("Object.PosY", Move.Obj[Nam].y+"");
					line = line.replaceAll("Player.PosX", Move.x+"");
					line = line.replaceAll("Player.PosY", Move.y+"");
					double Value = 0;
					try {
						Value = Operators.Calcule(Row);
					} catch (EvalError e) {
					}
					SetVariable(Name, Value);
					
				}
			}
			if(line.contains("end_if")){
				ifle--;
				if(ifle == 0)RUN = true;
			}
			
			START = false;
		}
	//	System.out.println(X);
	//	System.out.println(Y);
	}
	
	
	
}
