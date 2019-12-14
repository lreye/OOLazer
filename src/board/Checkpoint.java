package board;

public class Checkpoint extends Token {
	
	
	public Checkpoint(Direction directions, int x, int y) {
		this.setType(Pieces.P);
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
			if((initialD == Direction.S || initialD == Direction.N) && (inDir == Direction.N)  ) {
				y--;
				outDir = Direction.N;
			}
			else if((initialD == Direction.S || initialD == Direction.N) && (inDir == Direction.S)  ) {
				y++;
				outDir = Direction.S;
			}
			else if((initialD == Direction.E || initialD == Direction.W) && (inDir == Direction.E)  ) {
				x++;
				outDir = Direction.E;
			}
			else if((initialD == Direction.E || initialD == Direction.W) && (inDir == Direction.W)  ) {
				x--;
				outDir = Direction.W;
			}else
				break;
			
			if(x > 4 || x < 0 || y > 4 || y < 0) {
				
				break;
			}
			
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
