import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class g {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		N[] nodes = new N[n];
		
		for(int i=0; i<n; i++)
			nodes[i] = new N();
		
		
		for(int i=0; i<m; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			
			if(a < 0){
				a = -a;
				nodes[a-1].free = nodes[b-1];
			}
			
			else{
				nodes[a-1].adj.add(nodes[b-1]);
			}
		}
		
		int s = 0;
		ArrayDeque<S> q = new ArrayDeque<S>();

		q.add(new S(false, nodes[0]));
		
		while(!q.isEmpty()){
			S cur = q.poll();
			
			if(cur.skipped && cur.n.avisited) continue;
			if(!cur.skipped && cur.n.bvisited) continue;
			
			if(cur.skipped) cur.n.avisited = true;
			else cur.n.bvisited = true;
			
			if(cur.n.free != null) q.add(new S(cur.skipped, cur.n.free));
			
			if(!cur.skipped){
				for(N next : cur.n.adj){
					if(next.bvisited) continue;
					else{
						q.add(new S(true, next));
					}
					
				}
			}
		}
		
		for(int i=0; i<n; i++)
			if(nodes[i].free == null && (nodes[i].avisited || nodes[i].bvisited)) s++;
		
		System.out.println(s);
	}
	
	static class N{
		
		boolean avisited = false;
		boolean bvisited = false;
		
		N free = null;
		ArrayList<N> adj = new ArrayList<N>();
	}
	
	static class S{
		boolean skipped = false;
		N n;
		
		public S(boolean S, N N){
			skipped = S;
			n = N;
		}
	}
}

/*
7 9 
1 2
2 3
-1 5
2 6
5 1
-4 1
5 6
-6 7
-5 4

3 2
1 2
1 3

 */
