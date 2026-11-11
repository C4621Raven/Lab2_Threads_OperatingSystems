public class Lab2_OSThreadsProgram5
{	
	public static void main(String[] args)
	{		
		p5Thread t1 = new p5Thread();
		t1.setUp('A');
		
		p5Thread t2 = new p5Thread();
		t2.setUp('B');
		
		t1.start();
		t2.start();
	}
}