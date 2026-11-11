import java.util.concurrent.Semaphore;

public class p6Thread extends Thread
{
	Semaphore semA, semB;
	
	static char resourceA = 'A';
	static char resourceB = 'B';
		
	char aqu;

	public void setUp(Semaphore semA, Semaphore semB, char aqu)
	{
		this.semA = semA;
		this.semB = semB;
		this.aqu =aqu;
	}
	
	@Override
	public void run()
	{
		super.run();
		if(aqu == 'A')
		{
			try
			{
				semA.acquire();
				editA();
				semB.acquire();
				editB();
				semB.release();
				semA.release();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				semB.acquire();
				editB();
				semA.acquire();
				editA();
				semA.release();
				semB.release();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void editA()
	{
		System.out.println(resourceA);
	}
	
	private void editB()
	{
		System.out.println(resourceB);
	}
}