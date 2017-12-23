import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] filled = new int[9][9];
		
		for(int i=0; i<9; i++)
		{
			if(i == 3 || i == 6) in.nextLine();
			char[] line = in.nextLine().toCharArray();
			int idx = 0;
			for(int j=0; j<9; j++)
			{
				if(j == 3 || j == 6) idx++;
				if(line[idx] == '.') filled[i][j] = 0;
				if(line[idx] == 'x') filled[i][j] = 1;
				if(line[idx] == 'o') filled[i][j] = 2;
				idx++;
			}
		}
		
//		for(int i=0; i<9; i++)
//		{
//			for(int j=0; j<9; j++)
//			{
//				if(filled[i][j]) System.out.print("x");
//				else System.out.print(".");
//			}
//			System.out.println();
//		}
		
		int row = (in.nextInt()-1)%3;
		int col = (in.nextInt()-1)%3;
//		System.out.println("r: "+row+" c: "+col);
		
		boolean open = true;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(filled[(row*3)+i][(col*3)+j] == 0) open = false;
			}
		}
		
		int[][] after = new int[9][9]; // 0 = noplay 1 = filledo 2 = play 3 = filledx
		
		if(open)
		{
			for(int r=0; r<3; r++)
			{
				for(int c=0; c<3; c++)
				{
					for(int i=0; i<3; i++)
					{
						for(int j=0; j<3; j++)
						{
							if(filled[(r*3)+i][(c*3)+j] == 1) after[(r*3)+i][(c*3)+j] = 3;
							else if(filled[(r*3)+i][(c*3)+j] == 2) after[(r*3)+i][(c*3)+j] = 1;
							else after[(r*3)+i][(c*3)+j] = 2;
						}
					}
				}
			}
		}
		
		else
		{
			for(int r=0; r<3; r++)
			{
				for(int c=0; c<3; c++)
				{
					if(r == row && c == col)
					{
						for(int i=0; i<3; i++)
						{
							for(int j=0; j<3; j++)
							{
								if(filled[(r*3)+i][(c*3)+j] == 1) after[(r*3)+i][(c*3)+j] = 3;
								else if(filled[(r*3)+i][(c*3)+j] == 2) after[(r*3)+i][(c*3)+j] = 1;
								else after[(r*3)+i][(c*3)+j] = 2;
							}
						}
					}
					
					else
					{
						for(int i=0; i<3; i++)
						{
							for(int j=0; j<3; j++)
							{
								if(filled[(r*3)+i][(c*3)+j] == 1) after[(r*3)+i][(c*3)+j] = 3;
								else if(filled[(r*3)+i][(c*3)+j] == 2) after[(r*3)+i][(c*3)+j] = 1;
								else after[(r*3)+i][(c*3)+j] = 0;
							}
						}
					}
				}
			}
		}
		
		for(int i=0; i<9; i++)
		{
			if(i == 3 || i == 6) System.out.println();
			for(int j=0; j<9; j++)
			{
				if(j == 3 || j == 6) System.out.print(" ");
				if(after[i][j] == 0) System.out.print(".");
				if(after[i][j] == 1) System.out.print("o");
				if(after[i][j] == 2) System.out.print("!");
				if(after[i][j] == 3) System.out.print("x");
			}
			System.out.println();
		}
		

	}

}