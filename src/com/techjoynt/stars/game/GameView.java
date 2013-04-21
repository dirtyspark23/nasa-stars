package com.techjoynt.stars.game;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import at.bartinger.candroid.CandroidSurfaceView;
import at.bartinger.candroid.background.FixedBackground;
import at.bartinger.candroid.ingame.Score;
import at.bartinger.candroid.renderable.Sprite;
import at.bartinger.candroid.renderer.SurfaceRenderer;
import at.bartinger.candroid.texture.Texture;
import at.bartinger.candroid.texture.TextureAtlas;
import at.bartinger.candroid.texture.TextureManager;

public class GameView extends CandroidSurfaceView {
	private static final String TAG = GameView.class.getSimpleName();
	
	private SurfaceRenderer spriteRenderer;
	
	private Sprite[] objects = new Sprite[5];
	private Score gamescore;
    
    private Texture rover;
    private Texture green_house;
    private Texture drill;
    private Texture house1;
    private Texture house2;
    
    
    private Sprite mRover;
    private Sprite mGreenHouse;
    private Sprite mDrill;
    private Sprite mHouse1;
    private Sprite mHouse2;
	
	public GameView(Context context) {
		super(context);
		
		spriteRenderer = new SurfaceRenderer();
		
		gamescore = new Score(context, 20,100, "Your Score: ", Color.GREEN,35,false,"fonts/roboto.ttf");
		spriteRenderer.addRenderable(gamescore);
		
		TextureAtlas atlas = new TextureAtlas();

        rover = new Texture("gfx/rover.png");
        drill = new Texture("gfx/sprite_drill.png");
        green_house = new Texture("gfx/sprite_greenhaws.png");
        house1 = new Texture("gfx/sprite_haws.png");
        house2 = new Texture("gfx/sprite_haws2.png");
		
		//mRover = new Sprite(rover, 10, 10);
		//mDrill = new Sprite(drill, 20, 20);
		//mGreenHouse = new Sprite(green_house, 30, 30);
		//mHouse1 = new Sprite(house1, 40, 40);
		mHouse2 = new Sprite(house2, 50, 50);
	
		Texture app_background = new Texture("gfx/backgroundtile.png");
		atlas.addTexture(app_background);
		atlas.addTexture(rover);
		atlas.addTexture(drill);
		atlas.addTexture(green_house);
		atlas.addTexture(house1);
		atlas.addTexture(house2);
		 
		TextureManager.load(context, atlas);
		
		FixedBackground background = new FixedBackground(app_background);
		
		spriteRenderer.addRenderable(background);
		spriteRenderer.addRenderable(mRover);
		spriteRenderer.addRenderable(mDrill);
		spriteRenderer.addRenderable(mGreenHouse);
		spriteRenderer.addRenderable(mHouse1);
		spriteRenderer.addRenderable(mHouse2);
		spriteRenderer.setBackground(background);
		
		setRendererAndStart(spriteRenderer);
	}
	
	@Override
    public void onTouchDown(int touchX, int touchY, int pressure) {
		
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		try {
			Thread.sleep(16);
		} catch (InterruptedException i) {
			Log.i(TAG, "Don't wory about me" + i.getMessage());
		}
	}
	
	@Override
	public void recycle() {
		for (int i = 0; i < objects.length; i++) {
			objects[i].sprite.recycle();
		}
	}	
}