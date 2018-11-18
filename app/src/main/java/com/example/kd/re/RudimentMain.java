package com.example.kd.re;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RudimentMain extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.rudiment_main);



        Button home = (Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

        if (findViewById(R.id.fragment_container) != null) {

            if (saveInstanceState != null) {
                return;
            }
            Rudiment1 firstFragment= new Rudiment1();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();
        }
    }
    public void selectFragment(View view){
        Fragment fr=null;
        switch (view.getId()){
            case R.id.roll: fr = new Rudiment1();
            break;

            case R.id.paradiddle: fr = new Rudiment2();
            break;

            case R.id.flam_based: fr = new Rudiment3();
            break;

            case R.id.drag_based: fr = new Rudiment4();
            break;
        }

        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container,fr);
        fragmentTransaction.commit();

    }

}
