package ua.aleksey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {
	
	private String response;
	private int X;
	private int Z;
	private Pattern pattern;
	private Matcher matcher;
	
	public void http_get(String URL) throws IOException {
        URL coords = new URL(URL);
        URLConnection yc = coords.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
         //   System.out.println(inputLine);
        setResponse(getResponse() + (inputLine));
        in.close();
	}
	

	public void getCoords() {
		pattern = Pattern.compile("(?<=X:)-?[0-9]\\w*");
        matcher = pattern.matcher(response);
        while(matcher.find())
           setX(Integer.parseInt(matcher.group()));
        
		pattern = Pattern.compile("(?<=Z:)-?[0-9]\\w*");
        matcher = pattern.matcher(response);
        while(matcher.find())
           setZ(Integer.parseInt(matcher.group()));
        
        System.out.println(X);
        System.out.println(Z);
    }   

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getZ() {
		return Z;
	}


	public void setZ(int z) {
		Z = z;
	}

}
