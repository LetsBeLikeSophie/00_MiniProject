package com.spring.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.vo.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> boardSelect(BoardVO bvo) {
		
		return sqlSession.selectList("boardSelect", bvo);
	}

	@Override
	public List<BoardVO> boardSelectAll(BoardVO bvo) {
		
		return sqlSession.selectList("boardSelectAll", bvo);
	}

	@Override
	public int boardInsert(BoardVO bvo) {
		
		return sqlSession.insert("boardInsert", bvo);
	}

	@Override
	public int boardUpdate(BoardVO bvo) {
		
		return sqlSession.update("boardUpdate", bvo);
	}

	@Override
	public int boardDelete(BoardVO bvo) {
		
		return sqlSession.delete("boardDelete", bvo);
	}

}
