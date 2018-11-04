/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoassignment3;

import java.util.Scanner;

/**
 *
 * @author Wezzy
 */
public class SCOAssignment3Exercise5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tal = 0;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < 10; i++)
        {
            
            System.out.println(i + " * " + number + " = " + tal);
            tal += number;
        }
    }
    
}
