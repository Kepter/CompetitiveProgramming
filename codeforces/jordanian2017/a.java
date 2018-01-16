

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class a {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("tabs.in"));
		int runs = in.nextInt();
		
		for(int r=0; r<runs; r++){
			int num = in.nextInt();
			int cur = in.nextInt();
			
			if(num == 1) System.out.println(0);
			else if(cur == 1 || cur == num) System.out.println(1);
			else System.out.println(2);
		}

	}

}
