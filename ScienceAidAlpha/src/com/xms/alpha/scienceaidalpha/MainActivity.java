package com.xms.alpha.scienceaidalpha;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
//import com.github.espiandev.showcaseview.ShowcaseView;
//Load ActionBarSherlock equivalents of the Android UI elements


public class MainActivity extends SherlockActivity { //note: extend SherlockActivity, not extend Activity.
	
//	ShowcaseView sv;
        
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle(R.string.app_name_user);
		setContentView(R.layout.activity_main);
		 WebView app = (WebView) findViewById(R.id.webView1);
		 	app.loadUrl("file:///android_asset/www/background.html"); //load the first page
			WebSettings appSettings = app.getSettings();
			appSettings.setJavaScriptEnabled(true);
			try {
				appSettings.setAllowUniversalAccessFromFileURLs(true);  //required for jQuery Mobile to work on Android 4.x
			} catch (Exception e) {
			     //but it's not defined on Android 2.x so we'll just catch the error and do nothing.
			} catch(Error e2) {
			    //the error is pretty fatal, so we try all means to catch it or the app will crash.
			}
			appSettings.setRenderPriority(RenderPriority.HIGH);
			appSettings.setCacheMode(WebSettings.LOAD_DEFAULT); 
            appSettings.setJavaScriptEnabled(true);
            appSettings.setDomStorageEnabled(true);
            appSettings.setAppCacheEnabled(true);
            appSettings.setSupportZoom(false);
            appSettings.setAllowFileAccess(true);
            appSettings.setLoadsImagesAutomatically(true);
            app.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            
          	}
	
	//Handle buttons at bottom of screen for accessing different subjects
	public void physics(View view)
	{
		WebView mainViewer = (WebView) findViewById(R.id.webView1);
		mainViewer.loadUrl("file:///android_asset/www/physics.html");
	}

	public void chemistry(View view)
	{
		WebView mainViewer = (WebView) findViewById(R.id.webView1);
		mainViewer.loadUrl("file:///android_asset/www/chemistry.html");
	}
	
	public void biology(View view)
	{
		WebView mainViewer = (WebView) findViewById(R.id.webView1);
		mainViewer.loadUrl("file:///android_asset/www/biology.html");
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

//		ShowcaseView.ConfigOptions co = new ShowcaseView.ConfigOptions();
//		co.shotType = ShowcaseView.TYPE_ONE_SHOT;
//        
//		sv = ShowcaseView.insertShowcaseViewWithType(ShowcaseView.ITEM_ACTION_ITEM, R.id.search, this,
//      R.string.showcase_title, R.string.showcase_content, co);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection in the ActionBar. Items are defined in menu.xml
	WebView alpha = (WebView) findViewById(R.id.webView1);
	    int itemId = item.getItemId();
		if (itemId == R.id.btnprev) {
			alpha.goBack();
			return true;
		} else if (itemId == R.id.about) {
			alpha.loadUrl("file:///android_asset/www/about.html");
			return true;
		} else if (itemId == R.id.search) {
			alpha.loadUrl("file:///android_asset/www/search.html");
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	    
	}	
}
