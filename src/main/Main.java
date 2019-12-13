package main;

import java.io.FileNotFoundException;
import java.util.Arrays;

import board.Board;
import board.Direction;
import board.Laser;
import board.Mirror;
import board.Target;

public class Main {
	
	
	
	public static void main(String[] args) throws FileNotFoundException{
		
		String[] files = {"2.txt","12.txt","25.txt"};
		
		for (String file : files) 
		{ 
			Puzzle maze = Puzzle.createFromFile(file);
			
			Board board = maze.createBoard();
			board.getLaser().setOn(true);
			board.getLaser().setDir(Direction.N);
			board.addPiece(new Mirror(Direction.E,4,3), 4, 3);
			board.draw();
			
			board.printBoard();
		}
		
		
	}

}
