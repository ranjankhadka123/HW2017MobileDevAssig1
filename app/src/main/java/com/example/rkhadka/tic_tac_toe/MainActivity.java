package com.example.rkhadka.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.rkhadka.tic_tac_toe.TicTacToeLogic.TTTElement.EMPTY;

public class MainActivity extends AppCompatActivity {

    TicTacToeLogic.TTTElement[] gameState =
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};

    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9, mButton_new_game;
    private Button[] mButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.value_A_button);
        mButton2 = (Button) findViewById(R.id.value_B_button);
        mButton3 = (Button) findViewById(R.id.value_C_button);
        mButton4 = (Button) findViewById(R.id.value_D_button);
        mButton5 = (Button) findViewById(R.id.value_E_button);
        mButton6 = (Button) findViewById(R.id.value_F_button);
        mButton7 = (Button) findViewById(R.id.value_G_button);
        mButton8 = (Button) findViewById(R.id.value_H_button);
        mButton9 = (Button) findViewById(R.id.value_I_button);
        mButton_new_game = (Button) findViewById(R.id.next_game_button);

        mButtons = new Button[]{mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9};

        for (int i=0;i<mButtons.length;i++) {
            Button button = mButtons[i];
            final int final_i = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    didPressGameButton(final_i);
                }
            });
        }

        mButton_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int j =0; j < mButtons.length; j++) {
                    mButtons[j].setText("");
                    gameState[j] = TicTacToeLogic.TTTElement.EMPTY;
                    mButtons[j].setClickable(true);
                }
                mButton_new_game.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void didPressGameButton(int i){
            mButtons[i].setText("X");
            gameState[i] = TicTacToeLogic.TTTElement.X;
            if(!TicTacToeLogic.isGameOver(gameState)){
                int bestMove = TicTacToeLogic.getBestMove(gameState);
                mButtons[bestMove].setText("0"); // but what happens if bestMove == -1?
                gameState[bestMove] = TicTacToeLogic.TTTElement.O;
                mButtons[bestMove].setClickable(false);
            }
            mButtons[i].setClickable(false);

            if(TicTacToeLogic.isGameOver(gameState)) {
                mButton_new_game.setVisibility(View.VISIBLE);
            }
    }
}
