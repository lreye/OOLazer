package board;

public class Token implements Hit {
		
	private int x;
	private int y;
	private boolean hit;
	private Direction dir;
	private Pieces type;
	
	private Direction inDir;
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public Pieces getType() {
		return type;
	}
	public void setType(Pieces type) {
		this.type = type;
	}

	
	public String toString() {
		
		if(getDir() == Direction.None) {
			
			return "" + getType() + "?";
		}
		else {
			return "" + getType() + getDir();
		}
		
		
	}
	@Override
	public void hit(Token[][] tokens) {
		// TODO Auto-generated method stub
		
	}
	public Direction getInDir() {
		return inDir;
	}
	public void setInDir(Direction inDir) {
		this.inDir = inDir;
	}


}
