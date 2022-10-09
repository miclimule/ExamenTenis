package tenis;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;

import service.BanqueServiceService;
import service.BanqueWS;
import service.Faute;

public class stade extends JPanel {
		
	Color color = Color.white;
	Joueur j1;
	Joueur j2;
	Ball ball;
	int x = 40;
	int y = 30;
	int width = 1400;
	int height = 700;
	int widthTerrain = (width*95)/100;
	int heightTerrain = (height*95)/100;
	int xTerrain = 75;
	int yTerrain = 50;
	
	int initialService;
	
	boolean chekc = true;
	boolean chekc2 = true;
	boolean chekcball = true;
	
	boolean faute = false;
	boolean fin = false;
	
	stade(){
	}
	
	public stade(Joueur perso1, Joueur perso2, Ball ball) {
		this.j1 = perso1;
		this.j2 = perso2;
		this.ball = ball;
		this.ball.setDx(width, 100);
		this.ball.setDy(height, 0);
		this.ball.setDirectionRebons(height, 50);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		zone(g);
		Terrain(g);
		TerrainHaut(g);
		Terrainbas(g);
		TerrainJoueurNord(g);
		TerrainJoueurSud(g);
		TerrainSeparationMilieu(g);
		TerrainFilet(g);
		//joueur(g);
		//joueur2(g);
		ball(g);
	}
	
	public void joueur(Graphics g) {
//		if (j1.yjoueur<120) {
//			chekc = false;
//		}
//		else if (j1.yjoueur>=600) {
//			chekc = true;
//		}
//		if (chekc) {
//			j1.yjoueur--;
//		}
//		else {
//			j1.yjoueur++;
//		}
		g.setColor(Color.black);
		g.fillRect(180, ball.y, 20, 40);
		//repaint();
	}
	
	public void joueur2(Graphics g) {
//		if (j2.yjoueur<120) {
//			chekc = false;
//		}
//		else if (j2.yjoueur>=600) {
//			chekc = true;
//		}
//		if (chekc) {
//			j2.yjoueur--;
//		}
//		else {
//			j2.yjoueur++;
//		}
		g.setColor(Color.black);
		g.fillRect(1300, ball.y, 20, 40);
//		try {
//			Thread.sleep(1);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		//repaint();
	} 
	
