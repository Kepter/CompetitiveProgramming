// 839C - Journey (Probability DP, easy)

import java.util.ArrayList;
import java.util.Scanner;

public class journey {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		Node[] nodes = new Node[n];
		for(int i=0; i<n; i++)
			nodes[i] = new Node();
		
		for(int i=0; i<n-1; i++){
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			nodes[a].adj.add(nodes[b]);
			nodes[b].adj.add(nodes[a]);
		}
		
		
		System.out.println(dfs(nodes[0], null));
	}
	
	static double dfs(Node cur, Node last){
		if(cur.expected != -1) return cur.expected;
		cur.expected = 0;
		
		int cnt = 0;
		for(Node n : cur.adj){
			if(n == last) continue;
			cnt++;
			cur.expected += dfs(n, cur)+1;
		}
		if(cnt > 0) cur.expected /= cnt;
		
		return cur.expected;
	}
	
	static class Node{
		double expected = -1;
		ArrayList<Node> adj = new ArrayList<Node>();
	}

}
