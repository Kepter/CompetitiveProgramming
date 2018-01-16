import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String a = in.next();
		
		int flip = 0;
		for(int i=0; i<a.length(); i++)
		{
			char c = a.charAt(i);
			if(c == 'a' || c == 'i' || c =='e' || c == 'o' || c =='u')
				flip++;
			
			// If this is hackable the problem statement is lying and dumb
			if(c != '0' && c != '2' && c != '4'&& c!='6' && c!='8' && Character.isDigit(c))
				flip++;
		}
		System.out.println(flip);
		
	}

}
