import java.util.Arrays;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int[] boxes = new int[num];
		
		for(int i=0; i<num; i++)
			boxes[i] = in.nextInt();
		
		Arrays.sort(boxes);
		
		boolean changed = true;
		boolean[] used = new boolean[num];
		int count = 0;
		while(changed)
		{
			changed = false;
			int last = (int)2e9;
			
			for(int i=boxes.length-1; i>=0; i--)
			{
				if(boxes[i] < last && !used[i])
				{
					last = boxes[i];
					used[i] = true;
					changed = true;
					count++;
				}
			}
			count--;
		}
		
		
		System.out.println(num-count-1);

	}

}
