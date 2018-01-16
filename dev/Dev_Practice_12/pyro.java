import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class pyro {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		HashSet<Integer> vals = new HashSet<Integer>();
		HashMap<Integer, Integer> ways = new HashMap<Integer, Integer>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		
		while(true) {
			int n = in.nextInt();
			if(n == -1) break;
			
			vals.add(n);
			nums.add(n);
			ways.put(n, 0);
			
			int max = Integer.highestOneBit(n);
			
			
//			System.out.println("VAL: "+n);
			for(int i=1; i<=max; i<<=1) {
				int temp = n^i;
//				System.out.println("1: "+temp);
				if(temp<n && vals.contains(temp)) 
					ways.merge(temp, 1, Integer::sum);
				
				for(int j=i<<1; j<=max; j<<=1) {
					if(i == j) continue;
					int t2 = temp ^ j;
//					System.out.println(" 2: "+t2);
					
					if(t2<n && vals.contains(t2))
						ways.merge(t2, 1, Integer::sum);
				}
			}
		}
		
		for(int i=0; i<nums.size(); i++) {
			System.out.println(nums.get(i)+":"+ways.get(nums.get(i)));
		}
		
	}
}

/*
1
3
8
10
25
-1

2083
15093
15285
25147
31413
47797
49723
55989
58171
60085
95670
-1


*/