import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		boolean[] p = {false, false, false, true, false ,false, true, true, false, true, true, false, true};
		
		
		for(int i=0; i<n; i++)
		{
			int tar = in.nextInt();
			
			if(tar > 12 || p[tar]) System.out.println("YES");
			else System.out.println("NO");
		}

	}

}
