package board;

public class Laser extends Token{
	
	

	public Laser() {
		this.setType(Pieces.L);
		this.setDir(Direction.None);
	}
	

	
	public Laser(Direction direction,int x, int y) {
		this.setType(Pieces.L);
		this.setDir(direction);
		this.setX(x);
		this.setY(y);
	}
	
	
	
	public void setOn(boolean on) {
		this.setHit(on);
	
	}
}
