import java.util.Scanner;

public class hidden {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String pass = in.next();
		String s = in.next();
		
		int pidx = 0;
		boolean valid = false;
		
		search:
		for(int i=0; i<s.length(); i++){
			
			if(s.charAt(i) == pass.charAt(pidx)){
				pidx++;
				
				if(pidx >= pass.length()){
					valid = true;
					break;
				}
				
				continue;
			}
			
			char c = s.charAt(i);
			for(int j=pidx+1; j< pass.length(); j++){
				if(c == pass.charAt(j)){
					break search;
				}
			}
		}
		
		if(valid) System.out.println("PASS");
		else System.out.println("FAIL");

	}

}
