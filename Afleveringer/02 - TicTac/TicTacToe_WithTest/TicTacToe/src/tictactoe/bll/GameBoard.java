/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Gruppe H
 */
public class GameBoard implements IGameModel
{
    private final int gridEmpty = 0;
    private final int player0 = 0;
    private final int player1 = 1;
    private final int playerToGridNumber = 1;
    private final int minimumMovesToWin = 5;
    private final int movesToDraw = 9;
    private final int numberOfPlayers = 2;
    private final int returnDraw = -1;
    private int[][] grid = new int[3][3];
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
        if (player == player0)
        {
            return player1;
        } else
        {
            return player0;
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
    public boolean play(int col, int row)
    {
        if (grid[col][row] == gridEmpty)
        {
            grid[col][row] = player + playerToGridNumber;
            
            if (player == player0)
            {
                player = player1;
            } else
            {
                player = player0;
            }
            movesCounter++;
            return true;
        }
        return false;
    }

    /**
     * The method looks for a winning condition by running through the board and
     * each player
     * Also looks for a draw, and sets "draw" to true, if it is.
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
            return returnDraw;
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
}
