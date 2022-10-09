package tenis;

import service.BanqueServiceService;
import service.BanqueWS;
import service.Compte;

public class ClientWS {

	public static void main(String[] args) {
		BanqueWS stub = new BanqueServiceService().getBanqueWSPort();
		double res = stub.conversionEuroToDh(800);
		System.out.println("800 euro en DH = " + res);
		Compte cp = stub.getCompte(1L);
		System.out.println(cp.getSolde());
		System.out.println("//////////////////////////////////////////");
		Compte comp = stub.getCompte(2L);
		System.out.println("code : " + comp.getCode() + " solde : " + comp.getSolde());
	}

}
