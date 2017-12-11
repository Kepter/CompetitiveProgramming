import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class j {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int numStations = in.nextInt();
			if(numStations == 0) break;
			
			Station[] stations = new Station[numStations];
			for(int i=0; i<numStations; i++)
				stations[i] = new Station(in.nextInt(), in.nextInt());
			
			System.out.println(minVertical(stations, 35, new boolean[37]));
		}
		
	}
	
	public static int minVertical(Station[] stations, int curIndex, boolean[] added)
	{
		if(curIndex < 0) return greedy(stations, added);
		
		int ret = minVertical(stations, curIndex-2, added);
		added[curIndex] = true;
		ret = Math.min(minVertical(stations, curIndex-2, added)+1, ret);
		added[curIndex] = false;
		return ret;
	}
	
	public static int greedy(Station[] stations, boolean[] vWalls)
	{
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
		buckets.add(new ArrayList<Integer>());
		int[] remap = new int[37];
		
//		System.out.print("VWALLS:");
		int curBucket = 0;
		for(int i=0; i<=36; i++)
		{
			if(i%2 == 0)
			{
				remap[i] = curBucket;
			}
			
			if(i%2 == 1)
			{
				if(vWalls[i])
				{
//					System.out.print(" "+i);
					curBucket++;
					buckets.add(new ArrayList<Integer>());
				}
			}
		}
//		System.out.println("  total: "+(curBucket));
		
		Arrays.sort(stations);
		int ret = greedy(stations, buckets, remap);
//		System.out.println("\n");
		return ret;
	}
	
	public static int greedy(Station[] stations, ArrayList<ArrayList<Integer>> buckets, int[] remap)
	{
		int walls = 0;

//		System.out.print("HWALLS:");
		for(int i=0; i<stations.length; i++)
		{
			ArrayList<Integer> bucket = buckets.get(remap[stations[i].x]);
			if(bucket.size() > 0)
			{
				if(bucket.get(0) == stations[i].y) return (int) 1e9;
				
				bucket.clear();
				walls++;
				bucket.add(stations[i].y);
//				System.out.print(" "+(stations[i].y-1));
				
				for(ArrayList<Integer> a : buckets)
					if(a.size() > 0 && a.get(0) < stations[i].y) a.clear();	
			}
			
			else
			{
				bucket.add(stations[i].y);
			}
		}

//		System.out.println("  total: "+walls);
		return walls;
	}
	
	static class Station implements Comparable<Station>
	{
		int x, y;
		public Station(int X, int Y)
		{
			x = X;
			y = Y;
		}
		
		public int compareTo(Station s) {
			return y-s.y;
		}
	}

}

/*
4
12 12
4 8
8 6
2 4

4
0 0
4 4
10 9
14 6

0

*/
