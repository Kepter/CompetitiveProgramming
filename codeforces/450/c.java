import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int len = in.nextInt();
		
		int[] nums = new int[len];
		int[] val = new int[len];
		
		int max1=0;
		int max2=0;
		
		int maxIdx = -1;
		for(int i=0; i<len; i++)
		{
			int n = in.nextInt();
			nums[i] = n;
			if(n > max1)
			{
				val[i] = -1;
				max2 = max1;
				max1 = n;
				maxIdx = i;
			}
			
			else if(n > max2)
			{
				max2 = n;
				val[maxIdx]++;
			}
		}
		
		int best = -10;
		int bestIdx = -1;
		for(int i=0; i<len; i++)
		{
			if(val[i] > best)
			{
				bestIdx = i;
				best = val[i];
			}
			
			else if(val[i] == best && nums[i] < nums[bestIdx])
			{
				bestIdx = i;
				best = val[i];
			}
		}
			
		
		System.out.println(nums[bestIdx]);

	}

}
