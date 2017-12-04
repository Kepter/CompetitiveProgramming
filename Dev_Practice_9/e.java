package a;
import java.util.*;

public class e {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int numApart = in.nextInt();
			int width = in.nextInt();
			int length = in.nextInt();
			int height = in.nextInt();
			int areaCan = in.nextInt();
			int numObjects = in.nextInt();
			
			if(numApart == 0 && width == 0 && length == 0 && height == 0 && areaCan == 0 && numObjects == 0)
			{
				break;
			}
			
			int totalArea = width*length + width*height*2 + length*height*2;
			int totalBlocked = 0;
			
			for(int i = 0; i < numObjects; i++)
			{
				int oWidth = in.nextInt();
				int oHeight = in.nextInt();
				totalBlocked += oWidth*oHeight;
				
			}
			
			totalArea -= totalBlocked;
			totalArea *= numApart;
			int numNeeded = totalArea/areaCan;
			if(totalArea%areaCan != 0)
				numNeeded++;
			
			System.out.println(numNeeded);
		}
	}
}

/*
50 8 20 8 350 2
6 3
3 3
50 8 20 8 300 3
6 3
5 3
3 3
0 0 0 0 0 0

*/
