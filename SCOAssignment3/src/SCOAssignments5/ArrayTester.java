/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignments5;

/**
 *
 * @author Wezzy
 */
public class ArrayTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayOperations e1 = new ArrayOperations(50, 0, 10);
        System.out.println("Array");
        e1.printArray();
        System.out.println("getNumber" + e1.getNumber(7));
        System.out.println("getMinimum" + e1.getMinimum());
        System.out.println("getMaximum" + e1.getMaximum());
        System.out.println("getSum" + e1.getSum());
        System.out.println("getAverage" + e1.getAverage());
        System.out.println("firstIndexOf" + e1.firstIndexOf(7));
        System.out.println("lastIndexOf" + e1.lastIndexOf(1));
        System.out.println("reverse");
        e1.reverse();
        e1.printArray();
        
    }
    
}
