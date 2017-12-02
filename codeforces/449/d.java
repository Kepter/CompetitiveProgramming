import java.util.Arrays;
import java.util.Scanner;

public class d {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int sheets = in.nextInt();
		int rounds = in.nextInt();
		int max = in.nextInt();
		
		int[] numbers = new int[sheets];
		Arrays.fill(numbers, -1);
		
		int cur = 0;
		while(cur < sheets && in.hasNext())
		{
			int next = in.nextInt();
//			System.out.println((((double)next-1)/max)*sheets);
			int check = (int)Math.ceil((((double)next-1)/max)*sheets);
			int last = 0;
			
			while(check >= 0 && check < sheets && numbers[check] != -1)
			{
				if(numbers[check] > next)
				{
					if(last == 1) break;
					last = -1;
					check--;
				}
				
				if(numbers[check] < next)
				{
					check++;
					if(last == -1) break;
					last = 1;
				}
			}
			
			if(check < 0) check++;
			if(check >= sheets) check--;
			
			numbers[check] = next;
			System.out.println(check+1);
			System.out.flush();
		}

	}

}
