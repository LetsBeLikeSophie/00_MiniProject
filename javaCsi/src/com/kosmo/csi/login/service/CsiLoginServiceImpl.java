package com.kosmo.csi.login.service;

import com.kosmo.csi.login.dao.CsiLoginDAO;
import com.kosmo.csi.login.dao.CsiLoginDAOImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;

public class CsiLoginServiceImpl implements CsiLoginService {

	@Override
	public int cLoginCheck(CsiMemberVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("CsiLoginServiceImpl.hLoginCheck() 함수 진입 ");
		
		CsiLoginDAO cdao = new CsiLoginDAOImpl();
		return cdao.cLoginCheck(cvo);		
	}
}
