public class Principal {
	public static void main(String[] args) {
		 // Crear el monitor (mesa compartida)
        Mesa mesa = new Mesa();

        // Crear e iniciar los hilos para los fumadores
        Fumador fumadorTabaco = new Fumador("Tabaco", mesa, 1);
        Fumador fumadorPapel = new Fumador("Papel", mesa, 2);
        Fumador fumadorCerillas = new Fumador("Cerillas", mesa, 3);

        fumadorTabaco.start();
        fumadorPapel.start();
        fumadorCerillas.start();

        // Crear e iniciar el hilo para el agente
        Agente agente = new Agente(mesa);
        agente.start();
    }
}
