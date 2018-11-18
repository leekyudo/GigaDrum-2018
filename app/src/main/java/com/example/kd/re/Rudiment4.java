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


public class Rudiment4 extends Fragment{
    public Rudiment4(){}
    ListView listView4;
    MyBaseAdapter adapter;
    Button p1;


    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savadInstanceState){
        View rootView = inflater.inflate(R.layout.rudiments,container,false);


        listView4 = (ListView)rootView.findViewById(R.id.listview);
        adapter = new MyBaseAdapter(getActivity());
        listView4.setAdapter(adapter);
        Resources res = getResources();

        final String[] number = getResources().getStringArray(R.array.number);
        final String[] title = getResources().getStringArray(R.array.title);

        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeroll), number[30], title[30]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeroll), number[31], title[32]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[32], title[32]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[33], title[33]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sevenstrokeroll), number[34], title[34]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll), number[35], title[35]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_fivestrokeroll), number[36], title[36]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sixstrokeroll), number[37], title[37]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_sevenstrokeroll), number[38], title[38]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_ninestrokeroll), number[39], title[39]));


        listView4.setAdapter(adapter);
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int num4 = position+30;
                Intent intent = new Intent(getActivity(),RudimentsPlay_X.class);
                intent.putExtra("num",num4);
                startActivity(intent);

                ItemDataBox currentItem = (ItemDataBox) adapter.getItem(position);
                String[] currentData = currentItem.getData();
                Toast.makeText(getActivity(), number[position+30], Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }

}