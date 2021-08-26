package com.kosmo.csi.board.service;

import java.util.ArrayList;

import com.kosmo.csi.board.vo.CsiBoardVO;


public interface CsiBoardService {

	public ArrayList<CsiBoardVO> cboardSelectAll();
	public ArrayList<CsiBoardVO> cboardSelect(CsiBoardVO cvo);
	public int cboardInsert(CsiBoardVO cvo);
	public int cboardUpdate(CsiBoardVO cvo);
	public int cboardDelete(CsiBoardVO cvo);
}
