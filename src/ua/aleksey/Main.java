package ua.aleksey;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.*;
		
public class Main {
	
	public static void main(String[] args) throws IOException, GeoIp2Exception {
		Geolocation location = new Geolocation();
		PlayerIP ip = new PlayerIP();
		Coordinates coordinates = new Coordinates();
		
		coordinates.http_get("http://earth.motfe.net/coords.php?scale=1000&longitude_hou="
				+ location.getDeg(location.getLongitude(ip.getAdress())) + "&longitude_min="
						+ location.getMin(location.getLongitude(ip.getAdress())) + "&longitude_sec="
								+ location.getSec(location.getLongitude(ip.getAdress())) + "&longitude_pol=N&latitude_hou="
										+ location.getDeg(location.getLatitude(ip.getAdress())) + "&latitude_min="
												+ location.getMin(location.getLatitude(ip.getAdress())) + "&latitude_sec="
														+ location.getSec(location.getLatitude(ip.getAdress())) + "&latitude_pol=E");
		coordinates.getCoords();
	}
	
}
