import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int types = scan.nextInt();
			int cents = (int)(scan.nextDouble() *100);
			if(types ==0 && cents == 0) {
				break;
			}
			
			int[] val = new int[types];
			int[] cost = new int[types];
			for(int i = 0; i < types; i++) {
				val[i] = scan.nextInt();
				cost[i] = (int) (scan.nextDouble()*100);
			}
			
			int[] best = new int[cents +1];
			for(int i = 1; i <= cents;i++) {
				for(int j = 0; j < types; j++) {
					if(i-cost[j] >=0) {
						best[i] = Math.max(best[i], best[i-cost[j]] + val[j]);
					}
				}
			}
			System.out.println(best[cents]);
		}

	}

}

/*
2 8.00
700 7.00
199 2.00
3 8.00
700 7.00
299 3.00
499 5.00
0 0.00

*/