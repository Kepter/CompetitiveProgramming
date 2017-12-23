import java.util.ArrayList;
import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int ph = in.nextInt();
		int pa = in.nextInt();
		
		int heal = in.nextInt();
		
		int mh = in.nextInt();
		int ma = in.nextInt();
		
		ArrayList<String> moves = new ArrayList<String>();
		while(mh > 0)
		{
			if((ph - ma) <= 0 && mh - pa > 0)
			{
				moves.add("HEAL");
				ph = ph+heal;
			}
			
			else
			{
				moves.add("STRIKE");
				mh -= pa;
			}
			
			if(mh <= 0) break;
			ph -= ma;
		}
		
		System.out.println(moves.size());
		for(int i=0; i<moves.size(); i++)
			System.out.println(moves.get(i));

	}

}
