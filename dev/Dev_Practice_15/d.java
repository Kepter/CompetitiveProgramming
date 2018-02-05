import java.util.HashSet;
import java.util.Scanner;

public class d {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String[] line = in.nextLine().split(" ");
		
		HashSet<String> seen = new HashSet<>();
		
		for(int i=0; i<line.length; i++){
			if(seen.contains(line[i])){
				System.out.println("no");
				return;
			}
			seen.add(line[i]);
		}
			
		System.out.println("yes");
	}

}
