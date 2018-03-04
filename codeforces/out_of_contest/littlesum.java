// 276C - Little Girl and Maximum Sum

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class littlesum {
	public static void solve(FS in, PrintWriter out) {

		int n = in.nextInt();
		int q = in.nextInt();
		
		int[] vals = new int[n];
		for(int i=0; i<n; i++)
			vals[i] = in.nextInt();
		
		Arrays.sort(vals);
	
		DE count = new DE(n);
		for(int i=0; i<q; i++) {
			count.add(in.nextInt()-1, in.nextInt()-1, 1);
		}
		
		long[] tot = count.get();
		Arrays.sort(tot);
		
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum += vals[i]*tot[i];
		}
		
		out.println(sum);
	}
	
	static class DE{
		long[] delta;
		long[] init;
		
		public DE(int s){
			init = new long[s];
			delta = new long[init.length+1];
		}
		
		void add(int l, int r, long v){
			delta[l] += v;
			delta[r+1] -= v;
		}
		
		long[] get(){
			long[] ret = Arrays.copyOf(init, init.length);
			long sum = 0;
			for(int i=0; i<init.length; i++){
				sum += delta[i];
				ret[i] += sum;
			}
			
			return ret;
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
