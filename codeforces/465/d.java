// 935D - Fafa and Ancient Alphabet

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class d {
	public static void solve(FS in, PrintWriter out) {
		int n = in.nextInt();
		m = in.nextInt();
		
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = in.nextInt();
		
		int[] b = new int[n];
		for(int i=0; i<n; i++)
			b[i] = in.nextInt();
		
		int[] slots = new int[n];
		for(int i=n-2; i>=0; i--) {
			slots[i] = slots[i+1];
			if(a[i+1] == 0) slots[i]++;
			if(b[i+1] == 0) slots[i]++;
		}
		
		invm = inv(m);
		invmsq = inv((m*m)%mod);
		
		out.println(ways(0, a, b));
		
	}
	
	static long inv(long a){
		return modPow(a, mod-2);
	}
	
	static long modPow(long n, long exp) {
		if(exp == 0) return 1;
		if(exp == 1) return n;
		
		long ret = modPow(n, exp/2);
		ret = (ret*ret)%mod;
		
		if(exp%2 == 1)
			ret = (ret*n)%mod;
		
		return ret;
	}
	
	static long m;
	static long invm;
	static long invmsq;
	static long mod = 1000000007;
	static long ways(int idx, int[] a, int[] b) {
		if(idx == a.length) return 0;
		
		long ret = 0;
		if(a[idx] != 0 && b[idx] != 0) {
			if(a[idx] > b[idx]) {
				ret = 1;
			}
			
			else if(a[idx] == b[idx]) {
				ret = ways(idx+1, a, b);
			}
			
			else {
				ret = 0;
			}
		}
		
		else if(a[idx] != 0) {
			ret = (ways(idx+1, a, b)*invm)%mod;
			ret = (ret + ((a[idx]-1)*invm)%mod)%mod;
		}
		
		else if(b[idx] != 0) {
			ret = (ways(idx+1, a, b)*invm)%mod;
			ret = (ret + ((m-b[idx])*invm)%mod)%mod;
		}
		
		else {
			ret = ((invmsq*ways(idx+1, a, b))%mod * m)%mod;
			ret = ((((((m*m - m)/2))%mod)*invmsq)%mod + ret)%mod;
		}
		return ret;
	}
	
	
	
	static long gcd(long a, long b) {
		return b == 0? a : gcd(b, a%b);
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