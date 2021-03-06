package com.ballsproject.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ballsproject.game.states.GameState;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useImmersiveMode = true;
		initialize(new BallsScript(), config);
	}

	@Override
	protected void onPause() {
		GameState.isPlay = false;
		super.onPause();
	}

	@Override
	protected void onResume() {
		GameState.isPlay = true;
		super.onResume();
	}
}
