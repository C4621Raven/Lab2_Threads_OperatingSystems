public class Consumer extends Thread
{
	private Buffers b;
	
	public Consumer(Buffers b)
	{
		this.b = b;
	}
	
	@Override
	public void run()
	{
		super.run();
		while(true)
		{
			System.out.println(b.consume());
		}
	}
	
}