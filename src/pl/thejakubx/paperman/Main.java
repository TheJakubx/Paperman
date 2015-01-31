/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.thejakubx.paperman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



import pl.thejakubx.game.Core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.BitmapFactory.Options;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Main extends Activity {
    private SimulationView mSimulationView;
    private SensorManager mSensorManager;
    private PowerManager mPowerManager;
    private WakeLock mWakeLock;
    public static String androidId;
    @SuppressWarnings("deprecation")
    
    public static void showRateDialog(final Context mContext,
            final SharedPreferences.Editor editor) {
        Dialog dialog = new Dialog(mContext);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        String message = "If you Like Paperman rate it at the Google play. Thank you for your support!";
        builder.setMessage(message)
                .setTitle("Rate Paperman")
               // .setIcon(mContext.getApplicationInfo().icon)
                .setCancelable(false)
                .setPositiveButton("Rate Now",
                        new DialogInterface.OnClickListener() {
 
                            public void onClick(DialogInterface dialog,
                                    int which) {
                      	      PrintWriter zapis;
							try {
								zapis = new PrintWriter("/mnt/sdcard/add2.inf");
                    	      String a = "";
                    	      zapis.println(a);
                    	      zapis.println("");
                    	      zapis.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
                                editor.putBoolean("dontshowagain", true);
                                editor.commit();
                                mContext.startActivity(new Intent(
                                        Intent.ACTION_VIEW, Uri
                                                .parse("market://details?id=pl.thejakubx.paperman")));
                                dialog.dismiss();
                            }
                        })
                .setNeutralButton("Later",        
                        new DialogInterface.OnClickListener() {
 
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                dialog.dismiss();
 
                            }
                        });
        dialog = builder.create();
 
        dialog.show();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public static boolean a = false;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);


        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, getClass()
                .getName());
        mSimulationView = new SimulationView(this);
		androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID); 
        match.x = this;
        setContentView(mSimulationView);
        
   
		
		
		
		try {
	      File file = new File("/mnt/sdcard/add2.inf");
	      if(file.exists()){
		      Scanner in;
				in = new Scanner(file);
		      String zdanie = in.nextLine();
		      a = true;
	      }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	
		SharedPreferences prefs = this.getSharedPreferences("rate_app", 0);
		SharedPreferences.Editor editor = prefs.edit();
	    if(a == false)showRateDialog(this, editor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWakeLock.acquire();
        mSimulationView.startSimulation();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSimulationView.stopSimulation();
        mWakeLock.release();
    }
    class SimulationView extends View implements SensorEventListener {
        private Sensor mAccelerometer;
        public void startSimulation() {
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        }
        public void stopSimulation() {
            mSensorManager.unregisterListener(this);
        }
        boolean res = true;
        public SimulationView(Context context) {
            super(context);
            if(res){
                Display display = getWindowManager().getDefaultDisplay(); 
            	Scale.X = (display.getWidth()/ 1920.f);
            	Log.d("SCALE", Scale.X+"");
            	Scale.Y = (display.getHeight()/ 1280.f);
            	Image.Res = getResources();
	            res = false;
            }
        }
        @Override
		protected void onDraw(Canvas canvas) {
        	Image.canvas = canvas;
        	try {
				Core.Main();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	invalidate();
        }
        @Override
        public boolean onTouchEvent(MotionEvent e) {
            Touch.x0 = (int)e.getX(0)/Scale.X;
            Touch.y0 = (int)e.getY(0)/Scale.Y;
            if(e.getPointerCount() > 1){
	            Touch.x1 = (int)e.getX(1)/Scale.X;
	            Touch.y1 = (int)e.getY(1)/Scale.Y;
            }
            Touch.Event = e.getPointerCount();
            
            if(e.getAction() == MotionEvent.ACTION_UP){
            	Touch.Event--;
            }
            
            return true;
        } 
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
		public void onSensorChanged(SensorEvent arg0) {}
    }   
}
