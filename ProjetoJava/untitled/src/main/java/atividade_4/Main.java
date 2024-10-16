package atividade_4;

public class Main {
    public static void main(String[] args) {
        Runnable tarefa = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " executando ");
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
    }
}
