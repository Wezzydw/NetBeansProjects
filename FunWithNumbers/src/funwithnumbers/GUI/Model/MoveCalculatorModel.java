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
public class MoveCalculatorModel {
    
    public String getDistanceCalculated(double dx1, double dx2, double dy1, double dy2)
    {
        return String.valueOf(Math.sqrt((Math.pow(dy2-dy1, 2) + Math.pow(dx2-dx1, 2))));
    }
    
    public String getTMCX(double x,double angle, double length){
        
        double radian = Math.toRadians(angle);
        return String.valueOf(x + Math.cos(radian)*length);
    }
    
    public String getTMCY(double y, double angle, double length){
        
        double radian = Math.toRadians(angle);
        return String.valueOf(y + Math.sin(radian)*length);
    }
    
}
