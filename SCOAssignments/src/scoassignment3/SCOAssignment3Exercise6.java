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
public class SCOAssignment3Exercise6 {
    
    
            
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SCOAssignment3Exercise6 a = new SCOAssignment3Exercise6();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String a1 = a.getText(text);
        String a2 = a.getTextUppercase(text);
        String a3 = a.getTextLowercase(text);
        int a4 = a.getNumberOfCharacters(text);
        String a5 = a.getFirstCharacter(text);
        int a6 = a.getFirstA(text);
        
        System.out.println(a1 + "\n" + a2 + "\n" + a3 + "\n" + a4 + "\n" + a5 + "\n" + a6);
        

    }
    
    private String getText(String text){
        return text;
    }
    
    private String getTextUppercase(String text){
        return text.toUpperCase();
        
    }
    
    private String getTextLowercase(String text){
        return text.toLowerCase();
    }
    
    private int getNumberOfCharacters(String text){
        return text.length();
        
    }
    
    private String getFirstCharacter(String text){
        return "" + text.charAt(0);
        
    }
    
    private int getFirstA(String text){
        return text.indexOf("a");
    }
}
