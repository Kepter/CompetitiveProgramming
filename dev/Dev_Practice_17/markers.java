import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class markers {

	static int minMark;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;
			
			Node[] nodes = new Node[n];
			for(int i=0; i<n; i++)
				nodes[i] = new Node(i);

			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				Arrays.fill(adj[i], (int)1e9);
			
			for(int i=0; i<n; i++)
				adj[i][i] = 0;
			
			for(int i=0; i<n; i++) {
				in.next();
				
				int e = in.nextInt();
				for(int j=0; j<e; j++) {
					nodes[i].adj.add(new Edge(nodes[in.next().charAt(0)-'A'], in.nextInt()));
				}
				
				for(Edge ed : nodes[i].adj) {
					adj[i][ed.d.id] = ed.cost;
				}
			}
			
			for(int i=0; i<adj.length; i++)
				for(int j=0; j<adj.length; j++)
					for(int k=0; k<adj.length; k++)
						adj[j][k] = Math.min(adj[j][k], adj[j][i] + adj[i][k]);
			
			for(Node no : nodes) {
				for(Edge e : no.adj) {
					int toCost = adj[0][no.id];
					int edgeCost = e.cost + adj[e.d.id][n-1];
					
					e.bad = toCost+edgeCost != adj[0][n-1];
					no.hasBad |= e.bad;
					
//					System.out.println(no.id+" to "+e.d.id+" is "+e.bad+" ("+e.cost+" + "+adj[0][no.id]+")");
				}
			}
			
			ArrayList<Mask> masks = new ArrayList<Mask>();
			
			for(int i=0; i<1<<n; i++) {
				masks.add(new Mask(i));
			}
			
			Collections.sort(masks);
			
//			System.out.println(masks.size());
			minMark = (int)1e9;
			for(Mask mask : masks) {
//				System.out.println("Starting mask: "+Integer.toBinaryString(mask.mask));
				combo(mask.mask, 0, nodes);
				if(minMark != (int)1e9) break;
			}
			
			System.out.println(adj[0][n-1]+" "+minMark);
			
		}
		
	}
	
	static void combo(int mask, int idx, Node[] nodes) {
		if(idx == nodes.length) {
//			System.out.println("Trying mask: "+Integer.toBinaryString(mask));
			if(dfs(nodes[0])) minMark = Integer.bitCount(mask);
			return;
		}
		
		if((mask & (1<<idx)) == 0) {
			combo(mask, idx+1, nodes);
			return;
		}
		
		// TRY ALL COMBOS
		for(int i=0; i<nodes[idx].adj.size(); i++) {
			if(nodes[idx].adj.get(i).bad) continue;
			nodes[idx].marked = i;
			combo(mask, idx+1, nodes);
		}
		nodes[idx].marked = -1;
	}
	
	static boolean dfs(Node cur) {
		if(cur.marked == -1 && cur.hasBad) return false;
		
		if(cur.marked != -1) {
			return dfs(cur.adj.get(cur.marked).d);
		}
		
		for(Edge e : cur.adj) {
			if(!dfs(e.d)) return false;
		}
			
		return true;
	}
	
	
	static class Node{
		ArrayList<Edge> adj = new ArrayList<Edge>();
		int id;
		boolean hasBad = false;
		
		int marked = -1;
		
		public Node(int I) {
			id = I;
		}
	}
	
	static class Edge{
		int cost;
		boolean bad = false;
		Node d;
		public Edge(Node D, int c) {
			cost = c;
			d = D;
		}
	}
	
	static class Mask implements Comparable<Mask>{
		int mask;

		public Mask(int I) {
			mask = I;
		}
		
		public int compareTo(Mask o) {
			return Integer.bitCount(mask) - Integer.bitCount(o.mask);
		}
		
		
	}
}
