package com.example.ricebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView bgApp, bug;
    LinearLayout textlay, homeText, menus, predict, info;
    Animation fromBottom;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgApp = findViewById(R.id.bimage);
        bug = findViewById(R.id.bugImg);
        textlay = findViewById(R.id.splachText);
        homeText = findViewById(R.id.homeText);
        menus = findViewById(R.id.menus);
        predict = findViewById(R.id.predict);
        info = findViewById(R.id.info);

        bgApp.animate().translationY(-1250).setDuration(800).setStartDelay(300);
        bug.animate().alpha(0).setDuration(800).setStartDelay(600);
        textlay.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(800);
        homeText.startAnimation(fromBottom);
        menus.startAnimation(fromBottom);

        predict.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RicePlantPredictionActivity.class);
            startActivity(intent);
        });

        info.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RiceInfoActivity.class);
            startActivity(intent);
        });
    }
}