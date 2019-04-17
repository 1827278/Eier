package Eggs;

import java.util.Calendar;
import java.util.Random;

public class Ei {
	
	private Eigroesse groesse = null;	
	private String legedatum = null;
	private int gewicht = 0;
	private boolean defekt = false;
	
	public Ei() {
		legeEi(5);		
	}
	
	public Ei(int ausschussrate) {		
		legeEi(ausschussrate);		
	}
	
	public Ei (Ei ei) {
		this.gewicht = ei.getGewicht();
		this.groesse = ei.getGroesse();
		this.legedatum = ei.getLegedatum();
		this.defekt = ei.getDefekt();
	}

	public Ei (int gewicht, Eigroesse groesse, String legedatum, boolean defekt) {
		this.gewicht = gewicht;
		this.groesse = groesse;
		this.legedatum = legedatum;
		this.defekt = defekt;
	}
	
	private void legeEi(int ausschussrate) {
		int minGewicht = 40;
		int maxGewicht = 80;
		Random rand = new Random();
		gewicht = rand.nextInt(maxGewicht-minGewicht)+minGewicht;
		setGewicht(gewicht);

		//prozentuale Wahrscheinlichkeit auf einen Defekt
		if (rand.nextInt(100) < ausschussrate) {
			defekt = true;
		}			
			
		this.legedatum = Calendar.getInstance().getTime().toString();
	}
	
	
	public Eigroesse getGroesse() {
		return groesse;
	}
	
	public String getLegedatum() {
		return legedatum;
	}
	
	public int getGewicht() {
		return gewicht;
	}
	
	public boolean getDefekt() {
		return defekt;
	}

	
	public void setLegedatum(String legedatum) {
		if (this.legedatum == null) {
			this.legedatum = legedatum;
		}		
	}
	
	public void setGewicht(int gewicht) {
		if (this.gewicht >= 0) {
			this.gewicht = gewicht;
			if (gewicht < 53) {
				groesse = Eigroesse.S;
			}
			else if (gewicht < 63) {
				groesse = Eigroesse.M;
			}
			else if (gewicht < 74) {
				groesse = Eigroesse.L;
			}
			else {
				groesse = Eigroesse.XL;
			}
		}
	}
	
	public void setDefekt(boolean defekt) {
		if (!this.defekt) {
			this.defekt = defekt;
		}								
	}

	static public int codeid() {
		return 1723;
	}
}