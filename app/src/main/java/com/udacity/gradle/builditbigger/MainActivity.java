package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.EndPointsAsyncTask.EndPointsAsyncTaskComplete;


public class MainActivity extends AppCompatActivity implements EndPointsAsyncTaskComplete {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        new EndPointsAsyncTask(this).execute(new Pair<Context, String>(this, "Hey"));
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
