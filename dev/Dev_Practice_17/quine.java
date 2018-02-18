import java.util.Scanner;

public class quine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		loop:
		while(true){
			String raw = in.nextLine().trim();
			if(raw.equals("END")) break;
			
			if(raw.charAt(0) != '"'){
				System.out.println("not a quine");
				continue;
			}
			
			int numQuotes = 0;
			for(int i=0; i<raw.length(); i++)
				if(raw.charAt(i) == '"') numQuotes++;
			
			if(numQuotes < 2 || numQuotes > 2){
				System.out.println("not a quine");
				continue;
			}
			
			for(int i=1; i<raw.length()-1; i++){
				if(raw.charAt(i) == '"' && raw.charAt(i+1) == ' '){
					if(raw.substring(1, i).equals(raw.substring(i+2))){
						System.out.println("Quine("+raw.substring(i+2)+")");
						continue loop;
					}
				}
			}
			
			System.out.println("not a quine");
		}

	}

}

/*
"HELLO WORLD" HELLO WORLD
"IS A SENTENCE FRAGMENT" IS A SENTENCE FRAGMENT
"IS THE NAME OF THIS PROBLEM" IS THE NAME OF THIS PROBLEM
"YIELDS FALSEHOOD WHEN QUINED" YIELDS FALSEHOOD WHEN QUINED
"HELLO" I SAID
WHAT ABOUT "WHAT ABOUT"
" NO EXTRA SPACES " NO EXTRA SPACES
"NO"QUOTES" NO"QUOTES
""
END

*/