package my;
import Eggs.Ei;

public class CheckRingbuffer 
{	
	Ei [] Ringpuffer = new Ei[50];
	public int inUse;
	public int position;
	
	public void enqueue(Ei input) throws BufferOverflowException
	{
		try 
		{
			int i = 0;
			while(true)
			{
				if(Ringpuffer[i] == null)
				{
					break;
				}
				i++;
				if(i == 50)
				{
					throw new BufferOverflowException();
				}
			}
			Ringpuffer[i] = input;
		}
		catch(BufferOverflowException ex)
		{ 
			throw ex;
		}
		inUse++;
	}
	public boolean checkEgg() throws BufferUnderflowException
	{
		try
		{
			if(Ringpuffer[position] == null) 
			{
				throw new BufferUnderflowException();
			}
			else if(Ringpuffer[position].getDefekt() == true)
			{
				Ringpuffer[position] = null;
				return false;
			}
			else if(Ringpuffer[position].getDefekt() == true)
			{
				return true;
			}
		}
		catch(BufferUnderflowException ex)
		{
			throw ex;
		}
		return false;
	}
	public Ei dequeue() throws BufferUnderflowException
	{
		try
		{
			int i = 0;
			while(Ringpuffer[position+i] == null)
			{
				i++;
				if(position+i > 49)
				{
					throw new BufferUnderflowException();				
				}
			}		
			return Ringpuffer[position+i];
		}
		catch(BufferUnderflowException ex)
		{
			throw ex;
		}		
	}
}
