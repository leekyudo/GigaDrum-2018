package com.example.kd.re;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;

import java.sql.Array;
import java.util.Timer;
import java.util.TimerTask;

public class GameBeat extends View {
    public GameBeat(Context context)
    {
        super(context);

        Intent intent = new Intent();
        int number = intent.getIntExtra("number",0);
        if(number == 0)
        {

        }
        else if(number == 1)
        {

        }
        else if(number == 2)
        {
        }
        else if(number == 3)
        {

        }
        else if(number == 4)
        {

        }
    }
}
