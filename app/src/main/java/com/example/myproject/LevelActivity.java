package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class LevelActivity extends AppCompatActivity {
    Button back,tile1,tile2,tile3,tile4,tile5,tile6,startbutton;
    int[]tiles={1,2,2,4,6,4,1,3,6,4,5,3};
    int[]delays={3000,1000,4000,3000,2000,1200,3456,6000,2000,2500,1000,1000};
    Level level=new Level(tiles,delays,R.raw.jojo);
    Thread thread=new Thread();
    Timer timer = new Timer();
    SoundPool mSoundPool1,mSoundPool2,mSoundPool3,mSoundPool4,mSoundPool5,mSoundPool6;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        mSoundPool1=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool2=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool3=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool4=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool5=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool6=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        tile1=findViewById(R.id.tile1);
        tile2=findViewById(R.id.tile2);
        tile3=findViewById(R.id.tile3);
        tile4=findViewById(R.id.tile4);
        tile5=findViewById(R.id.tile5);
        tile6=findViewById(R.id.tile6);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        startbutton=findViewById(R.id.test);
        back=findViewById(R.id.back);
        tile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundPool1.load(LevelActivity.this,R.raw.bassgitarafankzvonkaya,1);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume / maxVolume;
                float rightVolume = curVolume / maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                mSoundPool1.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
            }
        });
        tile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundPool2.load(LevelActivity.this,R.raw.gitarabassodinochnyiy,1);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume / maxVolume;
                float rightVolume = curVolume / maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                mSoundPool2.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
            }
        });
        tile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundPool3.load(LevelActivity.this,R.raw.gitaraodinochnyiychetkiy,1);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume / maxVolume;
                float rightVolume = curVolume / maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                mSoundPool3.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
            }
        });
        tile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundPool4.load(LevelActivity.this,R.raw.gitaraodinochnyiyzvonkiysredniy,1);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume / maxVolume;
                float rightVolume = curVolume / maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                mSoundPool4.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
            }
        });
        tile5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundPool5.load(LevelActivity.this,R.raw.malyiybarabanodinochnyiyrimchetkiy,1);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume / maxVolume;
                float rightVolume = curVolume / maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                mSoundPool5.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
            }
        });
        tile6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoundPool6.load(LevelActivity.this,R.raw.malyiybarabanodinochnyiyvprostranstveklassicheskiy,1);
                AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float leftVolume = curVolume / maxVolume;
                float rightVolume = curVolume / maxVolume;
                int priority = 1;
                int no_loop = 0;
                float normal_playback_rate = 1f;
                mSoundPool6.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
            }
        });
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        Long levelID=bundle.getLong("levelID");
        final Intent intent=new Intent(LevelActivity.this,MainActivity.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                startbutton.setText("");
                class MyTimerTask1 extends TimerTask {
                    @Override
                    public void run() {
                        startbutton.setText(String.valueOf(level.tiles[counter]));
                        counter+=1;

                    }
                }
                MyTimerTask1 myTimerTask1=new MyTimerTask1();
                timer.schedule(myTimerTask1,1,2000);


            }
        });
    }

}