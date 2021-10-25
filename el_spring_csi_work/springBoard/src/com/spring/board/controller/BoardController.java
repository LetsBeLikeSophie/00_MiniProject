package com.spring.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.board.service.BoardService;

import a.b.c.com.common.service.ChabunService;

@Controller
public class BoardController {
	
	Logger logger = Logger.getLogger(BoardController.class);
	
	private ChabunService chabunService;
	private BoardService boardService;
	
	
	@Autowired(required=false)
	public BoardController(BoardService boardService, ChabunService chabunService) {
		boardService = this.boardService;
		chabunService = this.chabunService;
		
	}
	
	
	@RequestMapping(value="")

}
