package com.example.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKES_KEY = "JOKES_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView tvJoke = (TextView) findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle args = intent.getExtras();
            if (args != null && args.get(JOKES_KEY) != null) {
                String jokes = args.getString(JOKES_KEY);
                tvJoke.setText(jokes);
            }
        }

    }
}
