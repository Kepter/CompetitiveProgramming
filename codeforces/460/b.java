// 919B - Perfect Number

import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int k = in.nextInt()+1;
		
		
		int val = 19;
		int count = 1;
		while(count<k){
			if(isperfect(val)) count++;
			if(count == k) System.out.println(val);
			val++;
		}
		

	}
	
	public static boolean isperfect(int i){
		
		int sum = 0;
		
		while(i > 0){
			if(sum >= 10) break;
			sum += i%10;
			i /= 10;
		}
		
		if(sum == 10 && i == 0) return true;
		return false;
	}

}
