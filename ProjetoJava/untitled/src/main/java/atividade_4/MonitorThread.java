package atividade_4;

import java.util.Iterator;
import java.util.List;

public class MonitorThread implements Runnable{
    private final List<Thread> threadsToMonitor;

    public MonitorThread(List<Thread> threadsToMonitor) {
        this.threadsToMonitor = threadsToMonitor;
    }

    @Override
    public void run() {
        while (true) {
            Iterator<Thread> iterator = threadsToMonitor.iterator();
            while (iterator.hasNext()) {
                Thread thread = iterator.next();
                if (thread.isInterrupted()) {
                    System.out.println("A thread " + thread.getName() + " foi interrompida");
                    iterator.remove();
                }
            }

            if (threadsToMonitor.isEmpty()) {
                System.out.println("Todas as threads foram interrompidas, Finalizando monitoramento");
                break;
            }

            //Dorme a cada iteração completa na lista das threads
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread Monitora foi interrompida!");
                return;
            }
        }
    }
}
