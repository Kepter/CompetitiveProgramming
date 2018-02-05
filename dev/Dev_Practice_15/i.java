import java.util.ArrayList;
import java.util.Scanner;

public class i {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		
		E[] events = new E[n];
		
		for(int i=0; i<n; i++)
			events[i] = new E(in.nextInt(), in.nextInt(), in.nextInt());
		
		BIT b = new BIT(events[events.length-1].s + events[events.length-1].b + 1);
		b.set(events[events.length-1].s, 1);
		
		int idx = n-1;
		for(int i=events[events.length-1].s; i>0; i--){
			double max = b.freq[i+1];
			
			while(idx >= 0 && events[idx].s == i){
				double sum = b.sum(i+events[idx].a, i+events[idx].b) * ((double)1 / (events[idx].b - events[idx].a + 1))+1;
				max = Math.max(max, sum);
				idx--;
			}
			b.set(i, max);
		}
		
		System.out.println(b.freq[1]);

	}
	
	static class E{
		int s;
		int a;
		int b;
		
		public E(int S, int A, int B){
			a = A;
			b = B;
			s = S;
		}
	}
	
	static class BIT{
		double[] freq;
		
		public BIT(int n){
			freq = new double[1 << (int)Math.ceil(Math.log(n)/Math.log(2)) + 1];
		}
		
		// Set the value at index to the max of its current value and the given value
		void set(int index, double val){
			
			double add = val - sum(index, index);
			if(add <= 0) return;
			
			while(index < freq.length)
			{
				freq[index] = (freq[index]+add);
				index += (index & -index);
			}
		}
		
		double sum(int hi)
		{
			double ret = 0;
			while(hi > 0)
			{
				ret = (ret+freq[hi]);
				hi -= (hi & -hi);
			}
			return ret;
		}
		
		double sum(int lo, int hi)
		{
			return (sum(hi) - sum(lo-1));
		}

		double below(int hi)
		{
			return sum(hi-1);
		}

		double above(int lo)
		{
			return (sum(lo+1, freq.length-1));
		}
		
		void print(){

			for(int i=0; i<50; i++)
				System.out.printf("%6d ", i);
			System.out.println();
			
			for(int i=0; i<50; i++)
				System.out.printf("%.4f ", freq[i]);
			System.out.println();
		}
	}
}

/*
4
1 1 7
3 2 3
5 1 4
6 10 10

5
1 1 7
1 1 6
3 2 3
5 1 4
6 10 10

*/
