package com.example.kd.re;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;


import com.bumptech.glide.Glide;


public class Loading extends Activity{
 @Override
    protected void onCreate(Bundle saveInstanceState){
     super.onCreate(saveInstanceState);
     setContentView(R.layout.loading);
     startLoading();
 }

private void startLoading(){
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent2);
            finish();
        }
    },2000);

}


}
