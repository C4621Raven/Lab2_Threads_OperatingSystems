import java.util.concurrent.*;

public class Lab2_OSThreadsProgram3
{	
	public static void main(String[] args)
	{
		Semaphore mutex = new Semaphore(1);
		
		p3Thread t1 = new p3Thread();
		t1.setUpThread(1, mutex);
		
		p3Thread t2 = new p3Thread();
		t2.setUpThread(10, mutex);

		t1.start();
		t2.start();
	}
}