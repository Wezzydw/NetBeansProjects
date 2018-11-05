/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Model;

/**
 *
 * @author WezzyLaptop
 */
public class NumberConversionModel {
    
    

    
    
    public String getGreetingsMessage(String name){
        
        return "Hello " + name + ". Greetings from the top java developer class in town";
    }
    
    public double getMilesFromKilometer(double km){
        
        return km / 1.609344;
    }
    
    public double getKilometersFromMiles(double miles){
        
        return miles * 1.609344;
    }


















}
