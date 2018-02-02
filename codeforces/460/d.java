// 919D - Substring

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class d {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		ArrayList<TreeSet<Integer>> adj = new ArrayList<>();
		int[] incoming = new int[n];
		char[] l = in.next().toCharArray();
		
		for(int i=0; i<n; i++)
			adj.add(new TreeSet<Integer>());
		
		for(int i=0; i<m; i++){
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			
			if(!adj.get(a).contains(b)){
				adj.get(a).add(b);
				incoming[b]++;
			}
		}
		
		int[][] dp = new int[n][26];
		for(int i=0; i<n; i++)
			dp[i][l[i]-'a'] = 1;
		
		int best = Integer.MIN_VALUE;
		boolean[] visited = new boolean[n];
		
		
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		
		for(int i=0; i<n; i++)
			if(incoming[i] == 0) que.add(i);
		
		while(!que.isEmpty()){
			int cur = que.poll();
			
			visited[cur] = true;
			
			Iterator<Integer> i = adj.get(cur).iterator();
			while(i.hasNext()){
				int next = i.next();
				incoming[next]--;
				
				for(int j=0; j<26; j++){
					dp[next][j] = Math.max(dp[next][j], dp[cur][j] + ((j == (l[next]-'a')) ? 1 : 0));
					best = Math.max(best, dp[next][j]);
				}
				
				if(incoming[next] == 0)
					que.add(next);
			}
		}
		
//		for(int i=0; i<n; i++){
//			for(int j=0; j<26; j++)
//				System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
		boolean cycle = false;
		for(int i=0; i<n; i++){
			if(!visited[i]){
				cycle = true;
			}
		}
		
		if(!cycle) System.out.println(best);
		else System.out.println(-1);
	}
}

/*
7 6
ababccc
1 2
1 4
2 4
2 3
5 6
6 7

7 7
ababccc
1 2
1 4
2 4
2 3
5 6
6 7
7 5
 
5 4
aabcd
1 2
1 3
4 2
4 5

7 8
aabccec
1 2
1 3
4 2
4 5
2 6
5 6
6 7
5 7

6 7
aaaade
1 2
1 3
4 2
4 5
2 5
5 6
6 3

3 5
aba
1 2
1 3
1 3
2 3
2 3


*/