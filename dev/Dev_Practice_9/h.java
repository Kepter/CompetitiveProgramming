import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class h {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int num = in.nextInt();
			if(num == 0) break;
			City[] cities = new City[num];
			for(int i=0; i<num; i++)
			{
				cities[i] = new City();
				cities[i].id = i;
			}
			
			double[][] dist = new double[num][num];
			
			City start = null;
			int closest = -1;
			for(int i=0; i<num; i++)
			{
				cities[i].x = in.nextInt();
				cities[i].y = in.nextInt();
				
				for(int j=0; j<i; j++)
				{
					cities[i].adj.add(new E(cities[i].distTo(cities[j]), cities[j]));
					cities[j].adj.add(new E(cities[j].distTo(cities[i]), cities[i]));
					
					
				}
				
				if(closest == -1 || cities[i].y < closest)
				{
					closest = cities[i].y;
					start = cities[i];
				}
			}
			
			PriorityQueue<S> q = new PriorityQueue<S>();
			for(E e : start.adj)
			{
				q.add(new S(e, e.dist));
				e.est = e.dist;
			}
			
			start.est = 0;
			start.added = true;
			
			double len = 0;
			while(!q.isEmpty())
			{
				S cur = q.poll();
				
//				System.out.println("est: "+cur.est+" e: "+cur.e.est+" "+cur.e.dest.added+" "+cur.e.dest.id);
				
				if(cur.e.dest.added) continue;
//				System.out.println("D");
				
				len += cur.e.dist;
				cur.e.dest.added = true;
				
				for(E e : cur.e.dest.adj)
				{
					if(e.dest.added) continue;
					q.add(new S(e, e.dist));
				}
			}
			
			System.out.printf("%.2f\n", len);
			
		}

	}

}

class E
{
	City dest;
	double dist;
	double est;
	public E(double d, City de)
	{
		dist = d;
		dest = de;
	}
}

class City
{
	boolean added = false;
	ArrayList<E> adj = new ArrayList<E>();
	int id;
	
	int x, y;
	int est = (int)1e9;
	
	public double distTo(City c)
	{
		return Math.sqrt((x - c.x)*(x - c.x) + (y - c.y)*(y - c.y));
	}	
}

class S implements Comparable<S>
{
	E e;
	double est;
	public S(E d, double ed)
	{
		e = d;
		est = ed;
	}
	
	public int compareTo(S a) {
		if(a.e.dest.y != e.dest.y) return e.dest.y - a.e.dest.y;
		if(est == a.est) return 0;
		return (est - a.est) > 0 ? 1 : -1;
	}
}
