package a.b.c.com.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.board.vo.BoardVO;

import a.b.c.com.common.dao.ChabunDAO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	
	Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl (ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
		
	}

	@Override
	public BoardVO getBoardChabun() {
		
		return chabunDAO.getBoardChabun();
	}
}