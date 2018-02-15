// 478C - Table Decorations
import java.util.Arrays;
import java.util.Scanner;

public class tabledecorations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// This solution is really bad, don't read it
		int[] c = new int[3];
		int[] b = new int[3];
		int[] a = new int[3];
		a[0] = in.nextInt();
		a[1] = in.nextInt();
		a[2] = in.nextInt();
		
		
		int tablesa = 0;
		c = a;
		Arrays.sort(c);

		while(true){
			int diff = Math.abs(c[2]-c[1])+1;
			int change = Math.min(Math.min(c[0], c[1]), diff/4);
			c[0] -= change;
			c[1] -= change;
			c[2] -= change*4;
			
			tablesa += change*2;
			if(change == 0) break;
		}

		int change = Math.min(c[1], Math.min(c[0], c[2]));
		c[1] -= change;
		c[0] -= change;
		c[2] -= change;
		tablesa += change;

		Arrays.sort(c);
		while(true){
			int diff = Math.abs(c[2]-c[1]);
			change = Math.min(c[1], diff/2);
			c[1] -= change;
			c[2] -= change*2;
			
			tablesa += change;
			if(change == 0) break;
		}

		change = Math.min(c[1]/3, c[2]/3);
		c[1] -= change*3;
		c[2] -= change*3;
		tablesa += change*2;
		
		Arrays.sort(c);

		change = Math.min(c[1], c[2]/2);
		c[1] -= change;
		c[2] -= change*2;
		tablesa += change;

		System.out.println(Math.max(tablesa, 0));
	}

}
