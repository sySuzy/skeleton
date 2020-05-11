import static java.lang.Math.sqrt;

public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static double G = 6.67 * 1e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	} 

	public double calcDistance(Planet p){
		double d = sqrt((p.xxPos - this.xxPos)*(p.xxPos - this.xxPos) + 
			(p.yyPos - this.yyPos)*(p.yyPos - this.yyPos));
		return d;
	}


	public double calcForceExertedBy(Planet p){
		double d = this.calcDistance(p);
		double f = G * p.mass * this.mass / (d * d);
		return f;
	}

	public double calcForceExertedByX(Planet p){
		double f = this.calcForceExertedBy(p);
		double fx = f * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return fx;
	}

	public double calcForceExertedByY(Planet p){
		double f = this.calcForceExertedBy(p);
		double fx = f * (p.yyPos - this.yyPos) / this.calcDistance(p);
		return fx;
	}

	public double calcNetForceExertedByX(Planet[] ps){
		double fx = 0;
		for (Planet p : ps){
			if (this.equals(p)) continue;
			fx = fx + this.calcForceExertedByX(p);
		}
		return fx;
	}

	public double calcNetForceExertedByY(Planet[] ps){
		double fy = 0;
		for (Planet p : ps){
			if (this.equals(p)) continue;
			fy = fy + this.calcForceExertedByY(p);
		}
		return fy;
	}

	public void update(double dt, double fx, double fy){
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		this.xxVel = this.xxVel + dt * ax;
		this.yyVel = this.yyVel + dt * ay;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
		StdDraw.show();	
	}


}