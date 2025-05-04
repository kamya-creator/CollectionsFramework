package org.example.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class AskedInUKGBlockingQueuQuestion {
    public static void main(String[] args) throws InterruptedException {

        /*
        Print 1a2b3c4d using 2 Threads
        1st Thread must print numerical Value
        2nd Thread must print alphabets

        OutPut: 1a2b3c4d5e6f7g8h9i10j
         */

        ArrayBlockingQueue<Integer> numberQueue = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Character> alphabetsQueue = new ArrayBlockingQueue<>(1);


        Thread thread1 = new Thread(() -> {
            char ch = 'a';
            for(int i =1;i<=10;i++)
            {
                try {
                    System.out.print(i);  // Print number
                    numberQueue.put(1);  // Signal Thread 2 to print alphabet
                    alphabetsQueue.take();  // Wait from Signal from Thread 2

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        });

        Thread thread2 = new Thread(()->{


            for(char ch ='a';ch<='j';ch++)
            {
                try {
                    numberQueue.take();  // Wait for Signal from Thread 1
                    System.out.print(String.valueOf(ch).charAt(0)); // When signal Confirmed then print alphabet
                    alphabetsQueue.put('a');  // Signals Thread 1
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
