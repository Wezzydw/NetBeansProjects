/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoassignment3;

import java.awt.Rectangle;
import java.util.Scanner;

/**
 *
 * @author WezzyLaptop
 */
public class SCOAssignment3Exercise7NumberPrinter
{
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SCOAssignment3Exercise7NumberPrinter opg = new SCOAssignment3Exercise7NumberPrinter();
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        double a = opg.getNumber(number);
        double b = opg.getSquareRoot(number);
        double c = opg.getSquare(number);
        double d = opg.getRoundUp(number);
        double e = opg.getLargerInt(number);
        double f = opg.getSmallerInt(number);
        int [] numbers = {1,2,3,4};
        int [] tal = new int[5];
        for (int i = 0; i < numbers.length; i++){
            tal[i] = numbers[i];
            System.out.println(tal[i]);
        }
        System.out.println(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f);
        
    }
    
    private double getNumber(double number){
        return number;
    }
    
    private double getSquareRoot(double number){
        return Math.sqrt(number);
    }
    
    private double getSquare(double number){
        return number * number;
    }
    
    private double getRoundUp(double number){
        return Math.round(number);
        
    }
    
    private double getLargerInt(double number){
        return Math.ceil(number);
        
    }
    
    private double getSmallerInt(double number){
        return Math.floor(number);
    }
            
}
