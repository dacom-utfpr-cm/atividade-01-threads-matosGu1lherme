package atividade_1;

public class Main {
    public static void main(String[] args) {
        Thread thread_1 =  new Thread(new RandomTimeThread());
        Thread thread_2 =  new Thread(new RandomTimeThread());
        Thread thread_3 =  new Thread(new RandomTimeThread());

        thread_1.start();
        thread_2.start();
        thread_3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Erro durante sleep main");
        }

        System.out.println("Parando thread");
        thread_1.interrupt();
    }
}
