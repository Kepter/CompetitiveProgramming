import java.util.Scanner;

public class bounce {

	
	static int DY[] = {1,1,0,0,-1,-1};
	static int ODX[] = {0,1,-1,1,0,1};
	static int EDX[] = {-1,0,-1,1,-1,0};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(true) {
			int r = in.nextInt();
			if(r == 0) break;
			
			int c = in.nextInt();
			patLen = in.nextInt();
			
			grid = new char[r][];	
			boolean[][] used = new boolean[r][];
			
			for(int i=0; i<r; i++) {
				grid[i] = new char[c+i%2];
				used[i] = new boolean[c+i%2];
			}
			
			for(int i=0; i<r; i++)
				for(int j=0; j<c+i%2; j++) {
					grid[i][j] = in.next().charAt(0);
				}
			
			minLen = -1;
			
			for(int i=0; i<c-1; i++) {
				used[0][i] = true;
				sx = i;
				StringBuilder str = new StringBuilder();
				str.append(grid[0][i]);
				dfs(used, i, 0, 1, str, r == 1 ? true : false);
				
				used[0][i] = false;
			}
			
			if(minLen == -1) System.out.println("no solution");
			else System.out.println(minStr);
		}
		
		
	}
	
	static char[][] grid;
	static int minLen;
	static int patLen;
	static String minStr;
	
	static int sx;
	
	static void dfs(boolean[][] used, int x, int y, int len, StringBuilder str, boolean bot) {
		
		if(len > 0 && len%patLen == 0 && bot && x > sx && y == 0) {
			if(len < minLen || minLen == -1) {
				minLen = len;
				StringBuilder out = new StringBuilder();
				
				for(int i=0; i<len/patLen; i++)
					out.append(str.toString());
				
				minStr = out.toString();
			}
		}
		
		if(minLen != -1 && len > minLen) return;
		
		for(int d=0; d<6; d++) {
			int nx = x;
			int ny = y + DY[d];
			
			if(y%2 == 0) nx += ODX[d];
			else nx += EDX[d];
			
			if(nx < 0 || ny < 0 || ny >= used.length || nx >= used[ny].length) continue;
			if(used[ny][nx]) continue;

			boolean hitBot = bot;
			if(ny == used.length-1) hitBot = true; 
			
			if(len < patLen) {
				str.append(grid[ny][nx]);
				
				used[ny][nx] = true;
				dfs(used, nx, ny, len+1, str, hitBot);
				used[ny][nx] = false;
				
				str.deleteCharAt(str.length()-1);
			}
			
			else {
				if(str.charAt((len)%patLen) != grid[ny][nx]) continue;

				used[ny][nx] = true;
				dfs(used, nx, ny, len+1, str, hitBot);
				used[ny][nx] = false;
			}
		}
		
	}

}

/*
3 3 2
 B D C
C E B G
B C B

3 5 4
A B E B D
A C D C A D
D B B B C

3 3 4
B D C
C E B G
B C B

3 4 4
B D H C
C E F G B
B C B C

0


*/