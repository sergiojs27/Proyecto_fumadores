import java.util.Random;

public class Agente extends Thread {
	
	private Mesa mesa;
	
	public Agente(Mesa mesa) 
	{
		this.mesa=mesa;
	}
	
	
	public void run() 
	{
		for (int i = 0; i < 5; i++) {
			
			Random rnd=new Random();
			
			int aleatorio=rnd.nextInt(3);
			
			mesa.setIngredientes(aleatorio);
			
			switch (aleatorio) {
			case 0:
				
				System.out.println("El agente suelta papel y tabaco");
				
				break;
				
			case 1:
				
				System.out.println("El agente suelta tabaco y cerillas");
				
				break;
				
			case 2:
				
				System.out.println("El agente suelta cerillas y tabaco");
				
				break;

			default:
				break;
			}
			
		}
		
	}
	
		

}
