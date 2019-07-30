package ua.aleksey;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Location;

public class Geolocation {
	
	public Geolocation() throws IOException, GeoIp2Exception{
		
	}
	private File database = new File("GeoLite2-City.mmdb");
	private DatabaseReader reader = new DatabaseReader.Builder(database).build();
	private InetAddress ipAddress;
	private CityResponse response;
	private Location location;
	
	public Double getLatitude(String IP) throws IOException, GeoIp2Exception {
		ipAddress = InetAddress.getByName(IP);
		response = reader.city(ipAddress);
		location = response.getLocation();
		return location.getLatitude();
	}
	
	public Double getLongitude(String IP) throws IOException, GeoIp2Exception {
		ipAddress = InetAddress.getByName(IP);
		response = reader.city(ipAddress);
		location = response.getLocation();
		return location.getLongitude();
	}
	
	public int getDeg(double DD) {
		
		double coord = DD;
		int sec = (int)Math.round(coord * 3600);
		int deg = sec / 3600;
		sec = Math.abs(sec % 3600);
		sec %= 60;
		return deg;
	}
	
	public int getMin(double DD) {
		
		double coord = DD;
		int sec = (int)Math.round(coord * 3600);
		sec = Math.abs(sec % 3600);
		int min = sec / 60;
		sec %= 60;
		
		return min;
	}
	
	public int getSec(double DD) {
		
		double coord = DD;
		int sec = (int)Math.round(coord * 3600);
		sec = Math.abs(sec % 3600);
		sec %= 60;
		
		return sec;
	}

}
