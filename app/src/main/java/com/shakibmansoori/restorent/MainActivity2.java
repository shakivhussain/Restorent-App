package com.shakibmansoori.restorent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void displayTeamA(int score) {
        TextView tv = (TextView) findViewById(R.id.scoreTextA);
        tv.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View view) {
        scoreTeamA += 3;
        displayTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View view) {
        scoreTeamA += 2;
        displayTeamA(scoreTeamA);
    }

    public void freeThrow(View view) {
        scoreTeamA += 1;
        displayTeamA(scoreTeamA);
    }

    public void displayTeamB(int score) {
        TextView tv = (TextView) findViewById(R.id.scoreTextB);
        tv.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View view) {
        scoreTeamB += 3;
        displayTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View view) {
        scoreTeamB += 2;
        displayTeamB(scoreTeamB);
    }

    public void freeThrowB(View view) {
        scoreTeamB += 1;
        displayTeamB(scoreTeamB);
    }

    public void resetValues(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
    }
}