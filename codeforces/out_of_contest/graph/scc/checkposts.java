import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 427C - Checkposts

public class checkposts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		N[] nodes = new N[n];
		for(int i=0; i<n; i++){
			nodes[i] = new N();
			nodes[i].cost = in.nextInt();
		}
		
		int m = in.nextInt();
		
		for(int i=0; i<m; i++){
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			
			nodes[a].adj.add(nodes[b]);
		}

		t = 0;
		s = new ArrayDeque<>();
		comps = new ArrayList<>();
		
		for(int i=0; i<n; i++){
			if(nodes[i].time == -1){
				dfs(nodes[i]);
			}
		}
		
		long[] min = new long[comps.size()];
		long[] cnt = new long[comps.size()];
		
		Arrays.fill(min, Integer.MAX_VALUE);
		
		for(int i=0; i<comps.size(); i++){
			for(N cur : comps.get(i)){
				if(cur.cost < min[i]){
					min[i] = cur.cost;
					cnt[i] = 0;
				}
				
				if(cur.cost == min[i]){
					cnt[i]++;
				}
			}
		}
		
		long minCost = 0;
		for(int i=0; i<comps.size(); i++)
			minCost += min[i];
		
		long ways = 1;
		for(int i=0; i<comps.size(); i++)
			ways = (ways * cnt[i])%1000000007L;
		
		System.out.println(minCost+" "+ways);
	}
	
	static int t;
	static ArrayDeque<N> s;
	static ArrayList<ArrayList<N>> comps; 
	
	static class N{
		long cost;
		int time = -1;
		int lowlink = -1;
		boolean ins = false;
		
		ArrayList<N> adj = new ArrayList<N>();
	}
	
	static void dfs(N cur){
		cur.time = cur.lowlink = t++;
		cur.ins = true;
		s.push(cur);
		
		for(N n : cur.adj){
			if(!n.ins){
				if(n.time == -1){
					dfs(n);
					cur.lowlink = Math.min(cur.lowlink, n.lowlink);
				}
				else {
					// THIS IS CROSS EDGE
				}
			}
			else{
				cur.lowlink = Math.min(cur.lowlink, n.time);
			}
		}
		
		if(cur.lowlink == cur.time){
			N n = null;
			ArrayList<N> comp = new ArrayList<N>();
			while(n != cur){
				n = s.pop();
				n.ins = false;
				comp.add(n);
			}
			comps.add(comp);
		}
	}

}
