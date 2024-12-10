
public class FumadorConThread extends Thread{
	
	
	private String ingrediente;
	
	public  FumadorConThread(String ingrediente) 
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
