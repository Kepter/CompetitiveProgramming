import java.util.Arrays;
import java.util.Scanner;

public class f {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int people = scan.nextInt();
			if(people == 0) {
				break;
			}
			
			String[] list = new String[people];
			for(int i = 0; i < people; i++) {
				list[i] = scan.next();
			}
			Arrays.sort(list);
			
			String first = list[(people/2)-1];
			String second = list[(people/2)];
			int currIndex = 0;
			StringBuilder str = new StringBuilder();
			boolean diff = false;
			boolean strPrint = false;
			boolean printed = false;
			
			while(first.length() > currIndex && !diff) {
				char a = first.charAt(currIndex);
				char b = second.charAt(currIndex);
				
				if(a==b) {
					str.append(a);
				}else{
					diff = true;
					// z case might be different
					if(currIndex+1 >=  first.length()) {
						System.out.println(first);
						printed= true;
					}else if((char)(a+1) == b && currIndex+1 >=  second.length()) {
						str.append(a);
						currIndex++;
						while(currIndex < first.length()) {
							a = first.charAt(currIndex);
							currIndex++;
							if(a != 'Z') {
								break;
							}
							str.append(a);
						}
						
						//System.out.println(currIndex);
						if(currIndex == first.length()) {
							System.out.println(first);
							printed= true;
						}else{
							str.append((char)(a+1));
							strPrint = true;
						}
					}else{
						str.append((char)(a+1));
					}
				}
				currIndex++;
			}
			
			if(!diff && !strPrint) {
				System.out.println(first);
			}else if(printed){
				// do nothing
			}else {
				System.out.println(str.toString());
			}
		}
	}
}

/*
2
ZZZ
ZZZZ
2
ZYZZZAZ
ZZ
2
ZYZZZ
ZZ
2
AAA
AAB
2
AAAA
AAB
2
JUNE
JZ
2
AAAAA
AAB
0


2
AAAA
AAB
0


2
ZZAZ
ZZB
0

*/