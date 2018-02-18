import java.util.Arrays;
import java.util.Scanner;

public class juggle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true){
			int p = in.nextInt();
			if(p == 0) break;
			
			int[] jump = new int[20];
			int[] seq = new int[p];
			char[] sequence = new char[20];
			Arrays.fill(sequence, '!');
			
			for(int i=0; i<p; i++)
				seq[i] = in.nextInt();
			
			for(int i=0; i<20; i++){
				jump[i] = seq[i%p];
			}

			int nextChar = 0;
			boolean crash = false;
			for(int i=0; i<20; i++){
				if(sequence[i] == '!'){
					char c = (char)((nextChar++)+'A');
					
					for(int j=i; j<20; j+= seq[j%p]){
						if(sequence[j] != '!') crash = true;
						sequence[j] = c;
					}
				}
			}
			
			if(crash) System.out.println("CRASH");
			else System.out.println(sequence);
			
		}

	}

}
/*
3 3 4 5
1 3
3 3 5 4
5 7 7 7 3 1
0

*/