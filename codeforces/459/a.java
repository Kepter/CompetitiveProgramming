// 918A - Eleven

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] fib = new int[n+2];
		fib[1] = 1;
		fib[2] = 2;
		
		StringBuilder s = new StringBuilder();
		for(int i=3; i<=n; i++)
			fib[i] = fib[i-1]+fib[i-2];
		
		int idx = 1;
		for(int i=1; i<=n; i++){
			if(i == fib[idx]){
				idx++;
				s.append("O");
			}
			else s.append("o");
		}
		System.out.println(s.toString());

	}

}
