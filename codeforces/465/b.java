// 935B - Fafa and the Gates
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class b {
	public static void solve(FS in, PrintWriter out) {

		int n = in.nextInt();
		
		int x = 0;
		int y = 0;
		
		int last = -1;
		int cost = 0;
		
		String coms = in.next();
		for(int i=0; i<n; i++) {
			if(coms.charAt(i) == 'U') y++;
			if(coms.charAt(i) == 'R') x++;
			
			if(y > x && last == 1) {
				cost++;
				last = 2;
			}
			
			if(x > y && last == 2) {
				cost++;
				last = 1;
			}
			
			if(y > x) last = 2;
			if(x > y) last = 1;
		}
		
		out.println(cost);
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
