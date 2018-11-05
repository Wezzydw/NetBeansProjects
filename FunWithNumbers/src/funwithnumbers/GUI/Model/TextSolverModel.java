/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Model;

/**
 *
 * @author Wezzy
 */
public class TextSolverModel {
    
    public String getTXT(String input){
        
        String t0 = input;
        String t1 = getTXTUppercase(input);
        String t2 = getTXTLowercase(input);
        String t3 = getTXTChar(input);
        String t4 = getTXTFirstChar(input);
        String t5 = getTXTFirstA(input);

        return t0 + "\n" + t1 + "\n" + t2 + "\n" + t3 + "\n" + t4 + "\n" + t5;
    }
    
    private String getTXTUppercase(String input){
        String uppercase = input.toUpperCase();
        return uppercase;
    }
    
    private String getTXTLowercase(String input){
        String lowercase = input.toLowerCase();
        return lowercase;
    }
    private String getTXTChar(String input){
        int number = input.length();
        return "The number of Characters: " + number;
    }
    
    private String getTXTFirstChar(String input){
        char first = input.charAt(0);
        return "The first Character is: " + first;
    }
    
    private String getTXTFirstA(String input){   
        int number = input.indexOf("a");
        if (number != 0)
            number++;
        return "The first a is located at: " + number;
    }
    
    public String getFirstName(String fullName){
        int fullNameSpaceIndex = fullName.indexOf(" ");
        if (fullNameSpaceIndex != -1){
            String firstName = fullName.substring(0, fullNameSpaceIndex);
            return firstName;
        }
        return fullName;
    }
    
    public String getLastName(String fullName){
        int fullNameSpaceIndex = fullName.indexOf(" ");
        if (fullNameSpaceIndex != -1){
            String lastName = fullName.substring(fullNameSpaceIndex, fullName.length());
            return lastName;
        }
        return fullName;
        
    }
    
    public int getNumberOfLetters(String text){
        int total = 0;
        char tmp;
        for (int i = 0; i < text.length(); i++){
            tmp = text.charAt(i);
            if (Character.isAlphabetic(tmp)){
                total++;
            }
        }
        return total;
    }
    
    public String getFormattedName(String fullName){
        String returnName = "";
        boolean weFoundSpace = false;

        for (int i = 0; i < fullName.length(); i++) {
            if (i == 0){
                String chara = fullName.substring(i, i+1);
                returnName = returnName + chara.toUpperCase();
            }
            else 
            {
                String chara = fullName.substring(i,i+1);
                if (weFoundSpace == false && !chara.equals(" ")){
                    returnName = returnName + chara.toLowerCase();
                }         
                if (weFoundSpace == true){
                        returnName = returnName + chara.toUpperCase();
                        weFoundSpace = false;
                }
                
                if (chara.equals(" ")){
                    weFoundSpace = true;
                    returnName = returnName + " ";         
                }     
            }
        }
        return returnName;
    }
}
