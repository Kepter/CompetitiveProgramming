// 295A - Greg and Array
import java.util.ArrayDeque;
import java.util.Scanner;

public class gregarray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		RBIT bit = new RBIT(n);
		
		for(int i=0; i<n; i++)
			bit.addRange(i, i, in.nextInt());
		
		int[] a = new int[m];
		int[] b = new int[m];
		int[] c = new int[m];
		
		for(int i=0; i<m; i++){
			a[i] = in.nextInt()-1;
			b[i] = in.nextInt()-1;
			c[i] = in.nextInt();
		}

		RBIT ops = new RBIT(m);
		
		for(int i=0; i<k; i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			ops.addRange(x, y, 1);
		}
		
		for(int i=0; i<m; i++){
			bit.addRange(a[i], b[i], c[i]*ops.get(i));
		}
		
		for(int i=0; i<n; i++)
			System.out.print(bit.get(i)+" ");
		System.out.println();
		

	}
	
	static class RBIT{
		
		static class Node{
			Node l;
			Node r;
			long val = 0;
			
			int vl;
			int vr;
		}
		
		Node head;
		public RBIT(int n){
			int s = 1 << (int)Math.ceil(Math.log(n)/Math.log(2));
			head = build(s, 0, s-1);
		}
		
		// Builds the tree, only call from constructor
		private Node build(int size, int vl, int vr){
			if(size <= 0) return null;
			
			Node n = new Node();
			n.l = build(size/2, vl, vl+(vr-vl)/2);
			n.r = build(size/2, vl+(vr-vl)/2+1, vr);
			n.vl = vl;
			n.vr = vr;
			
			return n;
		}
		
		// Add V to range l to r in log(n), n is BIT size
		public void addRange(int l, int r, long v){
			addRange(l, r, v, head);
		}
		
		private void addRange(int l, int r, long v, Node cur){
			
			if(cur.vl >= l && cur.vr <= r){
				cur.val += v;
				return;
			}
			
			if(cur.vr < l || cur.vl > r ) return;
			
			if(cur.vr >= r) addRange(l, r, v, cur.l);
			if(cur.vl <= l) addRange(l, r, v, cur.r);
		}
		
		// Gets value at n
		public long get(int n){
			Node cur = head;
			
			long ret = head.val;
			while(true){
				if(cur.vr == cur.vl && cur.vl == n) return ret;
				if(Math.abs(cur.vr-n) < Math.abs(cur.vl-n)) cur = cur.r;
				else cur = cur.l;
				ret += cur.val;
			}
		}
		
		// Not great debug print
		public void print(){
			ArrayDeque<Node> que = new ArrayDeque<Node>();
			que.add(head);
			
			while(!que.isEmpty()){
				Node c = que.poll();
				
				System.out.print("("+c.vl+","+c.vr+" "+(c.vr-c.vl+1)+": "+c.val+") ");
				if(c.l != null) que.add(c.l);
				if(c.r != null) que.add(c.r);
			}
			System.out.println();
		}
	}
}

/*

1 2 3


     0
  8     0
1   2 9   0






 */
