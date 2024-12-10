package Semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Agente extends Thread {

    private Mesa mesa;
    private Semaphore mutex, propio, cerillas, tabaco, papel;

    public Agente(Semaphore mutex, Semaphore fumadorCerillas, Semaphore fumadorTabaco, Semaphore fumadorPapel, Semaphore semaforoAgente, Mesa mesa) {
        this.mesa = mesa;
        this.cerillas = fumadorCerillas;
        this.propio = semaforoAgente;
        this.mutex = mutex;
        this.tabaco = fumadorTabaco;
        this.papel = fumadorPapel;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                propio.acquire();

                Random rnd = new Random();
                int aleatorio = rnd.nextInt(3);

                mutex.acquire();
                mesa.setIngredientes(aleatorio);
                mutex.release();

                Thread.sleep(500); // Simula el tiempo para poner los ingredientes en la mesa

                switch (aleatorio) {
                    case 0:
                        System.out.println("El agente suelta papel y tabaco");
                        cerillas.release();
                        break;

                    case 1:
                        System.out.println("El agente suelta tabaco y cerillas");
                        papel.release();
                        break;

                    case 2:
                        System.out.println("El agente suelta cerillas y papel");
                        tabaco.release();
                        break;

                    default:
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
