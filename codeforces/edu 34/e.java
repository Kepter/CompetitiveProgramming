import java.util.Scanner;

public class e {

	// NOT SOLVED (Very close)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int len = in.nextInt();
		
		char[][] s = new char[len][num];
		for(int i=0; i<num; i++)
			s[i] = in.next().toCharArray();
		
		char[] comp = s[0];
		char t;
		
		boolean found = false;
		search:
		for(int a=0; a<len; a++)
		{
			for(int b=0; b<len; b++)
			{
				if(b == a) continue;
				t = comp[a];
				comp[a] = comp[b];
				comp[b] = t;
				
				boolean matching = true;
				for(int i=1; i<num; i++)
				{
					if(!match(s[i], comp))
					{
						matching = false;
						break;
					}
				}
				
				if(matching)
				{
					System.out.println(String.valueOf(comp));
					found = true;
					break search;
				}

				t = comp[a];
				comp[a] = comp[b];
				comp[b] = t;
			}
		}
		
		if(!found) System.out.println(-1);
		

	}
	
	static boolean match(char[] s, char[] comp)
	{
		int diffs = 0;
		
		for(int i=0; i<s.length; i++)
		{
			if(s[i] != comp[i])
			{
				diffs++;
			}
		}
		if(diffs == 0 || diffs == 2) return true;
		return false;
	}

}
