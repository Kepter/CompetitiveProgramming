import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		ArrayList<Seg> segs = new ArrayList<Seg>();
		
		int count = 0;
		
		for(int s=0; s<n; s++)
			for(int e=n; e>s; e--)
			{
				segs.add(new Seg(e-s, s, e));
			}
		
		Collections.sort(segs);
		
		loop:
		while(segs.size()>0)
		{
			Seg big = segs.get(segs.size()-1);
			
			for(int i=segs.size()-2; i>=0; i--)
			{
				Seg add = segs.get(i);
				if((add.s >= big.e) || (big.s >= add.e))
				{
					int s = Math.min(add.s, big.s);
					int e = Math.max(add.e, big.e);
					Seg nw = new Seg(e-s, s, e);
					segs.remove(segs.size()-1);
					segs.remove(i);
					
					
					if(nw.len < n)
						segs.add(nw);
					else
						count++;
					
					continue loop;
				}
			}
			
			segs.remove(segs.size()-1);
			count++;
		}
		
		System.out.println(count);
	}
	
	static class Seg implements Comparable<Seg>
	{
		int len;
		int s, e;
		
		public Seg(int l, int S, int E)
		{
			len = l;
			s = S;
			e = E;
		}

		public int compareTo(Seg o) {
			if(o.len != len)
				return o.len-len;
			else
				return s-o.s;
		}
	}
}
