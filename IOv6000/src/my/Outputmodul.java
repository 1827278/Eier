package my;

import java.io.File;

public class Outputmodul extends Thread
{
	int outputPosition = 0;
	CheckRingbuffer buffer;
	File [] Egglogs = new File[10];
	
	public Outputmodul(CheckRingbuffer buffer)
	{
		this.buffer = buffer;
	}
}
