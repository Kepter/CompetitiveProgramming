import java.util.Scanner;

public class boredom {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long[] count = new long[100001];
		for(int i=0; i<n; i++)
			count[in.nextInt()]++;
		
		long[] dp = new long[100001];
		dp[0] = 0;
		dp[1] = count[1];
		
		for(int i=2; i<100001; i++)
			dp[i] = Math.max(dp[i-1], dp[i-2]+count[i]*i);
		
		System.out.println(dp[dp.length-1]);
	}
}
