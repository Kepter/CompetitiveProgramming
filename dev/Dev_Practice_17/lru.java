import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class lru {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int run = 1;
		while(true){
			int n = in.nextInt();
			if(n == 0) break;
			
			TreeSet<Item> set = new TreeSet<Item>();
			HashMap<Character, Item> has = new HashMap<>();
			
			System.out.println("Simulation "+(run++));
			
			int time = 0;
			String coms = in.next();
			for(int i=0; i<coms.length(); i++){
				if(coms.charAt(i) == '!'){
					Iterator<Item> it = set.iterator();
					
					while(it.hasNext()){
						System.out.print(it.next().id);
					}
					System.out.println();
				}
				
				else{
					if(has.containsKey(coms.charAt(i))){
						Item s = has.get(coms.charAt(i));
						set.remove(s);
						s.time = time++;
						set.add(s);
					}
					
					else{
						if(set.size() == n){
							Item r = set.pollFirst();
							has.remove(r.id);
						}
						Item s = new Item(time++, coms.charAt(i));
						set.add(s);
						has.put(s.id, s);
					}
				}
			}
		}
		
		
	}
	
	
	static class Item implements Comparable<Item>{
		int time;
		char id;
		
		public Item(int t, char c){
			time = t;
			id = c;
		}
		
		public int compareTo(Item o) {
			return (time - o.time);
		}
	}
}

/*
5 ABC!DEAF!B!
3 WXWYZ!YZWYX!XYXY!
5 EIEIO!
0

*/
