package a.b.c.com.common.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.vo.BoardVO;

@Repository
public class ChabunDAOImpl implements ChabunDAO {

	Logger logger = Logger.getLogger(ChabunDAOImpl.class);
	
	@Autowired(required=false)
	SqlSessionTemplate sqlSession;
	
	@Override
	public BoardVO getBoardChabun() {

		return sqlSession.selectOne("getBoardChabun");
	}

}
