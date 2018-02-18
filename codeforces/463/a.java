// 932A - Palindromic Supersequence
import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String raw = in.next();
		
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		
		int l = 0;
		int r = raw.length()-1;
		
		while(l < r){
			if(l == r){
				left.append(raw.charAt(l));
				l++;
				r--;
			}
			
			else{
				left.append(raw.charAt(r));
				r--;
			}
		}
		
		left.append(raw.substring(l));
		
		l = 0;
		r = raw.length()-1;
		
		while(l < r){
			if(l == r){
				right.append(raw.charAt(l));
				l++;
				r--;
			}
			
			else{
				right.insert(0, raw.charAt(l));
				l++;
			}
		}
		
		right.insert(0, raw.substring(0, r+1));

		if(right.length() < left.length()) System.out.println(right.toString());
		else System.out.println(left.toString());
	}

}
