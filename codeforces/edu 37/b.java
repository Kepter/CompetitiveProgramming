// 920B - Tea Queue

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int runs = in.nextInt();
		for(int r=0; r<runs; r++) {
			int n = in.nextInt();
			
			P[] people = new P[n];
			P[] order = new P[n];
			
			int last = 0;
			for(int i=0; i<n; i++) {
				people[i] = new P(in.nextInt(), in.nextInt());
				order[i] = people[i];
				
				last = Math.max(last, people[i].l);
			}
			Arrays.sort(people);
			
			Queue<P> q = new LinkedList<P>();
			
			int idx = 0;
			for(int i=1; i<=last; i++) {
				while(idx < n && i >= people[idx].s) {
					q.add(people[idx++]);
				}
				
				while(!q.isEmpty() && i > q.peek().l) {
					q.poll().ret = 0;
				}
				
				if(!q.isEmpty()) q.poll().ret=i;
			}
			
			for(int i=0; i<n; i++)
				System.out.print(order[i].ret+" ");
			System.out.println();
		}
	}
	
	static class P implements Comparable<P>{
		int s;
		int l;
		int ret = 0;
		public P(int S, int L) {
			s = S;
			l = L;
		}
		@Override
		public int compareTo(P o) {
			return s-o.s;
		}
		
		
	}

}
