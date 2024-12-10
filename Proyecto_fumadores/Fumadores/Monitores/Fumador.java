public class Fumador extends Thread {
    private final String ingredientePropio;
    private final Mesa mesa;
    private final int idFumador;

    public Fumador(String ingrediente, Mesa mesa, int idFumador) {
        this.ingredientePropio = ingrediente;
        this.mesa = mesa;
        this.idFumador = idFumador;
    }

    @Override
    public void run() {
        while (true) {
            // Esperar a que sea su turno
            mesa.esperarTurno(idFumador);

            // Simular liar y fumar
            liarCigarro();
            fumar();

            // Notificar que ha terminado
            mesa.terminarTurno();
        }
    }

    private void liarCigarro() {
        System.out.println("Fumador con " + ingredientePropio + " está liando un cigarro.");
        try {
            Thread.sleep(1000); // Tiempo para liar el cigarro
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void fumar() {
        System.out.println("Fumador con " + ingredientePropio + " está fumando.");
        try {
            Thread.sleep(2000); // Tiempo para fumar
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Fumador con " + ingredientePropio + " termina de fumar.");
    }
}
