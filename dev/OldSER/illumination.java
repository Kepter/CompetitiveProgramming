import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class illumination {
	public static void solve(FS in, PrintWriter out) {
		int n = in.nextInt();
		int range = in.nextInt();
		int k = in.nextInt();
		
		// 0 = row, 1 = col
		Node[] nodes = new Node[k*2];
		
		for(int i=0; i<k; i++){
			int r = in.nextInt();
			int c = in.nextInt();
			
			nodes[i*2] = new Node();
			nodes[i*2].r = r;
			nodes[i*2].c = c;
			nodes[i*2].id = i*2;
			
			nodes[i*2+1] = new Node();
			nodes[i*2+1].r = r;
			nodes[i*2+1].c = c;
			nodes[i*2+1].id = i*2+1;
			
			for(int j=0; j<i; j++){
				if(r == nodes[j*2].r && Math.abs(c-nodes[j*2].c) <= range){
					nodes[i*2].adj.add(nodes[j*2+1]);
					nodes[j*2].adj.add(nodes[i*2+1]);
				}
				
				if(c == nodes[j*2].c && Math.abs(r-nodes[j*2].r) <= range){
					nodes[i*2+1].adj.add(nodes[j*2]);
					nodes[j*2+1].adj.add(nodes[i*2]);
				}
			}
		}
		
		for(int i=0; i<k*2; i++){
			if(nodes[i].time == -1)
				dfs(nodes[i]);
		}
		
		boolean valid = true;
		for(ArrayList<Node> comp : comps){
			HashSet<Integer> seen = new HashSet<Integer>();
			
			for(Node node : comp){
				if(seen.contains(node.id/2))
					valid = false;
				seen.add(node.id/2);
			}
		}
		
		out.println(valid ? 1 : 0);
	}
	
	static class Node{
		ArrayList<Node> adj = new ArrayList<Node>();
		int r = -1;
		int c = -1;
		int id = 0;
		
		long cost;
		int time = -1;
		int lowlink = -1;
		boolean ins = false;
	}
	
	static int t = 0;
	static ArrayDeque<Node> s = new ArrayDeque<Node>();
	static ArrayList<ArrayList<Node>> comps = new ArrayList<ArrayList<Node>>(); 

	static void dfs(Node cur){
		cur.time = cur.lowlink = t++;
		cur.ins = true;
		s.push(cur);
		
		for(Node n : cur.adj){
			if(!n.ins){
				if(n.time == -1){ /* FORWARD EDGE */
					dfs(n); 
					cur.lowlink = Math.min(cur.lowlink, n.lowlink);
				}
				
				else {/* CROSS EDGE */}
			}
			else{ /* BACK EDGE */
				cur.lowlink = Math.min(cur.lowlink, n.time);
			}
		}
		
		if(cur.lowlink == cur.time){
			Node n = null;
			ArrayList<Node> comp = new ArrayList<Node>();
			while(n != cur){
				n = s.pop();
				n.ins = false;
				comp.add(n);
			}
			comps.add(comp);
		}
	}

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		solve(new FS(), out);
		out.flush();
		out.close();
	}

	static class FS {
		BufferedReader br;
		StringTokenizer st;

		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
