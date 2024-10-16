package atividade_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable tarefa = () -> {
            System.out.println(Thread.currentThread().getName() + " executando ");
            while (true) {
                try {
                    Thread.sleep(1000); // Simulando algum trabalho
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " foi interrompida.");
                    Thread.currentThread().interrupt(); // Reinterrompe a thread
                    break;
                }
            }
        };

        Thread thread_1 = new Thread(tarefa);
        Thread thread_2 = new Thread(tarefa);
        Thread thread_3 = new Thread(tarefa);

        thread_1.start();
        thread_2.start();
        thread_3.start();

        List<Thread> threads = new ArrayList<>();
        threads.add(thread_1);
        threads.add(thread_2);
        threads.add(thread_3);
        Thread monitor = new Thread(new MonitorThread(threads));
        monitor.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread principal finalizada durante sleep");
        }

        thread_2.interrupt();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread principal finalizada durante sleep");
        }

        thread_1.interrupt();
    }
}
