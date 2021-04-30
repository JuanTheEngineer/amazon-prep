package streamdemo;

import java.time.Instant;

/**
 * This class is going to utilize Date and Time API
 * to get the time difference between points in code.
 * 
 */
public class Timer {
    
    public static long initialTime, finalTime;
    
    public static void setTimer()
    {
        initialTime = Instant.now().toEpochMilli();
        stopTimer();
    }
    
        public static void stopTimer()
    {
        finalTime = Instant.now().toEpochMilli();
    }
        
    public static long printTime()
    {
        if (finalTime - initialTime == 0){ System.out.printf("- Error: Sequence out of order.");}
        
        else { System.out.printf("runtime: %dms", finalTime - initialTime);}
        
        return(finalTime - initialTime);
    }
}
