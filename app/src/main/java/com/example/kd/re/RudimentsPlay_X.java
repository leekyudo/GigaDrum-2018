package com.example.kd.re;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.io.PrintWriter;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;


import static com.example.kd.re.Setting.a;


public class RudimentsPlay_X extends AppCompatActivity {

    MediaPlayer rudi;
    private Button start;
    SeekBar seekBar;
    boolean isPlaying;
    Button right,left,duration;
    static SoundPool drum;
    int soundID;
    static int counter=0;


    public class Clickimage extends View{
        Bitmap img;

        public Clickimage(Context context) {
            super(context);
            setBackgroundColor(Color.GREEN);
            img = BitmapFactory.decodeResource(getResources(),R.drawable.bar);
            this.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        }

    protected void Mycanvas(){

        Canvas canvas = new Canvas();
        canvas.drawBitmap(img, 700 , 800 ,null);

    }
}

    class MyThread extends Thread{
    @Override
        public void run(){
        while(isPlaying){
            seekBar.setProgress(rudi.getCurrentPosition()+100);
            }
        }
    }

    class Timerthread extends Thread{

    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.rudiment_play);
        addContentView(LayoutInflater.from(this).inflate(R.layout.icon,null),new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        Intent intent = getIntent();
        int num = intent.getIntExtra("num",0);
        int sound = intent.getIntExtra("vol",1);


             Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int Width = display.getWidth();
        int Height = display.getHeight();


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                counter=counter+10;
                Log.e("카운터 테스트 %d 입니다",String.valueOf(counter));
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,1000,1000);




        //------------------------------------------------------------------------------------------L/R 타격(임시)
        right =(Button)findViewById(R.id.right);
        left = (Button)findViewById(R.id.left); seekBar = (SeekBar) findViewById(R.id.itemimage);

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : drum.play(soundID, 1, 1, 0, 0, 1);
                    break;
                }
                return false;}
        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN : drum.play(soundID, 1, 1, 0, 0, 1);
                    break;
                }

        return false; }
});

        //------------------------------------------------------------------------------ 루디먼트 MIDI 시각화
       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        //---------------------------------------------------------------------------------타격음 인자 전달 받아 변경

        if (a == 0){
            drum = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
            soundID = drum.load(getApplicationContext(), R.raw.snare, 1);}
        else if(a== 1) {
            drum = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
            soundID = drum.load(getApplicationContext(),R.raw.rim707,1);
        }
        else if(a == 2) {
            drum = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
            soundID = drum.load(getApplicationContext(),R.raw.fpcsnare1,1);
        }
        else if(a == 3) {
            drum = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
            soundID = drum.load(getApplicationContext(), R.raw.snare909, 1);
        }
        //------------------------------------------------------------------------------- 루디먼트 인자 전달 받아 이미지 표시


            if (num == 0) {
                rudi = MediaPlayer.create(this, R.raw.rudiment1);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_singlestrokeroll);
                seekBar.setBackground(drawable);
            } else if (num == 1) {
                rudi = MediaPlayer.create(this, R.raw.rudiment2);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_singlestrokefour);
                seekBar.setBackground(drawable);
            } else if (num == 2) {
                rudi = MediaPlayer.create(this, R.raw.rudiment3);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_singlestrokeseven);
                seekBar.setBackground(drawable);
            } else if (num == 3) {
                rudi = MediaPlayer.create(this, R.raw.rudiment4);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_multiplebounceroll);
                seekBar.setBackground(drawable);
            } else if (num == 4) {
                rudi = MediaPlayer.create(this, R.raw.rudiment5);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_doublestrokeroll);
                seekBar.setBackground(drawable);
            } else if (num == 5) {
                rudi = MediaPlayer.create(this, R.raw.rudiment6);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_triplestrokeroll);
                seekBar.setBackground(drawable);
            } else if (num == 6) {
                rudi = MediaPlayer.create(this, R.raw.rudiment7);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_fivestrokeroll);
                seekBar.setBackground(drawable);
            } else if (num == 7){
                rudi = MediaPlayer.create(this, R.raw.rudiment8);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_sixstrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==8){
                rudi = MediaPlayer.create(this, R.raw.rudiment9);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_sevenstrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==9) {
                rudi = MediaPlayer.create(this, R.raw.rudiment10);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num == 10) {
                rudi = MediaPlayer.create(this, R.raw.reminiscence);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==11) {
                rudi = MediaPlayer.create(this, R.raw.rudiment12);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==12) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            }  else if(num==13) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==14) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==15) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==16) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==17) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==18) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==19) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==20) {
                rudi = MediaPlayer.create(this, R.raw.reminiscence);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==21) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==22) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==23) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==24) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==25) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==26) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==27) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==28) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==29) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==30) {
                rudi = MediaPlayer.create(this, R.raw.reminiscence);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==31) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==32) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==33) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==34) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==35) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==36) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==37) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==38) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            } else if(num==39) {
                rudi = MediaPlayer.create(this, R.raw.rudiment13);
                Drawable drawable = getResources().getDrawable(R.drawable.rudi_ninestrokeroll);
                seekBar.setBackground(drawable);
            }




        start = (Button)findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rudi.start();
                seekBar.setMax(rudi.getDuration());
                new MyThread().start();
                isPlaying=true;
            }
        });
    }
}