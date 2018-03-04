// Jamies and Interesting Graph

import java.util.Arrays;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int sp = 3;
		int mstw = (n-1)+2;
		
		boolean[] isPrime = new boolean[1000000];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for(int i=2; i*i < 1000000; i++){
			for(int j=2*i; j<1000000; j+=i)
				isPrime[j] = false;
		}
		
		while(!isPrime[mstw]) mstw++;
		
		System.out.println(sp+" "+mstw);
		
		for(int i=2; i<(n-1); i++)
			System.out.println(1+" "+i+" "+1);
		
		if(n > 2)
			System.out.println(1+" "+(n-1)+" "+(mstw - (n)));
		System.out.println(1+" "+n+" "+3);
		
		int placed = n-1;
		
		spam:
		for(int i=2; i<=n; i++){
			for(int j=i+1; j<=n; j++){
				if(placed == m) break spam;
				placed++;
				System.out.println(i+" "+j+" "+"1000000000");
			}
		}

	}

}
