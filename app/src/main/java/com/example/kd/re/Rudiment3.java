package com.example.kd.re;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;


public class Rudiment3 extends Fragment{
    public Rudiment3(){}
    ListView listView3;
    MyBaseAdapter adapter;
    Button p1;

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savadInstanceState){
        View rootView = inflater.inflate(R.layout.rudiments,container,false);


        listView3 = (ListView)rootView.findViewById(R.id.listview);
        adapter = new MyBaseAdapter(getActivity());
        listView3.setAdapter(adapter);
        Resources res = getResources();

        final String[] number = getResources().getStringArray(R.array.number);
        final String[] title = getResources().getStringArray(R.array.title);

        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeroll), number[19], title[19]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[20], title[20]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[21], title[21]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sevenstrokeroll), number[22], title[22]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll), number[23], title[23]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[24], title[24]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[25], title[25]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sevenstrokeroll), number[26], title[26]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll), number[27], title[27]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[28], title[28]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[29], title[29]));

        listView3.setAdapter(adapter);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int num3 = position+19;
                Intent intent = new Intent(getActivity(),RudimentsPlay_X.class);
                intent.putExtra("num",num3);
                startActivity(intent);

                ItemDataBox currentItem = (ItemDataBox) adapter.getItem(position);
                String[] currentData = currentItem.getData();
                Toast.makeText(getActivity(), number[position+19], Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }

}