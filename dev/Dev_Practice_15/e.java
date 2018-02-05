import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;


public class e {

static int[] R = {-1, -1, 0, 0, 1, 1};
static int[] EC = {0, -1, 1, -1, 0, -1};
static int[] OC = {0, 1, -1, 1, 0, 1};

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int r = in.nextInt();
		
		
		int len = r+r-1;
		N[][] map = new N[len][len];
		ArrayList<N> list = new ArrayList<>();		
		int id = 0;
//		System.out.println("A");
		for(int i=0; i<r-1; i++) {
			for(int j=0; j<r+i; j++) {
//				System.out.println(id);
				list.add(new N(id++, i, j+((len-(r+i))/2 + (len-(r+i))%2)));
				map[i][j+((len-(r+i))/2 + (len-(r+i))%2)] = list.get(list.size()-1);
//				System.out.println(i+" "+(j+((len-(r+i))/2 + (len-(r+i))%2))+" "+(id-1));
			}
		}

//		System.out.println("B");
		for(int i=0; i<len; i++) {
//			System.out.println(id);
			list.add(new N(id++, r-1, i));
//			System.out.println(r+" "+i+" "+(id-1));
			map[r-1][i] = list.get(list.size()-1);
		}

//		System.out.println("C");
		for(int i=r-2; i>=0; i--) {
			for(int j=0; j<r+i; j++) {
//				System.out.println(id);
				list.add(new N(id++, len-i-1, j+((len-(r+i))/2 + (len-(r+i))%2)));
				map[len-i-1][j+((len-(r+i))/2 + (len-(r+i))%2)] = list.get(list.size()-1);
//				System.out.println(len-i+" "+(j+((len-(r+i))/2 + (len-(r+i))%2))+" "+(id-1));
			}
		}
		
		int n = in.nextInt();
		int start = in.nextInt()-1;
		int tar = in.nextInt()-1;
		
		int x = in.nextInt();
		
		for(int i=0; i<x; i++)
			list.get(in.nextInt()-1).open = false;
		
		
//		for(int i=0; i<len; i++) {
//			for(int j=0; j<len; j++) {
//				System.out.print((map[i][j] == null ? "N" : (map[i][j].open ? map[i][j].id : "C"))+" ");
//			}
//			System.out.println();
//		}
		
		ArrayDeque<S> q = new ArrayDeque<S>();

		q.add(new S(0, start));
		
		int time = -1;
		
		while(!q.isEmpty()) {
			S cur = q.poll();
			N cn = list.get(cur.id);
			
			if(cn.visited) continue;
			cn.visited = true;

//			System.out.println(cur.id+" "+cur.cost);
			if(cur.id == tar) {
				time = cur.cost;
				break;
			}
			
			for(int i=0; i<6; i++) {
				int nr = R[i]+cn.r;
				int nc = -1;
				
				if((cn.r + r)%2 == 1)
					nc = OC[i] + cn.c;
				else
					nc = EC[i] + cn.c;
				
				if(nr < 0 || nc < 0 || nr >= len || nc >= len) continue;
				if(map[nr][nc] == null || !map[nr][nc].open) continue;
				
//				System.out.println(" --> "+map[nr][nc].id);
				q.add(new S(cur.cost+1, map[nr][nc].id));
			}
		}
		
		if(time > n || time == -1) System.out.println("No");
		else System.out.println(time);
	}
	
	static class N{
		int id;
		int r;
		int c;
		
		boolean open = true;
		boolean visited = false;
		
		public N(int I, int R, int C) {
			id = I;
			r = R;
			c = C;
		}
	}
	
	static class S{
		int cost;
		int id;
		
		public S(int C, int I) {
			cost = C;
			id = I;
		}
	}

}
/*
6 6 1 45 11
15 16 17 19 26 27 52 53 58 65 74

6 3 1 45 11
15 16 17 19 26 27 52 53 58 65 74

3 100 1 15 3
2 4 5

3 100 1 15 6
10 11 14 16 18 19

*/