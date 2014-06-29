package com.xms.alpha.scienceaidalpha;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
//Load ActionBarSherlock equivalents of the Android UI elements
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity { //note: extend SherlockActivity, not extend Activity
        
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle(R.string.app_name_user);
		setContentView(R.layout.activity_main);
		//define WebView name as [app]
		 WebView app = (WebView) findViewById(R.id.webView1); //define webView id for future reference to it
		 	app.loadUrl("file:///android_asset/www/background.html"); //load the first page
			WebSettings appSettings = app.getSettings(); //define name for WebView settings page and retrive properties of settings
			appSettings.setJavaScriptEnabled(true);  //setJavaScriptEnabled to use JavaScript in webView, which is req. in the HTML files
			try {
				appSettings.setAllowUniversalAccessFromFileURLs(true);  //required for jQuery Mobile to work on Android 4.x
			} catch (Exception e) {
			     //but it's not defined on Android 2.x so we'll just catch the error and do nothing.
			} catch(Error e2) {
			    //the error is pretty fatal, so we try all means to catch it or the app will crash.
			}
			//appSettings for WebView to increase fluidity and speed, reduction in lag.
			//Certain of the following may just be placebos
			appSettings.setRenderPriority(RenderPriority.HIGH);
			appSettings.setCacheMode(WebSettings.LOAD_DEFAULT); 
            appSettings.setJavaScriptEnabled(true);
            appSettings.setDomStorageEnabled(true);
            appSettings.setAppCacheEnabled(true);
            appSettings.setSupportZoom(false);
            appSettings.setAllowFileAccess(true);
            appSettings.setLoadsImagesAutomatically(true);
            app.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY); //note: to remove unsightly scrollbars in Android 2.x
            
          	}
	
	//Handle buttons at bottom of screen for accessing different subjects
	public void physics(View view)
	{
		WebView app = (WebView) findViewById(R.id.webView1);		//upon click, the button will force WebView to load physics.html
		app.loadUrl("file:///android_asset/www/physics.html");
	}

	public void chemistry(View view)
	{
		WebView app = (WebView) findViewById(R.id.webView1);
		app.loadUrl("file:///android_asset/www/chemistry.html");
	}
	
	public void biology(View view)
	{
		WebView app = (WebView) findViewById(R.id.webView1);
		app.loadUrl("file:///android_asset/www/biology.html");
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) { //required for the hardware back button to work
		WebView mainViewer = (WebView) findViewById(R.id.webView1);
	    // Check if the key event was back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && mainViewer.canGoBack()) {
	        mainViewer.goBack();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu); //getSupportMenuInflator - Sherlock. getMenuInflator is the Android one.
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection in the ActionBar. Items are defined in menu.xml
	WebView app = (WebView) findViewById(R.id.webView1);
	    int itemId = item.getItemId();
	    //first button is back button
		if (itemId == R.id.btnprev) {		//allocate id for back button
			app.goBack();					//on click, the button will force the WebView [id:webView 1] to go back
			return true;
		//if there is enough space, introduce button for about us/information page
		} else if (itemId == R.id.about) {		//allocate id for about button
			app.loadUrl("file:///android_asset/www/about.html");	//on click, the button will force the WebView to load about.html from assets
			return true;
		//if there is further space, introduce search button
		} else if (itemId == R.id.search) {		//allocate id for search button
			app.loadUrl("file:///android_asset/www/search.html");	//on click, the button will force the WebView to load search.html from assets
			return true;
		//note: if there isn't enough space, the buttons will either appear as 3 dot overflow or accesible with menu button.
		} else {
			return super.onOptionsItemSelected(item);
		}
	    
	}	
}
