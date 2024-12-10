package Semaforos;

import java.util.concurrent.Semaphore;

public class Fumador extends Thread {
    
    private String ingrediente;
    private Semaphore propio, agente, mutex;
    private Mesa mesa;
    
    public Fumador(String ingrediente, Semaphore mutex, Semaphore propio, Semaphore agente, Mesa mesa) {
        this.ingrediente = ingrediente;
        this.propio = propio;
        this.agente = agente;
        this.mutex = mutex;
        this.mesa = mesa;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                propio.acquire();
                mutex.acquire();

                // Chequear ingredientes antes de proceder
                if (mesa.getIngredientes() != 0) {
                    System.out.println("El fumador que tiene " + ingrediente + " empieza a liarse el cigarro");

                    Thread.sleep(1000); // Simula el tiempo de liar el cigarro
                    
                    System.out.println("El fumador que tiene " + ingrediente + " empieza a fumarse el cigarro");
                    
                    Thread.sleep(1000); // Simula el tiempo de fumar
                    
                    System.out.println("El fumador que tiene " + ingrediente + " acaba de fumar");

                    mesa.setIngredientes(0); // Limpiar la mesa
                }

                agente.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.release();
            }
        }
    }
}
