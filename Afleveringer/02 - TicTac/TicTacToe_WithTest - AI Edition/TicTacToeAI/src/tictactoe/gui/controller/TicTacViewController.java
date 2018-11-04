/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.GameBoard;
import tictactoe.bll.GameBoardAi;
import tictactoe.bll.IGameModel;

/**
 *
 * @author Grupper H
 */
public class TicTacViewController implements Initializable
{

    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;

    private static final String TXT_PLAYER = "Player: ";
    private final String playVsAi = "Play VS AI!";
    private final String playVsHuman = "Play VS Human";
    private IGameModel game;
    private boolean isGameFinished = false;
    
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnGamemode;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();
            Button btn = (Button) event.getSource();
            String xOrO = player == 0 ? "X" : "O";
            if (game.play(c, r))
            {
                if (game.isGameOver() && isGameFinished == false)
                {
                    isGameFinished = true;
                    btn.setText(xOrO);
                    int winner = game.getWinner();
                    displayWinner(winner);

                }
                if (isGameFinished == false)
                {
                    btn.setText(xOrO);
                    setPlayer();
                    player = game.getNextPlayer();
                    xOrO = player == 0 ? "X" : "O";
                    runAI();
                    btn = game.getBtn(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
                        btn9);
                    btn.setText(xOrO);
                    setPlayer();
                    
                    if (game.isGameOver() && isGameFinished == false)
                    {
                        isGameFinished = true;
                        btn.setText(xOrO);
                        int winner = game.getWinner();
                        displayWinner(winner);
                    }
                        
                }
                
                }

        } catch (Exception e)
        {
            System.out.println("exeption " + e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
        isGameFinished = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
    }

    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + (game.getNextPlayer() + 1));
    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + (winner + 1) + " wins!!!";
                break;
        }
        lblPlayer.setText(message);

    }

    private void clearBoard()
    {
        for (Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }
    
    private void runAI()
    {
        game.runAI();
        
        
    }

    @FXML
    private void changeGameMode(ActionEvent event)
    {
        if ("Human".equals(game.getGameType()))
        {
            game = new GameBoardAi();
            btnGamemode.setText("Play VS Human");
        }
        else
        {
            game = new GameBoard();
            btnGamemode.setText("Play VS AI");
        }
        game.newGame();
        setPlayer();
        clearBoard();
        isGameFinished = false;
        
    }

}
