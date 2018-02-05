import java.util.Scanner;

public class a {

	static int[] DX = {1, 1, -1, -1, 2, 2, -2, -2};
	static int[] DY = {2, -2, 2, -2, 1, -1, 1, -1};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[][] board = new char[5][5];
		
		for(int i=0; i<5; i++)
			board[i] = in.next().toCharArray();
		
		int count = 0;
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				if(board[i][j] == 'k'){
					if(!check(board, i, j)){
						System.out.println("invalid");
						return;
					}
					count++;
				}
		
		if(count == 9)
			System.out.println("valid");
		else
			System.out.println("invalid");
	}
	
	static boolean check(char[][] board, int x, int y){
		
		for(int i=0; i<DX.length; i++){
			int nx = x+DX[i];
			int ny = y+DY[i];
			
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
			if(board[nx][ny] == 'k') return false;
		}
		return true;
	}

}

/*
...k.
...k.
k.k..
.k.k.
k.k.k

.....
...k.
k.k.k
.k.k.
k.k.k

.....
...k.
k.k.k
.k.k.
k...k




 */
