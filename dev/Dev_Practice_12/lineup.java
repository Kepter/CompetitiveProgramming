import java.util.Scanner;

public class lineup {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		boolean inc = true;
		boolean dec = true;
		
		String last = "";
		for(int i=0; i<n; i++){
			String cur = in.next();
			
			if(i != 0){
				if(cur.compareTo(last) < 0) inc = false;
				if(cur.compareTo(last) > 0) dec = false;
			}
			
			last = cur;
		}
		
		if(inc) System.out.println("INCREASING");
		else if(dec) System.out.println("DECREASING");
		else System.out.println("NEITHER");
	}

}
