

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String a = in.next();
		String b = in.next();
		
		StringBuilder out = new StringBuilder();
		int idx = 1;
		out.append(a.charAt(0));
		
		while(idx < a.length() && a.charAt(idx) < b.charAt(0))
		{
			out.append(a.charAt(idx));
			idx++;
		}
		
		out.append(b.charAt(0));
		System.out.print(out.toString());

	}

}
