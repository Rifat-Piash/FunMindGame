package com.mrip.funmindgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MindGameThird extends AppCompatActivity {

    Button getNumber2, nextBtn2;
    TextView ranNumber2;
    public double secondRaNum;
    public boolean isNotEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_game_thrd);

        getNumber2 = (Button)findViewById(R.id.getNumber2);
        ranNumber2 = (TextView) findViewById(R.id.ranNumber2);
        nextBtn2 = (Button) findViewById(R.id.nextbt2);

        Intent intent = getIntent();
        final double firstRanNum = intent.getDoubleExtra("firstRanNum",0);

        getNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ranNumber2.setText("");
                String finalNumber= String.valueOf(displayRanNumber());
                ranNumber2.setText(ranNumber2.getText()+finalNumber);
                isNotEmpty=true;

            }
        });

        nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNotEmpty){
                    secondRaNum = Double.parseDouble(ranNumber2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), MindGameFinal.class);
                    intent.putExtra("firstRanNum",firstRanNum);
                    intent.putExtra("secondRanNum",secondRaNum);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Please press the button above and get a number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public final int displayRanNumber(){

        Random ran= new Random();
        int randomNumber= ran.nextInt(20);

        return randomNumber;
    }
}
