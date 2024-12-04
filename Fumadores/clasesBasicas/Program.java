import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		int valor=0;
		
		Scanner src=new Scanner(System.in);
		
		System.out.println("Introduce 1 para ejecutar el programa con la interfaz runnable o introduce 2 para ejecutarlo con la clase Thread");
		
		valor=src.nextInt();
		
		Mesa mesa=new Mesa();
		
		Agente agente=new Agente(mesa);
		
		switch (valor) {
		case 1:
			
			FumadorConRunnable fumadorR1= new FumadorConRunnable("Cerillas");
			FumadorConRunnable fumadorR2= new FumadorConRunnable("Tabaco");
			FumadorConRunnable fumadorR3= new FumadorConRunnable("Papel");
			
			fumadorR1.run();
			fumadorR2.run();
			fumadorR3.run();
			
			break;
		
		case 2:
			
			FumadorConThread fumadort1=new FumadorConThread("Cerillas");
			FumadorConThread fumadort2=new FumadorConThread("Tabaco");
			FumadorConThread fumadort3=new FumadorConThread("Papel");
			
			fumadort1.start();
			fumadort2.start();
			fumadort3.start();
			
			break;

		default:
			
			System.err.println("El valor introducido no corresponde con ninguna de las opciones");
			
			break;
		}
		
		agente.start();
		
	}

}
