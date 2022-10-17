package com.ojha.tictactoe.entity;

public class Board {
	private int cellNumber;
	private String characterName;
	public Board(int cellNumber, String characterName) {
		super();
		this.cellNumber = cellNumber;
		this.characterName = characterName;
	}
	public int getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(int cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	
}
