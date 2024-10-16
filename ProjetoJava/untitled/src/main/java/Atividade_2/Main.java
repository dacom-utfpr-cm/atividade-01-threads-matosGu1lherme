package Atividade_2;

public class Main {
    public static void main(String[] args) {
        Thread phraseThread = new Thread(new ReadPhraseRunnable());
        phraseThread.start();

        System.out.println("A thread será finalizada em 30s");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            System.out.println("Erro durante sleep main");
        }

        System.out.println("Parando thread");
        phraseThread.interrupt();
    }
}
