// 295B - Greg and Graph
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class gregGraph {
	public static void solve(FS in, PrintWriter out) {
		int n = in.nextInt();

		int[][] dist = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				dist[i][j] = in.nextInt();
		
		int[] remove = new int[n];
		for(int i=0; i<n; i++)
			remove[i] = in.nextInt()-1;
		
		boolean[] isAdded = new boolean[n];
		ArrayList<Long> o = new ArrayList<>();
		
		for(int idx=n-1; idx>=0; idx--) {
			isAdded[remove[idx]] = true;
			
			
			int i = remove[idx];
			for(int j=0; j<n; j++)
				for(int k=0; k<n; k++) {
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}

			long sum = 0;
			for(int j=0; j<n; j++)
				for(int k=0; k<n; k++)
					if(isAdded[j] && isAdded[k])
						sum += dist[j][k];
			
			o.add(sum);
		}
		
		for(int i=o.size()-1; i>=0; i--)
			System.out.print(o.get(i)+" ");
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
