package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class LevelActivity extends AppCompatActivity {
    ImageView lifesView;
    Button back;
    ImageButton startbutton,tile1,tile2,tile3,tile4,tile5,tile6;
    boolean startGame=false;
    int[] tiles={1,2,3,4,5,6,1,2,3,4,5,6};
    long[]delays={2000,3000,1000,3000,2000,1000,3000,1500,1200,1500,1400,3000};
    long alltime=0;
    int lifes=3;
    int counterdelays=0;
    boolean onButton=false;
    SoundPool mSoundPool1,mSoundPool2,mSoundPool3,mSoundPool4,mSoundPool5,mSoundPool6,soundPool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        for (int i = 0; i <delays.length-1 ; i++) {
            alltime+=delays[i];
        }


        final MyDownCounter myDownCounter=new MyDownCounter(alltime,100);
        mSoundPool1=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool2=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool3=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool4=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool5=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        mSoundPool6=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        soundPool=new SoundPool(6, AudioManager.STREAM_MUSIC,100);
        soundPool.load(LevelActivity.this,R.raw.error,0);
        tile1=findViewById(R.id.tiles1);
        tile2=findViewById(R.id.tiles2);
        tile3=findViewById(R.id.tiles3);
        tile4=findViewById(R.id.tiles4);
        tile5=findViewById(R.id.tiles5);
        tile6=findViewById(R.id.tiles6);
        lifesView=findViewById(R.id.lifes);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        startbutton=findViewById(R.id.test);
        back=findViewById(R.id.back);
        mSoundPool1.load(LevelActivity.this,R.raw.bassgitarafankzvonkaya,1);
        mSoundPool2.load(LevelActivity.this,R.raw.gitaraodinochnyiyzvonkiysredniy,1);
        mSoundPool3.load(LevelActivity.this,R.raw.gitaraodinochnyiychetkiy,1);
        mSoundPool4.load(LevelActivity.this,R.raw.gitarabassodinochnyiy,1);
        mSoundPool5.load(LevelActivity.this,R.raw.malyiybarabanodinochnyiyvprostranstveklassicheskiy,1);
        mSoundPool6.load(LevelActivity.this,R.raw.malyiybarabanodinochnyiyrimchetkiy,1);


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
                startGame=true;
                switch (tiles[0]){
                    case(1):startbutton.setImageResource(R.drawable.guitar1);break;
                    case(2):startbutton.setImageResource(R.drawable.guitar2);break;
                    case(3):startbutton.setImageResource(R.drawable.guitar3);break;
                    case(4):startbutton.setImageResource(R.drawable.guitar4);break;
                    case(5):startbutton.setImageResource(R.drawable.baraban1);break;
                    case(6):startbutton.setImageResource(R.drawable.baraban2);break;
                }
                myDownCounter.start();
            }
        });
    }
    public void MusicClick(View view){
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float leftVolume = curVolume / maxVolume;
        float rightVolume = curVolume / maxVolume;
        int priority = 1;
        int no_loop = 0;
        float normal_playback_rate = 1f;
        switch(view.getId()){
            case(R.id.tiles1):
                mSoundPool1.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                if (tiles[counterdelays]==1) {
                    onButton = true;
                }else if(tiles[counterdelays]!=1 && startGame){
                    soundPool.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                }
                break;
            case(R.id.tiles2):
                mSoundPool2.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                if (tiles[counterdelays]==2){
                    onButton=true;
                }else if(tiles[counterdelays]!=2 && startGame){
                    soundPool.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                }
                break;
            case(R.id.tiles3):
                mSoundPool3.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                if (tiles[counterdelays]==3){
                    onButton=true;
                }else if(tiles[counterdelays]!=3 && startGame){
                    soundPool.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                }
                break;
            case(R.id.tiles4):
                mSoundPool4.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                if (tiles[counterdelays]==4){
                    onButton=true;
                }else if(tiles[counterdelays]!=4 && startGame){
                    soundPool.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                }
                break;
            case(R.id.tiles5):
                mSoundPool5.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                if (tiles[counterdelays]==5){
                    onButton=true;
                }else if(tiles[counterdelays]!=5 && startGame){
                    soundPool.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                }
                break;
            case(R.id.tiles6):
                mSoundPool6.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                if (tiles[counterdelays]==6){
                    onButton=true;
                }else if(tiles[counterdelays]!=6 && startGame){
                    soundPool.play(1,leftVolume,rightVolume,priority,no_loop,normal_playback_rate);
                }
                break;
        }
    }
    class MyDownCounter extends CountDownTimer{
        long timerTime;
        int counter=0;
        boolean loseGame=false;


        public MyDownCounter(long millisInFuture, long countDownInterval ) {
            super(millisInFuture, countDownInterval);
            timerTime=countDownInterval;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            switch (lifes){
                case(0):lifesView.setImageResource(R.drawable.life0);loseGame=true;break;
                case(1):lifesView.setImageResource(R.drawable.life1);break;
                case(2):lifesView.setImageResource(R.drawable.lifes2);break;
                case(3):lifesView.setImageResource(R.drawable.lifes3);break;
            }
            if (loseGame){
                onFinish();
            }
            counter+=1;
            if((counter==(delays[counterdelays]/timerTime)) || onButton==true){
                switch (tiles[counterdelays+1]){
                    case(1):startbutton.setImageResource(R.drawable.guitar1);break;
                    case(2):startbutton.setImageResource(R.drawable.guitar2);break;
                    case(3):startbutton.setImageResource(R.drawable.guitar3);break;
                    case(4):startbutton.setImageResource(R.drawable.guitar4);break;
                    case(5):startbutton.setImageResource(R.drawable.baraban1);break;
                    case(6):startbutton.setImageResource(R.drawable.baraban2);break;
                }
                if (!onButton){
                    lifes-=1;
                }
                if(counterdelays+1<tiles.length-1){
                    counterdelays+=1;
                    counter=0;
                    onButton=false;
                }else{
                    onFinish();
                }
            }

        }

        @Override
        public void onFinish() {
            if(loseGame){
                startbutton.setImageResource(R.drawable.lose);
            }
            else{
                startbutton.setImageResource(R.drawable.win);
            }
        }
    }

}