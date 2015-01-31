package pl.thejakubx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import pl.thejakubx.game.Core;
import bsh.EvalError;
import bsh.Interpreter;

public class run {
	static Vector<Function> Functions = new Vector<Function>();

	public static void Load(int id) {
		Functions.clear();
		InputStream i = Core.class.getResourceAsStream("map" + id + ".ms");
		BufferedReader r = new BufferedReader(new InputStreamReader(i));

		String zdanie = "";
		boolean czy = false;
		int fun = 0;
		try {
			while ((zdanie = r.readLine()) != null) {
				if (zdanie.contains("end_function")) {
					czy = false;
					fun++;
				}

				else if (czy)
					Functions.get(fun).Line.add(zdanie);

				else if (zdanie.contains("function")) {
					zdanie = zdanie.replaceAll("function", "");
					zdanie = zdanie.replaceAll(" ", "");

					Functions.add(new Function());
					Functions.get(fun).Nam = Integer.parseInt(zdanie.replaceAll(
							"Object_", ""));
					czy = true;
				}

			}
		} catch (NumberFormatException e) {

		} catch (IOException e) {

		}
	}

	public static void Run(int id) {

		for (int i = 0; i < Functions.size(); i++) {
			if (Move.Obj[Functions.get(i).Nam] != null && Move.Obj[Functions.get(i).Nam].pick == false){
				Functions.get(i).run();
			}

		}

	}

}
