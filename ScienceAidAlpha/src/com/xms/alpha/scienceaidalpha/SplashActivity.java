package com.xms.alpha.scienceaidalpha;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

	public class SplashActivity extends Activity {
		private long splashDelay = 2500; //2.5 seconds

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_splash);
	        
	        TimerTask task = new TimerTask()
	        {

				@Override
				public void run() {
					finish();
					Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
					startActivity(mainIntent);
				}
	        	
	        };
	        
	        Timer timer = new Timer();
	        timer.schedule(task, splashDelay);
	    }
	   
	   
	}

