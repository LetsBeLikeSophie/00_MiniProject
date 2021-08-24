package com.kosmo.csi.member.scr;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.kosmo.common.CodeUtil;
import com.kosmo.csi.member.service.CsiMemberService;
import com.kosmo.csi.member.service.CsiMemberServiceImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;


public class CsiMemberAll extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -7773980409866362226L;

	
//	변수 선언	
	DefaultTableModel dtm;
	JTable             jt;
	Object[][] fieldValue;
	String[]   columnName;
	
	JPanel[]    jpR;
	JLabel      jlR;
	JComboBox<String>  jcR;
	JTextField  jtR;
	JButton     jbR;
	JScrollPane jsPain;
	JButton     jtBtn[];
	JCheckBox   jcb[];
	
	String comboStr;

//  CsiMemberAll 함수 JFrame 으로 꾸미기		
	@SuppressWarnings("unchecked")
	public CsiMemberAll() {
		this.setTitle("회원검색하기");
		this.getContentPane().setLayout(new BorderLayout(10, 10));

		jpR = new JPanel[3];
		jlR = new JLabel("조회조건");
		jlR.setHorizontalAlignment(SwingConstants.CENTER);

		jcR = new JComboBox<String>(CodeUtil.combo_cpation);
		jcR.setSelectedIndex(0);
		jcR.addActionListener(this);

		jtR = new JTextField();
		jtR.setVisible(false);
		jbR = new JButton("조회");
		jbR.addActionListener(this);

		for (int i=0; i < jpR.length; i++ ){
			jpR[i] = new JPanel();
			jpR[i].setLayout(new BorderLayout());
		}


		columnName = CodeUtil.member_value;
		dtm = new DefaultTableModel(fieldValue, columnName);
		jt = new JTable(dtm);
		jt.setEnabled(true);
		jsPain = new JScrollPane(jt);

		jpR[0].add(jlR);
		jpR[0].add(jcR);		
		jpR[0].add(jtR);
		jpR[0].add(jbR);
		jpR[0].setLayout(new GridLayout(1, 4, 5, 5));
		jpR[1].add(jsPain);
		
		jpR[2] = new JPanel();
		jpR[2].setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		jtBtn = new JButton[4];		
		for (int i=0; i < jtBtn.length; i++) {
			jtBtn[i] = new JButton(CodeUtil.jbtn_cpation[i]);
			jtBtn[i].addActionListener(this);
			jpR[2].add(jtBtn[i]);
		}

		this.getContentPane().add(jpR[0], BorderLayout.NORTH);
		this.getContentPane().add(jpR[1], BorderLayout.CENTER);
		this.getContentPane().add(jpR[2], BorderLayout.SOUTH);

		this.setLocation(100, 100);
		this.setSize(1300,540);
		this.setResizable(false);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
		});
	}
	
	public void jtablePrint(ArrayList<CsiMemberVO> aList, int rowCnt, int columnCnt) {
		
		fieldValue = new Object[rowCnt][columnCnt];

		for (int i=0; i < rowCnt; i++ ){
			
			CsiMemberVO _cvo = aList.get(i);
			fieldValue[i][0] = _cvo.getCnum();
			fieldValue[i][1] = _cvo.getCname();
			fieldValue[i][2] = _cvo.getCid();
			fieldValue[i][3] = _cvo.getCpw();
			fieldValue[i][4] = _cvo.getCbirth();
			fieldValue[i][5] = _cvo.getCgender();
			fieldValue[i][6] = _cvo.getCtel();
			fieldValue[i][7] = _cvo.getChp();								
			fieldValue[i][8] = _cvo.getCemail();
			fieldValue[i][9] = _cvo.getCaddr();
			fieldValue[i][10] = CodeUtil.hobby(_cvo.getChobby());
			fieldValue[i][11] = _cvo.getCphoto();
			fieldValue[i][12] = _cvo.getCskill();
			fieldValue[i][13] = CodeUtil.hobby(_cvo.getCjob());
			fieldValue[i][14] = _cvo.getDeleteyn();
			fieldValue[i][15] = _cvo.getInsertdate();
			fieldValue[i][16] = _cvo.getUpdatedate();	
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (jcR == e.getSource()) {
			comboStr = (String)jcR.getSelectedItem();
			if ("전체".equals(comboStr)){
				jtR.setVisible(false);				
			}
			if ("아이디".equals(comboStr)){
				jtR.setVisible(true);
			}
			if ("이름".equals(comboStr)){
				jtR.setVisible(true);
			}
		}
		
		// 조회 버튼 이벤트 
		if (jbR == e.getSource()) {
			String searchStr = "";

			if ("전체".equals(comboStr)){
				searchStr = jtR.getText();
				System.out.println("searchStr >>> : " + searchStr);

				int columnCnt = columnName.length;
		
				try{
					CsiMemberService cms = new CsiMemberServiceImpl();
					ArrayList<CsiMemberVO> aList =  cms.cmemSelectAll();
				
					int rowCnt = aList.size();
					System.out.println("rowCnt >>> : " + rowCnt);
			
					this.jtablePrint(aList, rowCnt, columnCnt);
					
				}
				catch (Exception ex){
					System.out.println("에러가 >>> : " + ex.getMessage());
				}		

				dtm = new DefaultTableModel(fieldValue, columnName);
				jt.setModel(dtm);
				
				return;
			}
			if ("이름".equals(comboStr)){
				searchStr = jtR.getText();
				System.out.println("searchStr >>> : " + searchStr);

				int columnCnt = columnName.length;
		
				try{
					CsiMemberService cms = new CsiMemberServiceImpl();
					CsiMemberVO cvo = null;
					cvo = new CsiMemberVO();
					cvo.setCname(searchStr);
					
					ArrayList<CsiMemberVO> aList =  cms.cmemSelectName(cvo);
				
					int rowCnt = aList.size();
					System.out.println("rowCnt >>> : " + rowCnt);

					this.jtablePrint(aList, rowCnt, columnCnt);
				}
				catch (Exception ex){
					System.out.println("에러가 >>> : " + ex.getMessage());
				}		

				dtm = new DefaultTableModel(fieldValue, columnName);
				jt.setModel(dtm);
				
				return;
			}
			if ("아이디".equals(comboStr)){
				searchStr = jtR.getText();
				System.out.println(" searchStr >>> : " + searchStr);

				int columnCnt = columnName.length;
		
				try{
					CsiMemberService cms = new CsiMemberServiceImpl();
					CsiMemberVO cvo = null;
					cvo = new CsiMemberVO();
					cvo.setCid(searchStr);
					
					ArrayList<CsiMemberVO> aList =  cms.cmemSelectId(cvo);
				
					int rowCnt = aList.size();
					System.out.println("rowCnt >>> : " + rowCnt);

					this.jtablePrint(aList, rowCnt, columnCnt);
				}
				catch (Exception ex){
					System.out.println("에러가 >>> : " + ex.getMessage());
				}		

				dtm = new DefaultTableModel(fieldValue, columnName);
				jt.setModel(dtm);
				
				return;
			}
		}
		
		// 버튼 
		if (jtBtn[0] == e.getSource()) {
			System.out.println("회원 가입하기 >>> : ");
		}
		if (jtBtn[1] == e.getSource()) {
			System.out.println("회원 수정하기 >>> : ");
		}
		if (jtBtn[2] == e.getSource()) {
			System.out.println("회원 삭제하기 >>> : ");
		}
		if (jtBtn[3] == e.getSource()) {
			System.out.println("회원 목록보기 >>> : ");
		}
	}
	

	public static void main(String[] args) {
		new CsiMemberAll();
	}
}
