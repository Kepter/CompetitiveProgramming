import java.awt.geom.Line2D;
import java.util.Scanner;

public class slice {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;
			double x = 0;
			double y = 0;
			
			int ang = 90;

			int ok = -1;
			Line2D[] lines = new Line2D[n];
			for(int i=0; i<n; i++) {
				int deg = in.nextInt();
				ang = (ang + deg)%360;
				if(ang < 0) ang += 360;
				
				int dist = in.nextInt();
				
				
				double dx = 0;
				double dy = 0;
				
				int a = 0;
				
				if(ang >= 90) {
					dx = 1;
					dy = 1;
					a = ang;
				}
				else if(ang >= 180) {
					dx = -1;
					dy = 1;
					a = 180 - ang;
				}
				else if(ang >= 270) {
					dx = -1;
					dy = -1;
					a = ang - 180;
				}
				else {
					dx = 1;
					dy = -1;
					a = 360 - ang;
				}
				
				dx = dx*Math.cos(Math.toRadians(a))*dist;
				dy = dy*Math.sin(Math.toRadians(a))*dist;
				
				double nx = x+dx;
				double ny = y+dy;
				
				lines[i] = new Line2D.Double(x, y, nx, ny);
				x = nx;
				y = ny;
				
				for(int j=0; j<i-1; j++) {
					if(j == i ) continue;
					
					if(ok == -1 && lines[i].intersectsLine(lines[j]))
						ok = i;
				}
			}
			if(ok == -1) System.out.println("SAFE");
			else System.out.println(ok+1);

		}
		
	}

}
/*
4
-90 10
90 5
135 10
-90 5

4
-90 10
90 5
135 5
-90 10

6
60 10
60 10
60 10
60 10
60 10
80 20
0

 */
