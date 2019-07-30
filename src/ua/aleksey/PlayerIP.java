package ua.aleksey;
import java.net.*;
import java.io.*;

public class PlayerIP {
	
	private String adress;

	public String getAdress() throws IOException {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine(); //Получить IP в строку
		adress = ip;
		return adress;
	}

}
