package com.example.myproject;

import android.media.MediaPlayer;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Level {
    int []tiles;
    int [] delays;
    int rawid;

    public Level(int[] tiles, int[] delays, int rawid) {
        this.tiles = tiles;
        this.delays = delays;
        this.rawid = rawid;
    }

    public void SetButton(final Button button,final Button button1,final Button button2,final Button button3, int delay) {
        Timer timer = new Timer();


    }
}
