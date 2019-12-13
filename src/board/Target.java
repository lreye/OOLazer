package board;

public class Target extends Token{
	
	private boolean lit;

	public Target(Direction directions, int x, int y) {
		this.setType(Pieces.Z);
		this.setDir(directions);
		this.setX(x);
		this.setY(y);
	}
	
	
	@Override
	public void hit(Token[][] tokens) {
		int x = this.getX();
		int y = this.getY();
		Direction initialD = this.getDir();
		Direction inDir = this.getInDir();
		Direction outDir = null;
		if(this.getDir() == Direction.None || this.isHit() == false) {
			System.out.println("Laser is not on");
			return;
		}
		
		if((initialD == Direction.N) && (inDir == Direction.S)  )
			this.setLit(true);
		else if((initialD == Direction.S) && (inDir == Direction.N)  )
			this.setLit(true);
		else if((initialD == Direction.E) && (inDir == Direction.W)  )
			this.setLit(true);
		else if((initialD == Direction.W) && (inDir == Direction.E)  )
			this.setLit(true);
		else
			this.setLit(false);
	}


	public boolean isLit() {
		return lit;
	}


	public void setLit(boolean lit) {
		this.lit = lit;
	}
}
