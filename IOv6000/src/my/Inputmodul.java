package my;

import java.io.File;
import java.io.IOException;

import Eggs.Ei;
public class Inputmodul extends Thread 
{
	public static int counter=0;
	public static int counter2=0;
	int inputPosition = 0;
	CheckRingbuffer buffer;
	
	public Inputmodul(CheckRingbuffer buffer) throws IOException
	{
		this.buffer = buffer;		
	}
	
	@Override
	public void run() 
	{
		try
		{
			Ei [][] Egglogs = null;
			
			while(counter <10)
			{
				Egglogs = EierFileConverter.fileToEier((counter+1)+"-Eierlog.txt");
				System.out.println("Datei "+(counter+1)+"-Eierlog.txt eingelesen");
				counter++;
			}
			
			counter =0;
			
			while(counter < 10)
			{
				while(counter2 < 10)
				{
					buffer.enqueue(Egglogs[counter][counter2]);
					counter++;
					counter2++;
					Thread.sleep(100);
				}
			}
		}
		catch(IOException | BufferOverflowException e)
		{
			e.printStackTrace();
		} 
		catch (InterruptedException e) 
		{
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}
	}
}
