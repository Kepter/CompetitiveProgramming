import java.util.ArrayList;
import java.util.Scanner;

//334A - Candy Bags

public class candybags {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n/2; j++){
				System.out.print(((i*n)+j+1) +" "+ ((n*n)-(i*n)-j)+" ");
			}
			System.out.println();
		}
		
	}

}