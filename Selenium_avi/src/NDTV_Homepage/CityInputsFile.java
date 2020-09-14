package NDTV_Homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CityInputsFile {
	
	public String Input(int citynum) throws FileNotFoundException{
		
		Scanner sc;
		File inpt= new File("C:\\Users\\Avinash\\Desktop\\input.txt");
		String Cityname = null;
		int line=0;
        sc = new Scanner(inpt);
		while(sc.hasNextLine() && line<citynum)
        {
			line++;
           Cityname=sc.nextLine();
        }
		return Cityname;

	}
}
