package com.example.kd.re;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.example.kd.re.Usernote;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.datatype.Duration;

public class Rudi_view extends View {

    private int canvasWidth;
    private int canvasHeight;
    //---- 루디 이미지

    Bitmap RudimentImage;
    private int RudiImgX,RudiImgY;

    //---- 진행바 이미지, 위치
    private int rudi_imgX;
    private int rudi_imgY;

    //---- 버튼 이미지, 위치
    Bitmap leftkey, rightkey;
    int button_width;
    int leftkeyX, leftkeyY;
    int rightkeyX, rightkeyY;

    //---- 음표
    private Paint note = new Paint();

    //-----바
    Bitmap bar;
    private int barX, barY;
    private int barspeed = 20;

    int counter;
    int second;
    static boolean touchtime = true;

    // --- 버튼 터치 플래그
    static boolean touchLeft=false;
    static boolean touchRgiht=false;

    // --- 노트 배열
    ArrayList<Usernote> usernote;

    // --- midi
    MediaPlayer rudi;


    public Rudi_view(Context context) {
        super(context);

        usernote = new ArrayList<Usernote>();

        canvasWidth =  2220;
        canvasHeight = 1080;

        rightkeyX = canvasWidth * 6 / 10;
        rightkeyY = canvasHeight * 3 / 4;

        leftkeyX = canvasWidth * 3 / 10;
        leftkeyY = canvasHeight * 3 / 4;

        RudiImgX = canvasWidth  / 10;
        RudiImgY = canvasHeight/ 10;

        button_width = canvasWidth / 8;

        barX = canvasWidth / 10;
        barY = canvasHeight/ 10;


        leftkey = BitmapFactory.decodeResource(getResources(), R.drawable.wood);
        rightkey = BitmapFactory.decodeResource(getResources(), R.drawable.wood);

        note.setAntiAlias(false);
        note.setColor(Color.BLACK);

        bar = BitmapFactory.decodeResource(getResources(), R.drawable.bar);

        int u = Rudiment1.num;
        if (u == 0) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment1);

            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_singlestrokefour);

        } else if (u == 1) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment2);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if (u == 2) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment3);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if (u == 3) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment4);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if (u == 4) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment5);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if (u == 5) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment6);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if (u == 6) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment7);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if (u == 7){
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment8);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==8){
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment9);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==9) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment10);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u == 10) {
            rudi = MediaPlayer.create(getContext(), R.raw.reminiscence);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==11) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment12);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==12) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        }  else if(u==13) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==14) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==15) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==16) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==17) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==18) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==19) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==20) {
            rudi = MediaPlayer.create(getContext(), R.raw.reminiscence);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==21) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==22) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==23) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==24) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==25) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==26) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==27) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==28) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==29) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==30) {
            rudi = MediaPlayer.create(getContext(), R.raw.reminiscence);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==31) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==32) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==33) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==34) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==35) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==36) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==37) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==38) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        } else if(u==39) {
            rudi = MediaPlayer.create(getContext(), R.raw.rudiment13);
            RudimentImage = BitmapFactory.decodeResource(getResources(),R.drawable.rudi_ninestrokeroll);

        }


        // -- (미완성)        기기에 따른 화면 크기 변경 요망
        canvasWidth =  2220;
        canvasHeight = 1080;

        rightkeyX = canvasWidth * 6 / 10;
        rightkeyY = canvasHeight * 3 / 4;

        leftkeyX = canvasWidth * 3 / 10;
        leftkeyY = canvasHeight * 3 / 4;

        RudiImgX = canvasWidth  / 10;
        RudiImgY = canvasHeight/ 10;

        button_width = canvasWidth / 8;

        barX = canvasWidth / 10;
        barY = canvasHeight/ 10;


        // ---- 카운터

        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(touchtime == true){
                    if(counter<=2000)
                    {counter += 10;
                        second ++;}
                    else
                    {touchtime =false;}
                }
                if(touchtime == false){
                    counter=0;
                }

            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,0,100);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(RudimentImage,rudi_imgX,rudi_imgY,null);

        canvas.drawBitmap(leftkey, leftkeyX, leftkeyY, null);
        canvas.drawBitmap(rightkey, rightkeyX, rightkeyY, null);

        canvas.drawBitmap(bar, barX, barY, null);

        canvas.drawLine(0,300,canvasWidth,300,note);
        // --- 루디먼트 Seekbar
        barX+=barspeed;
        if(barX>canvasWidth*9/10)
            barX = canvasWidth /10;
        if(touchRgiht&&touchtime){
            usernote.add(new Usernote(counter,280));
            touchRgiht=false;
        }
        if(touchLeft&&touchtime){
            usernote.add(new Usernote(counter,320));

        touchLeft=false;
    }
        for(Usernote tmp : usernote){
            canvas.drawCircle(tmp.x,tmp.y,24,note);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = 0, y = 0;
        if (event.getAction() == MotionEvent.ACTION_DOWN||event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
            x = (int) event.getX();
            y = (int) event.getY();
        }

        if((x>leftkeyX)&&(x<leftkeyX+button_width)&&(y>leftkeyY)&&(y<leftkeyY+button_width))
            touchLeft = true;

        if((x>rightkeyX)&&(x<rightkeyX+button_width)&&(y>rightkeyY)&&(y<rightkeyY+button_width))
            touchRgiht = true;
        return true;
    }
}

