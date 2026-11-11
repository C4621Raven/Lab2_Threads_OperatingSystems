public class p7Thread extends Thread
{

	static char resourceA = 'A';
	static char resourceB = 'B';
		
	char aqu;

	public void setUp(char aqu)
	{
		this.aqu =aqu;
	}
	
	@Override
	public void run()
	{
		super.run();
		if(aqu == 'A')
		{
			editA();
			editB();
		}
		else
		{
			editB();
			editA();
		}
	}
	
	private synchronized void editA()
	{
		System.out.println(resourceA);
	}
	
	private synchronized void editB()
	{
		System.out.println(resourceB);
	}
}