import java.util.Scanner;

public class ACM {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean[] solved = new boolean[26];
		long[] pen = new long[26];
		long totPen = 0;
		int sv = 0;
		
		while(true){
			int time = in.nextInt();
			if(time == -1) break;
			
			char p = in.next().charAt(0);
			String res = in.next();
			
			if(solved[p-'A']) continue;
			
			if(res.equals("wrong")){
				pen[p-'A'] += 20;
			}
			else{
				solved[p-'A'] = true;
				totPen += time + pen[p-'A'];
				sv++;
			}
			
		}
		
		System.out.println(sv+" "+totPen);

	}

}

/*
3 E right
10 A wrong
30 C wrong
50 B wrong
100 A wrong
200 A right
250 C wrong
300 D right
-1

7 H right
15 B wrong
30 E wrong
35 E right
80 B wrong
80 B right
100 D wrong
100 C wrong
300 C right
300 D wrong
-1


*/