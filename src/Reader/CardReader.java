package Reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardReader{
	 
	
	public static void read() throws IOException{
		
		File file = new File("2.txt");
		String token1 = "";
		
		Scanner scanner = new Scanner(file).useDelimiter(",\\s*");
		
		List<String> temps = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
			
		   token1 = scanner.next();
		   temps.add(token1);
		   
		}
		scanner.close();
		
		String[] tempsArray = temps.toArray(new String[0]);

	    for (String s : tempsArray) {
	      System.out.println(s);
	    }
	}
}