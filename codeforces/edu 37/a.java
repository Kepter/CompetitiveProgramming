// 920A - Water the Garden

import java.util.ArrayDeque;
import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int runs = in.nextInt();
		for(int r=0; r<runs; r++) {
			int n = in.nextInt();
			int k = in.nextInt();
			
			boolean[] visited = new boolean[n];
			int max = 0;
			
			ArrayDeque<S> que = new ArrayDeque<S>();
			
			for(int i=0; i<k; i++)
				que.add(new S(in.nextInt()-1, 1));
			
			while(!que.isEmpty()) {
				S c = que.poll();
				
				if(visited[c.i]) continue;
				visited[c.i] = true;
				
				max = Math.max(max, c.t);
				
				if(c.i-1 >=0 && !visited[c.i-1])
					que.add(new S(c.i-1, c.t+1));

				if(c.i+1 < n && !visited[c.i+1])
					que.add(new S(c.i+1, c.t+1));
			}
			
			System.out.println(max);
		}
	}
	
	static class S{
		int t;
		int i;
		public S(int I, int T) {
			i = I;
			t = T;
		}
	}

}
