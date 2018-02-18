import java.util.Scanner;

public class digits {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while(true){

			int s = in.nextInt();
			if(s == 0) break;
			
			while(s%10 != s){
				System.out.print(s+" ");
				int t = 1;
				while(s > 0){
					t *= s%10;
					s /= 10;
				}
				s = t;
			}
			
			System.out.println(s);
		}
		
	}

}
