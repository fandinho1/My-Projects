package developmentutilities;

import static developmentutilities.BrowserUtilities.*;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class CheckConnection {
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
	public static boolean connectedToInternet2() throws InterruptedException, IOException{		   
		String comando = "ping www.olx.com.co";
		if (java.lang.Runtime.getRuntime().exec (comando).waitFor() == 0) {
			return true;
		} else {
			System.out.println("No hay conexion a internet. Es necesario tener conexion");
			return false;
		}	   
	}
}
