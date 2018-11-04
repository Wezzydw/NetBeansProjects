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
public class BMICalculatorModel {
    
    public double getBMI(double height, double weight){
        
        return weight/(height*height);
    }
    
}
