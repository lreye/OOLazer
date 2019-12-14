package main;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import board.BeamSplitter;
import board.Board;
import board.CellBlocker;
import board.Checkpoint;
import board.Direction;
import board.DoubleMirror;
import board.Laser;
import board.Mirror;
import board.Target;
import board.Token;


public class Puzzle {

	public static String name;
	public static String missingPiece;
	public static String problemText;
	public static String solutionText;
	public static Board board;
	
	public Puzzle() {
		problemText = "";
		solutionText = "";
		missingPiece = "";
	}
	
	public static Puzzle read(String path) {
		File file = new File(path);
		String line = ""; 
		int i = 0;
		Puzzle problem = new Puzzle();
		
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();

				// Reads the name
				if(i == 0) {
					problem.name = line;
				}
				// Reads the missing pieces
				else if(i == 1) {
					problem.missingPiece += line;
				}
				//Reads the board
				else if(i < 7) {
					problem.problemText += line;
					problem.problemText += "\n";
				}
				// Check if its now in solution
				else if(i == 7) {

				}else {
					problem.solutionText += line;
					problem.solutionText += "\n";
				}
				i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problem;
	}
	public Board createBoard() {
		Token tokens[][] = new Token[5][5];
		Laser laser = null;
		String strBoard = "";
		int k = 0;
		System.out.println(this.name);
		System.out.println(this.missingPiece);
		System.out.println(this.problemText);
		for(int i=0;i<5;i++) {
			for(int j=1;j<15;j+=3) {
				strBoard += problemText.split("\n")[i].substring(j,j+2);
				
			}
		
		}
		
		int j = 0;
		int i1 = 0;
		for(int i=0;i<50;i+=2) {
			
			if(strBoard.charAt(i) == 'L') {
				
				laser = new Laser(Direction.None,i1%5,j);
				tokens[j][i1%5] = laser;
				
			}else if(strBoard.charAt(i) == 'T') {
				if(strBoard.charAt(i+1) == '?') {
					Mirror m = new Mirror(Direction.None,i1%5,j);
					tokens[j][i1%5] = m;
				}else {
					Mirror m = new Mirror(Direction.valueOf(strBoard.substring(i+1,i+2)),i1%5,j);
					tokens[j][i1%5] = m;
				}
				
			}else if(strBoard.charAt(i) == 'Z') {
				if(strBoard.charAt(i+1) == '?') {
					Target t = new Target(Direction.None,i1%5,j);
					tokens[j][i1%5] = t;
				}else {
					Target t = new Target(Direction.valueOf(strBoard.substring(i+1,i+2)),i1%5,j);
					tokens[j][i1%5] = t;
				}
				
			}else if(strBoard.charAt(i) == 'B') {
				if(strBoard.charAt(i+1) == '?') {
					BeamSplitter b = new BeamSplitter(Direction.None,i1%5,j);
					tokens[j][i1%5] = b;
				}else {
					BeamSplitter b = new BeamSplitter(Direction.valueOf(strBoard.substring(i+1,i+2)),i1%5,j);
					tokens[j][i1%5] = b;
				}
				
			}else if(strBoard.charAt(i) == 'M') {
				if(strBoard.charAt(i+1) == '?') {
					DoubleMirror dm = new DoubleMirror(Direction.None,i1%5,j);
					tokens[j][i1%5] = dm;
				}else {
					DoubleMirror dm = new DoubleMirror(Direction.valueOf(strBoard.substring(i+1,i+2)),i1%5,j);
					tokens[j][i1%5] = dm;
				}
				
			}else if(strBoard.charAt(i) == 'P') {
				if(strBoard.charAt(i+1) == '?') {
					Checkpoint p = new Checkpoint(Direction.None,i1%5,j);
					tokens[j][i1%5] = p;
				}else {
					Checkpoint p = new Checkpoint(Direction.valueOf(strBoard.substring(i+1,i+2)),i1%5,j);
					tokens[j][i1%5] = p;
				}
				
			}else if(strBoard.charAt(i) == 'K') {
				if(strBoard.charAt(i+1) == '?') {
					CellBlocker k2 = new CellBlocker(Direction.None,i1%5,j);
					tokens[j][i1%5] = k2;
				}else {
					CellBlocker k2 = new CellBlocker(Direction.valueOf(strBoard.substring(i+1,i+2)),i1%5,j);
					tokens[j][i1%5] = k2;
				}
			}
				
						
			
			if(i == 8 || i == 18 || i == 28 || i == 38)
				j++;
			
			i1++;
		}
		
		
		
		return new Board(laser, tokens);
		
		
		
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Puzzle.name = name;
	}

	public static String getMissingPiece() {
		return missingPiece;
	}

	public static void setMissingPiece(String missingPiece) {
		Puzzle.missingPiece = missingPiece;
	}

	public static String getProblemText() {
		return problemText;
	}

	public static void setProblemText(String problemText) {
		Puzzle.problemText = problemText;
	}

	public static String getSolutionText() {
		return solutionText;
	}

	public static void setSolutionText(String solutionText) {
		Puzzle.solutionText = solutionText;
	}

	public static Board getBoard() {
		return board;
	}

	public static void setBoard(Board board) {
		Puzzle.board = board;
	}
	
	
}


