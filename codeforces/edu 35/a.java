

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int nums = in.nextInt();
		int minDist = Integer.MAX_VALUE;
		int lastMin = -1;
		int minVal = Integer.MAX_VALUE;
		
		int[] vals = new int[nums];
		for(int i=0; i<nums; i++){
			vals[i] = in.nextInt();
			if(vals[i] < minVal)
				minVal = vals[i];
		}
		
//		System.out.println(minVal);
		for(int i=0; i<nums; i++){
			if(vals[i] == minVal)
			{
				if(lastMin != -1){
					if(i-lastMin < minDist)
						minDist = i-lastMin;
				}
				
				lastMin = i;
			}
		}
			
		System.out.println(minDist);

	}

}
