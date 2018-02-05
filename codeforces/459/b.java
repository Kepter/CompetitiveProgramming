// 918B - Radio Station

import java.util.HashMap;
import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		HashMap<String, String> name = new HashMap<String, String>();
		
		for(int i=0; i<n; i++){
			String a = in.next();
			String b = in.next();
			name.put(b, a);
		}
		
		for(int i=0; i<m; i++){
			String a = in.next();
			String b = in.next();
			
			System.out.println(a+" "+b+" #"+name.get(b.substring(0, b.length()-1)));
		}

	}

}

/*
3 5
google 8.8.8.8
codeforces 212.193.33.27
server 138.197.64.57
redirect 138.197.64.57;
block 8.8.8.8;
cf 212.193.33.27;
unblock 8.8.8.8;
check 138.197.64.57;

*/