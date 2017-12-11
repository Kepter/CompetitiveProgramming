import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

// NOT VALID -- NOT SOLVED IN CONTEST
public class b {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int denom = in.nextInt();
		int find = in.nextInt();
		
		ArrayDeque<Integer> numDigits = new ArrayDeque<Integer>();
		while(num != 0)
		{
			numDigits.addLast(num%10);
			num /= 10;
		}
		HashSet<Long> seen = new HashSet<Long>();
		

		// Plz no hackerino i need the rating
		long position = 1;
		long div = numDigits.pollLast();
		
		int empty = 0;
		while(true)
		{
			if(empty < 5 && numDigits.size() == 0) empty++;
			
			div *= 10;
			div += (numDigits.size() == 0) ? 0 :numDigits.pollLast();
			
			
			if(empty >= 5 && seen.contains(div))
			{
				position = -1;
				break;
			}
			
			if(empty >= 5) seen.add(div);
			if(div >= denom)
			{
				long mult = div/denom;
				div -= (denom*mult);
				if(mult == find) break;
			}
			
			else
			{
				if(0 == find) break;
			}
			
			position++;
		}
		
		System.out.println(position);
	}
	
	

}
