/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoassignment3;

import java.util.Scanner;

/**
 *
 * @author WezzyLaptop
 */
public class SCOAssignment3Exercise1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        
        String stars = "***********";
        System.out.println(stars + "\n" + "*" + name + "*" + "\n" + stars);
        // TODO code application logic here
    }
    
}
