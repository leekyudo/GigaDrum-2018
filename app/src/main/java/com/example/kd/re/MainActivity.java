package com.example.kd.re;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button rudi_start, setting_start, game_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        rudi_start = (Button) findViewById(R.id.b1);
        rudi_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), RudimentMain.class);
                startActivity(intent1);
            }
        });

        setting_start = (Button) findViewById(R.id.b2);
        setting_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent2);
            }
        });
        game_start = (Button) findViewById(R.id.b3);
        game_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(),GameList.class);
                startActivity(intent3);
            }
        });
    }
}
