package com.mrip.funmindgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckEasy extends AppCompatActivity {

    EditText getLuckyNum;
    Button matchLuckyNum,startAgain;
    TextView ranFinalNum;
    double takeLuckyNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_easy);

        getLuckyNum = (EditText) findViewById(R.id.getLuckyNum);
        matchLuckyNum = (Button) findViewById(R.id.matchLuckyNum);
        startAgain = (Button) findViewById(R.id.startAgain);
        ranFinalNum = (TextView) findViewById(R.id.ranFinalNum);

        matchLuckyNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ranFinalNum.setText("");

                if(TextUtils.isEmpty(getLuckyNum.getText())){
                    Toast.makeText(getApplicationContext(),"Please provide a number (1-10) above to check your luck today!!",Toast.LENGTH_SHORT).show();
                }else{
                    takeLuckyNum = Double.valueOf(getLuckyNum.getText().toString());

                    String compareLuckyNum = String.valueOf(takeLuckyNum);

                    String finalNumber= String.valueOf(displayRanNumber());
                    ranFinalNum.setText(ranFinalNum.getText()+finalNumber);

                    if (compareLuckyNum.equals(finalNumber)){
                        Intent intent = new Intent(getApplicationContext(),Congratulations.class);
                        startActivity(intent);
                    }
                }
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

    public final double displayRanNumber(){

        Random ran= new Random();
        double randomNumber= ran.nextInt(11);

        return randomNumber;
    }
}
