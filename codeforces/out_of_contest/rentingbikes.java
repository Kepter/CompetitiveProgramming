// 363D - Renting Bikes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class rentingbikes {
	public static void solve(FS in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		shared = in.nextInt();
		
		personal = new int[n];
		for(int i=0; i<n; i++)
			personal[i] = in.nextInt();
		
		cost = new int[m];
		for(int i=0; i<m; i++)
			cost[i] = in.nextInt();

		Arrays.sort(personal);
		Arrays.sort(cost);
		
		int numBikes = 0;
		int l = 0;
		int r = Math.min(m, n);
		
		while(l < r) {
			int mid = (l+r+1)/2;
			if(ok(mid)) {
				numBikes = mid;
				l = mid;
			}
			else {
				r = mid-1;
			}
		}
		
		long totCost = 0;
		for(int i=0; i<numBikes; i++) {
			totCost += cost[i];
		}
		
		System.out.println(numBikes+" "+(Math.max(0, totCost-shared)));
	}
	
	static int shared;
	static int[] personal;
	static int[] cost;
	static boolean ok(int numBikes) {
		
		long sum = 0;
		for(int i=0; i<numBikes; i++) {
			sum += Math.max(0, cost[i]-personal[personal.length-numBikes+i]);
		}
		
		return sum<=shared;
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
