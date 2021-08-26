package com.kosmo.csi.board.service;

import java.util.ArrayList;

import com.kosmo.csi.board.dao.CsiBoardDAO;
import com.kosmo.csi.board.dao.CsiBoardDAOImpl;
import com.kosmo.csi.board.vo.CsiBoardVO;



public class CsiBoardServiceImpl implements CsiBoardService {

	@Override
	public ArrayList<CsiBoardVO> cboardSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("HbeBoardServiceImpl cboardSelectAll() 함수 진입 >>> : ");
		
		CsiBoardDAO hdao = new CsiBoardDAOImpl();		
		return hdao.cboardSelectAll();
	}

	@Override
	public ArrayList<CsiBoardVO> cboardSelect(CsiBoardVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("HbeBoardServiceImpl cboardSelect() 함수 진입 >>> : ");
		
		CsiBoardDAO hdao = new CsiBoardDAOImpl();		
		return hdao.cboardSelect(cvo);
	}

	@Override
	public int cboardInsert(CsiBoardVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("HbeBoardServiceImpl cboardInsert() 함수 진입 >>> : ");
		
		CsiBoardDAO hdao = new CsiBoardDAOImpl();		
		return hdao.cboardInsert(cvo);
	}

	@Override
	public int cboardUpdate(CsiBoardVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("HbeBoardServiceImpl cboardUpdate() 함수 진입 >>> : ");
		
		CsiBoardDAO hdao = new CsiBoardDAOImpl();		
		return hdao.cboardUpdate(cvo);
	}

	@Override
	public int cboardDelete(CsiBoardVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("HbeBoardServiceImpl cboardDelete() 함수 진입 >>> : ");
		
		CsiBoardDAO hdao = new CsiBoardDAOImpl();		
		return hdao.cboardDelete(cvo);
	}

}
