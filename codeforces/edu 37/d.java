// 920D - Tanks

import java.util.Arrays;
import java.util.Scanner;

public class d {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int v = in.nextInt();
		
		int tar = v%k;
		int tot = 0;
		
		
		
		int[] water = new int[n];
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			tot += a;
			
			water[i] = a;
		}
		
		// Silly base case
		if(v == 0) {
			int mv = (water[0]/k + ((water[0]%k == 0 ? 0 : 1)));
			System.out.println("YES");
			if(mv != 0)
				System.out.println(mv+" 1 2");
			
			return;
		}
		
		// Compute ways we can reach every value under mod k
		int[] path = canMake(water, k);

//		for(int i=0; i<k; i++) {
//			System.out.print(path[i]+" ");
//		}
//		System.out.println();
		
		if(path[tar] == -1 || tot < v) {
			System.out.println("NO");
			return;
		}
		
		System.out.println("YES");
		
		moved = new boolean[n];
		s = -1;
		printPath(water, path, tar, k);
		if(s == -1) {
			s = 0;
			int cnt = (water[0]/k + ((water[0]%k == 0 ? 0 : 1)));
			System.out.println(cnt+" 1 2");
			
			water[1] += water[0];
			water[0] = 0;
		}
		
		// Move the water around to get that mod stuff worked out
//		printPath(water, path, tar, tar);
//		
		int mv = v-water[s];
		
		if(mv > 0) {
			int fill = s == 0 ? 1 : 0;
			for(int i=0; i<n; i++) {
				if(i == fill || i == s) continue;
				
				int cnt = (water[i]/k + ((water[i]%k == 0 ? 0 : 1)));
				if(cnt > 0 && !moved[i])
					System.out.println(cnt+" "+(i+1)+" "+(fill+1));
				water[fill] += water[i];
			}
			
			System.out.println((mv/k)+" "+(fill+1)+" "+(s+1));
		}
		
		else {
			int fill = s == 0 ? 1 : 0;
			if(mv != 0) System.out.println((-mv/k)+" "+(s+1)+" "+(fill+1));
		}

	}
	
	static int[] canMake(int[] nums, int k) {
		int[] ret = new int[k];
		Arrays.fill(ret, -1);
		
		ret[0] = -2;
//		for(int i=0; i<nums.length; i++) {
//			ret[nums[i]%k] = i;
//			System.out.println(i+": "+i+" <-- "+(nums[i]%k));
//		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=k; j>= 0; j--) {
				int val = j-nums[i];
				while(val < 0) val+=k;
				val = val%k;
				
//				System.out.println("I: "+i+" J: "+j+" V: "+val);
				if((ret[val] != -1 && ret[val] != i && ret[j%k] == -1)) {
//					System.out.println("SET "+(j%k)+" TO "+i+" WAS "+ret[j%k]);
					ret[j%k] = i;
				}
			}
		}
		
		return ret;
	}
	
	static boolean[] moved;
	static int s;
	static void printPath(int[] water, int[] p, int c, int k) {
		
		if(c == 0) return;
		if(s == -1) s = p[c];
		
		int next = c - water[p[c]];
		while(next < 0) next += k;
		
		moved[p[c]] = true;
		printPath(water, p, next, k);

		int cnt = ( water[p[c]]/k + ((water[p[c]]%k == 0 ? 0 : 1)));
		if(s != p[c]) {
			System.out.println(cnt+" "+(p[c]+1)+" "+(s+1));
			water[s] += water[p[c]];
			water[p[c]] = 0;
		}
	}

}

/*
5 4 10
1
20
18
5
0

5 4 10
1
20
2
5
0

5 4 10
1
20
6
5
0

5 4 10
1
20
10
5
0

5 4 10
1
1
1
2
5

10 4 10
1
1
1
1
1
1
1
1
1
1

3 3 3
1
1
1

 */
