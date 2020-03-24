import java.util.ArrayList;

public class DrawLine {
	double m,x,y;
	public ArrayList<String> linear = new ArrayList<String>();

	public void plotting(double x1,double y1,double x2,double y2)
	{
		m = (y2-y1)/(x2-x1);
		x = x1;
		y = y1;
		push(x,y);
		while(x < x2)
		{
			y = y + m;
			x++;
			push(x,y);
		}
	}
	
	public void push(double x, double y)
	{
		String point = "("+String.valueOf(x)+","+String.valueOf(y)+")";
		linear.add(point);
	}
}
