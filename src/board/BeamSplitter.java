package board;

public class BeamSplitter extends Token{
	
	public BeamSplitter(Direction directions, int x, int y) {
		this.setType(Pieces.B);
		this.setDir(directions);
		this.setX(x);
		this.setY(y);
	}
	
	
	
	@Override
	public void hit(Token[][] tokens) {
		int x = this.getX();
		int y = this.getY();
		int x1 = this.getX();
		int y1 = this.getY();
		boolean beam1 = true;
		boolean beam2 = true;
		Direction initialD = this.getDir();
		Direction inDir = this.getInDir();
		Direction outDir = null;
		Direction outDir1 = null;
		if(this.getDir() == Direction.None || this.isHit() == false) {
			System.out.println("Laser is not on");
			return;
		}
		while(true){	
			if((initialD == Direction.N || initialD == Direction.S) && (inDir == Direction.E)  ) {
				x++;
				outDir = Direction.E;
				y1--;
				outDir1 = Direction.N;
			}else if((initialD == Direction.N || initialD == Direction.S) && (inDir == Direction.W)  ) {
				x--;
				outDir = Direction.W;
				y1++;
				outDir1 = Direction.S;
			}else if((initialD == Direction.E || initialD == Direction.W) && (inDir == Direction.E)  ) {
				x++;
				outDir = Direction.E;
				y1++;
				outDir1 = Direction.S;
			}else if((initialD == Direction.E || initialD == Direction.W) && (inDir == Direction.W)  ) {
				x--;
				outDir = Direction.W;
				y1--;
				outDir1 = Direction.N;
			}else {
				break;
			}
			
			
			
	
			if(   (x > 4 || x < 0 || y > 4 || y < 0)  && (x1 > 4 || x1 < 0 || y1 > 4 || y1 < 0)) 
				break;
			
			
			if((x <= 4 && x >= 0 && y <= 4 && y >= 0) && beam1 == true) {
				if(tokens[y][x] == null)
					tokens[y][x] = new Beam();
				
				else {
					tokens[y][x].setHit(true);
					tokens[y][x].setInDir(outDir);
					tokens[y][x].hit(tokens);
					
					beam1 = false;
				}
			}
			if( (x1 <= 4 && x1 >= 0 && y1 <= 4 && y1 >= 0) && beam2 == true) {
				if(tokens[y1][x1] == null)
					tokens[y1][x1] = new Beam();
				
				else {
					tokens[y1][x1].setHit(true);
					tokens[y1][x1].setInDir(outDir1);
					tokens[y1][x1].hit(tokens);
					
					beam2 = false;
				}
			}
			
			if(beam1 == false && beam2 == false) {
				break;
			}
		}
	}

}



