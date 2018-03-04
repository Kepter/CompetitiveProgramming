// Jamie and Alarm Snooze

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int snooze = in.nextInt();
		int h = in.nextInt();
		int m = in.nextInt();
		
		int press = 0;
		
		while(!(contains(h) || contains(m))){
			m -= snooze;
			press++;
			
			while(m < 0){
				h--;
				m += 60;
			}
			
			if(h < 0){
				h += 24;
			}
		}
		
		System.out.println(press);
	}
	
	public static boolean contains(int a){
		if(a%10 == 7 || (a/10)%10 == 7) return true;
		return false;
	}

}
