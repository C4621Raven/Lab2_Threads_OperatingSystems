public class Lab2_OSThreadsProgram7
{	
	public static void main(String[] args)
	{		
		p7Thread t1 = new p7Thread();
		t1.setUp('A');
		
		p7Thread t2 = new p7Thread();
		t2.setUp('A');
		
		t1.start();
		t2.start();
	}
}