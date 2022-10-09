package tenis;

import java.util.Random;

public class Ball {
	
	public int x;
	public int y;
	public int dx;
	public int dy;
	public int xRebons;
	public int yRebons;
	public boolean positionDepart;
	public boolean positionArrive;
	public int vitesse;
	public int direction;
	public int xdrawRebons;
	public int ydrawRebons;
	
	
	public int getDirection() {
		return direction;
	}

	public void setDirection() {
		this.direction = new Random().nextInt(2);
	}

	public int getDx() {
		return dx;
	}
	
	public void setDirectionRebons(int max , int min) {
		this.xRebons = (dx*30)/100;
		this.yRebons = (dy*30)/100;
	}

	public void setDx(int max , int min) {
		this.dx = new Random().nextInt(max - min) + min;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int max , int min) {
		this.dy = new Random().nextInt(max - min) + min;
		this.direction = new Random().nextInt(2);
	}
	
	public Ball(int x, int y, int vitesse) {
		super();
		this.x = x;
		this.y = y;
		this.vitesse = vitesse;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
}
