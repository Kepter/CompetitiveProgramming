import java.util.Scanner;

// 476A - Dreamoon and Stairs

public class dreamoon {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int sA = n/2;
		int sB = n%2;
		
		if((sA + sB)%m == 0){
			System.out.println(sA + sB);
			return;
		}
		
		while(sA > 0){
			sA--;
			sB += 2;
			if((sA + sB)%m == 0){
				System.out.println(sA + sB);
				return;
			}
		}
		
		System.out.println(-1);
	}
}
