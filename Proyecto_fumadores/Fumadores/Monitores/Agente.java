import java.util.Random;

public class Agente extends Thread {
    private final Mesa mesa;
    private final Random random;

    public Agente(Mesa mesa) {
        this.mesa = mesa;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // Seleccionar aleatoriamente un fumador (1, 2 o 3)
            int fumadorSeleccionado = random.nextInt(3) + 1;

            switch (fumadorSeleccionado) {
                case 1: // Fumador con tabaco
                    mesa.colocarIngredientes(1, "Papel", "Cerillas");
                    break;
                case 2: // Fumador con papel
                    mesa.colocarIngredientes(2, "Tabaco", "Cerillas");
                    break;
                case 3: // Fumador con cerillas
                    mesa.colocarIngredientes(3, "Tabaco", "Papel");
                    break;
            }

            try {
                Thread.sleep(1000); // Tiempo entre turnos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}