package tenis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {

	stade stade;
	Joueur perso1 = new Joueur("mic","A",1,600);
	Joueur perso2 = new Joueur("limule","B",1,600);
	Ball ball = new Ball(200, perso1.yjoueur, 4);
	
	Frame(){
		
		stade = new stade(perso1,perso2,ball);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tenis");
		this.setSize(1500,850);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
 
		JButton btn = new JButton("continue");
		JButton rest = new JButton("restard");
		
		this.add(stade);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stade.ball.setX(200);
				int rand = new Random().nextInt(600-200)+200;
				stade.ball.setY(rand);
				stade.faute = false;
				stade.chekcball = true;
				stade.ball.setDx(1440, 100);
				stade.ball.setDy(800, 0);
				stade.ball.setDirectionRebons(2, 3);
				stade.ball.xdrawRebons = -50;
				stade.ball.ydrawRebons = -50;
			}
		});
		
		btn.setBounds(1500, 0, 100, 100);
		
		rest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stade.ball.setX(200);
				int rand = new Random().nextInt(600-200)+200;
				stade.ball.setY(rand);
				stade.faute = false;
				stade.chekcball = true;
				stade.ball.setDx(1440, 100);
				stade.ball.setDy(800, 0);
				stade.ball.setDirectionRebons(2, 3);
				stade.ball.xdrawRebons = -50;
				stade.ball.ydrawRebons = -50;
				perso1.point = 0;
				perso2.point = 0;
			}
		});
		
		rest.setBounds(1500, 0, 100, 100);
		this.add(rest , BorderLayout.SOUTH);
		this.add(btn , BorderLayout.NORTH);
		this.setVisible(true);
		
	}
	
}
