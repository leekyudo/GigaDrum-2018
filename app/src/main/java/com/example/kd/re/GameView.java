package com.example.kd.re;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    //Canvas
    private int canvasWidth;
    private int canvasHeight;

    //Drum
    private Bitmap drum[] = new Bitmap[3];
    private int leftDrumX;
    private int leftDrumY;
    private int leftDrumX_Red;
    private int leftDrumY_Red;

    private int rightDrumX;
    private int rightDrumY;

    private int rightDrumX_Blue;
    private int rightDrumY_Blue;
    //key
    Bitmap leftKey,rightKey;
    int leftKey_x,leftKey_y;
    int rightKey_x,rightKey_y;
    int button_width;

    //Blue Ball
    private int blueX;
    private int blueY;
    private int blueSpeed = 20;
    private  Paint bluePaint = new Paint();

    //Red Ball
    private  int redX;
    private  int redY;
    private  int redSpeed = 20;
    private  Paint redPaint = new Paint();

    //Background
    private  Bitmap bgImage;

    //Score
    private  Paint scorePaint = new Paint();
    private int score;

    //Rudiment
    private  Paint rudiPaint = new Paint();
    private int rudi;

    //Life
    private Bitmap life[] = new Bitmap[2];
    private int life_count;
    private Paint lifePaint = new Paint();

    //Status Check
    static boolean touch_drumRed = false;
    static boolean touch_drumBlue = false;

    public GameView(Context context){
        super(context);

        leftKey = BitmapFactory.decodeResource(getResources(),R.drawable.leftkey);

        rightKey = BitmapFactory.decodeResource(getResources(),R.drawable.rightkey);

        drum[0] = BitmapFactory.decodeResource(getResources(),R.drawable.drumset_red);
        drum[1] = BitmapFactory.decodeResource(getResources(),R.drawable.drumset_blue);
        drum[2] = BitmapFactory.decodeResource(getResources(),R.drawable.drumset);

        bgImage = BitmapFactory.decodeResource(getResources(),R.drawable.bg);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);

        redPaint.setColor(Color.RED);
        redPaint.setAntiAlias(false);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(48);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        rudiPaint.setColor(Color.DKGRAY);
        rudiPaint.setTextSize(48);
        rudiPaint.setTypeface(Typeface.DEFAULT_BOLD);
        rudiPaint.setTextAlign(Paint.Align.CENTER);
        rudiPaint.setAntiAlias(true);

        lifePaint.setColor(Color.DKGRAY);
        lifePaint.setTextSize(48);
        lifePaint.setTypeface(Typeface.DEFAULT_BOLD);
        lifePaint.setTextAlign(Paint.Align.CENTER);
        lifePaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        life[1] = BitmapFactory.decodeResource(getResources(),R.drawable.heart_g);
        //First position.
        rudi = 1;
        score = 0;
        life_count = 5;
    }

    SoundPool midi_left = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
    int music1 = midi_left.load(getContext(),R.raw.midi_left2,1);
    SoundPool midi_right = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
    int music2 = midi_right.load(getContext(),R.raw.midi_right2,1);

    @Override
    protected void onDraw(Canvas canvas) {
        canvasWidth = 2220;
        canvasHeight = 1080;

        //Drum
        leftDrumX = 20;
        leftDrumY = canvasHeight/2-150;

        rightDrumX = 20;
        rightDrumY = canvasHeight/2+70;

        leftDrumX_Red = -20;
        leftDrumY_Red = canvasHeight/2-150;

        rightDrumX_Blue = -20;
        rightDrumY_Blue = canvasHeight/2+70;

        leftKey_x = canvasWidth*2/9;
        leftKey_y = canvasHeight*7/9;

        rightKey_x = canvasWidth*6/9;
        rightKey_y = canvasHeight*7/9;

        button_width = canvasWidth/7;

        canvas.drawBitmap(bgImage,0,20,null);
        canvas.drawBitmap(leftKey,leftKey_x,leftKey_y,null);
        canvas.drawBitmap(rightKey,rightKey_x,rightKey_y,null);

        if(touch_drumRed){
            midi_left.play(music1,1,1,0,0,1);
            leftDrumX_Red = 40;
            canvas.drawBitmap(drum[0],leftDrumX_Red,leftDrumY_Red, null);
            leftDrumX_Red = 60;
            canvas.drawBitmap(drum[0],leftDrumX_Red,leftDrumY_Red, null);
            leftDrumX_Red = 80;
            canvas.drawBitmap(drum[0],leftDrumX_Red,leftDrumY_Red, null);
            leftDrumX_Red = 100;
            canvas.drawBitmap(drum[0],leftDrumX_Red,leftDrumY_Red, null);
            touch_drumRed = false;
        }
        else{
            leftDrumX_Red = -20;
            canvas.drawBitmap(drum[2],leftDrumX,leftDrumY,null);
        }

        if(touch_drumBlue){
            midi_right.play(music2,1,1,0,0,1);
            rightDrumX_Blue = 40;
            canvas.drawBitmap(drum[1],rightDrumX_Blue,rightDrumY_Blue, null);
            rightDrumX_Blue = 60;
            canvas.drawBitmap(drum[1],rightDrumX_Blue,rightDrumY_Blue, null);
            rightDrumX_Blue = 80;
            canvas.drawBitmap(drum[1],rightDrumX_Blue,rightDrumY_Blue, null);
            rightDrumX_Blue = 100;
            canvas.drawBitmap(drum[1],rightDrumX_Blue,rightDrumY_Blue, null);
            touch_drumBlue = false;
        }
        else{
            rightDrumX_Blue = -20;
            canvas.drawBitmap(drum[2],rightDrumX,rightDrumY,null);
        }


        //Red ball
        redX -= redSpeed;
        if(leftHitCheck(redX,redY)){
            life_count--;
            redX = - 100;
        }
        if(redHitCheck(redX,redY)){
            score = score + 10;
            life_count++;
            redX = - 100;
        }
        if(redX <0){
            redX = canvasWidth + 200;
            redY = canvasHeight/2-90;
        }
        canvas.drawCircle(redX,redY,80,redPaint);

        //Blue ball

        blueX -= blueSpeed;
        if(rightHitCheck(blueX,blueY)){
            life_count--;
            blueX = -100;
        }
        if(blueHitCheck(blueX,blueY)){
            score = score + 10;
            life_count++;
            blueX = -100;
        }
        if(blueX <0){
            blueX = canvasWidth + 200;
            blueY = canvasHeight/2+140;
        }
        canvas.drawCircle(blueX,blueY,80,bluePaint);



        //Score
        canvas.drawText("Score : "+ score,500,100,scorePaint);

        //Rudiment
        canvas.drawText("Rudiment : "+ rudi,200,100,rudiPaint);

        //Life
        if(life_count>5)
        {
            life_count = 5;
        }
        else if(life_count< 0)
        {
            life_count = 0;
        }
        canvas.drawText("Life: ",900,100,lifePaint);
        for(int i = 0; i < 5; i++){
            int x = (int)(1000 + life[0].getWidth()*1.5*i);
            int y = 50;

            if(i<life_count){
                canvas.drawBitmap(life[0],x,y,null);
            }else{
                canvas.drawBitmap(life[1],x,y,null);
            }
        }
    }

    public boolean leftHitCheck(int x, int y){
        if(leftDrumX< x && x <(leftDrumX+drum[2].getWidth())&&
                leftDrumY < y && y < (leftDrumY+drum[2].getHeight())){
            return true;
        }
        return false;
    }

    public boolean redHitCheck(int x, int y){
        if(leftDrumX_Red< x && x <(leftDrumX_Red+drum[0].getWidth())&&
                leftDrumY_Red < y && y < (leftDrumY_Red+drum[0].getHeight())){
            return true;
        }
        return false;
    }
    public boolean rightHitCheck(int x, int y){
        if(rightDrumX < x && x <(rightDrumX+drum[2].getWidth())&&
                rightDrumY < y && y < (rightDrumY+drum[2].getHeight())){
            return true;
        }
        return false;
    }
    public boolean blueHitCheck(int x, int y){
        if(rightDrumX_Blue < x && x <(rightDrumX_Blue+drum[1].getWidth())&&
                rightDrumY_Blue < y && y < (rightDrumY_Blue+drum[1].getHeight())){
            return true;
        }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x=0, y=0;
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x = (int) event.getX();
            y = (int) event.getY();
        }
        if((x>leftKey_x) && (x<leftKey_x+button_width) && (y>leftKey_y)&&(y<leftKey_y+button_width))
        {
            touch_drumRed = true;
        }
        if((x>rightKey_x) && (x<rightKey_x+button_width) && (y>rightKey_y)&&(y<rightKey_y+button_width))
        {
            touch_drumBlue = true;
        }
        return true;
    }
}
