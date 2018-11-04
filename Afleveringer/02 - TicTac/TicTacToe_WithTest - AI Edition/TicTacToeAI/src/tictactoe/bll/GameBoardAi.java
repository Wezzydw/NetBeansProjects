/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.scene.control.Button;

/**
 *
 * @author Gruppe H
 */
public class GameBoardAi implements IGameModel
{

    private final int gridEmpty = 0;
    private final int playerAI = 0;
    private final int player1 = 1;
    private final int playerToGridNumber = 1;
    private final int minimumMovesToWin = 5;
    private final int movesToDraw = 9;
    private final int numberOfPlayers = 2;
    private final int moveOffensive = player1;
    private final int moveDefensive = playerAI;
    private int[][] grid = new int[3][3];
    private int whereToPlace = 0;
    private int player = 1;
    private int movesCounter = 0;

    private boolean isDraw = false;

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        if (player == playerAI)
        {
            return player1;
        } else
        {
            return playerAI;
        }
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     *
     * Grid values represent : Empty = 0; Player 0 = 1; Player 1 = 2;
     */
    public boolean play(int row, int col)
    {

        if (grid[col][row] == gridEmpty)
        {
            grid[col][row] = player + playerToGridNumber;
            player = playerAI;
            movesCounter++;
            return true;
        }

        return false;

    }

    /**
     * The method looks for a winning condition by running through the board and
     * each player Also looks for a draw, and sets "draw" to true, if it is.
     *
     * @return true if there is a winner or a draw to end the game
     */
    public boolean isGameOver()
    {
        if (movesCounter >= minimumMovesToWin)
        {
            for (int i = 0; i < grid.length; i++)
            {
                for (int j = 1; j <= numberOfPlayers; j++)
                {
                    if (grid[i][0] == j && grid[i][1] == j && grid[i][2] == j)
                    {
                        return true;
                    }
                    if (grid[0][i] == j && grid[1][i] == j && grid[2][i] == j)
                    {
                        return true;
                    }
                    if (grid[0][0] == j && grid[1][1] == j && grid[2][2] == j)
                    {
                        return true;
                    }
                    if (grid[2][0] == j && grid[1][1] == j && grid[0][2] == j)
                    {
                        return true;
                    }
                }
            }
        }
        if (movesCounter == movesToDraw)
        {
            isDraw = true;
            return true;
        }
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if (isDraw == true)
        {
            return -1;
        }
        return player;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        grid = new int[3][3];
        movesCounter = 0;
        isDraw = false;
        player = player1;
    }

    public String getGameType()
    {
        return "AI";
    }

    public Button getBtn(Button btn1, Button btn2, Button btn3, Button btn4,
            Button btn5, Button btn6, Button btn7, Button btn8, Button btn9)
    {
        if (whereToPlace == 1)
        {
            return btn1;
        }
        if (whereToPlace == 2)
        {
            return btn2;
        }
        if (whereToPlace == 3)
        {
            return btn3;
        }
        if (whereToPlace == 4)
        {
            return btn4;
        }
        if (whereToPlace == 5)
        {
            return btn5;
        }
        if (whereToPlace == 6)
        {
            return btn6;
        }
        if (whereToPlace == 7)
        {
            return btn7;
        }
        if (whereToPlace == 8)
        {
            return btn8;
        }
        if (whereToPlace == 9)
        {
            return btn9;
        } else
        {
            return btn9;
        }

    }

    public void runAI()
    {
        whereToPlace = 0;
        if (movesCounter < 3)
        {
            placeAtRandom();
        } else
        {
            if (goForMove(moveOffensive) == false)
            {
                if (goForMove(moveDefensive) == false)
                {
                    placeAtRandom();
                }
            }
        }
        movesCounter++;
        player = player1;
    }

    private boolean isThreat()
    {
        int[][] threatHolder = removePlayerFromArray(playerAI);
        for (int i = 0; i < grid.length; i++)
        {
            if (threatHolder[i][0] + threatHolder[i][1] + threatHolder[i][2] == 4)
            {
                return true;
            }
            if (threatHolder[0][i] + threatHolder[1][i] + threatHolder[2][i] == 4)
            {
                return true;
            }
        }
        if (threatHolder[0][0] + threatHolder[1][1] + threatHolder[2][2] == 4)
        {
            return true;
        }
        if (threatHolder[2][0] + threatHolder[1][1] + threatHolder[0][2] == 4)
        {
            return true;
        }

        return false;
    }