	public void ball(Graphics g) {
		// true = left 
		// false = right
		if (j1.point<50 && j2.point<50) {
			if (!faute) {
				BanqueWS stub = new BanqueServiceService().getBanqueWSPort();
				if (chekcball) {
					if(ball.dx<=0) {
						if (ball.xRebons==0) {
							ball.setDx(width+40, 100);
							ball.setDy(height+100, 0);
							ball.setDirectionRebons(height, 50);
							ball.setDirection();
							chekcball = false;
							// WS
							Faute faut = stub.fauteJ1AvecRebons(ball.x, ball.y, width, height, widthTerrain, xTerrain);
							System.out.println(faut.getFauteType());
							faute = faut.isFaute();
							j1.point+=faut.getPoint1();
							j2.point+=faut.getPoint2();
						}
						else {
							ball.dx=ball.xRebons;
							ball.dy=ball.yRebons;
							ball.xRebons = 0;
							ball.ydrawRebons = ball.y;
							ball.xdrawRebons = ball.x;
							// WS
							Faute faut = stub.fauteJ1SansRebons(ball.x, ball.y, width, height, widthTerrain, xTerrain);
							System.out.println(faut.getFauteType());
							faute = faut.isFaute();
							j1.point+=faut.getPoint1();
							j2.point+=faut.getPoint2();
						}
						
					}
					if (ball.dy != 0) {
						if (ball.direction == 1) {
							ball.y += 1;
							ball.dy--;
						}
						else {
							ball.y -= 1;
							ball.dy--;
						}
					}
					if (ball.y < 30 || ball.y > height+50) {if (ball.xRebons == 0) {faute = true;System.out.println("Faute du joueur2 " + j2.name + " la balle est sortie du terrain , n'a pas ratrapper la balle");j1.point+=15;}
						else {
							faute = true;
							System.out.println("Faute du joueur1 " + j1.name + " la balle est sortie du terrain");
							j2.point+=15;
						}
					}
					ball.x+=ball.vitesse;
					ball.dx-=ball.vitesse;
				}
				else {
					if(ball.dx<=0) {
						if (ball.xRebons==0) {
							ball.setDx(width+40, 100);
							ball.setDy(height+100, 30);
							ball.setDirectionRebons(height, 50);
							ball.setDirection();
							chekcball = true;
							// WS
							Faute faut = stub.fauteJ2AvecRebons(ball.x, ball.y, width, height, widthTerrain, xTerrain);
							System.out.println(faut.getFauteType());
							faute = faut.isFaute();
							j1.point+=faut.getPoint1();
							j2.point+=faut.getPoint2();
						}
						else {
							ball.dx=ball.xRebons;
							ball.dy=ball.yRebons;
							ball.xRebons = 0;
							ball.ydrawRebons = ball.y;
							ball.xdrawRebons = ball.x;
							// WS
							Faute faut = stub.fauteJ2SansRebons(ball.x, ball.y, width, height, widthTerrain, xTerrain);
							System.out.println(faut.getFauteType());
							faute = faut.isFaute();
							j1.point+=faut.getPoint1();
							j2.point+=faut.getPoint2();
						}
						
					}
					if (ball.dy != 0) {
						if (ball.direction == 1) {
							ball.y += 1;
							ball.dy--;
						}
						else {
							ball.y -= 1;
							ball.dy--;
						}
						
					}
					if (ball.y < 30 || ball.y > height+30) {
						if (ball.xRebons == 0) {
							faute = true;
							System.out.println("Faute du joueur1 " + j1.name + " la balle est sortie du terrain , n'a pas ratrapper la balle");
							j2.point+=15;
						}
						else {
							faute = true;
							System.out.println("Faute du joueur2 " + j2.name + " la balle est sortie du terrain");
							j1.point+=15;
						}
					}
					ball.x-=ball.vitesse;
					ball.dx-=ball.vitesse;
					
				}
			}
		}
		else {
			if (!fin) {
				OracleConnection o = new OracleConnection();
				o.open_connection_psql();
				try {
					o.stmt.executeQuery("insert into match (pointj1,pointj2,joueur1,joueur2) values ("+j1.point+","+j2.point+",'"+j1.name+"','"+j2.name+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				o.close_connection_psql();
				fin = true;
			}
			
		}
		
		g.setColor(Color.white);
		g.fillOval(ball.x, ball.y, 20, 20);
		
		g.setColor(Color.red);
		g.drawOval(ball.xdrawRebons-5, ball.ydrawRebons-5, 30, 30);
		
		g.setColor(Color.black);
		g.drawString(Integer.toString(j1.point), 700, 50);
		
		g.setColor(Color.black);
		g.drawString(Integer.toString(j2.point), 770, 50);
		repaint();
	}
	
	
	
	
	
	//////////////////////////////////////////////////  TERRAIN  /////////////////////////////////////////////// 
	
	public void zone(Graphics g) {
		g.setColor(new Color(30,170,37));
		g.fillRect(x, y, width, height);
	}
	
	public void Terrain(Graphics g) {
		g.setColor(color);
		g.drawRect(xTerrain, yTerrain, widthTerrain, heightTerrain);
	}
	
	public void TerrainHaut(Graphics g) {
		g.setColor(color);
		g.drawRect(xTerrain, yTerrain, widthTerrain, (heightTerrain*10)/100);	
	}
	
	public void Terrainbas(Graphics g) {
		g.setColor(color);
		g.drawRect(xTerrain, yTerrain+600, widthTerrain, (heightTerrain*10)/100);	
	}
	
	public void TerrainJoueurNord(Graphics g) {
		g.setColor(color);
		g.drawRect(xTerrain, yTerrain+(heightTerrain*10)/100, (widthTerrain*20)/100, (heightTerrain*80)/100);	
	}
	
	public void TerrainJoueurSud(Graphics g) {
		g.setColor(color);
		g.drawRect(widthTerrain-((widthTerrain*20)/100)+xTerrain, yTerrain+(heightTerrain*10)/100, (widthTerrain*20)/100, (heightTerrain*80)/100);	
	}
	
	public void TerrainSeparationMilieu(Graphics g) {
		g.setColor(color);
		g.drawLine(xTerrain+(widthTerrain*20)/100, (yTerrain+height+30)/2, widthTerrain-((widthTerrain*20)/100)+xTerrain, (yTerrain+height+30)/2);	
	}
	
	public void TerrainFilet(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine((width+xTerrain)/2, y, (width+xTerrain)/2, y+height);
		g.fillOval(((width+xTerrain)/2)-10, y, 20, 20);
		g.fillOval(((width+xTerrain)/2)-10, y+height-20, 20, 20);
	}
}
