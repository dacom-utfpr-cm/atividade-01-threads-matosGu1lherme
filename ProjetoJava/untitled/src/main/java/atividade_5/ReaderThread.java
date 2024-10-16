package atividade_5;

import java.util.Scanner;

public class ReaderThread implements Runnable{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite numeros para some:");
    }
}
