package com.ecorpin.ecorpin_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView header;

    Animation headerAnimation;

    Button intern;

    ImageButton timelineBtn;
    ImageButton serviceBtn;
    ImageButton workflowBtn;
    ImageButton taskBtn;
    ImageButton ecorpinlabBtn;
    ImageButton exploreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button alpha animation effect
        final Animation button_effect_anim = AnimationUtils.loadAnimation(this, R.anim.button_effect);

        header = (TextView) findViewById(R.id.appName);

        headerAnimation = AnimationUtils.loadAnimation(this, R.anim.up_to_down_anim);
        header.setAnimation(headerAnimation);

        timelineBtn = (ImageButton) findViewById(R.id.timelineBtn);
        timelineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_effect_anim);
            }
        });
        serviceBtn = (ImageButton) findViewById(R.id.servicesBtn);
        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_effect_anim);
            }
        });
        workflowBtn = (ImageButton) findViewById(R.id.workflowBtn);
        workflowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_effect_anim);
            }
        });
        taskBtn = (ImageButton) findViewById(R.id.taskBtn);
        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_effect_anim);
            }
        });
        ecorpinlabBtn = (ImageButton) findViewById(R.id.ecorpinlabBtn);
        ecorpinlabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_effect_anim);
                Intent intent = new Intent(getApplicationContext(), EcorpinLabActivity.class);
                startActivity(intent);
            }
        });
        exploreBtn = (ImageButton) findViewById(R.id.exploreBtn);
        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(button_effect_anim);
                Intent webViewIntent = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(webViewIntent);
            }
        });
        intern = (Button) findViewById(R.id.internBtn);
        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(button_effect_anim);
                Intent intent = new Intent(getApplicationContext(), Ecorpin_Intern.class);
                startActivity(intent);
            }
        });
    }


}
