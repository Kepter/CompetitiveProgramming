import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class i {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		precomp = new int[6200];
		Arrays.fill(precomp, -1);
		precomp[1] = 1;
		for(int i=0; i<precomp.length; i++)
			precomp[i] = isHappy(i);
		
		memo = new long[6200][20];
		for(int i=0; i<6200; i++)
			for(int j=0; j<20; j++)
				memo[i][j] = -1;
		
		while(true)
		{
			long lo = in.nextLong();
			long hi = in.nextLong();
			
			if(lo == 0 && hi == 0) break;
			lo--;
			
			long out = dp(hi) - dp(lo);
			System.out.println(out);
		}
		
		
		
	}
	
	static int isHappy(int i)
	{
		HashSet<Integer> seen = new HashSet<>();
		
		while(!seen.contains(i))
		{
			if(precomp[i] != -1) return precomp[i];
			if(i == 1) return 1;
			
			seen.add(i);
			
			int n = 0;
			while(i != 0)
			{
				n += (i%10)*(i%10);
				i /= 10;
			}
			i = n;
		}
		return 0;
			
	}
	
	static long dp(long hi)
	{
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while(hi != 0)
		{
			digits.add((int)(hi%10));
			hi /= 10;
		}
		int [] d = new int[digits.size()];
		for(int i=0; i<digits.size(); i++)
			d[i] = digits.get(i);
		
		return dp(d, true, digits.size()-1, 0);
	}
	
	static int precomp[];
	static long[][] memo;
	static long dp(int[] digits, boolean bounded, int curDigit, int sum)
	{
		if(curDigit < 0)
		{
			return precomp[sum] == 1 ? 0 : 1;
		}
		
		if(!bounded && memo[sum][curDigit] != -1) return memo[sum][curDigit];
		int cap = 9;
		if(bounded) cap = digits[curDigit];
		
		long count = 0;
		for(int i=0; i<=cap; i++)
			count += dp(digits, bounded && i==cap, curDigit-1, sum + (i*i));
		
		if(!bounded) memo[sum][curDigit] = count;
		return count;
	}

}
