package board;

public class CellBlocker extends Token{
	
	public CellBlocker(Direction directions, int x, int y) {
		this.setType(Pieces.K);
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
	
		while(true){	
			if(initialD == Direction.N) {
				y--;
			}
			else if(initialD == Direction.E) {
				x++;
			}
			else if(initialD == Direction.S) {
				y++;
			}
			else if(initialD == Direction.W) {
				x--;
			}
			if(x > 4 || x < 0 || y > 4 || y < 0) 
				break;
			
	
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
