// 932B - Recursive Queries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b {

	static int k[];
	static int q[][];
	
	public static void main(String[] args) {
		FastReader in = new FastReader();
		
		k = new int[(int)1e6+1];
		Arrays.fill(k, -1);
		
		for(int i=0; i<1e6+1; i++)
			val(i);
		
		q = new int[(int)1e6+1][10];
		
		for(int j=1; j<1e6+1; j++){
			for(int i=0; i<10; i++)
				q[j][i] = q[j-1][i];
			q[j][k[j]]++;
		}
		
		int qu = in.nextInt();
		
		for(int i=0; i<qu; i++){
			int l = in.nextInt();
			int r = in.nextInt();
			int k = in.nextInt();
			
			System.out.println(q[r][k] - q[l-1][k]);
		}

	}
	
	static int val(int n){
		if(n < 10){
			k[n] = n;
			return n;
		}
		
		if(k[n] == -1){
			int next = 1;
			int cpy = n;
			while(cpy > 0){
				int m = cpy%10;
				cpy /= 10;
				
				if(m > 0) next *= m;
			}
			
			k[n] = val(next);
		}
		
		
		return k[n];
	}
	
	static class FastReader
	{
	    BufferedReader br;
	    StringTokenizer st;
	    
	    public FastReader()
	    {
	        br = new BufferedReader(new
	                                InputStreamReader(System.in));
	    }
	    
	    String next()
	    {
	        while (st == null || !st.hasMoreElements())
	        {
	            try
	            {
	                st = new StringTokenizer(br.readLine());
	            }
	            catch (IOException  e)
	            {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }
	    
	    int nextInt()
	    {
	        return Integer.parseInt(next());
	    }
	    
	    long nextLong()
	    {
	        return Long.parseLong(next());
	    }
	    
	    double nextDouble()
	    {
	        return Double.parseDouble(next());
	    }
	    
	    String nextLine()
	    {
	        String str = "";
	        try
	        {
	            str = br.readLine();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        return str;
	    }
	}
}


