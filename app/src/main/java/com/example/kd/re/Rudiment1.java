package com.example.kd.re;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Rudiment1 extends Fragment{
    public Rudiment1(){}
    ListView listView;
    MyBaseAdapter adapter;
    TextView roll;
    static int num;

@Override
public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savadInstanceState){
    View rootView = inflater.inflate(R.layout.rudiments,container,false);

        listView = (ListView)rootView.findViewById(R.id.listview);
        adapter = new MyBaseAdapter(getActivity());
        listView.setAdapter(adapter);
        Resources res = getResources();



        final String[] number = getResources().getStringArray(R.array.number);
        final String[] title = getResources().getStringArray(R.array.title);

        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeroll), number[0], title[0]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokefour), number[1], title[1]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeseven), number[2], title[2]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_multiplebounceroll), number[3], title[3]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_doublestrokeroll), number[4], title[4]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_triplestrokeroll), number[5], title[5]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[6], title[6]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[7], title[7]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sevenstrokeroll), number[8], title[8]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll), number[9], title[9]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[10], title[10]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[11], title[11]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sevenstrokeroll), number[12], title[12]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll), number[13], title[13]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll),number[14],title[14]));



        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),Rudi_play.class);
                startActivity(intent);

                 num=position;

                ItemDataBox currentItem = (ItemDataBox) adapter.getItem(position);
                String[] currentData = currentItem.getData();
                Toast.makeText(getActivity(), number[position], Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }

}




            /*
            @Override
            public boolean onCreateOptionMenu(Menu menu) {
                getMenuInflater().inflate(R.menu_main, menu);
                return true;
            }

            @Override
            public boolean onOptionItemSelected(MenuItem item) {
                int id = item.getItemId();
                id(id == R.id.action_settings);
                {
                    return true;
                }
                return super.onOptionsItemSelected(item);

           } */

