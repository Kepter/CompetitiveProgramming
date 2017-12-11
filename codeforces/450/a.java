import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		int left = 0;
		int right = 0;
		
		for(int i=0; i<num; i++)
		{
			int n = in.nextInt();
			in.nextInt();
			if(n < 0) left++;
			if(n > 0) right++;
		}
		
		if(left > 1 && right > 1) System.out.println("No");
		else System.out.println("Yes");

	}

}
