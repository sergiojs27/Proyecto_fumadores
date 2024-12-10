//Esta clae hará de monitor y maneja los mensajes de el agente.
public class Mesa {
    private int turnoFumador = -1; // -1 indica que no hay fumador activo

    // Método para que el agente seleccione dos ingredientes y active un fumador
    public synchronized void colocarIngredientes(int fumadorId, String ingrediente1, String ingrediente2) {
        while (turnoFumador != -1) {
            try {
                wait(); // Esperar a que un fumador termine de fumar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        turnoFumador = fumadorId;
        System.out.println("El agente pone sobre la mesa " + ingrediente1 + " y " + ingrediente2);
        notifyAll(); // Notificar al fumador correspondiente
    }

    // Método para que un fumador verifique si es su turno
    public synchronized void esperarTurno(int fumadorId) {
        while (turnoFumador != fumadorId) {
            try {
                wait(); // Esperar a que sea su turno
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Método para que un fumador indique que ha terminado de fumar
    public synchronized void terminarTurno() {
        turnoFumador = -1;
        notifyAll(); // Notificar al agente que puede seleccionar de nuevo
    }
}