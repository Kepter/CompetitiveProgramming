// 920C - Swap Adjacent Elements

import java.util.Arrays;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = in.nextInt();
		
		String sort = in.next();
		
		int s = -1;
		for(int i=0; i<n-1; i++) {
			if(sort.charAt(i) == '0' && s != -1) {
				Arrays.sort(a, s, i+1);
				s = -1;
			}
			
			if(sort.charAt(i) == '1' && s == -1) {
				s = i;
			}
		}
		
		if(s != -1) {
			Arrays.sort(a, s, a.length);
		}
		
		boolean sorted = true;
		for(int i=0; i<n; i++)
			if(i+1 != a[i]) sorted = false;
		
		if(sorted) System.out.println("YES");
		else System.out.println("NO");

	}

}
