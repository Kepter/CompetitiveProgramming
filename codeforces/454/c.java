import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean[] not = new boolean[26];
		
		int turns = in.nextInt();
		int left = 26;
		int excess = 0;
		
		for(int i=0; i<turns; i++)
		{
			char type = in.next().charAt(0);
			String say = in.next();
			
			if(type == '.')
			{
				for(int c=0; c<say.length(); c++)
				{
					if(!not[say.charAt(c)-'a']) left--;
					not[say.charAt(c)-'a'] = true;
				}
			}
			
			if(type == '!')
			{
				if(left == 1) excess++;
				else
				{
					boolean[] said = new boolean[26];
					for(int c=0; c<say.length(); c++)
						said[say.charAt(c)-'a'] = true;
				
					for(int j=0; j<26; j++)
					{
						if(said[j]) continue;
						
						if(!not[j]) left--;
						not[j] = true;
					}
				}
			}
			
			if(type == '?')
			{
				if(i+1 < turns)
				{
					if(left == 1) excess++;
					
					else
					{
						if(!not[say.charAt(0)-'a']) left--;
						not[say.charAt(0)-'a'] = true;
					}
				}
			}
		}
		System.out.println(excess);

	}

}
