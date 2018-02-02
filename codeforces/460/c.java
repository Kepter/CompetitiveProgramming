// 919C - Seat Arrangments

import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		char[][] map = new char[n][m];
		
		for(int i=0; i<n; i++)
			map[i] = in.next().toCharArray();

		int count = 0;
		int ret = 0;
		for(int r=0; r<n; r++){
			count = 0;
			for(int c=0; c<m; c++){
				if(map[r][c] == '.') count++;
				if(c-k >= 0 && map[r][c-k] == '.') count--;
				
				if(count == k) ret++;
			}
		}
		
		if(k != 1){
			for(int c=0; c<m; c++){
				count = 0;
				for(int r=0; r<n; r++){
					if(map[r][c] == '.') count++;
					if(r-k >= 0 && map[r-k][c] == '.') count--;
					
					if(count == k) ret++;
				}
			}
		}
		
		System.out.println(ret);

	}

}
