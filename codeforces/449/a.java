import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int len = in.nextInt();
		int ops = in.nextInt();
		
		char[] out = in.next().toCharArray();
		
		for(int i=0; i<ops; i++)
		{
			int left = in.nextInt()-1; 
			int r = in.nextInt()-1;
			char from = in.next().charAt(0);
			char to = in.next().charAt(0);
			
			for(int j=left; j<=r; j++)
				if(out[j] == from) out[j] = to;
			
		}
		
		System.out.println(String.copyValueOf(out));

	}

}
