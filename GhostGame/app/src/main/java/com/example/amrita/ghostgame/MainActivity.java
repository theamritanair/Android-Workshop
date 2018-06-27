package com.example.amrita.ghostgame;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private TextView ghostView, gameStatus;
    private Button resetButton, challengeButton;
    private boolean turn;
    private SimpleDictionary simpleDictionary;
    private static final String COMPUTER_TURN = "Computer's turn";
    private String USERS_TURN= "User's turn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ghostView = findViewById(R.id.tv_ghostview);
        gameStatus = findViewById(R.id.game_status);

        resetButton = findViewById(R.id.reset_button);
        challengeButton = findViewById(R.id.challenge_button);
        AssetManager assetManager = getAssets();
        try {
            simpleDictionary = new SimpleDictionary(assetManager.open("words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        reset();
        challenge();
        begin();




    }

    private void begin() {
        new Random().nextBoolean();
        if (turn) {
            turn = false;
            gameStatus.setText("Your turn!");
        } else {
            gameStatus.setText("Computer's turn");
            computerTurn();
        }

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (turn){
            //User's turn
            turn = false;
            char userInput = (char) event.getUnicodeChar();
            if (Character.isLetter(userInput)) {
                ghostView.append(Character.toString(userInput));
                computerTurn();
            }
            else {
                //You cannot type :(
            }


        }
        return super.onKeyUp(keyCode, event);
    }

    private void computerTurn() {
        //computer's turn
    Log.v("Turn", COMPUTER_TURN);
    gameStatus.setText(COMPUTER_TURN);
   new Handler().postDelayed(() ->{
        String ghostWord = ghostView.
                getText().toString();
        if(ghostWord.length()>=4 && simpleDictionary.isAGoodWord(ghostWord)){
            gameStatus.setText("Computer Wins");
            challengeButton.setEnabled(false);
        }
        else{
            String computerWord = simpleDictionary.isAValidWord(ghostWord);
            if(computerWord==null){
                gameStatus.setText("Computer Wins");
                challengeButton.setEnabled(false);
            }
            else{
                ghostView.append(computerWord.charAt(ghostWord.length())+"");
                turn = true;
                gameStatus.setText(USERS_TURN);
            }
        }
   }, 2000);
    }

    public void reset() {
        resetButton.setOnClickListener((view) -> {
            Log.v("reset", "reset button pressed");
        });
    }

    public void challenge() {

        challengeButton.setOnClickListener((view) -> {
            Log.v("challenge", "challenge button pressed");
        });
    }


}

