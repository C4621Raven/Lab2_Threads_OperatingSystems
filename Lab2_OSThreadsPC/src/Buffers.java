import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Buffers
{
	int N = 10; //buffer size
	
	Semaphore mutex = new Semaphore(1);
	Semaphore empty = new Semaphore(N);
	Semaphore full = new Semaphore(0);
	
	LinkedList<Integer> buff = new LinkedList<Integer>();
	
	public Buffers(int N)
	{
		this.N = N;
	}
	
	public void produce(Integer input)
	{
		try
		{
			empty.acquire();
			mutex.acquire();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		buff.push(input);
		mutex.release();
		full.release();
	}
	
	public Integer consume()
	{
		Integer out = null;
		try
		{
			full.acquire();
			mutex.acquire();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		out = buff.removeLast();
		mutex.release();
		empty.release();
		return out;
	}

}
