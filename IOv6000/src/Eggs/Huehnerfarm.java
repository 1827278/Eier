package Eggs;

import java.io.File;
import java.util.ArrayList;

import my.EierFileConverter;

public class Huehnerfarm {
	private static final int EIERKARTONGROESSE = 25;
	private static final int DEFAULT_AUSSCHUSS = 5;
		
	private int minMenge = 50;
	private int maxMenge = 5000;
	
	public Huehnerfarm() {		
	}
	
	public Huehnerfarm(int minMenge, int maxMenge) throws FarmDeliveryQuantityException {
		if (minMenge <= maxMenge) {
			//min- und max-Liefermenge festlegen
			this.minMenge = minMenge;
			this.maxMenge = maxMenge;
		}
		else {
			throw new FarmDeliveryQuantityException("Die minMenge muss kleiner/gleich als die maxMenge sein!");
		}
	}
	
	
	public Ei[][] liefereEier(int menge) throws FarmDeliveryQuantityException {
		//Eier liefern ohne Ausschussangabe -> defaultwert
		return liefereEier(menge, DEFAULT_AUSSCHUSS);
	}	
	
	public Ei[][] liefereEier(int menge, int ausschuss) throws FarmDeliveryQuantityException {
		Ei[][] eierkartonstapel = null;
		
		if (ausschuss < 0 || ausschuss > 100) {
			//Ausschuss out of range
			ausschuss = DEFAULT_AUSSCHUSS;
		}
		
		if (menge < minMenge || menge > maxMenge) {
			//auﬂerhalb der Bestellbereichs bestellt
			throw new FarmDeliveryQuantityException(menge, minMenge, maxMenge);
		}
		else {
			eierkartonstapel = erstelleEierkartonstapel(menge);			
			
			for (int i=0; i<eierkartonstapel.length; i++) {
				for (int j=0; j<eierkartonstapel[i].length; j++) {
					//produziere Eier
					eierkartonstapel[i][j] = new Ei(ausschuss);					
				}			
			}
		}
		return eierkartonstapel;
	}


	public static Ei[][] erstelleEierkartonstapel(int anzahlEier) {
		Ei[][] eierkartonstapel;
		
		int anzPaletten = anzahlEier / EIERKARTONGROESSE;
		int anzRestEier = anzahlEier % EIERKARTONGROESSE;
		
		if (anzRestEier > 0) {
			//geht nicht genau auf -> es gibt noch eine kleinere Palette
			anzPaletten++;
		}				
		
		eierkartonstapel = new Ei[anzPaletten][];
		
		for (int i=0; i<anzPaletten; i++) {
			if (i == anzPaletten-1 && anzRestEier > 0  ) {
				//letzte Palette ist nicht ganz gefuellt
				eierkartonstapel[i] = new Ei[anzRestEier];
			}
			else {
				//volle Palettengroesse
				eierkartonstapel[i] = new Ei[EIERKARTONGROESSE];
			}			
		}				
		
		return eierkartonstapel;
	}	
	/*
	private Ei[][] erstelleEierkartonstapel(int anzahlEier) {
		return erstelleEierkartonstapel(anzahlEier, EIERKARTONGROESSE);
	}
	public static Ei[][] erstelleEierkartonstapel(int anzahlEier, int eierkartongroesse) {
		Ei[][] eierkartonstapel;
		int anzPaletten = anzahlEier / eierkartongroesse;
		int anzRestEier = anzahlEier % eierkartongroesse;
		if (anzRestEier > 0) {
			//geht nicht genau auf -> es gibt noch eine kleinere Palette
			anzPaletten++;
		}
		eierkartonstapel = new Ei[anzPaletten][];
		for (int i=0; i<anzPaletten; i++) {
			if (i == anzPaletten-1 && anzRestEier > 0  ) {
				//letzte Palette ist nicht ganz gefuellt
				eierkartonstapel[i] = new Ei[anzRestEier];
			}
			else {
				//volle Palettengroesse
				eierkartonstapel[i] = new Ei[eierkartongroesse];
			}
		}
		return eierkartonstapel;
	}
	*/
}