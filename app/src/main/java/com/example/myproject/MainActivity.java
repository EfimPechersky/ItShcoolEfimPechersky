package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    RadioGroup levelsGroup;
    RadioButton levelBut1,levelBut2,levelBut3,levelBut4,levelBut5;
    Button startBut;
    SeekBar volumeMus;
    int volume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        levelsGroup=findViewById(R.id.levels);
        levelBut1=findViewById(R.id.level1);
        levelBut2=findViewById(R.id.level2);
        levelBut3=findViewById(R.id.level3);
        levelBut4=findViewById(R.id.level4);
        levelBut5=findViewById(R.id.level5);
        startBut=findViewById(R.id.start);
        volumeMus=findViewById(R.id.volume);
        final Intent intent=new Intent(MainActivity.this,LevelActivity.class);


        levelsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean check=false;
                switch (checkedId){
                    case R.id.level1:check=true;long levelID1=levelBut1.getId();intent.putExtra("levelID",levelID1);break;
                    case R.id.level2:check=true;long levelID2=levelBut2.getId();intent.putExtra("levelID",levelID2);break;
                    case R.id.level3:check=true;long levelID3=levelBut1.getId();intent.putExtra("levelID",levelID3);break;
                    case R.id.level4:check=true;long levelID4=levelBut1.getId();intent.putExtra("levelID",levelID4);break;
                    case R.id.level5:check=true;long levelID5=levelBut1.getId();intent.putExtra("levelID",levelID5);break;
                    default:break;
                }
                final boolean finalCheck = check;
                startBut.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           if(finalCheck){ startActivity(intent);}
                       }
                   });
            }
        });
    }


}