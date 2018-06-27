package com.example.amrita.scarnesdice;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.R.drawable;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int scoreComputer=0, scorePlayer =0, turnScorePlayer = 0, turnScoreComputer=0;

    String userScoreText ="Your score is ";
    String compScoreText = "Computer score is";
    String userTurnScoreText = "Your turn score is";
    String compTurnScoreText = "Computer turn score ";

    String ScoreText=  userScoreText+scorePlayer+compScoreText+scoreComputer;
    TextView text;

    int[] drawables ={ R.drawable.dice1,
                        R.drawable.dice2,
                        R.drawable.dice3,
                        R.drawable.dice4,
                        R.drawable.dice5,
                        R.drawable.dice6};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.tv_score);
        text.setText(ScoreText);


    }

    private int rollDice(){
       Random random = new Random();
       int randomNumber = random.nextInt(6)+1;      //+1 changes the index number from 0 to 1
       return randomNumber;
    }

    public void rollButtonClick(View v){
        int number = rollDice();
        ImageView imageView = findViewById(R.id.dice_image);
        imageView.setImageResource(drawables[number-1]);

        if(number ==1){
            turnScorePlayer=0;
            computerTurn(); // define the computer's turn
        }
        else{
            turnScorePlayer+=number;
            ScoreText = userScoreText + scorePlayer + compScoreText + scoreComputer + userTurnScoreText + turnScorePlayer;

        }

    }
    public void enableButtons(boolean enable){

        Button roll_button = findViewById(R.id.roll_button);
        Button hold_button = findViewById(R.id.hold_button);
        roll_button.setEnabled(false);
        hold_button.setEnabled(false);
    }

    public void checkWinner(){
        TextView viewWinner;
        if(scorePlayer>=100){
            viewWinner= findViewById(R.id.winner);
            viewWinner.setText("1st winner won");
            resetButton();

        }
        else if(scoreComputer>=100)
        {
            viewWinner= findViewById(R.id.winner);
            viewWinner.setText("Computer won");
            resetButton();
        }

    }

    public void computerTurn(){
        enableButtons(false);

        Thread thread = new Thread() {
            int number;
            ImageView imageView;


            @Override
            public void run() {
                while(true){
                    number = rollDice();
                    imageView = findViewById(R.id.dice_image);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageResource(drawables[number-1]);
                        }
                    });
                    if(number ==1){
                        turnScoreComputer=0;
                        ScoreText = userScoreText + scorePlayer + compScoreText+ scoreComputer+ compTurnScoreText+ turnScoreComputer;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(ScoreText);
                                enableButtons(true);
                            }
                        });
                        return;
                                            }
                    else {
                        turnScoreComputer += number;
                        ScoreText = userScoreText + scorePlayer + compScoreText + scoreComputer + compTurnScoreText + turnScoreComputer;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(ScoreText);
                                enableButtons(true);
                            }
                        });

                    }
                    if(turnScoreComputer>=20) {
                        scoreComputer += turnScoreComputer;
                        turnScoreComputer = 0;

                        ScoreText = userScoreText + scorePlayer + compScoreText + scoreComputer + compTurnScoreText + turnScoreComputer;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(ScoreText);
                                enableButtons(true);
                                checkWinner();
                            }
                        });
                        return;
                    }
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }



        };
        thread.start();


    }
    public void holdButtonClick(View v){
         scorePlayer+=turnScorePlayer;
         turnScorePlayer=0;

         ScoreText= userScoreText + scorePlayer+compScoreText+scoreComputer;
         text.setText(ScoreText);

         checkWinner();
         computerTurn();
    }

    public void resetButton(){
        turnScorePlayer=0;
        turnScoreComputer=0;
        scoreComputer=0;
        scorePlayer=0;

    }
    public  void resetButtonsClick(View v){

        resetButton();
        ScoreText= userScoreText + scorePlayer+compScoreText+scoreComputer;
        text.setText(ScoreText);





    }




}
