import java.util.concurrent.*;

public class p3Thread extends Thread
{
	Semaphore mutex;
	
	static int resource = 0;
	int changeVar;
	
	public void setUpThread(int changeVar, Semaphore sem)
	{
		mutex = sem;
		
		this.changeVar = changeVar;
	}
	
	@Override
	public void run()
	{
		super.run();
		
		for(int i = 1; i < 10; i++)
        {
			try
			{
				mutex.acquire();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
          	add();
          	mutex.release();
        }	
	}
	
	private void add()
	{
		int y = changeVar;
		resource+=y;
		y=resource;
		System.out.println(y);
	}
}