package com.example.kd.re;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Rudi_play extends AppCompatActivity {
    private Rudi_view rudi_view;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        rudi_view = new Rudi_view(this);
        setContentView(rudi_view);

        Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        rudi_view.invalidate();
                    }
                });
            }
        }, 0, 16); // 60프레임 - 1초에 60번 갱신
    }
}
