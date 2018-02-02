// 919A - Supermarket

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		double min = Double.MAX_VALUE;
		
		for(int i=0; i<n; i++){
			min = Math.min(min, in.nextDouble()/in.nextDouble());
		}
		
		System.out.println(min*m);

	}

}
