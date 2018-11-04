/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Wezzy
 */
public class MatrixTest {

    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int arg1 = sc.nextInt();
        int arg2 = sc.nextInt();
        int [][] a = new int[arg1][arg2];
        MatrixGenerator.loadMAtrix(a);
        MatrixGenerator.printMatrix(a);
        Arrays.sort(a);
        
    }
    
}
