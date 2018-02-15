import java.util.Scanner;

// 59A - Word

public class word {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		
		int l = 0;
		int u = 0;
		for(int i=0; i<s.length(); i++){
			if(Character.isLowerCase(s.charAt(i))) l++;
			else u++;
		}
		
		if(u > l) System.out.println(s.toUpperCase());
		else System.out.println(s.toLowerCase());

	}

}
