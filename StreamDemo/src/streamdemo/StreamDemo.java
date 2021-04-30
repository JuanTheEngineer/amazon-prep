package streamdemo;

/** Notes on Streaming and Pipelines
 * <pre>
 * Stream Methods
 *  Intermediate Operations (Returns a stream consisting of the~)
 *      Stateless
 *          .filter(Predicate(T) predicate)     ~ elements that match the given predicate
 *          .map(Function(T, R) mapper)         ~ results of applying the given function to the elements of this stream
 *          .mapTo___(To___Function(T) mapper) 
 *          .peek(Consumer(T) action)           ~ elements of this stream, additionally performing the provided action on each element
 * 
 *      Stateful
 *          .sorted(Comparator(T) comparator)   ~ elements of this stream, sorted according to the provided Comparator
 *          .limit(long maxSize)                ~ elements of this stream, truncated to be no longer than maxSize in length
 *          .skip(long n)                       ~ remaining elements of this stream after discarding the first n elements of the stream
 *      
 *  Terminate Operations
 *      .forEach(Consumer(T) action)        ~ Performs an action for each element of this stream
 *      .reduce(T identity, BiOptr(T) accumulator)  
 * `        ~ identity - both the initial value of the reduction and default result if there are no elements in the stream
 *          ~ accumulator - an associative, non-interfering, stateless function for combining two values (lambda expression)
 *      .collect(Collector(T,A,R) collector)
 *          
 * </pre>
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo 
{
    public static void main(String[] args) 
    {
        
        // An exercise involving a list of numbers
        Numbers test = new Numbers();
        
        // Return numbers with a square that is a multiple of 4
        List<Integer> result = test.getList().stream()
                .filter(p -> (p * p) % 4 == 0)
                .collect(Collectors.toList());
        Numbers.printNumbers(result);
                
        
    }
    
}
