package board;

public class Board {
	
	
	private Laser laser;// = new Laser(Direction.S);
	private Token tokens[][];// = new Token[5][5];
	
	
	
	public Board(Laser laser, Token tokens[][]) {
		this.laser = laser;
		this.tokens = tokens;
	}
	
	
	public void draw() {
		//Dont forget to assign x y to actual token as well
		/**DoubleMirror m = new DoubleMirror(Direction.N,2,3);
		Mirror t = new Mirror(Direction.S,0,3);
		Mirror t1 = new Mirror(Direction.W,0,1);
		Checkpoint p  = new Checkpoint(Direction.E,1,1);
		Target z = new Target(Direction.W,4,1);
		BeamSplitter b = new BeamSplitter(Direction.E,3,1);
		
		tokens[3][2] = m;
		tokens[1][0] = t1;
		tokens[3][0] = t;
		tokens[1][4] = z;
		tokens[1][1] = p;
		tokens[1][3] = b;
		
		*/
		//laser.setX(2);
		//laser.setY(2);
		//tokens[2][2] = laser;
		int x = getLaser().getX();
		int y = getLaser().getY();
		Direction initialD = getLaser().getDir();
	
		if(getLaser().getDir() == Direction.None || getLaser().isHit() == false) {
			System.out.println("Laser is not on");
			return;
		}
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
			
			
			if(tokens[y][x] == null)
				tokens[y][x] = new Beam();
			
			else {
				tokens[y][x].setHit(true);
				tokens[y][x].setInDir(initialD);
				tokens[y][x].hit(tokens);
				
				break;
			}
		}
	}
	
	public void addPiece(Token token,int x,int y) {
		
		this.tokens[y][x] = token;
	}
	
	public void printBoard() {
		for(int i=0;i<5;i++) {
			System.out.print("|");
			for(int j=0;j<5;j++) {
				if(tokens[i][j] == null) {
					System.out.print("  |");
				}
			else if(tokens[i][j].getType() == Pieces.BEAM) {
					System.out.print("* |");
				}
				
				else{
					
					System.out.print(tokens[i][j] +"|");
				}
			}
			System.out.println("");
		}
	}
	
	public Laser getLaser() {
		return laser;
	}
	public void setLaser(Laser laser) {
		this.laser = laser;
	}
	
	
	
}
