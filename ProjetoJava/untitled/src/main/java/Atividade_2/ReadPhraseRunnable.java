package Atividade_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadPhraseRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Abrindo_arquivo");

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("frases.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String linha = "do";
        try {
            while (linha != null) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread foi interrompida, encerrando a leitura.");
                    break;
                }

                linha = reader.readLine();
                if (linha != null) {
                    System.out.println(linha);
                }

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrompida durante Sleep");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("Reader fechado");
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o reader");
                e.printStackTrace();
            }
        }
    }
}
