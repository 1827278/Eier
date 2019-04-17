package my;
import Eggs.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main 
{
	public static int AnzDateien = 10;
	public static int AnzEier = 50; //min.50 max 5000
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, FarmDeliveryQuantityException, InterruptedException 
	{
		//creating objects
		Huehnerfarm ChickenFarm = new Huehnerfarm();
		EierFileConverter transit = new EierFileConverter();		
		Ei[][][] eggs = new Ei[AnzDateien][][];
		
		//creating Eggs
		for(int i = 0; i < eggs.length; i++)
		{
			eggs[i] = ChickenFarm.liefereEier(AnzEier);
		}
		//b)
		//convert Eggs to File
		for (int i = 0; i < eggs.length; i++)
		{			
			transit.eierToFile(eggs[i],(i+1)+"-Eierlog.txt");
			System.out.println("Datei "+(i+1)+"-Eierlog.txt erstellt");
		}
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println(AnzDateien+" Dateien wurden erstellt und werden jetzt wieder eingelesen");
		System.out.println("----------------------------------------------------------------------");
		//c)
		//Convert the Files again to Eggs
		for (int i = 0; i < eggs.length; i++)
		{
			transit.fileToEier((i+1)+"-Eierlog.txt");
			System.out.println("Datei "+(i+1)+"-Eierlog.txt eingelesen");
		}
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Eier wurden wieder eingelesen");
		System.out.println("----------------------------------------------------------------------");
		//Aufgabe 2
		
	}
	

}