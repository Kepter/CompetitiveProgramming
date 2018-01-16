import java.util.Scanner;

public class b {

	static int[] DC = {0, 0, 1, -1};
	static int[] DR = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int height = in.nextInt();
		int width = in.nextInt();
		
		char[][] map = new char[height][];
		
		int sx = 0;
		int sy = 0;
		for(int i=0; i<height; i++){
			map[i] = in.next().toCharArray();
			for(int j=0; j<map[i].length; j++)
				if(map[i][j] == 'S'){
					sy = i;
					sx = j;
				}
			}

		char[] coms = in.next().toCharArray();
		
		int valid = 0;
		for(int u=0; u<4; u++){
			for(int d=0; d<4; d++){
				if(d == u) continue;
				for(int l=0; l<4; l++){
					if(l == d || l == u) continue;
					search:
					for(int r=0; r<4; r++){
						if(r == d || r == l || r == u) continue;
						
						int col = sx;
						int row = sy;
						
						for(int i=0; i<coms.length; i++){
							
							int nc = col;
							int nr = row;
							
							if(coms[i]-'0' == l) nc -= 1;
							if(coms[i]-'0' == r) nc += 1;
							if(coms[i]-'0' == d) nr -= 1;
							if(coms[i]-'0' == u) nr += 1;
							
							if(nc < 0 || nr < 0 || nc >= width || nr >= height)
								continue search;
							if(map[nr][nc] == '#') continue search;
							if(map[nr][nc] == 'E'){
								valid++;
								continue search;
							}
							
							col = nc;
							row = nr;
						}
					}
				}
			}
			
		}
		
		
		System.out.println(valid);
	}

}