    private boolean goForMove(int playertest)
    {
        int[][] onePlayerGrid = removePlayerFromArray(playertest);
        int arrayCheck;
        if (playertest == 0)
        {
            arrayCheck = (player1 + playerToGridNumber) * 2;
        } else
        {
            arrayCheck = (playerAI + playerToGridNumber) * 2;
        }

        for (int i = 0; i < grid.length; i++)
        {
            if (onePlayerGrid[i][0] + onePlayerGrid[i][1] + onePlayerGrid[i][2] == arrayCheck)
            {
                if (grid[i][0] == 0)
                {
                    setButton(i, 0);
                    return true;
                } else if (grid[i][1] == 0)
                {
                    setButton(i, 1);
                    return true;
                } else if (grid[i][2] == 0)
                {
                    setButton(i, 2);
                    return true;
                }
            }
            if (onePlayerGrid[0][i] + onePlayerGrid[1][i] + onePlayerGrid[2][i] == arrayCheck)
            {
                if (grid[0][i] == 0)
                {
                    setButton(0, i);
                    return true;
                } else if (grid[1][i] == 0)
                {
                    setButton(1, i);
                    return true;
                } else if (grid[2][i] == 0)
                {
                    setButton(2, i);
                    return true;
                }
            }

        }
        if (onePlayerGrid[0][0] + onePlayerGrid[1][1] + onePlayerGrid[2][2] == arrayCheck)
        {

            if (grid[0][0] == 0)
            {

                setButton(0, 0);
                return true;
            } else if (grid[1][1] == 0)
            {
                setButton(1, 1);
                return true;
            } else if (grid[2][2] == 0)
            {
                setButton(2, 2);
                return true;
            }
        }
        if (onePlayerGrid[2][0] + onePlayerGrid[1][1] + onePlayerGrid[0][2] == arrayCheck)
        {
            if (grid[2][0] == 0)
            {
                setButton(2, 0);
                return true;
            } else if (grid[1][1] == 0)
            {
                setButton(1, 1);
                return true;
            } else if (grid[2][2] == 0)
            {
                setButton(2, 2);
                return true;
            }
        }
        return false;

    }

    private int[][] removePlayerFromArray(int playerToBeRemoved)
    {

        //int[][] remove = grid;
        //Virker ikke. så fjerner det fra GRID!
        int[][] remove = new int[3][3];
        //Det loop her fjerner en bug, så remove ikke fjerne tal fra grid
        for (int k = 0; k < remove.length; k++)
        {
            for (int l = 0; l < remove.length; l++)
            {
                remove[k][l] = grid[k][l];
            }
        }
        //

        for (int i = 0; i < remove.length; i++)
        {
            for (int j = 0; j < remove.length; j++)
            {
                if (remove[i][j] == playerToBeRemoved + playerToGridNumber)
                {
                    remove[i][j] = 0;
                }
            }
        }

        return remove;
    }

    public void setButton(int col, int row)
    {
        grid[col][row] = 1;
        if (col == 0 && row == 0)
        {
            whereToPlace = 1;
        }
        if (col == 0 && row == 1)
        {
            whereToPlace = 2;
        }
        if (col == 0 && row == 2)
        {
            whereToPlace = 3;
        }
        if (col == 1 && row == 0)
        {
            whereToPlace = 4;
        }
        if (col == 1 && row == 1)
        {
            whereToPlace = 5;
        }
        if (col == 1 && row == 2)
        {
            whereToPlace = 6;
        }
        if (col == 2 && row == 0)
        {
            whereToPlace = 7;
        }
        if (col == 2 && row == 1)
        {
            whereToPlace = 8;
        }
        if (col == 2 && row == 2)
        {
            whereToPlace = 9;
        }

    }

    public void placeAtRandom()
    {
        boolean whileholder = true;
        while (whileholder)
        {
            int rnd1 = (int) (Math.random() * 3);
            int rnd2 = (int) (Math.random() * 3);
            if (grid[rnd1][rnd2] == 0)
            {
                setButton(rnd1, rnd2);

                whileholder = false;
            }

        }
    }

}
