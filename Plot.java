/*
 * PROGRAMMER: ALAN DUONG
 */
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot(){
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
		}
	public Plot(Plot p){
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
		}
	public Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		}
	public boolean overlaps(Plot p){
		boolean overlapsXYa;
		boolean overlapsXYaa;
		boolean overlapsXYb;
		boolean overlapsXYbb;
		boolean overlapsXYc;
		boolean overlapsXYcc;
		boolean overlapsXYd;
		boolean overlapsXYdd;
		
		overlapsXYa = (p.x >= x && p.x < (x + width)) && (p.y >= y && p.y < (y + depth));
		overlapsXYaa = (x >= p.x && x < (p.x + width)) && (y >= p.y && y < (p.depth + p.y));
		overlapsXYb =  (p.x + p.width) > x && (p.x + p.width) < (x + width) &&  p.y >= y && p.y <= (y + depth);
	    overlapsXYbb = (x + width) > p.x && (x + width) < (p.x + p.width) && y>= p.y && y <= (p.y + p.depth);
	    overlapsXYc = p.x >= x && p.x < (x + width) && (p.y + p.depth) > y && (p.y + p.depth) <= (y + depth);
	    overlapsXYcc =  x >= p.x && x < (p.x +  p.width) && (y + depth) > p.y && (y + depth) <= (p.y + p.depth);
	    overlapsXYd = (p.x + p.width) > x && (p.x +p.width) <= (x + width) && (p.y + p.depth) > y && (p.y + p.depth) <= (y + depth);
	    overlapsXYdd = (x + width) > p.x && (x + width) <= (p.x + p.width) && (y + depth) > p.y && (y + depth) <= (p.y + p.depth);
	    
	    return overlapsXYa || overlapsXYaa || overlapsXYb || overlapsXYbb || overlapsXYc || overlapsXYcc || overlapsXYd || overlapsXYdd;
	}
	public boolean encompasses(Plot p){
		boolean encomX;
		boolean encomY;
		boolean encomWidth;
		boolean encomDepth;
		
		encomX = p.x >= x;
		encomY = p.y >= y;
		encomWidth = (p.x + p.width) <= (x + width);
		encomDepth = (p.y + p.depth) <= (y + depth);
		
		return encomX && encomY && encomWidth && encomDepth;
	}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public int getWidth(){
		return width;
	}
	public int getDepth(){
		return depth;
	}
	public void setDepth(int depth){
		this.depth = depth;
	}
	public java.lang.String toString(){
		String toReturn = "Upper left: (" + x + "," + y + ");" + " Width: " + width + " Depth: " + depth;
		return toReturn;
	}
}




