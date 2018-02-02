import java.util.Arrays;
import java.util.Scanner;

public class Vacations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		boolean[] gym = new boolean[n];
		boolean[] contest = new boolean[n];
		
		for(int i=0; i<n; i++){
			int d = in.nextInt();
			
			if(d >= 2) gym[i] = true;
			if(d%2 == 1) contest[i] = true;
		}
		
		memo = new int[2][2][n];
		for(int i=0; i<2; i++)
			for(int j=0; j<2; j++)
				Arrays.fill(memo[i][j], -1);
		
		System.out.println(dp(gym, contest, 1, 1, 0));

	}
	
	static int[][][] memo;
	public static int dp(boolean[] gym, boolean[] contest, int canWork, int canWrite, int day){
		if(day >= gym.length) return 0;
		
		if(memo[canWork][canWrite][day] != -1) return memo[canWork][canWrite][day];
		int ret = Integer.MAX_VALUE;
		if(canWork == 1 && gym[day]){
			ret = Math.min(ret, dp(gym, contest, 0, 1, day+1));
		}
		
		if(canWrite == 1 && contest[day]){
			ret = Math.min(ret, dp(gym, contest, 1, 0, day+1));
		}
		
		ret = Math.min(ret, dp(gym, contest, 1, 1, day+1)+1);
		memo[canWork][canWrite][day] = ret;
		return ret;
	}

}
