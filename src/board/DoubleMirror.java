package board;

public class DoubleMirror extends Token{

	
	
	public DoubleMirror(Direction directions, int x, int y) {
		this.setType(Pieces.M);
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
		while(true){	
			if((initialD == Direction.N || initialD == Direction.S) && (inDir == Direction.N)  ) {
				x++;
				outDir = Direction.E;
			}
			else if((initialD == Direction.N || initialD == Direction.S) && (inDir == Direction.S)  ) {
				x--;
				outDir = Direction.W;
			}
			else if((initialD == Direction.N || initialD == Direction.S) && (inDir == Direction.E)  ) {
				y++;
				outDir = Direction.N;
			}
			else if((initialD == Direction.N || initialD == Direction.S) && (inDir == Direction.W)  ) {
				y--;
				outDir = Direction.S;
			}
			
			
			else if((initialD == Direction.W || initialD == Direction.E) && (inDir == Direction.N)  ) {
				x--;
				outDir = Direction.W;
			}
			else if((initialD == Direction.W || initialD == Direction.E) && (inDir == Direction.S)  ) {
				x++;
				outDir = Direction.E;
			}
			else if((initialD == Direction.W || initialD == Direction.E) && (inDir == Direction.E)  ) {
				y--;
				outDir = Direction.S;
			}
			else if((initialD == Direction.W || initialD == Direction.E) && (inDir == Direction.W)  ) {
				y++;
				outDir = Direction.N;
			}
	
			if(x > 4 || x < 0 || y > 4 || y < 0) 
				break;
			
			
			if(tokens[y][x] == null)
				tokens[y][x] = new Beam();
			
			else {
				tokens[y][x].setHit(true);
				tokens[y][x].setInDir(outDir);
				tokens[y][x].hit(tokens);
				
				break;
			}
		}
	}
	
	
	
}
