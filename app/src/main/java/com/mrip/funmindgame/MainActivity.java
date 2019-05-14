package com.mrip.funmindgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton mindGame, luckGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mindGame =(ImageButton) findViewById(R.id.mindGame);
        luckGame = (ImageButton) findViewById(R.id.testYourLuck);

        mindGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(getApplicationContext(),MindGame.class);
             startActivity(intent);

            }
        });

        luckGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LuckGame.class);
                startActivity(intent);

            }
        });

    }
}
