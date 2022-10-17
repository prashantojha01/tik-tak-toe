package com.ojha.tictactoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojha.tictactoe.entity.Board;
import com.ojha.tictactoe.service.BoardService;
@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/status")
	public List<Board> getBoardStatus(){
		return boardService.getBoardStatus();
	}
	
	@PostMapping("/play")
	public Board play(@RequestBody Board board) {
		return boardService.play(board);
	}
	
	@GetMapping("/restart")
	public List<Board> nowRestart(){
		return boardService.nowRestart();
	}
}
