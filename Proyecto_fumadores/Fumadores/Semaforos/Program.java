package Semaforos;

import java.util.concurrent.Semaphore;

public class Program {

    public static void main(String[] args) {
        
        Mesa mesa = new Mesa();
        
        Semaphore fumadorCerillas = new Semaphore(0, false);
        Semaphore fumadorTabaco = new Semaphore(0, false);
        Semaphore fumadorPapel = new Semaphore(0, false);
        Semaphore semaforoAgente = new Semaphore(1, false);
        Semaphore mutex = new Semaphore(1, false);
        
        Agente agente = new Agente(mutex, fumadorCerillas, fumadorTabaco, fumadorPapel, semaforoAgente, mesa);
        
        Fumador fumador1 = new Fumador("Cerillas", mutex, fumadorCerillas, semaforoAgente, mesa);
        Fumador fumador2 = new Fumador("Tabaco", mutex, fumadorTabaco, semaforoAgente, mesa);
        Fumador fumador3 = new Fumador("Papel", mutex, fumadorPapel, semaforoAgente, mesa);
        
        agente.start();
        fumador1.start();
        fumador2.start();
        fumador3.start();
    }
}
