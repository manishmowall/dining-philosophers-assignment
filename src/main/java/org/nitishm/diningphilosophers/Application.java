package org.nitishm.diningphilosophers;

public class Application {
   public static void main(String[] args) throws Exception {
      //int ponder = 5;

      int size = 5;

      Fork[] forks = new Fork[size];
      for (int i = 0; i < size; i++) {
         forks[i] = new Fork();
      }

      for (int i = 0; i < size; i++) {
         if (i < (size - 1)) {
            new Thread(new Philosopher(
               forks[i], forks[i + 1], i));

         } else {
            new Thread(new Philosopher(
               forks[0], forks[i], i));
         }
      }
   }
}


