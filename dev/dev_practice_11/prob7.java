import java.util.Arrays;
import java.util.Scanner;

public class prob7 {

	static long[][] memo;
	static long mod = 1000001L;
	static String raw;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int runs = in.nextInt();
		for(int r=0; r<runs; r++) {
			raw = in.next();
			memo = new long[raw.length()][raw.length()];
			
			for(int i=0; i<raw.length(); i++)
				Arrays.fill(memo[i], -1);
			
			for(int i=0; i<raw.length(); i++)
				memo[i][i] = raw.charAt(i) == '0' ? 1 : 0;
			
			System.out.println(dp(0, raw.length()-1));
		}

	}
	
	public static long dp(int l, int r) {
		if(l > r) return 1;
		
		if(memo[l][r] != -1) return memo[l][r];
		
		long ret = 0;
		for(int i=l; i<=r; i++) {
			if(raw.charAt(i) != '1') continue;
			ret = (ret + dp(l, i-1)*dp(i+1, r))%mod;
		}
		
		memo[l][r] = ret;
		return ret;
	}

}
