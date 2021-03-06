package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.*;


public class MainActivity extends AppCompatActivity implements EndPointsAsyncTask.EndPointsAsyncTaskComplete {

    private static final String TAG = MainActivity.class.getSimpleName();
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        loadNewInterstitialAd();
    }

    private void loadNewInterstitialAd() {
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        showProgress();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d(TAG, "The interstitial wasn't loaded yet.");
            executeAsyncTask();
        }

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadNewInterstitialAd();
                executeAsyncTask();
            }
        });
    }

    private void executeAsyncTask() {
        new EndPointsAsyncTask(this).execute(new Pair<Context, String>(MainActivity.this, "Hey"));
    }

    public void showProgress() {
        FragmentManager fm = getSupportFragmentManager();
        MainActivityFragment fragment = (MainActivityFragment) fm.findFragmentById(R.id.fragment);
        fragment.showProgress();
    }

    public void dismissProgress() {
        FragmentManager fm = getSupportFragmentManager();
        MainActivityFragment fragment = (MainActivityFragment) fm.findFragmentById(R.id.fragment);
        fragment.dismissProgress();
    }

    @Override
    public void onAsyncCompleted() {
        dismissProgress();
    }
}
