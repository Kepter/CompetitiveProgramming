

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int f = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		
		int a = in.nextInt();
		
		int sSize = -1;
		if(2*a >= 2*s && 2*s >= a)
		{
			sSize = a;
		}
		
		else if(2*s >= 2*a && 2*a >= s)
		{
			sSize = s;
		}
		
		int mSize = -1;
		if(2*m > 2*a)
		{
			mSize = 2*m;
		}
		
		int fSize = -1;
		if(2*f > 2*a)
		{
			fSize = 2*f;
		}
		

//		System.out.println(sSize+" "+mSize+" "+fSize);
		if(sSize == -1 || mSize == -1 || fSize == -1) System.out.println(-1);
		else System.out.println(fSize+"\n"+mSize+"\n"+sSize);
	}

}
