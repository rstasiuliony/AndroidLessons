package com.hardfreedom.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA;
    private int scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView scoreViewA = findViewById(R.id.team_a_score);
        scoreTeamA = Integer.parseInt(scoreViewA.getText().toString());

        TextView scoreViewB = findViewById(R.id.team_b_score);
        scoreTeamB = Integer.parseInt(scoreViewB.getText().toString());
    }

    public void calculateScore(View view) {

        switch (view.getId()) {
            case R.id.three_points_a:
                scoreTeamA = scoreTeamA + 3;
                break;
            case R.id.three_points_b:
                scoreTeamB = scoreTeamB + 3;
                break;
            case R.id.two_points_a:
                scoreTeamA = scoreTeamA + 2;
                break;
            case R.id.two_points_b:
                scoreTeamB = scoreTeamB + 2;
                break;
            case R.id.one_point_a:
                scoreTeamA++;
                break;
            case R.id.one_point_b:
                scoreTeamB++;
                break;
            default:
            throw new RuntimeException("Unknown button ID");
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
