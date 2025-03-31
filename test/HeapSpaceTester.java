/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Anton
 */
public class HeapSpaceTester {
    
    
    public static void loggTheHeapspace(){
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        Runnable task = new Runnable() {
            @Override
            public void run() {

                Runtime runtime = Runtime.getRuntime();


                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();
                long usedMemory = totalMemory - freeMemory;

                System.out.println("Used heap memory: " + usedMemory / (1024 * 1024) + " MB");
            }
        };

        // print eevery 2 minutes 
        scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.MINUTES);
    
    }
    
}
