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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo 
{
    public static void main(String[] args) 
    {
        
        // An exercise involving a list of numbers and parallel stream
        int amount = 1000000;
        Numbers serialTest = new Numbers(amount);
        
        System.out.printf("1a)Find: Numbers that are a multiple of 7^5 and whose sum of first 2 digits is greater than 10 via stream()\n");
        
        // Date and Time API for timing streams
        Timer.setTimer();   // Looks good
        List<Integer> sResult = serialTest.getList().parallelStream()
                .filter(p -> p % (7*7*7*7*7) == 0 &&
                        ((p % 10) + ((p - (p % 10)) / 10) > 10))
                .collect(Collectors.toList());
        Timer.stopTimer();
        Numbers.printNumbers(sResult);
        
        System.out.printf("Sequential ");
        long sTime = Timer.printTime();
        
        
        Numbers parallelTest = new Numbers(amount);
        
        System.out.printf("\n\n\n1b)Find: Numbers that are a multiple of 7^5 and whose sum of first 2 digits is greater than 10 via parallelStream()\n");
        Timer.setTimer(); 
        List<Integer> pResult = parallelTest.getList().parallelStream()
                .filter(p -> p % (7*7*7*7*7) == 0 &&
                        ((p % 10) + ((p - (p % 10)) / 10) > 10))
                .collect(Collectors.toList());
        Timer.stopTimer();
        Numbers.printNumbers(pResult);
                
        System.out.printf("\nParallel ");
        long pTime = Timer.printTime();
        
        System.out.printf("\n\n.parallelStream() is %dms faster than .stream() for %d numbers streamed! \n\n\n", sTime - pTime, amount);
        // An exercise involving objects
        
        List<Person> people = new ArrayList<Person>();
        
        // Initializing Collection
        people.add(new Person("Travis", "Campbell", 24));
        people.add(new Person("Yusuf", "Glover", 42));
        people.add(new Person("Stephen", "Beasley", 17));
        people.add(new Person("Hazel", "Huffman", 26));
        people.add(new Person("Triston", "Fowler", 19));
        people.add(new Person("Isai", "Mclaughlin", 31));
        people.add(new Person("Ansley", "Vega", 21));
        people.add(new Person("Peter", "Lionoudakis", 25));
        people.add(new Person("Randy", "Wilcox", 51));
        people.add(new Person("Kobe", "Young", 28));
        people.add(new Person("Michelle", "Dawson", 15));
        people.add(new Person("Francesca", "Thomas", 16));
        people.add(new Person("Aubrie", "Simon", 13));
        
        // Print emails of 18-25 year olds in alphabetical order by lastname
        System.out.printf("2) Find: Emails of 18-25 year olds in alphabetical order by lastname\n");
        List<String> mailingList = people.stream()
                .filter(p -> p.getAge() >= 18 &&
                             p.getAge() <= 25)
                .sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
                .map(m -> m.getEmail())
                .collect(Collectors.toList());
        
        // Just to utilize forEach()
        mailingList.stream().forEach(System.out::println);
        
        // Print average age of people with a gmail.com account
        System.out.printf("\n\n3) Find: Average age of people with a gmail.com account  ");
        double average = people.stream()
                .filter(p -> p.getEmail().contains("gmail.com"))
                .mapToInt(i -> i.getAge())
                .average()
                .orElse(0);

        // Small Demo of Date and Time API to return average age as Years and Months
        Period avgDoB = Period.ofMonths((int) (average * 12)).normalized();     
        System.out.printf("%d years %d months\n", avgDoB.getYears(), avgDoB.getMonths());  
        
    }
    
}
