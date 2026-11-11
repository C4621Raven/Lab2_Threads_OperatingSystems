import java.util.concurrent.Semaphore;

public class Lab2_OSThreadsProgram6
{	
	public static void main(String[] args)
	{
		Semaphore semA = new Semaphore(1);
		Semaphore semB = new Semaphore(1);
		
		p6Thread t1 = new p6Thread();
		t1.setUp(semA, semB, 'A');
		
		p6Thread t2 = new p6Thread();
		t2.setUp(semA, semB, 'A');
		
		t1.start();
		t2.start();
	}
}