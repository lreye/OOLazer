package board;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Board {
	
	
	private Laser laser;
	public Token tokens[][];
	
	
	
	public Board(Laser laser, Token tokens[][]) {
		this.laser = laser;
		this.tokens = tokens;
	}
	
	
	public void draw() {

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
	
	public String printBoard() {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
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
		
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		 return out.toString();
	}
	
	public Laser getLaser() {
		return laser;
	}
	public void setLaser(Laser laser) {
		this.laser = laser;
	}
	
	
	
}
