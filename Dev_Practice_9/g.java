import java.util.*;

public class g {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int size = in.nextInt();
			if(size == 0)
				break;
			
			char[][] grid = new char[size][size];
			
			for(int row = 0; row < size; row++)
			{
				grid[row] = in.next().toCharArray();
				processLine(grid[row]);
			}
			
			for(int col = 0; col < size; col++)
			{
				char[] tempCol = new char[size];
				for(int row = 0; row < size; row++)
				{
					tempCol[row] = grid[row][col];
				}
				processLine(tempCol);
			}
		}
		
		
	}
	
	static void processLine(char[] line)
	{
		ArrayList<Integer> output = new ArrayList<Integer>();
		int ind1=0, ind2=0;
		boolean cont = true;
		while(cont)
		{
			ind1 = findIndexOf(line, 'X', ind2);
			if(ind1 == -1)
				break;
			ind2 = findIndexOf(line, '.', ind1);
			if(ind2 == -1)
			{
				ind2 = line.length;
				cont = false;
			}
			int num = ind2 - ind1;
			output.add(num);
		}
		if(output.size() == 0)
		{
			output.add(0);
		}
		print(output);
	}
	
	static int findIndexOf(char[] line, char target, int start)
	{
		int output = -1;
		for(int i = start; i < line.length; i++)
		{
			if(target == line[i])
			{
				output = i;
				break;
			}
		}
		return output;
	}
	
	static void print(ArrayList<Integer> line)
	{
		for(int i = 0; i < line.size(); i++)
		{
			System.out.print(line.get(i));
			if(i + 1 != line.size())
				System.out.print(" ");
		}
		System.out.println();
	}
}

/*
3
XXX
.XX
.X.
3
X.X
..X
X..
5
..X..
.XXX.
X.X.X
..X..
..X..
3
...
XXX
...
0

*/
