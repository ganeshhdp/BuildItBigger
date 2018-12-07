package com.example.displayjokelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    String joke;
    TextView displayJokeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_display);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        joke = intent.getExtras().getString("JOKE");
        displayJokeText = (TextView) findViewById(R.id.showText);
        displayJokeText.setText(joke);
    }

}
