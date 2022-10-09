package tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Joueur {
	
	public int id;
	public String name;
	public int point;
	public String equipe;
	public int vitesse;
	public int puissanceTire;
	int yjoueur;
	
	public Joueur() {
		super();
	}

	public Joueur(String name, String equipe , int v , int y) {
		super();
		this.name = name;
		this.equipe = equipe;
		this.vitesse = v;
		this.yjoueur = y;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	
	
	
}
