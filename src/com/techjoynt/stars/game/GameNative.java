package com.techjoynt.stars.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.techjoynt.stars.R;

public class GameNative extends Activity {
	private ImageView greenHouse;
	private ImageView drill;
	private ImageView house1;
	private ImageView house2;
	
	LinearLayout layout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_native);
		
		layout = (LinearLayout)findViewById(R.id.linearLayout);
		setupViews();
		

		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.title);
		builder.setMessage(R.string.message);
		builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				setupTutorial();
			}
		});
		
		builder.create();
		builder.show();
	}
	
	
	private void setupTutorial() {
		house1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder builder = new AlertDialog.Builder(GameNative.this);
				builder.setTitle("House");
				builder.setMessage(R.string.house_info);
				
				builder.setPositiveButton("Add Another Object", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						ImageView image = new ImageView(GameNative.this);
						image.setImageDrawable(getResources().getDrawable(R.drawable.sprite_haws));
						layout.addView(image);
					}
				});
				
				builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				
				builder.create().show();
			}
		});
		
		house2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder builder = new AlertDialog.Builder(GameNative.this);
				builder.setTitle("House");
				builder.setMessage(R.string.house_info);

				builder.setPositiveButton("Add Another Object", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						ImageView image = new ImageView(GameNative.this);
						image.setImageDrawable(getResources().getDrawable(R.drawable.sprite_haws2));
						layout.addView(image);
					}
				});
				
				builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				
				builder.create().show();
			}
		});
		
		greenHouse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder builder = new AlertDialog.Builder(GameNative.this);
				builder.setTitle("Green House");
				builder.setMessage(R.string.green_house_info);
				
				builder.setPositiveButton("Add Another Object", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						ImageView image = new ImageView(GameNative.this);
						image.setImageDrawable(getResources().getDrawable(R.drawable.sprite_greenhaws));
						layout.addView(image);
					}
				});
				
				builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				
				builder.create().show();
			}
		});
		
		drill.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder builder = new AlertDialog.Builder(GameNative.this);
				builder.setTitle("Drill");
				builder.setMessage(R.string.drill_info);
				
				builder.setPositiveButton("Add Another Object", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						ImageView image = new ImageView(GameNative.this);
						image.setImageDrawable(getResources().getDrawable(R.drawable.sprite_drill));
						layout.addView(image);
					}
				});
				
				builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				
				builder.create().show();
			}
		});
	}
	
	private void setupViews() {
		greenHouse = (ImageView)findViewById(R.id.green_house);
		drill = (ImageView)findViewById(R.id.drill);
		house1 = (ImageView)findViewById(R.id.house_1);
		house2 = (ImageView)findViewById(R.id.house_2);
	}
}
