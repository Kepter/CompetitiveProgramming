package a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class d {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int essays = scan.nextInt();
			int relations = scan.nextInt();
			
			if(essays == 0) {
				break;
			}
			
			Node[] nodes = new Node[essays];
			for(int i = 0; i < essays; i++) {
				nodes[i] = new Node();
			}
			
			for(int i = 0; i < relations; i++) {
				int d = scan.nextInt() -1;
				int u = scan.nextInt() -1;
				nodes[d].edgelist.add(new Edge(nodes[u]));
			}
			TopSort tp = new TopSort(nodes);
			
			System.out.println(tp.sortTop());
		}

	}

}

class TopSort{
	public Node[] ordering;
	boolean[] used;
	int nodes; 
	Node[] nodeList;
	
	public TopSort(Node[] list) {
		nodeList = list; nodes = list.length;
		used = new boolean[nodes]; ordering = new Node[nodes];
	}
	
	public int sortTop() {
		int currIndex = 0; int retVal = 1; int count = 0;
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		for (int i = 0; i < nodes; i++){
			if(nodeList[i].inDegree == 0) {
				queue.add(nodeList[i]);
				count++;
			}
		}
		while (currIndex < nodes){
			if(queue.size() ==0) return 0;
			if(queue.size() > 1) retVal = 2;
			int nextCount = 0;
			for(int i = 0;i < count; i++) {
				Node n = queue.poll();
				ordering[currIndex] = n;
				currIndex++;
				for(Edge e: n.edgelist) {
					e.towards.inDegree--;
					if(e.towards.inDegree ==0) {
						queue.add(e.towards);
						nextCount++;
					}
				}
			}
			count = nextCount;
		}
		return retVal;
	}
}

class Node{
	public int inDegree;
	public ArrayList<Edge> edgelist;
	
	public Node() {
		inDegree = 0;
		edgelist = new ArrayList<Edge>();
	}
}

class Edge{
	public Node towards;
	public Edge(Node n){
		towards = n;
		n.inDegree++;
	}
}

/*
5 4
1 5
5 2
3 2
4 3

5 4
3 1
4 2
1 5
5 4

2 2
1 2
2 1

0 0

*/