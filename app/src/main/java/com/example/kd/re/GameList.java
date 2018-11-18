package com.example.kd.re;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class GameList extends AppCompatActivity {

    public void startAudio(View v){
        int count = 0;
        MediaPlayer mp = MediaPlayer.create(this,R.raw.yourself);

        switch(count){
            case 0: mp = MediaPlayer.create(this,R.raw.yourself);
                mp.start();
                count++;
                break;
            case 1: mp.stop();
                mp.release();
                mp = MediaPlayer.create(this,R.raw.yourself);
                mp.start();
                count++;
                break;
            case 2: mp.stop();
                mp.release();
                mp = MediaPlayer.create(this,R.raw.yourself);
                mp.start();
                count++;
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout_game);
        ListView listView = (ListView) findViewById(R.id.MusicList);
        SingerAdapter adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("Rudiment 1","Easy",R.drawable.rudi_cd));
        adapter.addItem(new SingerItem("Rudiment 2","Easy",R.drawable.rudi_cd));
        adapter.addItem(new SingerItem("Rudiment 3","Easy",R.drawable.rudi_cd));
        adapter.addItem(new SingerItem("Rudiment 4","Easy",R.drawable.rudi_cd));
        adapter.addItem(new SingerItem("Rudiment 5","Easy",R.drawable.rudi_cd));
        adapter.addItem(new SingerItem("너 너 해 - 마마무","Normal",R.drawable.yourself_cd));


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(),GameMain.class);
                startActivity(intent);
                Intent intent2  = new Intent(getApplicationContext(),GameMain.class);
                intent2.putExtra("number",position);
                startActivity(intent2);
            }
        });
    }

    class SingerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }
}
