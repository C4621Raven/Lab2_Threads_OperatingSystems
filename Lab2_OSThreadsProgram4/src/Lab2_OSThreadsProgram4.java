import java.util.concurrent.Semaphore;

public class Lab2_OSThreadsProgram4
{	
	public static void main(String[] args)
	{
		Semaphore semA = new Semaphore(1);
		Semaphore semB = new Semaphore(1);
		
		p4Thread t1 = new p4Thread();
		t1.setUp(semA, semB, 'A');
		
		p4Thread t2 = new p4Thread();
		t2.setUp(semA, semB, 'B');
		
		t1.start();
		t2.start();
	}
}