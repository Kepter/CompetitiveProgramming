import java.util.Scanner;

public class f {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		String a = in.next();
		String b = in.next();
		
		int bs = -1;
		int be = -1;
		
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				bs = i;
				break;
			}
		}
		
		for(int i=bs+1; i<b.length(); i++) {
			if(a.charAt(i) == b.charAt(i) && be == -1) 
				be = i;
			
			if(a.charAt(i) != b.charAt(i))
				be = -1;
		}
		
		if(be == -1) be = a.length();
		be--;

		for(int i=0; i<=be-bs; i++) {
			if(a.charAt(bs+i) != b.charAt(be-i)) {
				System.out.println(0);
				return;
			}
		}
		
		
		long count = 1;
		for(int i=1;;i++) {
			if(be + i >= a.length() || bs - i < 0) break;
			
			if(a.charAt(be+i) == b.charAt(bs-i)) count++;
            else break;
		}
		
		System.out.println(count);
	}

}
