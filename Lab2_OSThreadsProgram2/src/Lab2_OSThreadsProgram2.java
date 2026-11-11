public class Lab2_OSThreadsProgram2
{	
	public static void main(String[] args)
	{
		p2Thread t1 = new p2Thread();
		t1.setChangeVar(1);
		
		p2Thread t2 = new p2Thread();
		t2.setChangeVar(10);

		t1.start();
		t2.start();
	}
}