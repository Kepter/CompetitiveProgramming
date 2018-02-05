import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int base = 0;
		int count = 0;
		
		for(int i=0; i<n; i++){
			int a = in.nextInt();
			if(a == -1) continue;
			base++;
			count += a;
		}
		
		System.out.println(((double)count/base));

	}

}
/*
3
3 0 2

3
1 -1 4

*/