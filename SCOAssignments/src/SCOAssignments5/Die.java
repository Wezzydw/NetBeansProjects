/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

import java.util.Random;

/**
 *
 * @author Wezzy
 */
public class Die {
    Random rnd = new Random();
    int eyesMinimum = 1;
    int eyesMaximum = 6;
    int amountOfRolls = 100;
    int[] die = new int[amountOfRolls];
    int totalNumberOfRolls = 0;

    public Die()
    {
        
    }
    
    public void printRoll()
    {
        for (int i = 0; i < amountOfRolls; i++)
        {
            die[i] = roll();
            System.out.println("roll: " + die[i]);
        }
    }
    
    public int roll()
    {
        totalNumberOfRolls++;
        int number = rnd.nextInt(eyesMaximum - eyesMinimum + 1) + eyesMinimum;
        return number;
    }
    
    public void reset()
    {
        for (int i = 0; i < amountOfRolls; i++)
        {
            die[i] = 0;
        }
    }
    
    public int getEyeCount(int eyeNumber)
    {
        int count = 0;
        for (int x : die)
        {
            if (x == eyeNumber)
                count++;
        }
        return count;
    }
    
    public double getEyeFrequency(int eyeNumber)
    {
        double frequency;
        frequency = getEyeCount(eyeNumber)/totalNumberOfRolls();
        return frequency;
    }
    
    public int totalNumberOfRolls()
    {
        return totalNumberOfRolls;
    }
}
