import java.util.Scanner;

public class e {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int given = in.nextInt();
		
		boolean[] used = new boolean[size+5];
		boolean[] inStack = new boolean[size+5];
		
		int[] perm = new int[size];
		int[] stack = new int[size+5];
		int top = 0;
		int front = 0;
		
		for(int i=0; i<given; i++){
			perm[i] = in.nextInt();
			used[perm[i]] = true;
		}
		
		// Process the first k elements
		int next = 1;
		for(int i=0; i<given; i++){
			
			if(inStack[next]){
				if(stack[top] != next){
					System.out.println(-1);
					return;
				}
				
				inStack[next] = false;
				top--;
				next++;
				continue;
			}
			
			while(perm[front] != next && front < given){
				if(perm[front] > stack[top] && top != 0){
					System.out.println(-1);
					return;
				}
				inStack[perm[front]] = true;
				stack[++top] = perm[front++];
			}
			
			if(front == given) break;
			if(perm[front] == next) {
				next++;
				front++;
			}
		}
		
//		System.out.println("STACK: ");
//		for(int i=0; i<=top; i++)
//			System.out.println(stack[i]+" ");
		
		int maxAdd = size;
		while(maxAdd >= 0 && used[maxAdd])
			maxAdd--;
		
		// Add remaining elements to the array
		for(int i=given; i<size; i++){
			while(top >= 0 && stack[top] == next){
				top--;
				next++;
			}
			
			int add = stack[top]-1;
			if(top == 0) add = maxAdd;
			
			while(add >=0 && used[add])
				add--;
			
			if(add <= 0){
				System.out.println(-1);
				return;
			}
			
			perm[i] = add;
			used[add] = true;
			stack[++top] = add;
			
			while(maxAdd >= 0 && used[maxAdd])
				maxAdd--;
		}
		
		// Pls no hackerino 
		for(int i=0; i<size; i++)
			System.out.print(perm[i]+" ");
		System.out.println();
		
	}

}
/*
5 3
5 1 4

*/