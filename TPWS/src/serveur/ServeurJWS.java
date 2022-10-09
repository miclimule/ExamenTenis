package serveur;

import javax.xml.ws.Endpoint;

import service.BanqueService;

public class ServeurJWS {

	public static void main(String[] args) {
		String url = "http://localhost:8585/";
		Endpoint.publish(url, new BanqueService());
		System.out.println(url);
	}

}
