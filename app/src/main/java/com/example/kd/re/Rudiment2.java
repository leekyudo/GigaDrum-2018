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


public class Rudiment2 extends Fragment{
    public Rudiment2(){}
    ListView listView2;
    MyBaseAdapter adapter;
    Button p1;


    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savadInstanceState){
        View rootView = inflater.inflate(R.layout.rudiments,container,false);


        listView2 = (ListView)rootView.findViewById(R.id.listview);
        adapter = new MyBaseAdapter(getActivity());
        listView2.setAdapter(adapter);
        Resources res = getResources();

        final String[] number = getResources().getStringArray(R.array.number);
        final String[] title = getResources().getStringArray(R.array.title);


        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokefour), number[15], title[15]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeseven), number[16], title[16]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_multiplebounceroll), number[17], title[17]));
        adapter.addItem(new ItemDataBox(res.getDrawable(R.drawable.rudi_singlestrokeroll), number[18], title[18]));

        listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int num2 =position+14;
                Intent intent = new Intent(getActivity(),RudimentsPlay_X.class);
                intent.putExtra("num",num2);
                startActivity(intent);

                ItemDataBox currentItem = (ItemDataBox) adapter.getItem(position);
                String[] currentData = currentItem.getData();
                Toast.makeText(getActivity(), number[position+14], Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }

}
