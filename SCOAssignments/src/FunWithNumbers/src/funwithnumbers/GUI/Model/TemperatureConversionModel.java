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
public class TemperatureConversionModel {
    
    
    public double getTemperatureInFahrenheit(double degree){
        
        return degree * 1.8 + 32;
    }
    
    public double getTemperatureInCelcius(double degree){
        return (degree -32) / 1.8;
    }
    
}
