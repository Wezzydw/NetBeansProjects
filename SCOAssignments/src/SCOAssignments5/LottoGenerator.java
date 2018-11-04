/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Wezzy
 */
public class LottoGenerator {
    
    int[] draws;
    int[] lottoNumbers;
    Random rnd = new Random();
    int numberMinimum = 0;
    int numberMaximum = 35;
    int numbersToDraw = 7;
    int[] supNumbers;

    public LottoGenerator()
    {
        lottoNumbers = new int[36];
        draws = new int[7];  
        supNumbers = new int[2];
    }
    
    public static void main(String[] args) {
        LottoGenerator lg = new LottoGenerator();
        lg.generateLottoNumbers();
        lg.drawLottoNumbers();
        lg.sortArray();
        lg.printArrayAfter();
        lg.printArraySup();
    }
    
    public void generateLottoNumbers()
    {
        for (int i = 0; i < lottoNumbers.length; i++)
        {       
            lottoNumbers[i] = i+1;
        }
    }
    
    private void drawLottoNumbers()
    {
        for (int i = 0; i < numbersToDraw; i++)
        {
            int number = rnd.nextInt(numberMaximum - numberMinimum + 1) + numberMinimum;
            if (lottoNumbers[number] == 0)
            {
                i--;
            }
            else
            {
                draws[i] = lottoNumbers[number];
                lottoNumbers[number] = 0;       
            }
        }
        for (int i = 0; i < supNumbers.length; i++)
        {
            int number = rnd.nextInt(numberMaximum - numberMinimum + 1) + numberMinimum;
            if (lottoNumbers[number] == 0)
            {
                i--;
            }
            else
            {
                supNumbers[i] = lottoNumbers[number];
                lottoNumbers[number] = 0;       
            }
        }
    }
    
    private void sortArray()
    {
        int[] tmpSort = new int[draws.length];
        int smallestIndex = 0;
        int smallestNumber = draws[0];
        //Arrays.sort(lottoNumbers);
        for (int j = 0; j < draws.length; j++)
        {
            smallestNumber = 36;
            for (int i = 0; i < numbersToDraw; i++)
            {
                if (smallestNumber >= draws[i] && draws[i] != 0)
                {
                    smallestNumber = draws[i];
                    smallestIndex = i;
                }
            }
            tmpSort[j] = draws[smallestIndex];
            draws[smallestIndex] = 0;
        }
        draws = tmpSort;
        
        if (supNumbers[0] > supNumbers[1])
        {
            int tmp = supNumbers[0];
            supNumbers[0] = supNumbers[1];
            supNumbers[1] = tmp;
            
        }
    }
    
    private void printArrayAfter()
    {
        for (int i = 0; i < draws.length; i++)
        {
            System.out.println("Lotto nr: " + (i+1) + " is " + draws[i]);
            
        }
    }
    
    private void printArraySup()
    {
        for (int i = 0; i < supNumbers.length; i++)
        {
            System.out.println("Supplementary numbers are: " + supNumbers[i]);
        }
    }  
}
