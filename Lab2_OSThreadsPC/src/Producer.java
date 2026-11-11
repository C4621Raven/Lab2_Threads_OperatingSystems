public class Producer extends Thread
{
	private Buffers b;
	private Integer id = 0;
	
	public Producer(Buffers b)
	{
		this.b=b;
	}
	
	@Override
	public void run()
	{
		super.run();
		while(true)
		{
			b.produce(id);
			id++;
		}
	}

}