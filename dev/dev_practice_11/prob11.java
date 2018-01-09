import java.util.Scanner;

public class prob11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			long n = in.nextLong()+1;
			mod = in.nextLong();
			
			if(n == 1 && mod == 0) break;
			
			long[][] mat = new long[2][2];
			mat[0][0] = 1;
			mat[0][1] = 1;
			mat[1][0] = 1;
			mat[1][1] = 0;
			
			mat = expo(mat, n);
			System.out.println(mat[0][0]);
		}
		

	}
	
	static long mod;
	static long[][] mult(long[][] a, long[][] b){
		long[][] ret = new long[a.length][b[0].length];
		
		for(int i=0; i<ret.length; i++)
			for(int j=0; j<ret[i].length; j++)
				for(int k=0; k<b.length; k++)
					ret[i][j] = ((a[i][k]*b[k][j])%mod + ret[i][j])%mod;
		
		return ret;
	}
	
	static long[][] expo(long[][] mat, long n){
		if(n == 0) {
			long[][] ret = new long[mat.length][mat.length];
			
			for(int i=0; i<mat.length; i++)
				ret[i][i] = 1;
			return ret;
		}
		
		if(n == 1) return mat;
		
		long[][] ret = expo(mat, n/2);
		ret = mult(ret, ret);
		
		if(n%2 == 1)
			ret = mult(ret, mat);
		return ret;
	}

}
