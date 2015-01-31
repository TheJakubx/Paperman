package pl.thejakubx.game;

public class Exec extends Thread{
	public void run() {
		while(true){
			long start=System.currentTimeMillis();
			if(Core.SCREEN == Core.GAME)
				run.Run(0);
			long stop=System.currentTimeMillis();
			Core.SCRIPT = stop-start;
		}
	}
}
