// 258A - Little Elephant and Bits

import java.util.Scanner;

public class littleelephant {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String raw = in.next();
		StringBuilder out = new StringBuilder();
		
		boolean r = false;
		
		for(int i=0; i<raw.length(); i++){
			if(raw.charAt(i) == '0' && !r){
				r = true;
				continue;
			}
			out.append(raw.charAt(i));
		}
		
		if(!r) out.deleteCharAt(0);
		
		System.out.print(out.toString());
	}
}
