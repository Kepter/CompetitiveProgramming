// Jamie and Binary Sequence
// FAKE SOLUTION, PROBLEM HAD BAD DATA AND WAS UNRATED LOL

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		HashMap<Integer, Integer> bits = new HashMap<Integer,Integer>();
		
		long n = in.nextLong();
		int k = in.nextInt();
		
		int b = 0;
		int max = 0;
		int used = 0;
		while(n != 0){
			if(((1L<<b) & n) != 0){
//				System.out.println(b);
				n = n^(1L<<b);
				if(!bits.containsKey(b))
					bits.put(b, 0);
				bits.merge(b, 1, Integer::sum);
				used++;
				max = b;
			}
			
			b++;
		}
		
//		System.out.print(max+ " --- ");
//		System.out.print(" --- ");
//		for(Integer i : bits.keySet())
//			System.out.print(i+" "+bits.get(i));
//		System.out.println();
		
		
		if(used > k){
			System.out.println("No");
			return;
		}
		
		while(used < k){
			bits.merge(max, -1, Integer::sum);
			if(!bits.containsKey(max-1))
				bits.put(max-1, 0);
			bits.merge(max-1, 2, Integer::sum);
			used++;
			
//			System.out.print(" --- ");
//			for(Integer i : bits.keySet())
//				System.out.print(i+" "+bits.get(i));
//			System.out.println();
			
			if(bits.get(max) == 0)
				max--;
		}
		
//		System.out.print(" --- ");
//		for(Integer i : bits.keySet())
//			System.out.print(i+" "+bits.get(i));
//		System.out.println();
		
		
		System.out.println("Yes");
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(Integer i : bits.keySet())
			for(int j=0; j<bits.get(i); j++)
				out.add(i);

		Collections.sort(out);
//		System.out.println(out.size());
		for(int i=out.size()-1; i>=0; i--)
			System.out.print(out.get(i)+" ");
	}

}
