package co.com.olx.qa.searchwitholx.utils;

import java.net.URL;
import java.net.URLConnection;

public class CheckConnection {
	private static final String URL_PAGE = "https://www.olx.com.co/";
	
	/**
	 * This method verify if the URLConnection from URL_PAGE specified can connect or not
	 * @return true or false if there are internet connection
	 */
	public static boolean connectedToInternet() {
		try {
			URL url = new URL(URL_PAGE);
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
