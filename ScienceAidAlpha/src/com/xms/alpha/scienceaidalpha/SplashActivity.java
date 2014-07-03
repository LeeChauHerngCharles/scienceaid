//This java activity is for the splash screen shown every time on application startup.
//Generally not much has to be changed with each released.
package com.xms.alpha.scienceaidalpha;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import necessary android elements for timer and activity

	public class SplashActivity extends Activity {
		private long splashDelay = 2500; //command sets duration of splash screen to 2.5 seconds

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_splash);
	        
	        TimerTask task = new TimerTask()	//calls for timer to be activated
	        {

				@Override
				public void run() {
					finish();
					Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);	//set mainIntent to open MainActivity
					startActivity(mainIntent); //after timer, run mainIntent
				}
	        	
	        };
	        
	        Timer timer = new Timer();
	        timer.schedule(task, splashDelay); //set timer to use time set in splashDelay
	    }
	   
	   
	}

