package my;

import Eggs.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class EierFileConverter 
{
	static int counter = 0;
	public static int eierToFile(Ei[][] eier, String filename) throws IOException 
	{
		File EggLog = new File(filename);
		EggLog.createNewFile();
		FileOutputStream StreamWrite = new FileOutputStream(EggLog);
		
		for (int i = 0; i < eier.length; i++) 
		{
			for (int j = 0; j < eier[i].length; j++)
			{
				Ei egg = eier[i][j];
				StreamWrite.write
				((i + "|" + j + "|" + egg.getGewicht() + "|" + egg.getGroesse() + 
			    "|" + egg.getLegedatum()+ "|" + egg.getDefekt() + "\r\n").getBytes());
						
			}
		}
		StreamWrite.close();
		return counter++;
	}

	/**
	 * Converts the file in which the last eggs where written to an Ei[][]
	 * 
	 * @param number of file
	 * @return the eggs
	 * @throws IOException
	 */
	public static Ei[][] fileToEier(String filename) throws IOException
	{
		File EggLog = new File(filename);
		BufferedReader StreamRead = new BufferedReader(new FileReader(EggLog));
		ArrayList<String> lines = new ArrayList<String>();
		
		while (lines.add(StreamRead.readLine()) && lines.get(lines.size() - 1) != null)
		{}
		
		int xSize = Integer.parseInt(lines.get(lines.size()-2).split("\\|")[0]) + 1;
		int[] ySizes = new int[xSize];
		int lastYSize = 0;
		int count = 0;
		
		for(String line : lines) 
		{
			if (line != null && !line.equals(""))
			{
				int foundYSize = Integer.parseInt(line.split("\\|")[1]) + 1;
				if(foundYSize < lastYSize) 
				{
					ySizes[count++] = lastYSize;
				}
				lastYSize = foundYSize;
			}
		}
		
		ySizes[count] = lastYSize;
		Ei[][] eier = new Ei[xSize][];		
		for(int i = 0; i < eier.length; i++) 
		{
			eier[i] = new Ei[ySizes[i]];
		}
		
		count = 0;
		for (int i = 0; i < xSize; i++) 
		{
			for (int j = 0; j < ySizes[i]; j++)
			{
				String line = lines.get(count);
				if (line != null && !line.equals("")) 
				{
					String[] splitLine = line.split("\\|");
					int gewicht = Integer.parseInt(splitLine[2]);
					Eigroesse size =  gewicht < 53 ? Eigroesse.S
									: gewicht < 63 ? Eigroesse.M 
									: gewicht < 74 ? Eigroesse.L :
													 Eigroesse.XL;
					eier[i][j] = new Ei(gewicht, size, splitLine[4], splitLine[5].equals("true") ? true : false);
					count++;
				}
			}
		}
		StreamRead.close();		
		return eier;
	}
}