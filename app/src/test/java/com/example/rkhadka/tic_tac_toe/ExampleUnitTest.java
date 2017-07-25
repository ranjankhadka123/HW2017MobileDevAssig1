package com.example.rkhadka.tic_tac_toe;

import org.junit.Test;

import static com.example.rkhadka.tic_tac_toe.TicTacToeLogic.TTTElement.EMPTY;
import static com.example.rkhadka.tic_tac_toe.TicTacToeLogic.TTTElement.O;
import static com.example.rkhadka.tic_tac_toe.TicTacToeLogic.TTTElement.X;
import static org.junit.Assert.*;

public class ExampleUnitTest {
    @Test
    public void ticTacToeTest(){
        TicTacToeLogic.TTTElement[] gameState1 =
                {X, EMPTY, EMPTY, X, O, EMPTY, EMPTY, EMPTY, EMPTY};
        assertEquals(6, TicTacToeLogic.getBestMove(gameState1));

        TicTacToeLogic.TTTElement[] gameState2 =
                {O, O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        assertEquals(2, TicTacToeLogic.getBestMove(gameState2));

        TicTacToeLogic.TTTElement[] gameState3 =
                {O, O, X, X, O, X, O, X, X};
        assertEquals(-1, TicTacToeLogic.getBestMove(gameState3));


    }
}