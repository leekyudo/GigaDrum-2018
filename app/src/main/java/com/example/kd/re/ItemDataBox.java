package com.example.kd.re;

import android.graphics.drawable.Drawable;

public class ItemDataBox {

    Drawable myImage;
    String[] myData;

    public ItemDataBox(Drawable myImage, String text1, String text2){
        super();
        this.myImage = myImage;
        myData=new String[2];
        myData[0]=text1;
        myData[1]=text2;
    }
    public String[] getData(){
        return myData;
    }
    public String getData(int index) {
        if (myData==null || index >= myData.length){
            return null;
        }
        return myData[index];
    }

    public Drawable getImage(){
        return myImage;
    }
}
