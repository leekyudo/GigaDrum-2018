package com.example.kd.re;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import static com.example.kd.re.RudimentsPlay_X.drum;

public class Setting extends Activity {

    Button back;
    SoundPool sp;
    private SeekBar volumeSeekBar;
    private AudioManager audioManager;
    static int a;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.setting_activity);

        back = (Button)findViewById(R.id.b);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setVolumeControlStream(R.raw.snare);
        initControls();

        drum = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        final int sound1 = drum.load(this,R.raw.snare,1);
        final int sound2 = drum.load(this,R.raw.rim707,1);
        final int sound3 = drum.load(this,R.raw.fpcsnare1,1);
        final int sound4 = drum.load(this,R.raw.snare909,1);


        Button drum1 = (Button)findViewById(R.id.drum1);
        Button drum2 = (Button)findViewById(R.id.drum2);
        Button drum3 = (Button)findViewById(R.id.drum3);
        Button drum4 = (Button)findViewById(R.id.drum4);

        drum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drum.play(sound1,1,1,1,0,0);
                a=0;
            }
        });
        drum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drum.play(sound2,1,1,1,0,0);
                a=1;
            }
        });
        drum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drum.play(sound3,1,1,1,0,0);

                a=2;
            }
        });
        drum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drum.play(sound4,1,1,1,0,0);
                a=3;
            }
        });
    }

    private void initControls() {


        try {
            volumeSeekBar = (SeekBar) findViewById(R.id.seekbar_vol);
            audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
            volumeSeekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        } catch (Exception e) {}

    }

}

