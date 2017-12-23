import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class d {

	// NOT SOLVED (Very close though)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		HashMap<Integer, BigInteger> seen = new HashMap<Integer, BigInteger>();
		BigInteger sum = BigInteger.ZERO;
		BigInteger cum = BigInteger.ZERO;
		
		for(int i=0; i<num; i++)
		{
			int n = in.nextInt();
//			System.out.print(n+": ");
			
			BigInteger toAdd = BigInteger.valueOf((i*n)).subtract(cum);
			
			if(seen.containsKey(n-1))
			{
//				System.out.print("Seen-1: "+seen.get(n-1));
				toAdd = toAdd.subtract(seen.get(n-1));
			}
			
			if(seen.containsKey(n+1))
			{
//				System.out.print("Seen+1: "+seen.get(n-1));
				toAdd = toAdd.add(seen.get(n+1));
			}
			
			cum = cum.add(BigInteger.valueOf(n));
			sum = sum.add(toAdd);
//			System.out.println(" toAdd: "+toAdd);
			if(seen.containsKey(n))
			{
				BigInteger to = seen.get(n).add(BigInteger.ONE);
				seen.put(n, to);
			}
			else
			{
				seen.put(n, BigInteger.ONE);
			}
		}
		
		System.out.println(sum);

	}

}
