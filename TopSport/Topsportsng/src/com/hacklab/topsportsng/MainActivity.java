package com.hacklab.topsportsng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.Settings;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.IntentSender.SendIntentException;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	WebView v = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
   	 	setContentView(R.layout.webshow);
     
   	 	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
   
   		v = (WebView)findViewById(R.id.webshow);
   	   	
        v.setWebChromeClient(new WebChromeClient(){
        	@Override
        	public void onProgressChanged(WebView view, int newProgress) {
        		// TODO Auto-generated method stub
        		super.onProgressChanged(view, newProgress);

        		ProgressBar pb = (ProgressBar) findViewById(R.id.progress);
        		
        		pb.setVisibility(ProgressBar.VISIBLE);
        		pb.setProgress(0);
        		
        		pb.setIndeterminate(false);
        		
        		if(newProgress!=100){
        			pb.setProgress(newProgress);
        		}
        		
        		if(newProgress==100){
        			pb.setVisibility(ProgressBar.GONE);
        	}
        	}
        });
       
        v.setWebViewClient(new WebViewClient());
        v.getSettings().setSupportZoom(true);
        v.getSettings().setLoadsImagesAutomatically(true);
        v.getSettings().setJavaScriptEnabled(true);
        v.getSettings().setDisplayZoomControls(true);
              //v.loadUrl("http://topsportsng.blogspot.com");
        v.loadUrl("http://unilagradio1031fm.org/streaming/index.html");
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
     public boolean onKeyDown(int keyCode, KeyEvent event){
    	 
    	  if ((keyCode == KeyEvent.KEYCODE_BACK) && v.canGoBack()) {
    	   v.goBack();
    	   return true;
    	  }
    	  return super.onKeyDown(keyCode, event);
   }
}
