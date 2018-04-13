package com.altm.jeopard.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.altm.jeopard.R;
import com.altm.jeopardygame.view.fragment.GameFragment;
import com.altm.jeopardygame.view.fragment.PlayerFragment;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = GameActivity.class.getName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.gamescreen);
        loadPlayerFragment();
        loadGameFragment();
    }

    private void loadPlayerFragment()
    {
        String tag = "PlayerFragment";
        FragmentManager mFragmentManager = getSupportFragmentManager();
        PlayerFragment issFragment = (PlayerFragment) mFragmentManager.findFragmentByTag(tag);

        // If the Fragment is non-null, then it is currently being
        // retained across a configuration change.
        if (issFragment == null) {
            issFragment = new PlayerFragment();
            mFragmentManager.beginTransaction().add(R.id.playerframe, issFragment, tag).commit();
        }

        Log.d(TAG, "loadFragment() -> All Layout loaded ");
    }
    private void loadGameFragment()
    {
        String tag = "GameFragment";
        FragmentManager mFragmentManager = getSupportFragmentManager();
        GameFragment gameFragment = (GameFragment) mFragmentManager.findFragmentByTag(tag);

        // If the Fragment is non-null, then it is currently being
        // retained across a configuration change.
        if (gameFragment == null) {
            gameFragment = new GameFragment();
            mFragmentManager.beginTransaction().add(R.id.categoryframe, gameFragment, tag).commit();
        }

        Log.d(TAG, "loadFragment() -> All Layout loaded ");
    }
}
