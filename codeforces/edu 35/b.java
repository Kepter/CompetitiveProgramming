import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		
		int plates = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		search:
		for(int i=Math.min(a, b); i>=0; i--)
		{
			int a1 = a;
			int b1 = b;
			
			for(int j=0; j<plates; j++){
				if(a1 >= i){
					a1-=i;
					continue;
				}
				
				if(b1 >= i){
					b1-=i;
					continue;
				}
				
				continue search;
			}
			
			System.out.println(i);
			break;
		}

	}

}
