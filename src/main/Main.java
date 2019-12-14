package main;

import java.io.FileNotFoundException;
import java.util.Arrays;

import board.BeamSplitter;
import board.Board;
import board.CellBlocker;
import board.Checkpoint;
import board.Direction;
import board.DoubleMirror;
import board.Laser;
import board.Mirror;
import board.Target;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Puzzle maze1 = Puzzle.createFromFile("2.txt");
		
		Board board1 = maze1.createBoard();
		board1.getLaser().setOn(true);
		board1.getLaser().setDir(Direction.N);
		board1.addPiece(new Mirror(Direction.E,4,3), 4, 3);
		board1.draw();
		
		board1.printBoard();
		
		Puzzle maze2 = Puzzle.createFromFile("12.txt");
		
		Board board2 = maze2.createBoard();
		board2.getLaser().setOn(true);
		board2.getLaser().setDir(Direction.N);
		board2.addPiece(new Mirror(Direction.W,0,2), 0, 2);
		board2.addPiece(new DoubleMirror(Direction.N,2,2), 2, 2); /////
		//board2.tokens[2][2].setDir(Direction.N);
		board2.addPiece(new Checkpoint(Direction.N,2,1), 2, 1); /////
		board2.addPiece(new Mirror(Direction.W,2,0), 2, 0);
		board2.addPiece(new Target(Direction.W,4,0), 4, 0); /////
		
		board2.draw();
		
		board2.printBoard();
		
		Puzzle maze3 = Puzzle.createFromFile("25.txt");
		
		Board board3 = maze3.createBoard();
		board3.getLaser().setOn(true);
		board3.getLaser().setDir(Direction.S);
		board3.addPiece(new DoubleMirror(Direction.W,0,3), 0, 3); /////
		board3.addPiece(new Checkpoint(Direction.W,2,3), 2, 3); /////
		board3.addPiece(new BeamSplitter(Direction.W,3,3), 3, 3); /////
		board3.addPiece(new Target(Direction.W,4,3), 4, 3); /////
		board3.addPiece(new BeamSplitter(Direction.W,3,3), 3, 3); /////
		board3.addPiece(new CellBlocker(Direction.W,3,0), 3, 0); /////
		board3.addPiece(new Target(Direction.W,3,4), 3, 4); /////
		board3.draw();
		
		board3.printBoard();
		
		
		
	}

}
