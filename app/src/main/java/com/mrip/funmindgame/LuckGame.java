package com.mrip.funmindgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LuckGame extends AppCompatActivity {

    Button easy, medium, hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_game);

        easy = (Button) findViewById(R.id.easy);
        medium = (Button) findViewById(R.id.medium);
        hard = (Button) findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LuckEasy.class);
                startActivity(intent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LuckMedium.class);
                startActivity(intent);
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LuckHard.class);
                startActivity(intent);

            }
        });
    }
}
