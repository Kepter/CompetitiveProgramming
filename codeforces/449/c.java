import java.math.BigInteger;
import java.util.Scanner;

public class c {

	static String base = "What are you doing at the end of the world? Are you busy? Will you save us?";
	
	static String a = "What are you doing while sending \"";
	static String b = "\"? Are you busy? Will you send \"";
	static String c = "\"?";
	
	static BigInteger [] lengths = new BigInteger[101];
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();
		
		
		lengths[0] = BigInteger.valueOf(base.length());
		BigInteger add = BigInteger.valueOf(a.length() + b.length() + c.length());
		for(int i=1; i<lengths.length; i++)
		{
			lengths[i] = (lengths[i-1].multiply(BigInteger.valueOf(2))).add(add);
//			System.out.println(i+": "+lengths[i]);
		}
		
//		System.out.println("36: "+val);
		
//		System.out.println("a: "+a.length()+"\nb: "+b.length()+"\nc: "+c.length());

		int runs = in.nextInt();
		for(int r=0; r<runs; r++)
		{
			int n = in.nextInt();
			BigInteger k = BigInteger.valueOf(in.nextLong()-1);
			
//			System.out.println(find(k, n));
			out.append(find(k, n));
		}
		
		System.out.println(out.toString());
	}
	
	public static char find(BigInteger k, int n)
	{
		if(n == 0)
		{
			if(k.compareTo(BigInteger.valueOf(base.length())) < 0) return base.charAt(k.intValue());
			return '.';
		}
		
		if(n > 101)
		{
			while(n > 101)
			{
				if(k.compareTo(BigInteger.valueOf(a.length())) < 0)
				{
					return a.charAt(k.intValue());
				}
				
				n--;
				k = k.subtract(BigInteger.valueOf(a.length()));
			}
			return find(k, n);
		}
		
		if(k.compareTo(BigInteger.valueOf(a.length())) < 0)
		{
			return a.charAt(k.intValue());
		}
		k = k.subtract(BigInteger.valueOf(a.length()));
		
		if(k.compareTo(lengths[n-1]) < 0)
		{
			return find(k, n-1);
		}
		k = k.subtract(lengths[n-1]);
		
		if(k.compareTo(BigInteger.valueOf(b.length())) < 0)
		{
			return b.charAt(k.intValue());
		}
		k = k.subtract(BigInteger.valueOf(b.length()));
		
		if(k.compareTo(lengths[n-1]) < 0)
		{
			return find(k, n-1);
		}
		k = k.subtract(lengths[n-1]);
		
		if(k.compareTo(BigInteger.valueOf(c.length())) < 0)
		{
			return c.charAt(k.intValue());
		}
		k = k.subtract(BigInteger.valueOf(c.length()));
	
		return '.';
	}
}

/*
4913442586555
 */
