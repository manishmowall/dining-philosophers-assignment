package org.nitishm.diningphilosophers;

import java.util.concurrent.TimeUnit;

/**
 * Created by mowall on 19/9/16.
 */
public class Philosopher implements Runnable {
   private Fork left;
   private Fork right;
   private final String id;
   Thread thread;

   public Philosopher(Fork left, Fork right,
                      int ident) {
      this.left = left;
      this.right = right;
      id = "" + ident;

      thread = new Thread(this, id);
      thread.start();
   }

   public void run() {
      try {
         int i = 0;
         while (i < 5) {
            System.out.println(id + " " + "thinking");
            pause();
// Philosopher becomes hungry
            System.out.println(id + " " + "grabbing right");
            right.take();
            System.out.println(id + " " + "grabbing left");
            left.take();
            System.out.println(id + " " + "eating");
            pause();
            right.drop();
            left.drop();
            i++;
         }
      } catch (InterruptedException e) {
         System.out.println(id + " " + "exiting via interrupt");
      }
   }

   private void pause() throws InterruptedException {
      TimeUnit.MILLISECONDS.sleep(1000);
   }
}
