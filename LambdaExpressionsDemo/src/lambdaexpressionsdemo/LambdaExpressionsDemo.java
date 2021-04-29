/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpressionsdemo;

import java.util.Arrays;
import java.util.List;

/* Excessive code that can be replaced with Lambda
// Interface for method show()
interface A
{
    void show();
}
// Class to implement interface A
class Xyz implements A
{
    // Method definition
    public void show()
    {
        System.out.println("Hello");
    }
}
*/


interface A
{
    void show(int i);
}
public class LambdaExpressionsDemo 
{
    public static void main(String[] args) 
    {
        
        /* Takes too long to print
        // Java 1.7
        for (int i : values) {
            System.out.println(i);
        }*/
               
        // Instantiate A - Part of excessive code example.
        // A obj = new Xyz();
        //obj.show();
        
        /* Excessive code still
        A obj;
        obj = new A()
                {
                    public void show()
                    {
                        System.out.println("Hello")l;
                    }
                };
        */
        
        A obj;
        // Lambda Expression
        obj = i -> System.out.println("Hello User#" + i);
        
        obj.show(10000);
        
  
        // Next Lesson - Consumer Interface in Java 1.8
        List<Integer> values = Arrays.asList(4,5,6,7,8);        
        
        values.forEach(i -> System.out.println(i)); // Lambda // Consumer
    }
}
