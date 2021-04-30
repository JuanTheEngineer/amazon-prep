package streamdemo;

import java.util.ArrayList;
import java.util.List;

public class Numbers 
{
    private List<Integer> numbers = new ArrayList<Integer>();
    
    public Numbers (int length)
    {
        for(int i = 1; i <= length; i++)
        {
            numbers.add(i);
        }
    }
    
    public Numbers ()
    {
        for(int i = 1; i <= 100; i++)
        {
            numbers.add(i);
        }
    }
    
    // Prints initial list
    public void printNumbers()
    {
        System.out.printf("Numbers: \n  ");
        for(int i = 1; i <= numbers.size(); i++)
        {
            if (((i - 2) % 10) == 9) System.out.printf("\n  ");
            
            System.out.printf("%3d ", i);
        }
        System.out.println();
    }
    
    // Class method to print list
    public static void printNumbers(List<Integer> numbers)
    {
        System.out.printf("Numbers: \n  ");
        for(int i = 0; i < numbers.size(); i++)
        {
            if (((i - 1) % 10) == 9) System.out.printf("\n  ");
            
            System.out.printf("%3d ", numbers.get(i));
        }
        System.out.printf("\n\n\n");
    }
    
    // Getter
    public List<Integer> getList()
    {
        return numbers;
    }
}
