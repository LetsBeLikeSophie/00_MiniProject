package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardVO;


public interface BoardDao {

	public List<BoardVO> boardSelect(BoardVO bvo);
	public List<BoardVO> boardSelectAll(BoardVO bvo);
	public int boardInsert(BoardVO bvo);
	public int boardUpdate(BoardVO bvo);
	public int boardDelete(BoardVO bvo);


}
