// 2016 ACM IPCP South East Regionals SER

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class paint {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		int k = in.nextInt();
		
		P[] p = new P[k];
		for(int i=0; i<k; i++)
			p[i] = new P(in.nextLong(), in.nextLong());
		
		Arrays.sort(p);
		
		// Compress coordinates to only ones we care about
		ArrayList<Long> c = new ArrayList<>();
		for(int i=0; i<p.length; i++){
			if(c.size() == 0 || c.get(c.size()-1) != p[i].a) c.add(p[i].a);
//			if(c.get(c.size()-1) != p[i].b) c.add(p[i].b);
		}
		
		// DP on "important" coordinates
		
		int idx = c.size()-1;
		long[] dp = new long[c.size()];
		Arrays.fill(dp, -1);
		
//		System.out.println("CORDS: ");
//		for(int i=0; i<c.size(); i++)
//			System.out.print(c.get(i)+" ");
//		System.out.println();
		
		for(int i=p.length-1; i>=0; i--){
			if(c.get(idx) != p[i].a) idx--;
			
			int id = Collections.binarySearch(c, p[i].b+1);
			if(id < 0) id = -(id + 1);
			long sum = (id == c.size() ? 0 : dp[id]) + p[i].b - p[i].a + 1;
			dp[idx] = Math.max(dp[idx], Math.max((idx == c.size()-1 ? -1 : dp[idx+1]), sum));
		
//			System.out.println("i: "+i+" idx: "+idx+" val: "+dp[idx]);
		}
		
		System.out.println(n - dp[0]);
	}
	
	static class P implements Comparable<P>{
		long a;
		long b;
		
		public P(long A, long B){
			a = A;
			b = B;
		}

		@Override
		public int compareTo(P o) {
			if(a < o.a) return -1;
			return 1;
		}
	}

}

/*
10 4
1 2
1 3
1 2
6 10

*/
