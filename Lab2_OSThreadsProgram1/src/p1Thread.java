public class p1Thread extends Thread
{
	static int resource = 0;
	int changeVar;
	
	public void setChangeVar(int changeVar)
	{
		this.changeVar = changeVar;
	}
	
	@Override
	public void run()
	{
		super.run();
		
		for(int i = 1; i < 10; i++)
        {
          	add();
        }	
	}
	
	private void add()
	{
		int y = changeVar;
		resource+=y;
		y=resource;
		System.out.println(y);
	}
}