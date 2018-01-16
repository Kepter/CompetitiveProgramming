import java.util.Arrays;
import java.util.Scanner;

public class wordclouds {
	
	static int maxWidth;
	static int n;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		maxWidth = in.nextInt();
		
		int[] ws = new int[n];
		int[] hs = new int[n];
		
		for(int i=0; i<n; i++) {
			ws[i] = in.nextInt();
			hs[i] = in.nextInt();
		}
		
		memo = new long[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(memo[i], -1);
		
		System.out.println(dp(ws, hs, 0, 0));
	}
	
	static long memo[][];
	public static long dp(int[] ws, int[] hs, int l, int r) {
		
		long cw = 0;
		long ch = 0;
		for(int i=l; i<r; i++) {
			cw += ws[i];
			ch = Math.max(ch, hs[i]);
		}
		
		if(r >= ws.length) {
			return ch;
		}
		
		if(memo[l][r] != -1) return memo[l][r];
		
		long min = Long.MAX_VALUE;
		if(cw + ws[r] <= maxWidth) {
			min = dp(ws, hs, l, r+1);
		}
		
		min = Math.min(min, ch+dp(ws, hs, r, r+1));
		memo[l][r] = min;
		return min;
	}

}

/*
6 260
65 23
38 11
135 48
97 43
95 28
130 23

3 309
150 100
10 10
150 100

*/