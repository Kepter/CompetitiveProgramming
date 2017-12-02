import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class b {
	
	static class N
	{
		ArrayList<Integer> digits = new ArrayList<>();
		
		public int add(int index)
		{
			if(index == -1)
			{
				digits.add(0, 1);
				return 1;
			}
			
			if(digits.get(index) == 9)
			{
				int move = add(index-1);
				digits.set(index+move, 0);
				return move;
			}
			
			digits.set(index, digits.get(index)+1);
			return 0;
		}
		
		public long val()
		{
			long ret = 0;
			long mult = 1;
			
			for(int i=0; i<digits.size(); i++)
			{
				ret +=	digits.get(i)*mult;
				mult *= 10;		
			}
			
			for(int i=digits.size()-1; i>=0; i--)
			{
				ret +=	digits.get(i)*mult;
				mult *= 10;		
			}
			
			return ret;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int mod = in.nextInt();
		
		N build = new N();
		
//		long out = 0;
		BigInteger t = BigInteger.valueOf(0);
		for(int i=0; i<count; i++)
		{
			build.add(build.digits.size()-1);
			t = t.add(BigInteger.valueOf(build.val()));
//			out = (out + build.val())%mod;
		}
//		System.out.println(out);
		System.out.println(t.mod(BigInteger.valueOf(mod)));
		
		
	}
	
//	public static int go(StringBuilder number, int mod, boolean isFirst)
//	{
//		if(made >= count) return 0;
//		
//		
//		
//		i = 0;
//		if(isFirst) i = 1;
//		for(; i<9; i++)
//		{
//			number.append(i+'0');
//			ret = (ret + go(number, mod, false))%mod;
//			number.deleteCharAt(number.length()-1);
//			made++;
//			if(made >= count) return ret;
//		}
//		
//		return ret;
//	}
//	
//	public static int val(int number, boolean isFirst)
//	{
//		
//		StringBuilder cpy = new StringBuilder(number.toString());
//		
//		for(int i=number.length()-1; i>=0; i--)
//			cpy.append(number.charAt(i));
//		
//		return Integer.valueOf(cpy.toString());
//	}

}

/*
20
11 + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99 + 1001 + 1111 + 1221 + 1331 + 1441 + 1551 + 1661 + 1771 + 1881 + 1991 + 2002

30
11 + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99 + 1001 + 1111 + 1221 + 1331 + 1441 + 1551 + 1661 + 1771 + 1881 + 1991 + 2002 + 2112 + 2222 + 2332 + 2442 + 2552 + 2662 + 2772 + 2882 + 2992 + 3003
 */
