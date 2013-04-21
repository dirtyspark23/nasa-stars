package com.techjoynt.stars.service;

import com.techjoynt.stars.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service implements MediaPlayer.OnErrorListener {
    public static final String TAG = MusicService.class.getSimpleName();
    
    private final IBinder mBinder = new ServiceBinder();
    MediaPlayer mPlayer;
	
	public MusicService() {}
	
	public class ServiceBinder extends Binder {
		public MusicService getService() {
			return MusicService.this;
		}
	}
    
	public IBinder onBind(Intent arg0) {
        return mBinder;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = MediaPlayer.create(this, R.raw.ambience);
        mPlayer.setOnErrorListener(this);
        
        if (mPlayer != null) {
        	mPlayer.setLooping(true); // Set looping
        	mPlayer.setVolume(100,100);
        }
        
        mPlayer.setOnErrorListener(new OnErrorListener() {

      	  public boolean onError(MediaPlayer mp, int what, int extra) {
      		  onError(mPlayer, what, extra);
      		  return true;
      	  }
        });
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mPlayer.start();
        return Service.START_STICKY;
    }
    
    public void pause() {
    	if (mPlayer.isPlaying()) {
    		mPlayer.pause();
    	}
    }
    
    public void resume() {
    	if (!mPlayer.isPlaying()) {
    		mPlayer.start();
    	}
    }
    
    public void stop() {
    	mPlayer.stop();
    	mPlayer.release();
    	mPlayer = null;
    }
    
    public IBinder onUnBind(Intent arg0) {
        return null;
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	
    	if (mPlayer != null) {
    		try {
    			mPlayer.stop();
    			mPlayer.release();
    		} finally {
    			mPlayer = null;
    		}
    	}
    }
    
    @Override
    public void onLowMemory() {
    	super.onLowMemory();
    	if (mPlayer.isPlaying()) {
    		mPlayer.stop();
    		mPlayer.release();
    		mPlayer = null;
 
    		Log.i(TAG, "Warning to much memory being used!");
    	}
    }

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		if (mPlayer != null) {
			try {
				mPlayer.stop();
				mPlayer.release();
			} finally {
				mPlayer = null;
			}
		}
		return false;
	}
}