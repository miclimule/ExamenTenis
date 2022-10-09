package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.Compte;
import metier.Faute;

@WebService(name="BanqueWS")
public class BanqueService {
	@WebMethod(operationName="conversionEuroToDh")
	public double conversion(@WebParam(name="montant") double mt) {
		return mt*11.3;
	}
	@WebMethod
	public Compte getCompte(@WebParam(name="code") Long code) {
		return new Compte(code,Math.random()*80000,new Date());
	}
	@WebMethod
	public Faute fauteJ1SansRebons(@WebParam(name="xball") int xball ,@WebParam(name="yball") int yball  , @WebParam(name="width") int width ,@WebParam(name="height") int height ,@WebParam(name="widthTerrain") int  widthTerrain ,@WebParam(name="xTerrain") int  xTerrain) {
		Faute faut = new Faute();
		if (xball>width) {
			faut.setFaute(true);
			faut.setFauteType("FAUTE du joueur1 la balle est sortie a droite du terrain");
			faut.setPoint2(15);
			return faut;
		}
		else if (xball < (widthTerrain+100)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur1 la balle est encore a gauche");
			faut.setPoint2(15);
		}
		else if(xball < (width+xTerrain+10)/2 && xball> (width+xTerrain-10)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur1 la balle a touche les filets");
			faut.setPoint2(15);
		}
		return faut;
	}
	
	@WebMethod
	public Faute fauteJ1AvecRebons(@WebParam(name="xball") int xball ,@WebParam(name="yball") int yball  , @WebParam(name="width") int width ,@WebParam(name="height") int height ,@WebParam(name="widthTerrain") int  widthTerrain ,@WebParam(name="xTerrain") int  xTerrain) {
		Faute faut = new Faute();
		if (xball>width) {
			faut.setFaute(true);
			faut.setFauteType("FAUTE du joueur2 la balle est sortie a droite du terrain");
			faut.setPoint1(15);
			return faut;
		}
		else if (xball < (widthTerrain+100)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur1 la balle est encore a gauche");
			faut.setPoint2(15);
		}
		else if(xball < (width+xTerrain+10)/2 && xball> (width+xTerrain-10)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur1 la balle a touche les filets");
			faut.setPoint2(15);
		}
		return faut;
	}
	
	@WebMethod
	public Faute fauteJ1AxeY(@WebParam(name="xball") int xball ,@WebParam(name="yball") int yball  , @WebParam(name="width") int width ,@WebParam(name="height") int height ,@WebParam(name="widthTerrain") int  widthTerrain ,@WebParam(name="xTerrain") int  xTerrain ,@WebParam(name="xRebons") int  xRebons) {
		Faute faut = new Faute();
		if (yball < 30 || yball > height+50) {
			if ( xRebons == 0) {
				faut.setFaute(true);
				faut.setFauteType("Faute du joueur2 la balle est sortie du terrain , n'a pas ratrapper la balle");
				faut.setPoint1(15);
			}
			else {
				faut.setFaute(true);
				faut.setFauteType("Faute du joueur1 la balle est sortie du terrain");
				faut.setPoint2(15);
			}
		}
		return faut;
	}
	
	@WebMethod
	public Faute fauteJ2SansRebons(@WebParam(name="xball") int xball ,@WebParam(name="yball") int yball  , @WebParam(name="width") int width ,@WebParam(name="height") int height ,@WebParam(name="widthTerrain") int  widthTerrain ,@WebParam(name="xTerrain") int  xTerrain) {
		Faute faut = new Faute();
		if (xball<100) {
			faut.setFaute(true);
			faut.setFauteType("FAUTE du joueur2 la balle est sortie a gauche du terrain");
			faut.setPoint1(15);
			return faut;
		}
		else if (xball > (widthTerrain+100)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur2 la balle est encore a droite");
			faut.setPoint1(15);
		}
		else if(xball < (width+xTerrain+10)/2 && xball> (width+xTerrain-10)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur2 la balle a touche les filets");
			faut.setPoint1(15);
		}
		return faut;
	}
	
	@WebMethod
	public Faute fauteJ2AvecRebons(@WebParam(name="xball") int xball ,@WebParam(name="yball") int yball  , @WebParam(name="width") int width ,@WebParam(name="height") int height ,@WebParam(name="widthTerrain") int  widthTerrain ,@WebParam(name="xTerrain") int  xTerrain) {
		Faute faut = new Faute();
		if (xball<100) {
			faut.setFaute(true);
			faut.setFauteType("FAUTE du joueur2 la balle est sortie a gauche du terrain");
			faut.setPoint1(15);
			return faut;
		}
		else if (xball > (widthTerrain+100)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur1 la balle est encore a droite");
			faut.setPoint2(15);
		}
		else if(xball < (width+xTerrain+10)/2 && xball> (width+xTerrain-10)/2) {
			faut.setFaute(true);
			faut.setFauteType("Faute du joueur1 la balle a touche les filets");
			faut.setPoint2(15);
		}
		return faut;
	}
	
	@WebMethod
	public Faute fauteJ2AxeY(@WebParam(name="xball") int xball ,@WebParam(name="yball") int yball  , @WebParam(name="width") int width ,@WebParam(name="height") int height ,@WebParam(name="widthTerrain") int  widthTerrain ,@WebParam(name="xTerrain") int  xTerrain ,@WebParam(name="xRebons") int  xRebons) {
		Faute faut = new Faute();
		if (yball < 30 || yball > height+50) {
			if ( xRebons == 0) {
				faut.setFaute(true);
				faut.setFauteType("Faute du joueur1 la balle est sortie du terrain , n'a pas ratrapper la balle");
				faut.setPoint2(15);
			}
			else {
				faut.setFaute(true);
				faut.setFauteType("Faute du joueur2 la balle est sortie du terrain");
				faut.setPoint1(15);
			}
		}
		return faut;
	}
	
	@WebMethod
	public List<Compte> getComptes(){
		List<Compte> cptes = new ArrayList<>();
		cptes.add(new Compte(1L,Math.random()*80000,new Date()));
		cptes.add(new Compte(2L,Math.random()*80000,new Date()));
		return cptes;
	}
}
