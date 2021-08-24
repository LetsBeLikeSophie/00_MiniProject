package a.b.c.swing.member.scr;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import a.b.c.common.SwingMemberChabun;
import a.b.c.swing.member.service.SwingMemberService;
import a.b.c.swing.member.service.SwingMemberServiceImpl;
import a.b.c.swing.member.vo.SwingMemberVO;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMember extends JFrame{
	
	private static final long serialVersionUID = 1223945384484229538L;
	
	// 멤버변수
	private JLabel      la1, la2, la3, la4, la5, la6, la7;
	private JTextField  tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton     bt1, bt2, bt3, bt4;
	private JPanel      pa1, pa2;

	// 생성자 
	public SwingMember() {
	
		// JFrame 타이틀 세팅하기
		this.setTitle("SwingMember");
		// JFrame 레이아웃 매니저 보더 레이아웃으로 설정하기 
		this.setLayout(new BorderLayout());
		
		// 라벨, 텍스트필드 붙일 JPanel 인스턴스 
		pa1 = new JPanel();
		// JPanel 바탕색 칠하기 시안으로 
		pa1.setBackground(Color.cyan);	
		// 버튼 붙일 JPanel 인스턴스
		pa2 = new JPanel();
		// JPanel 바탕색 칠하기 블루로		
		pa2.setBackground(Color.blue);

		// 라벨, 텍스트필드 붙일 JPanel 레이아웃 매니저 그리드 레이아웃
		pa1.setLayout(new GridLayout(7,2));
		// 라벨 인스턴스 
		la1 = new JLabel(" 고객번호 ", JLabel.CENTER);	
		la2 = new JLabel(" 고객명 ", JLabel.CENTER);	
		la3 = new JLabel(" 아이디 ", JLabel.CENTER);	
		la4 = new JLabel(" 패스워드 ", JLabel.CENTER);			
		la5 = new JLabel(" 삭제여부 ", JLabel.CENTER);	
		la6 = new JLabel(" 등록일 ", JLabel.CENTER);	
		la7 = new JLabel(" 수정일 ", JLabel.CENTER);	

		// 텍스트필드 인스턴스
		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		tf3 = new JTextField(10);
		tf4 = new JTextField(10);
		tf5 = new JTextField(10);
		tf6 = new JTextField(10);
		tf7 = new JTextField(10);
		
		// 라벨, 텍스트필드 붙일 JPanel에 라벨, 텍스트 필드 붙이기
		pa1.add(la1);
		pa1.add(tf1);
		pa1.add(la2);
		pa1.add(tf2);
		pa1.add(la3);
		pa1.add(tf3);
		pa1.add(la4);
		pa1.add(tf4);
		pa1.add(la5);
		pa1.add(tf5);
		pa1.add(la6);
		pa1.add(tf6);
		pa1.add(la7);
		pa1.add(tf7);		

		// 버튼 붙일 JPanel 레이아웃 매니저 플로우 레이아웃
		pa2.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 버튼 인스턴스 
		bt1 = new JButton("조회");
		bt2 = new JButton("저장");
		bt3 = new JButton("수정");
		bt4 = new JButton("삭제");
		// 버튼 붙일 JPanel에 버튼 필드 붙이기
		pa2.add(bt1);
		pa2.add(bt2);
		pa2.add(bt3);
		pa2.add(bt4);
				
		// JTextFiled disable : 삭제여부, 등록일, 수정일
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		
		// JPanel 두장 JFrame 붙이기 
		this.add(pa1, BorderLayout.CENTER);
		this.add(pa2, BorderLayout.SOUTH);
		
		// 조회, 등록, 수정, 삭제 버튼에 이벤트 전달
		bt1.addActionListener(new EventHandler());
		bt2.addActionListener(new EventHandler());
		bt3.addActionListener(new EventHandler());
		bt4.addActionListener(new EventHandler());

		this.setSize(300, 250);
		this.setLocation(400, 200);
		this.setVisible(true);

		// JFrame 클로우즈 
		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}
	
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String btnCmd = String.valueOf(e.getActionCommand());
			
			if ("조회".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);
				
				String swnum = "";
				swnum = tf1.getText();				
				System.out.println("swnum >>> : " + swnum);

				try {
					
					SwingMemberService sms = new SwingMemberServiceImpl();
					SwingMemberVO svo = null;
					svo = new SwingMemberVO();
					svo.setSwnum(swnum);
					
					// 화면 텍스트필드 클리어 
					jtextFileClear();
					
					ArrayList<SwingMemberVO> aList = sms.smSelect(svo);
					
					if (aList !=null && aList.size() > 0) {
						
						for (int i=0; i < aList.size(); i++) {
							
							SwingMemberVO _svo = aList.get(i);
							
							tf1.setText(_svo.getSwnum());
							tf2.setText(_svo.getSwname());
							tf3.setText(_svo.getSwid());
							tf4.setText(_svo.getSwpw());
							tf5.setText(_svo.getDeleteyn());
							tf6.setText(_svo.getInsertdate());
							tf7.setText(_svo.getUpdatedate());	
						}		
					}else {
						
					}
				}catch(Exception ex) {
					System.out.println("조건 중 에러가 >>> : " + ex.getMessage());
				}	
			}
			if ("저장".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);	
								
				String swnum = "";
				String swname = "";
				String swid = "";
				String swpw = "";
				
				swnum = SwingMemberChabun.ymdNum();
				swname = tf2.getText();
				swid = tf3.getText();
				swpw = tf4.getText();
				System.out.println("swnum >>> : " + swnum);
				System.out.println("swname >>> : " + swname);
				System.out.println("swid >>> : " + swid);
				System.out.println("swpw >>> : " + swpw);
								
				try {
					
					SwingMemberService sms = new SwingMemberServiceImpl();
					SwingMemberVO svo = null;
					svo = new SwingMemberVO();
					svo.setSwnum(swnum);
					svo.setSwname(swname);
					svo.setSwid(swid);
					svo.setSwpw(swpw);
					
					// 화면 텍스트필드 클리어 
					jtextFileClear();
					
					boolean bool = sms.smInsert(svo);
					
					if (bool) {
						System.out.println("회원 정보 입력 성공 >>> : " + bool);	
					}else {
						System.out.println("회원 정보 입력 실패 >>> : " + bool);
					}						
				}catch(Exception ex) {
					System.out.println("등록 중 에러가 >>> : " + ex.getMessage());
				}
				
			}
			if ("수정".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);
				
				// 이름만 수정하기 				
				String swnum = "";
				String swname = "";				
				swnum = tf1.getText();
				swname = tf2.getText();
				
				System.out.println("swnum >>> : " + swnum);
				System.out.println("swname >>> : " + swname);
								
				try {
					
					SwingMemberService sms = new SwingMemberServiceImpl();
					SwingMemberVO svo = null;
					svo = new SwingMemberVO();
					svo.setSwnum(swnum);
					svo.setSwname(swname);				
					
					// 화면 텍스트필드 클리어 
					jtextFileClear();
					
					boolean bool = sms.smUpdate(svo);
					
					if (bool) {
						System.out.println("회원 정보 수정 성공 >>> : " + bool);	
					}else {
						System.out.println("회원 정보 수정 실패 >>> : " + bool);
					}		
				}catch(Exception ex) {
					System.out.println("수정 중 에러가 >>> : " + ex.getMessage());
				}		
				
			}
			if ("삭제".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);
				
				String swnum = "";
				swnum = tf1.getText();				
				System.out.println("swnum >>> : " + swnum);
							
				try {
					
					SwingMemberService sms = new SwingMemberServiceImpl();
					SwingMemberVO svo = null;
					svo = new SwingMemberVO();
					svo.setSwnum(swnum);				
					
					// 화면 텍스트필드 클리어 
					jtextFileClear();
					
					boolean bool = sms.smDelete(svo);
					
					if (bool) {
						System.out.println("회원 정보 삭제 성공 >>> : " + bool);	
					}else {
						System.out.println("회원 정보 삭제 실패 >>> : " + bool);
					}				
					
				}catch(Exception ex) {
					System.out.println("삭제 중 에러가 >>> : " + ex.getMessage());
				}		
			}
		}
	}
	
	public void jtextFileClear() {
		
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tf7.setText("");		
	}
	
	public static void main(String args[]){
		// TODO Auto-generated method stub		
		new SwingMember();		
	}
}