public class NBody {
	public static double readRadius(String filename){
		In in = new In(filename);
		int n = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();

		Planet[] ps = new Planet[n];
		double xp, yp, xv, yv, m;
		String img;
		Planet p;
		for (int i=0;i<n;i++){
			xp = in.readDouble();
			yp = in.readDouble();
			xv = in.readDouble();
			yv = in.readDouble();
			m = in.readDouble();
			img = in.readString();
			p = new Planet(xp, yp, xv, yv, m, img);
			ps[i] = p;
		}
		return ps;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		// read the necessary data
		double radius = readRadius(filename);
		Planet[] ps = readPlanets(filename);
		int n = ps.length;


		// Animation
		double time;
		double[] xForces = new double[n];
		double[] yForces = new double[n];
		int i;
		for(time=0; time<T; time = time + dt){
			for(i=0;i<n;i++){
				xForces[i] = ps[i].calcNetForceExertedByX(ps);
				yForces[i] = ps[i].calcNetForceExertedByY(ps);
			}
			for(i=0;i<n;i++) ps[i].update(dt, xForces[i], yForces[i]);

			// draw the background picture
			StdDraw.setScale(-radius, radius);
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			// draw planets
			for (Planet p: ps) p.draw();
			StdDraw.show(1);	
		}
		StdOut.printf("%d\n", ps.length);
		StdOut.printf("%.2e\n", radius);
		for (i = 0; i < ps.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		ps[i].xxPos, ps[i].yyPos, ps[i].xxVel, ps[i].yyVel, ps[i].mass, ps[i].imgFileName);	
		}	
	}
}


















