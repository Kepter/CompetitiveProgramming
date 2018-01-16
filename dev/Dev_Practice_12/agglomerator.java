import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class agglomerator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int drops = scan.nextInt();
		ArrayList<Drop> all = new ArrayList<Drop>();
		for(int i = 0; i < drops; i++) {
			all.add(new Drop(scan.nextInt(),scan.nextInt(), scan.nextInt(),scan.nextInt(), Math.pow(scan.nextInt(), 2), i) );
		}
		
		int dropsCount = drops;
		int current_drops = drops;
		
		PriorityQueue<Intersection> boop = new PriorityQueue<Intersection>();
		for (int i = 0; i < drops; ++i) {
			for (int j = i+1; j < drops; ++j) {
				double tmp = all.get(i).intersectTime(all.get(j));
				if (tmp >= 0)
					boop.add(new Intersection(tmp, all.get(i).id, all.get(j).id) );
			}
		}
		
		ArrayList<Boolean> have_rem = new ArrayList<>();
		for (int i = 0; i < drops; ++i)
			have_rem.add(false);
		
		double last_time = 0;
		
		while(!boop.isEmpty()) {
			Intersection first = boop.poll();
//			System.out.println(first.id1 + " " + first.id2 + " " + first.time);
			
			if (have_rem.get(first.id1) || have_rem.get(first.id2))
				continue;
			
			have_rem.set(first.id1,true);
			have_rem.set(first.id2, true);
			
			Drop a = all.get(first.id1);
			Drop b = all.get(first.id2);
			
			Drop c = a.merge(b, first.time);
			c.id = all.size();
			
			
			--current_drops;
		
			
			for (int i = 0; i < all.size(); ++i) {
				if (have_rem.get(i)) continue;
				
				double tmp = all.get(i).intersectTime(c);
				if (tmp >= first.time)
					boop.add(new Intersection(tmp, all.get(i).id, c.id));
			}
		
			
			all.add(c);
			
			have_rem.add(false);
			
			last_time = Math.max(last_time, first.time);
		
			
		}
		
		System.out.printf("%d %.12f", current_drops, last_time);
		
//		System.out.println("x: " + all[0].intersectTime(all[1]));
	}

}

class Intersection implements Comparable<Intersection> {
	
	int id1,id2;
	double time;
	
	public Intersection (double t, int i, int j) {
		id1 = i;
		id2 = j;
		time = t;		
	}

	@Override
	public int compareTo(Intersection o) {
		double diff = time - o.time;
		final double eps = 0.00001;
		
		if (Math.abs(diff) <= eps)
			return 0;
		
		if (time < o.time)
			return -1;
		else
			return 1;
	}
}

class Drop{
	double x;
	double y;
	double dx;
	double dy;
	double radius;
	double offset;
	
	int id;
	
	public Drop(int a, int b, int vx, int vy, int r, int id) {
		x = a;
		y = b;
		dx = vx;
		dy = vy;
		radius = r;
		
		this.id = id; 
	}
	
	public Drop(double a, double b, double vx, double vy, double r, int id) {
		x = a;
		y = b;
		dx = vx;
		dy = vy;
		radius = r;
		
		this.id = id; 
	}
	
	public double intersectTime(Drop d) {
		double distSq = radius + d.radius + 2*Math.sqrt(radius)*Math.sqrt(d.radius);
		double fx = x-d.x;
		double fy = y-d.y;
		double lx = dx-d.dx;
		double ly = dy-d.dy;
		
		double a = (lx*lx) + (ly*ly);
		double b = (2*lx*fx) + (2*ly*fy);
		double c = (fx*fx)+(fy*fy)-distSq;
		
		double other_t = (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);
		double t = (-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
		
		if(t < 0 || other_t < 0) return t < 0 ? other_t : t;
		return Math.min(t, other_t) > 1e9 ? -1 : Math.min(t, other_t);
	}
	
	public Drop merge(Drop other, double t) {
		double total_area = radius + other.radius;
		double my_weight = radius;
		double other_weight = (total_area - my_weight);
		
		my_weight /= total_area;
		other_weight /= total_area;
		
		Drop d =  new Drop(my_weight * (x + dx*t) + other_weight * (other.x + other.dx*t),
				my_weight * (y + dy*t) + other_weight * (other.y + other.dy*t),
				my_weight * dx + other_weight * other.dx,
				my_weight * dy + other_weight * other.dy,
				total_area,
				101010
			);

//		System.out.println("MERGE: "+d.id+" "+d.dx+" "+d.dy+" t: "+t);
		d.x -= t*(d.dx);
		d.y -= t*(d.dy);
		
		return d;
		
	}
}

/*
2
-2 0 2 0 1
2 0 0 0 1

2
-2 0 -2 0 1
2 0 -2 1 1

4
-8 0 2 -2 2
0 -8 -2 2 2
2 8 0 -4 3
8 2 -4 0 3

4
-8 3 3 0 2
-2 4 2 0 2
2 -2 2 0 2
8 -2 0 0 2

3
0 0 0 0 1
10 0 0 0 1
-10 0 10 0 1

4
-5 0 2 0 1
0 -5 0 2 1
5 0 0 0 1
0 5 0 0 1

*/