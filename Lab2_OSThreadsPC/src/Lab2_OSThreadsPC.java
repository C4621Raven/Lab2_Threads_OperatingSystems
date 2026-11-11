public class Lab2_OSThreadsPC 
{
	public static void main(String[] args) 
	{
		Buffers buf = new Buffers(10);
		
		Consumer c = new Consumer(buf);
		Producer p = new Producer(buf);
		
		p.start();
		c.start();
		
		while(true);
	}
}