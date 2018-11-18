package com.example.kd.re;


import android.content.Intent;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class GameMain extends AppCompatActivity {

    private  GameView gameView;
    private Handler handler = new Handler();
    private  final  static long TIMER_INTERVAL = 30;
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        }, 0, TIMER_INTERVAL);

        Intent intent = getIntent();
        int number = intent.getIntExtra("number",0);

        if(number == 0)
        {
            MediaPlayer backMusic = MediaPlayer.create(this,R.raw.reminiscence);
            backMusic.setLooping(true);
            backMusic.start();
            Intent intent1  = new Intent(getApplicationContext(),GameView.class);
            intent1.putExtra("number",0);
            startActivity(intent1);

        }
        else if(number == 1)
        {
            MediaPlayer backMusic = MediaPlayer.create(this,R.raw.reminiscence);
            backMusic.setLooping(true);
            backMusic.start();
            Intent intent1  = new Intent(getApplicationContext(),GameView.class);
            intent1.putExtra("number",1);
            startActivity(intent1);
        }
        else if(number == 2)
        {
            MediaPlayer backMusic = MediaPlayer.create(this,R.raw.reminiscence);
            backMusic.setLooping(true);
            backMusic.start();
            Intent intent1  = new Intent(getApplicationContext(),GameView.class);
            intent1.putExtra("number",2);
            startActivity(intent1);
        }
        else if(number == 3)
        {
            MediaPlayer backMusic = MediaPlayer.create(this,R.raw.reminiscence);
            backMusic.setLooping(true);
            backMusic.start();
            Intent intent1  = new Intent(getApplicationContext(),GameView.class);
            intent1.putExtra("number",3);
            startActivity(intent1);
        }
        else if(number == 4)
        {
            MediaPlayer backMusic = MediaPlayer.create(this,R.raw.reminiscence);
            backMusic.setLooping(true);
            backMusic.start();
            Intent intent1  = new Intent(getApplicationContext(),GameView.class);
            intent1.putExtra("number",4);
            startActivity(intent1);
        }
        else if(number == 5)
        {
            MediaPlayer backMusic = MediaPlayer.create(this,R.raw.reminiscence);
            backMusic.setLooping(true);
            backMusic.start();
        }
        Intent intent1  = new Intent(getApplicationContext(),GameView.class);
        intent1.putExtra("number",5);
        startActivity(intent1);
    }
}
