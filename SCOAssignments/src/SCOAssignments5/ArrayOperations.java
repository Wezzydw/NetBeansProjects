/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

import java.util.Random;

/**
 *
 * @author WezzyLaptop
 */
public class ArrayOperations
{
    private int[] numbers;
    
    public ArrayOperations(int numberOfElements)
    {
        numbers = new int[numberOfElements];
    }
    
    public ArrayOperations(int numberOfElements, int minimumValue, int maximumValue)
    {
        Random rnd = new Random();
        
        numbers = new int[numberOfElements];
        for (int i = 0; i < numbers.length; i++)
        {
            int number = rnd.nextInt(maximumValue - minimumValue + 1) + minimumValue;
            numbers[i] = number;
        }
    }
    
    public void printArray()
    {
        for (int i = 0; i < numbers.length; i++)
            
            System.out.println("I index :" + i + " er tallet: " + numbers[i]);
    }
    
    public int getNumber(int number)
    {
        int antal = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == number)
                antal++;
        }
        return antal;
    }
    
    public int getMaximum()
    {
        int maximum = 0;
        for (int x : numbers)
        {
            if (x > maximum)
            {
                maximum = x;
            }
        }
        return maximum;
        
    }
    
    public int getMinimum()
    {
        int minimum = numbers[0];
        for (int x : numbers)
        {
            if (x < minimum)
                minimum = x;
        }
        return minimum;
    }
    
    public int getSum()
    {
        int sum = 0;
        for (int x : numbers)
        {
            sum += x;
        }
        return sum;
    }
    
    public double getAverage()
    {
        double sum = 0;
        for (int x : numbers)
        {
            sum += x;
        }
        
        return sum / numbers.length;
    }
    
    public int firstIndexOf(int number)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == number)
                return i;
        }
        return -1;
    }
    
    public int lastIndexOf(int number)
    {
        int tmpIndex = -1;
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == number)
                tmpIndex = i;
                
        }
        return tmpIndex;
    }
    
    public void reverse()
    {
        int [] tmp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++)
        {
            tmp[numbers.length - 1 -i] = numbers[i];
            
        }
        numbers = tmp;
    }
    
}
