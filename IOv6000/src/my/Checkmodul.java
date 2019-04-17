package my;
import Eggs.*;
import java.io.File;

import Eggs.*;
public class Checkmodul extends Thread
{
	int checkPosition = 0;
	CheckRingbuffer buffer;	
	
	public Checkmodul(CheckRingbuffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		for(int i = 0; i <= 49; i++)
		{
			try 
			{
				buffer.checkEgg();
				Thread.sleep(50);
			}
			catch (BufferUnderflowException | InterruptedException e) 
			{
				// TODO Automatisch generierter Erfassungsblock
				e.printStackTrace();
			}
		}
	}
}
