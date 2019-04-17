package Eggs;

public class EggNotBoiledException extends Exception {	
	
	@Override
	public String toString() {
		return "Das Ei ist noch ungekocht.";
	}
}