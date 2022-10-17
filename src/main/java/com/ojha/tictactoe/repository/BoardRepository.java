package com.ojha.tictactoe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.el.MethodNotFoundException;

import org.springframework.stereotype.Repository;

import com.ojha.tictactoe.entity.Board;

@Repository
public class BoardRepository{
	private boolean gameEnd = false;
	private int count=0;
	private String state=" ";
	private static List<Board> boardDetails=new ArrayList<>();
	
	static{
				boardDetails.add(new Board(0," "));
				boardDetails.add(new Board(1," "));
				boardDetails.add(new Board(2," "));
				boardDetails.add(new Board(3," "));
				boardDetails.add(new Board(4," "));
				boardDetails.add(new Board(5," "));
				boardDetails.add(new Board(6," "));
				boardDetails.add(new Board(7," "));
				boardDetails.add(new Board(8," "));
	}
	
	public List<Board> getBoardStatus() {
		try{
			return boardDetails;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Board save(Board board2) {
		
		try {
			if(gameEnd==true)
				throw new MethodNotFoundException("please restart game as game is over");
			if(board2.getCellNumber()>8 || board2.getCellNumber()<0) {
				throw new MethodNotFoundException("please enter cell number between 0 and 8 ");
			}
			if(board2.getCharacterName().equals("X") || board2.getCharacterName().equals("O")) {
				if(boardDetails.get(board2.getCellNumber()).getCharacterName().equals(" ")){
					if(board2.getCharacterName().equals(state)) {
						throw new MethodNotFoundException("player should change in each term");
					}
					boardDetails.remove(board2.getCellNumber());
					boardDetails.add(board2.getCellNumber(), board2);
					state=board2.getCharacterName();
					count++;
					if(isEnd(board2.getCharacterName())) {
						gameEnd=true;
					}
					return board2;
				}
				else {
					throw new MethodNotFoundException("please enter value in empty cell");
				}
			}
			else {
				throw new MethodNotFoundException("please enter character as X or O");
			}
			
		}
		catch (MethodNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	public boolean isEnd(String player) {
		if((boardDetails.get(0).getCharacterName().equals(player) && boardDetails.get(1).getCharacterName().equals(player) &&
			boardDetails.get(2).getCharacterName().equals(player)) || (boardDetails.get(3).getCharacterName().equals(player) && 
			boardDetails.get(4).getCharacterName().equals(player) && boardDetails.get(5).getCharacterName().equals(player)) || 
			(boardDetails.get(6).getCharacterName().equals(player) && boardDetails.get(7).getCharacterName().equals(player) &&
			boardDetails.get(8).getCharacterName().equals(player)) || (boardDetails.get(0).getCharacterName().equals(player) && 
			boardDetails.get(4).getCharacterName().equals(player) && boardDetails.get(8).getCharacterName().equals(player)) || 
			(boardDetails.get(1).getCharacterName().equals(player) && boardDetails.get(4).getCharacterName().equals(player) &&
			boardDetails.get(7).getCharacterName().equals(player)) || (boardDetails.get(2).getCharacterName().equals(player) &&
			boardDetails.get(4).getCharacterName().equals(player) && boardDetails.get(6).getCharacterName().equals(player)) || 
			(boardDetails.get(0).getCharacterName().equals(player) && boardDetails.get(3).getCharacterName().equals(player) &&
			boardDetails.get(6).getCharacterName().equals(player)) || (boardDetails.get(1).getCharacterName().equals(player) &&
			boardDetails.get(4).getCharacterName().equals(player) && boardDetails.get(7).getCharacterName().equals(player)) ||
			(boardDetails.get(2).getCharacterName().equals(player) && boardDetails.get(5).getCharacterName().equals(player) &&
			boardDetails.get(8).getCharacterName().equals(player))) {
			System.out.println("winner is : "+ player);
			return true;
		}
		else if(count==9) {
			System.out.println("Match Draw");
			return true;
		}
		return false;
	}

	public List<Board> nowRestart() {
		// TODO Auto-generated method stub
		gameEnd=false;
		count=0;
		state=" ";
		boardDetails.clear();
		boardDetails.add(new Board(0," "));
		boardDetails.add(new Board(1," "));
		boardDetails.add(new Board(2," "));
		boardDetails.add(new Board(3," "));
		boardDetails.add(new Board(4," "));
		boardDetails.add(new Board(5," "));
		boardDetails.add(new Board(6," "));
		boardDetails.add(new Board(7," "));
		boardDetails.add(new Board(8," "));
		return boardDetails;
	}
	
	
	

}
