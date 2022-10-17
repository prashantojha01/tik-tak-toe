package com.ojha.tictactoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojha.tictactoe.entity.Board;
import com.ojha.tictactoe.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	public List<Board> getBoardStatus() {
		return boardRepository.getBoardStatus();
	}

	public Board play(Board board) {
		// TODO Auto-generated method stub
		return boardRepository.save(board);
	}

	public List<Board> nowRestart() {
		// TODO Auto-generated method stub
		return boardRepository.nowRestart();
	}

}
