package com.techjoynt.stars.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.techjoynt.stars.R;
import com.techjoynt.stars.game.Game;
import com.techjoynt.stars.game.GameNative;
import com.techjoynt.stars.service.MusicService;
import com.techjoynt.stars.service.MusicService.ServiceBinder;

public class StartScreen extends Activity {
	private Button mLogin;
	
	//private boolean mIsBound = false;
	//private MusicService mServ;
	//private MusicService.ServiceBinder mBinder;
	/**
	private ServiceConnection Scon = new ServiceConnection() {
		public void onServiceConnected(ComponentName name, IBinder binder) {
			mBinder = (ServiceBinder) binder;
			mServ = mBinder.getService();
		}

		public void onServiceDisconnected(ComponentName name) {
			mServ = null;
		}
	};

	void doBindService() {
		bindService(new Intent(this,MusicService.class), Scon,Context.BIND_AUTO_CREATE);
			mIsBound = true;
		}

	void doUnbindService() {
		if (mIsBound) {
			unbindService(Scon);
			mIsBound = false;
		}
	} **/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		setupView();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		//mServ.pause();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//mServ.stop();
	}
	
	private void setupView() {
		mLogin = (Button)findViewById(R.id.btn_start);
		
		mLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				selectActivity().show();
			}
		});
	}
	
	private Dialog selectActivity() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setPositiveButton("Game (Canvas Based)", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				startActivity(new Intent(StartScreen.this, Game.class));
			}
		});
		
		builder.setNeutralButton("Game (Native Based)", new DialogInterface.OnClickListener() {	
			@Override
			public void onClick(DialogInterface dialog, int which) {
				startActivity(new Intent(StartScreen.this, GameNative.class));
			}
		});
		return builder.create();
	}
}