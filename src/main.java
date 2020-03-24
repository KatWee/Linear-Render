import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		midPointLineAlgo line = new midPointLineAlgo();
		String temp = new String();
		Scanner in = new Scanner(System.in);
		int x1,y1,x2,y2,m,dx,dy,tx,ty,tmp,order;
		   
		do {
			//input (x1,y1),(x2,y2)
			//*********************************************
			System.out.println("\nStart Point");
			System.out.print("x : ");
			x1 = Integer.parseInt(in.nextLine());
				
			System.out.print("y : ");
			y1 = Integer.parseInt(in.nextLine());
				
			System.out.println("End Point");
			System.out.print("x : ");
			x2 = Integer.parseInt(in.nextLine());
				
			System.out.print("y : ");
			y2 = Integer.parseInt(in.nextLine());
			//*********************************************
			System.out.println("point ("+x1+","+y1+") -> ("+x2+","+y2+")");
			
			//2 point is the same point
			if(x1 == x2 && y1 == y2)
			{
				System.out.println("case : 2 point is the same point");
				System.out.println("("+x1+","+y1+")");
			}
			//m = infinity
			else if(x1 == x2)
			{
				order = 1;
				//swap start and end point when plot from right to left
				if(y1 > y2)
				{
					tmp = x1;
					x1 = x2;
					x2 = tmp;
					tmp = y1;
					y1 = y2;
					y2 = tmp;
					//set order flag for mark that point was swapped
					order = -1;
				}
				
				//translate (x1,y1) to origin
				tx = -x1;
				x1 = x1 + tx;
				x2 = x2 + tx;
				ty = -y1;
				y1 = y1 + ty;
				y2 = y2 + ty;
				
				System.out.println("case : m = infinity");
				line.plotLine(x1,y1,y2,x2);
				
				//translate origin to (x1,y1) 
				int i = 0;
				while(i < line.pointx.size())
				{
					line.pointy.set(i, line.pointy.get(i) - tx);
					line.pointx.set(i, line.pointx.get(i) - ty);
					i++;
				}
				
				show(line.pointy,line.pointx,order);
			}
			
			//can render linear
			else 
			{
				//find m
				dy = y2 - y1;
				dx = x2 - x1;
				m = dy/dx;
				System.out.print("m : " + m);
				
				order = 1;
				//swap start and end point when plot from right to left
				if((x2 < x1 && y2 < y1) || (x2 < x1))
				{
					tmp = x1;
					x1 = x2;
					x2 = tmp;
					tmp = y1;
					y1 = y2;
					y2 = tmp;
					//set order flag for mark that point was swapped
					order = -1;
				}

				
				//translate (x1,y1) to origin
				tx = -x1;
				x1 = x1 + tx;
				x2 = x2 + tx;
				ty = -y1;
				y1 = y1 + ty;
				y2 = y2 + ty;
				
				/////////////////////////////plot/////////////////////////////////////
				//m = 0
				if(y1 == y2)
				{
					System.out.println("case : m = 0");
					line.plotLine(x1,y1,x2,y2);
				}
				//case 0 < m < 1
				else if(m >= 0 && m < 1 && ((dx > 0 && dy > 0)||(dx < 0 && dy < 0)))
				{
					System.out.println("case : 0 < m < 1");
					line.plotLine(x1,y1,x2,y2);
				}
				//case m > 1
				else if(m >= 1)
				{
					System.out.println("case : 1 < m");
					//mirror by 45 degree
					line.plotLine(x1,y1,y2,x2);
					//mirror back
					line.mirror45();
				}
				
				//case m < 0
				else if(m <= 0 && m > -1)
				{
					System.out.println("case : -1 < m < 0");
					//mirror by x axis
					line.plotLine(x1,y1,x2,-y2);
					//mirror back
					line.mirrorY();
				}
				//case m < -1
				else if(m <= -1)
				{
					System.out.println("case : -1 > m");
					//mirror by y axis,then mirror by 45 degree
					line.plotLine(x1,y1,-y2,x2);
					show(line.pointx,line.pointy,order);
					//mirror by 45 degree back
					line.mirror45();
					show(line.pointx,line.pointy,order);
					//mirror by y axis back
					line.mirrorY();
					
				
				}
				/////////////////////////////////////////////////////////////////////////

				
				//translate origin to (x1,y1) 
				int i = 0;
				while(i < line.pointx.size())
				{
					line.pointy.set(i, line.pointy.get(i) - ty);
					line.pointx.set(i, line.pointx.get(i) - tx);
					i++;
				}
				
				//show
				show(line.pointx,line.pointy,order);	
			}
			
			//clear list of all point
			line.pointx.removeAll(line.pointx);
			line.pointy.removeAll(line.pointy);
			
			//ask to continue
			System.out.print("Continue? (y/n) ");
			temp = in.nextLine();
	

		}while(!(temp.equalsIgnoreCase("n")));
		
		System.out.print("End Program");
	}
	
	//method for printing list of points
	public static void show(ArrayList<Integer> a,ArrayList<Integer> b,int order)
	{
		if(order == 1)
		{
			int i = 0;
			while(i < a.size()) {
				System.out.print("("+a.get(i)+","+b.get(i)+") ");
				i++;
			}
		}else {
			int i = a.size()-1;
			while(i >= 0) {
				System.out.print("("+a.get(i)+","+b.get(i)+") ");
				i--;
			}
		}
		System.out.println();
	}
}
