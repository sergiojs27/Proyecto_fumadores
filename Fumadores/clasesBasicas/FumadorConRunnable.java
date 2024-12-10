
public class FumadorConRunnable implements Runnable {
	
private String ingrediente;
	
	public  FumadorConRunnable(String ingrediente) 
	{
		this.ingrediente=ingrediente;
	}
	
	public void run() 
	{
	
		for (int i = 0; i < 5; i++) {
			
			System.out.println("El fumador que tiene "+ingrediente+" empieza a liarse el cigarro");
			
			System.out.println("El fumador que tiene "+ingrediente+" empieza a fumarse el cigarro");
			
			System.out.println("El fumador que tiene "+ingrediente+" acaba de fumar");
			
			
		}
		
	}

}
