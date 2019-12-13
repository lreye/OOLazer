package board;

public class Mirror extends Token{

		
	public Mirror(Direction directions, int x, int y) {
		this.setType(Pieces.T);
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
			if((initialD == Direction.S) && (inDir == Direction.W)  ) {
				y--;
				outDir = Direction.N;
			}
			else if((initialD == Direction.S) && (inDir == Direction.S)  ) {
				x++;
				outDir = Direction.E;
			}
			else if((initialD == Direction.N) && (inDir == Direction.E)  ) {
				y++;
				outDir = Direction.S;
			}
			else if((initialD == Direction.N) && (inDir == Direction.N)  ) {
				x--;
				outDir = Direction.W;
			}
			else if((initialD == Direction.E) && (inDir == Direction.S)  ) {
				x--;
				outDir = Direction.W;
			}
			else if((initialD == Direction.E) && (inDir == Direction.E)  ) {
				y--;
				outDir = Direction.N;
			}
			else if((initialD == Direction.W) && (inDir == Direction.N)  ) {
				x++;
				outDir = Direction.E;
			}
			else if((initialD == Direction.W) && (inDir == Direction.W)  ) {
				y++;
				outDir = Direction.S;
			}
			else {
				break;
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


