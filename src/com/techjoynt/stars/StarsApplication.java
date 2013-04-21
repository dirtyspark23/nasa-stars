package com.techjoynt.stars;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.bugsnag.android.Bugsnag;

public class StarsApplication extends Application {
	protected static final String bugSnagId = "2068115cd530a0d627d11b712c89584b";
	public static boolean DEBUG = true;

	private static Context mApplicationContext;
	private static SharedPreferences mPrefs;

	@Override
	public void onCreate() {
		super.onCreate();
		mApplicationContext = getApplicationContext();
		mPrefs = PreferenceManager.getDefaultSharedPreferences(mApplicationContext);
	    Bugsnag.register(this, bugSnagId);
	}

	public static Context getGloablContext() {
		return mApplicationContext;
	}

	public static SharedPreferences getPrefs() {
		return mPrefs;
	}
}