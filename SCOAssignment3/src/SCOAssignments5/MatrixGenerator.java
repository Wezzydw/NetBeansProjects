/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

/**
 *
 * @author Wezzy
 */
public class MatrixGenerator {
    
    
    public static void loadMAtrix(int[][] m)
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                m[i][j] = (i+1)*(j+1);
            }
        }
    }
    
    public static void printMatrix(int[][] m)
    {
        String s = "";
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                if (m[i][j] < 10)
                    s += "   " + m[i][j];
                else if (m[i][j] < 100)
                    s += "  " + m[i][j];
                else
                    s += " " + m[i][j];
            }
            s += "\n";
        }
        System.out.println(s);
    }
    
}
