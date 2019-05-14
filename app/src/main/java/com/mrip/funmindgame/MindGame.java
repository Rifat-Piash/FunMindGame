package com.mrip.funmindgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.lang.String;

public class MindGame extends AppCompatActivity {

   TextView ranNumber;
   Button getNumber, nextBtn1;
   public double firstRaNum;
   public boolean isNotEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_game);

        ranNumber = (TextView)findViewById(R.id.ranNumber);
        getNumber = (Button)findViewById(R.id.getNumber);
        nextBtn1 = (Button) findViewById(R.id.nextbt1);

        getNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ranNumber.setText("");
                String finalNumber= String.valueOf(displayRanNumber());
                ranNumber.setText(ranNumber.getText()+finalNumber);
                isNotEmpty=true;
            }
        });

        nextBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNotEmpty){
                    Intent intent = new Intent(getApplicationContext(), MindGameThird.class);
                    firstRaNum = Double.parseDouble(ranNumber.getText().toString());
                    intent.putExtra("firstRanNum",firstRaNum);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Please press the button above and get a number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public final int displayRanNumber(){

        Random ran= new Random();
        int randomNumber= ran.nextInt(30);

        return randomNumber;
    }
}
