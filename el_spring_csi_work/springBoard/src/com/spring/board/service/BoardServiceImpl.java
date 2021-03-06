package com.spring.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	
	Logger logger = Logger.getLogger(BoardServiceImpl.class);
	
	@Autowired(required=false)
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> boardSelect(BoardVO bvo) {
		
		return boardDao.boardSelect(bvo) ;
	}

	@Override
	public List<BoardVO> boardSelectAll(BoardVO bvo) {
		
		return boardDao.boardSelectAll(bvo);
	}

	@Override
	public int boardInsert(BoardVO bvo) {
		
		return boardDao.boardInsert(bvo);
	}

	@Override
	public int boardUpdate(BoardVO bvo) {
		
		return boardDao.boardUpdate(bvo);
	}

	@Override
	public int boardDelete(BoardVO bvo) {
		
		return boardDao.boardDelete(bvo);
	}

}
