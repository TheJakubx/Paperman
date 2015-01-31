package pl.thejakubx.paperman;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import pl.thejakubx.game.Core;

public class File {
	public static String Get(String rsc,int line) {
	      String val = "";
	      int a = 0;
	      try {


	         InputStream i = Core.class.getResourceAsStream(rsc);
	         BufferedReader r = new BufferedReader(new InputStreamReader(i));

	         // reads each line
	         String l;
	         while((l = r.readLine()) != null) {
	            if(a == line)val = val + l;
	            a++;
	         } 
	         i.close();
	      } 
	      catch(Exception e) {
	        // System.out.println(e);
	      }
	      return val;
	   }
	public static int lines(String rsc) {
	      String val = "";
	      int a = 0;
	      try {


	         InputStream i = Core.class.getResourceAsStream(rsc);
	         BufferedReader r = new BufferedReader(new InputStreamReader(i));

	         // reads each line
	         String l;
	         while((l = r.readLine()) != null) {
	            a++;
	         } 
	         i.close();
	      } 
	      catch(Exception e) {
	        // System.out.println(e);
	      }
	      return a;
	   }
		    
}
