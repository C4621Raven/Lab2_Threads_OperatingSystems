public class Lab2_OSThreadsProgram1
{	
	public static void main(String[] args)
	{
		p1Thread t1 = new p1Thread();
		t1.setChangeVar(1);
		
		p1Thread t2 = new p1Thread();
		t2.setChangeVar(10);

		t1.start();
		t2.start();
	}
}