import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 230B - T-primes

public class Tprimes {

	public static void main(String[] args) {
		
		boolean[] p = new boolean[(int)1e6+1];
		Arrays.fill(p, true);
		p[1] = p[0] = false;
		
		for(int i=2; i*i <= (int)1e6; i++)
			for(int j=2*i; j<=(int)1e6; j+=i)
				p[j] = false;
		
		HashSet<Long> tPrimes = new HashSet<>();
		
		for(int i=0; i<=(int)1e6; i++)
			if(p[i]) tPrimes.add((long)i*i);

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++)
			if(tPrimes.contains(in.nextLong())) System.out.println("YES");
			else System.out.println("NO");
	}

}

/*
4 --> 2 
5 --> 
6 --> 2 3 

10 --> 5 2
9 --> 3 3
8 --> 2 2 2

*/