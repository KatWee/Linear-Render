import java.util.ArrayList;

public class midPointLineAlgo{
	public int dx, dy, d, dU, dD, x, y;
	public ArrayList<Integer> pointx = new ArrayList<Integer>();
	public ArrayList<Integer> pointy = new ArrayList<Integer>();
	
	public void plotLine(int x1,int y1,int x2,int y2)
	{
		dx = x2 - x1;
	    dy = y2 - y1;
	    d = 2 * dy - dx;
	    dD = 2 * dy;
	    dU = 2*(dy-dx);
	    x = x1;
	    y = y1;
	 
	    plot(x,y);
	    
	    while(x<x2) {
		    if(d<0)
		    {
		    	d = d+dD;
		    	x++;
		    }else {
		    	d = d+dU;
		    	x++;
		    	y++;
		    }
		    plot(x,y); 
	    }
	}
	
	public void plot(int x, int y)
	{
		pointx.add(x);
		pointy.add(y);
	}
	
	public void mirrorY ()
	{
		int i = 0;
		while(i < pointy.size())
		{
			pointy.set(i,-pointy.get(i));
			i++;
		}
	}
	
	public void mirror45 ()
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(pointx);
		pointx.removeAll(pointx);
		pointx.addAll(pointy);
		pointy.removeAll(pointy);
		pointy.addAll(temp);
	}
}


