package com.techjoynt.stars.game;

import com.techjoynt.stars.activity.AddItemActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import at.bartinger.candroid.CandroidActivity;

public class Game extends CandroidActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GameView(this));
		
		Button button = new Button(this);
		button.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Game.this, AddItemActivity.class));
			}
		});
	}
}
