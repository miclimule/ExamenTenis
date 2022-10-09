package tenis;

public class Match {
	public int id;
	
	public int pointj1;
	public int pointj2;
	public String joueur1;
	public String joueur2;
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getPOINTJ1() {
		return pointj1;
	}
	public void setPOINTJ1(int pOINTJ1) {
		pointj1 = pOINTJ1;
	}
	public int getPOINTJ2() {
		return pointj2;
	}
	public void setPOINTJ2(int pOINTJ2) {
		pointj2 = pOINTJ2;
	}
	public String getJOUEUR1() {
		return joueur1;
	}
	public void setJOUEUR1(String jOUEUR1) {
		joueur1 = jOUEUR1;
	}
	public String getJOUEUR2() {
		return joueur2;
	}
	public void setJOUEUR2(String jOUEUR2) {
		joueur2 = jOUEUR2;
	}
	public Match(int pOINTJ1, int pOINTJ2, String jOUEUR1, String jOUEUR2) {
		super();
		pointj1 = pOINTJ1;
		pointj2 = pOINTJ2;
		joueur1 = jOUEUR1;
		joueur2 = jOUEUR2;
	}
	public Match() {
		super();
	}
	
	
}
