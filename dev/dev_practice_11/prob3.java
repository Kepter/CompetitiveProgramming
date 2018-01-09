import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class prob3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> words = new ArrayList<String>();
		HashMap<String, Integer> count = new HashMap<>();
		
		int mode = 0;
		ArrayList<String> modes = new ArrayList<String>();
		
		
		while(in.hasNext()) {
			String raw = in.next();
//			if(raw.equals("0")) break;
			StringBuilder l = new StringBuilder();
			
			for(int i=0; i<raw.length(); i++) {
				if(!Character.isAlphabetic(raw.charAt(i))) continue;
				l.append(Character.toLowerCase(raw.charAt(i)));
			}
			
			words.add(l.toString());
			
			if(!count.containsKey(l.toString())) {
				count.put(l.toString(), 1);
				if(1 > mode) {
					mode = 1;
					modes.clear();
					modes.add(l.toString());
				}
				
				else if(1 == mode) {
					modes.add(l.toString());
				}
			}
			
			else {
				int c = count.get(l.toString())+1;
				count.put(l.toString(), c);
				if(c > mode) {
					mode = c;
					modes.clear();
					modes.add(l.toString());
				}
				
				else if(c == mode) {
					modes.add(l.toString());
				}
			}
		}
		
		Collections.sort(words);
		Collections.sort(modes);
		
		System.out.print("My median=[");
		if(words.size()%2 == 0) {
			System.out.println(words.get(words.size()/2 - 1)+","+words.get(words.size()/2)+"]");
		}
		else {
			System.out.println(words.get(words.size()/2)+"]");
		}
		
		System.out.print("My mode=[");
		for(int i=0; i<modes.size(); i++) {
			if(i!=0)
				System.out.print(",");
			System.out.print(modes.get(i)+"("+mode+")");
		}
		System.out.println("]");
		
		
	}

}

/*
the the the
dog dog dog
man man man

the
*/
