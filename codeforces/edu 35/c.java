import java.util.Arrays;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] intervals = new int[3];
		for(int i=0; i<3; i++)
			intervals[i] = in.nextInt();
		
		
		boolean found = false;
		search:
		for(int a=0; a<3; a++){
			boolean[] on = new boolean[4000];
			
			for(int i=0; i<4000; i+=intervals[a])
				on[i] = true;
			
			for(int b=0; b<3; b++){
				if(b == a) continue;
				
				boolean[] on2 = new boolean[4000];
				int bstart = 0;
				
				for(int i=0; i<4000; i++)
					if(!on[i]){
						bstart = i;
						break;
					}
				
				for(int i=0; i<4000; i++)
					if(on[i]) on2[i] = true;
				
				for(int i=bstart; i<4000; i+=intervals[b])
					on2[i] = true;
				
				for(int c=0; c<3; c++){
					if(c == a || c == b) continue;
					
					int cstart = 0;
					for(int i=0; i<4000; i++)
						if(!on2[i]){
							cstart = i;
							break;
						}
					
					for(int i=cstart; i<4000; i+=intervals[c])
						on2[i] = true;
					
					for(int i=0; i<4000; i++)
						if(!on2[i]) continue search;
					
					found = true;
					break search;
				}
			}
		}
		
		if(found) System.out.println("YES");
		else System.out.println("NO");

	}

}
