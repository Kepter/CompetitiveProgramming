import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class b {

	public static void main(String[] args)  throws FileNotFoundException {
		Scanner in = new Scanner(new File("overcode.in"));

		int runs = in.nextInt();
		for(int r=0; r<runs; r++){
			int num = in.nextInt();
			
			int[] skill = new int[num];
			for(int i=0; i<num; i++) skill[i] = in.nextInt();
			
			Arrays.sort(skill);
			
			int count = 0;
			int last = -1;
			int got = 0;
			for(int i=0; i<num; i++){
				if(last == -1 || skill[i] - last <= 1000){
					last = skill[i];
					got++;
				}
				else{
					last = skill[i];
					got = 1;
				}
				
				if(got == 6){
					last = -1;
					got = 0;
					count++;
				}
				
//				System.out.println("i: "+i+" got: "+got+" teams: "+count+" last: "+last);
			}
			
			System.out.println(count);
		}
	}

}
