import java.util.Scanner;

public class revenge {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			long a = scan.nextInt();
			if(a == 0) {
				break;
			}
			
			long square = a*a;
			long max = ((int)Math.ceil(Math.sqrt(2)-1))*a;
			
			
			int sums = 0;
			for(long i = 1; i <= max; i++) {
				//System.out.println(i);
				long j = square/i;
				if((i*j) != square) {
					continue;
				}
				
				long b = (j-i)/2;
				//System.out.println("b: "+b);
				if((b*2) != (j-i)) {
					continue;
				}
				
				long c = j-b;
				
				if(b <= a) {
					continue;
				}
				
				if(c <= b) {
					continue;
				}
				
				sums++;
			}
			
			System.out.println(sums);
		}

	}

}

/*
3
12
2
1048574
1048575
0

*/