package streamdemo;

import java.time.LocalDate;
import java.util.Random;

public class Person
{
    private int age;
    private String firstName;
    private String lastName;
    private String email;
    
    Random rand = new Random(); //instance of random class
    final String[] domains = new String[]{"@gmail.com",
                                          "@hotmail.com",
                                          "@me.com",
                                          "@gatech.edu",
                                          "@amazon.com",
                                          "@dadeschools.net",
                                          "@yahoo.com",
                                         };
    
    // Current Year
    final LocalDate currentDate = LocalDate.now();
    int currentYear = currentDate.getYear();
    
    // Clever constructor that assigns new person with an email.
    public Person (String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        String yoB = Integer.toString(currentYear - age);
        int i = rand.nextInt(domains.length);
        this.email = firstName.substring(0,1).toLowerCase() + 
                    lastName.substring(0,4).toLowerCase() + 
                    yoB.substring(yoB.length() - 2, yoB.length()) +
                    domains[i];
    }

    // Getters
    public int getAge() {
        return age;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void printAge(int _age) {
        this.age = age;
    }
}