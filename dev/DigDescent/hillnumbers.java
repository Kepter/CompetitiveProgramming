import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class hillnumbers {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long num = in.nextLong();
		
		if(!isHill(num))
		{
			System.out.println(-1);
			return;
		}
		
		ArrayDeque<Integer> digits = new ArrayDeque<Integer>();
		
		while(num != 0)
		{
			digits.addFirst((int)(num%10));
			num /= 10;
		}
		
		dp = new long[digits.size()+1][10][2];
		for(int i=0; i<digits.size()+1; i++)
			for(int j=0; j<10; j++)
				Arrays.fill(dp[i][j], -1);
		
		long out = dp(digits, 0, true, true, digits.size());
		System.out.println(out-1);
	}
	
	static long dp[][][];
	public static long dp(ArrayDeque<Integer> digits, int last, boolean bounded, boolean isUp, int digitsLeft)
	{
		if(digitsLeft == 0) return 1;
		
		if(!bounded && dp[digitsLeft][last][isUp ? 1 : 0] != -1) return dp[digitsLeft][last][isUp ? 1 : 0];
		long ret = 0;
		int cap = 9;
		if(bounded) cap = digits.pollFirst();
		
		
		for(int i=0; i<=cap; i++)
		{
			if(isUp)
			{
				ret += dp(digits, i, (bounded && i == cap), i >= last, digitsLeft-1);
			}
			
			else if(i <= last)
			{
				ret += dp(digits, i, (bounded && i == cap), false, digitsLeft-1);
			}
		}
		
		if(bounded) digits.addFirst(cap);
		if(!bounded) dp[digitsLeft][last][isUp ? 1 : 0] = ret;
		return ret;
	}
	
	public static boolean isHill(long num)
	{
		boolean up = true;
		int last = 0;
		
		while(num != 0)
		{
			int n = (int)(num%10);
			if(up)
			{
				if(n < last) up = false;
			}
			else
			{
				if(n > last) return false;
			}
			
			num /= 10;
			last = n;
		}
		
		return true;
	}

}
