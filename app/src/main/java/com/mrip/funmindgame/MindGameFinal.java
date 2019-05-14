package com.mrip.funmindgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MindGameFinal extends AppCompatActivity {

    Button getFinalNum, startAgain;
    TextView ranFinalNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_game_final);

        getFinalNum = (Button) findViewById(R.id.getFinalNum);
        startAgain = (Button) findViewById(R.id.startAgain);
        ranFinalNum = (TextView) findViewById(R.id.ranFinalNum);

        Intent intent= getIntent();
        final double firstRanNum = intent.getDoubleExtra("firstRanNum",0);
        final double secondRanNum = intent.getDoubleExtra("secondRanNum",0);

        getFinalNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            double magicalNumber = ((firstRanNum/2)+secondRanNum);

                String finalMagicalNum = String.valueOf(magicalNumber);
                ranFinalNum.setText(finalMagicalNum);
            }
        });

        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
