package atividade_1;


import java.util.concurrent.ThreadLocalRandom;

public class RandomTimeThread implements Runnable{
    @Override
    public void run() {
        int random_number = ThreadLocalRandom.current().nextInt(1, 11);
        System.out.println("Nova thread com tempo de vida de:" + random_number);

        try {
            System.out.println("Thread em sleep");
            Thread.sleep(random_number * 1000);
            System.out.println("Thread fora do sleep");
        } catch (InterruptedException e) {
            System.out.println("Thread finalizada durante sleep");
        }
    }
}
