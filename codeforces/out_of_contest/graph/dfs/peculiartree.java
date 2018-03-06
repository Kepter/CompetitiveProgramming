// 931D - Peculiar Apple-Tree

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class peculiartree {
	static ArrayList<ArrayList<Integer>> next;
	public static void solve(FS in) {
		int n = in.nextInt();
		
		next = new ArrayList<ArrayList<Integer>>();
		
		
		for(int i=0; i<n; i++){
			next.add(new ArrayList<Integer>());
		}
		for(int i=1; i<n; i++){
			next.get(in.nextInt()-1).add(i);
		}
		
		lens = new HashSet<Integer>();
		dfs(0,0);
		System.out.println(lens.size());
	}
	
	static HashSet<Integer> lens;
	static void dfs(int len, int idx){
		if(lens.contains(len)) lens.remove(len);
		else lens.add(len);
		
		for(Integer i : next.get(idx)){
			dfs(len+1, i);
		}
	}

	public static void main(String[] args) {
		new Thread(null, ()->solve(new FS()), "go", 1<<28).start();
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
