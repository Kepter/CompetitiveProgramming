import java.util.HashSet;
import java.util.Scanner;

// 217A - Ice Skating

public class iceskating {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int n = in.nextInt();
		
		int[] x = new int[n];
		int[] y = new int[n];
		
		
		for(int i=0; i<n; i++){
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		DS set = new DS(n);
		for(int i=0; i<n; i++){
			for(int j=0; j<i; j++){
				if(x[i] == x[j]) set.union(i, j);
				if(y[i] == y[j]) set.union(i, j);
			}
		}
		
		HashSet<Integer> seen = new HashSet<>();
		
		int cnt = 0;
		for(int i=0; i<n; i++){
			if(seen.contains(set.find(i))) continue;
			seen.add(set.find(i));
			cnt++;
		}
		System.out.println(cnt-1);
	}
	
	static class DS{
		int[] p;
		int[] r;
		
		public DS(int n){
			p = new int[n];
			r = new int[n];
			
			for(int i=0; i<n; i++){
				p[i] = i;
			}
		}
		
		public int find(int n){
			if(p[n] != n) p[n] = find(p[n]);
			return p[n];
		}
		
		public void union(int a, int b){
			a = find(a);
			b = find(b);
			
			if(r[a] < r[b]) p[a] = b;
			else if(r[b] < r[a]) p[b] = a;
			else{
				p[a] = b;
				r[b]++;
			}
		}
	}

}
