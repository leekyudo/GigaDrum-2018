package com.example.kd.re;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemView extends LinearLayout{

    ImageView myImage;
    TextView mytext1;
    TextView mytext2;



    public ItemView(Context context,ItemDataBox aItem) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listlayout_rudi,this,true);

        myImage = (ImageView)findViewById(R.id.itemimage);
        myImage.setImageDrawable(aItem.getImage());

        mytext1 = (TextView)findViewById(R.id.number);
        mytext1.setText(aItem.getData(0));

        mytext2 = (TextView)findViewById(R.id.title);
        mytext2.setText(aItem.getData(1));


    }
    public void setText(int index, String data){
        if (index==0){
            mytext1.setText(data);
        }
        else if(index==1){
            mytext2.setText(data);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public void setIcon(Drawable icon){
        myImage.setImageDrawable(icon);
    }
}
