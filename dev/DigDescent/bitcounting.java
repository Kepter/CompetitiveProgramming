import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bitcounting {

	static long precomp[] = new long[120];
	public static void main(String[] args) {
		for(int i=1; i<120; i++)
		{
			int moves = 0;
			int n = i;
			while(n != 1)
			{
				int c = 0;
				while(n != 0)
				{
					c++;
					n -= (n & -n);
				}
				n = c;
				moves++;
			}
			precomp[i] = moves;
		}
		precomp[0] = -1;

		dp = new long[120][120];
		for(int i=0; i<120; i++)
			Arrays.fill(dp[i], -1);

		
		// ******** REALLY COOL AUTOMATED TESTING ZONE ********
		
//		long test[] = new long[100000001];
//		int count[] = new int[20];
//		for(int i=1; i<100000001; i++)
//		{
//			int moves = 0;
//			int n = i;
//			while(n != 1)
//			{
//				int c = 0;
//				while(n != 0)
//				{
//					c++;
//					n -= (n & -n);
//				}
//				n = c;
//				moves++;
//			}
//			test[i] = moves;
//			count[moves]++;
//		}
//		
//		
//		for(int i=0; i<100; i++)
//		{
//			int lo = (int)(Math.random()*100000000-1);
//			int hi = lo + (int)(Math.random()*(100000000-lo-1));
//			int k = (int)(Math.random()*5) + 1;
//
//			System.out.println("LO: "+lo+" HI: "+hi+" K: "+k);
//			long expected = 0;
//			for(int j=lo; j<=hi; j++)
//				if(test[j] == k)expected++;
//			
//			long actual = go(hi, k) - go(lo-1, k);
//
//			System.out.println("GOT: "+actual+"\nEXPECETED: "+expected);
//			if(actual != expected) System.out.println(" <----------------------------------------- ");
//		}
		
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			long a = in.nextLong();
			long b = in.nextLong();
			long k = in.nextLong();
			
			if(a == 0 && b == 0 && k == 0) break;
			
			long out = go(a-1, k);
			long out2 = go(b, k);
			
			System.out.println(out2 - out);
		}
		
		
	}
	
	public static long go(long a, long k)
	{
		if(k == 0) return a > 0 ? 1 : 0;
		ArrayList<Integer> bits = new ArrayList<>();
		long out = 0;
		if(k == 1 && a > 0) out = -1;
		
		int shift = 0;
		while(a != 0)
		{
			long bit = (a & (1 << shift++));
			bits.add(bit == 0 ? 0 : 1);
			a -= bit;
		}
		
		for(int i=0; i<=bits.size(); i++)
		{
			if(precomp[i]+1 == k)
			{
//				System.out.println(i+": "+dp(bits, bits.size()-1, i, true));
				out += dp(bits, bits.size()-1, i, true);
			}
		}
		
		return out;
	}
	
	static long dp[][];
	public static long dp(ArrayList<Integer> bits, int curDigit, int tarBits, boolean bounded)
	{
		if(tarBits == 0)return 1;
		if(curDigit < 0) return 0;
		
		if(!bounded && dp[curDigit][tarBits] != -1) return dp[curDigit][tarBits];
		long ret = 0;
		int cap = bounded ? bits.get(curDigit) : 1;
		
		for(int i=0; i<=cap; i++)
			ret += dp(bits, curDigit-1, tarBits-i, bounded && i == cap);
		
//		System.out.println("CURDIGIT: "+curDigit+" bounded: "+bounded+" tarBit: "+tarBits +" ret: "+ret);
		
		if(!bounded) dp[curDigit][tarBits] = ret;
		return ret;
	}

}

/*
1 1000000000000000000 1

*/