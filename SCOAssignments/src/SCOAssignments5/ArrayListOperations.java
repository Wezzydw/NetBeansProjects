/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author WezzyLaptop
 */
public class ArrayListOperations
{
    private ArrayList<Integer> numbers = new ArrayList<>();
    Random rnd = new Random();
    
    public ArrayListOperations(int numberOfElements)
    {
        int number;
        for (int i = 0; i < numberOfElements; i++)
        {
            number = rnd.nextInt();
            numbers.add(number);
        }
    }
    
    public ArrayListOperations(int numberOfElements, int minimumValue, int maximumValue)
    {
        int number;
        for (int i = 0; i < numberOfElements; i++)
        {
            number = rnd.nextInt(maximumValue - minimumValue + 1) + minimumValue;
            numbers.add(number);
        }
    }
    
    public String printArray()
    {
        
        String output = "( ";
        for (int x : numbers)
        {
            output += x + " ";
        }
        output += " )";
        return output;
    }
    
    public int getNumber(int number)
    {
        int antal = 0;
        for(int i = 0; i < numbers.size(); i++)
        {
            if (numbers.get(i) == number)
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
        int minimum = numbers.get(0);
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
        
        return sum / numbers.size();
    }
    
    public int firstIndexOf(int number)
    {
        for (int i = 0; i < numbers.size(); i++)
        {
            if (numbers.get(i) == number)
                return i;
        }
        return -1;
    }
    
    public int lastIndexOf(int number)
    {
        int tmpIndex = -1;
        for (int i = 0; i < numbers.size(); i++)
        {
            if (numbers.get(i) == number)
                tmpIndex = i;
        }
        return tmpIndex;
    }
    
    public void reverse()
    {
        ArrayList<Integer> tmp = new ArrayList<>();
        
        System.out.println("numbers.size " + numbers.size());
        for (int i = 0; i < numbers.size(); i++)
        {
            tmp.add(i, numbers.get(numbers.size()-i-1));
            
        }
        numbers = tmp;
    }
}
