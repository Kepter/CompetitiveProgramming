import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true)
		{
			long numerator = in.nextLong();
			long denominator = in.nextLong();
			
			
			if(numerator == 0 && denominator == 0) break;
			
			// NUMERATOR BE ZERO
			long reducedDenom = denominator/gcd(numerator, denominator);
			
			ArrayList<Frac> fracs = new ArrayList<Frac>();
			
			for(long d=reducedDenom; d<=3*denominator; d+=reducedDenom)
			{
				long a = (2*numerator*d*denominator - numerator*d*d) / (denominator*denominator);
				
				if(a >= 0 && check(a, d, numerator, denominator) && !(d == denominator && a == numerator))
				{
					fracs.add(new Frac(a, d));
				}
			}
			
//			fracs.add(new Frac(0, 2*denominator));
			Collections.sort(fracs);
			
			for(int i=0; i<fracs.size(); i++)
			{
				if(i != 0) System.out.print(" ");
				System.out.print(fracs.get(i).num+"/"+fracs.get(i).denom);
			}
			System.out.println();
		}
		

	}
	
	static boolean check(long a, long m, long b, long n)
	{
		long left = (m-n)*(a*n - b*m);
		long right = (a-b)*m*n;
		
//		System.out.println(a+"/"+m+" "+b+"/"+n+" "+(left == right));
		return left == right;
	}
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	
	static class Frac implements Comparable<Frac>
	{
		long num;
		long denom;
		
		public Frac(long n, long d)
		{
			num = n;
			denom = d;
		}
		@Override
		public int compareTo(Frac a) {
			
			long v = (num*a.denom) - (a.num*denom);
			if(v == 0)
			{
				if(num == a.num) return 0;
				return num - a.num > 0 ? 1 : -1;
			}
			return v > 0 ? 1 : -1;
		}
	}

}

/*
9 12
12 14
4 12
0 0

*/