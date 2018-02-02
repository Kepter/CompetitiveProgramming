// 653B - Bear and Compressing

import java.util.Arrays;
import java.util.Scanner;

public class compressing {

	static char[] to;
	static char[] from;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int q = in.nextInt();
		
		to = new char[q];
		from = new char[q];
		
		for(int i=0; i<q; i++){
			to[i] = in.next().charAt(0);
			from[i] = in.next().charAt(0);
		}
		memo = new long[26][n+1];
		for(int i=0; i<26; i++) Arrays.fill(memo[i], -1);
		
		System.out.println(dp(n, 'a'));
	}
	
	static long[][] memo;
	public static long dp(int len, char cur){
		if(len == 1) return 1;
		
		if(memo[cur-'a'][len] == -1){
			long ret = 0;
			for(int i=0; i<from.length; i++){
				if(from[i] != cur) continue;
				
				ret += dp(len-1, to[i]);
			}
			memo[cur-'a'][len] = ret;
		}
		
		return memo[cur-'a'][len];
	}

}
