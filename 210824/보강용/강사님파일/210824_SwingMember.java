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
	
	// �������
	private JLabel      la1, la2, la3, la4, la5, la6, la7;
	private JTextField  tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton     bt1, bt2, bt3, bt4;
	private JPanel      pa1, pa2;

	// ������ 
	public SwingMember() {
	
		// JFrame Ÿ��Ʋ �����ϱ�
		this.setTitle("SwingMember");
		// JFrame ���̾ƿ� �Ŵ��� ���� ���̾ƿ����� �����ϱ� 
		this.setLayout(new BorderLayout());
		
		// ��, �ؽ�Ʈ�ʵ� ���� JPanel �ν��Ͻ� 
		pa1 = new JPanel();
		// JPanel ������ ĥ�ϱ� �þ����� 
		pa1.setBackground(Color.cyan);	
		// ��ư ���� JPanel �ν��Ͻ�
		pa2 = new JPanel();
		// JPanel ������ ĥ�ϱ� ����		
		pa2.setBackground(Color.blue);

		// ��, �ؽ�Ʈ�ʵ� ���� JPanel ���̾ƿ� �Ŵ��� �׸��� ���̾ƿ�
		pa1.setLayout(new GridLayout(7,2));
		// �� �ν��Ͻ� 
		la1 = new JLabel(" ����ȣ ", JLabel.CENTER);	
		la2 = new JLabel(" ���� ", JLabel.CENTER);	
		la3 = new JLabel(" ���̵� ", JLabel.CENTER);	
		la4 = new JLabel(" �н����� ", JLabel.CENTER);			
		la5 = new JLabel(" �������� ", JLabel.CENTER);	
		la6 = new JLabel(" ����� ", JLabel.CENTER);	
		la7 = new JLabel(" ������ ", JLabel.CENTER);	

		// �ؽ�Ʈ�ʵ� �ν��Ͻ�
		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		tf3 = new JTextField(10);
		tf4 = new JTextField(10);
		tf5 = new JTextField(10);
		tf6 = new JTextField(10);
		tf7 = new JTextField(10);
		
		// ��, �ؽ�Ʈ�ʵ� ���� JPanel�� ��, �ؽ�Ʈ �ʵ� ���̱�
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

		// ��ư ���� JPanel ���̾ƿ� �Ŵ��� �÷ο� ���̾ƿ�
		pa2.setLayout(new FlowLayout(FlowLayout.CENTER));
		// ��ư �ν��Ͻ� 
		bt1 = new JButton("��ȸ");
		bt2 = new JButton("����");
		bt3 = new JButton("����");
		bt4 = new JButton("����");
		// ��ư ���� JPanel�� ��ư �ʵ� ���̱�
		pa2.add(bt1);
		pa2.add(bt2);
		pa2.add(bt3);
		pa2.add(bt4);
				
		// JTextFiled disable : ��������, �����, ������
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		
		// JPanel ���� JFrame ���̱� 
		this.add(pa1, BorderLayout.CENTER);
		this.add(pa2, BorderLayout.SOUTH);
		
		// ��ȸ, ���, ����, ���� ��ư�� �̺�Ʈ ����
		bt1.addActionListener(new EventHandler());
		bt2.addActionListener(new EventHandler());
		bt3.addActionListener(new EventHandler());
		bt4.addActionListener(new EventHandler());

		this.setSize(300, 250);
		this.setLocation(400, 200);
		this.setVisible(true);

		// JFrame Ŭ�ο��� 
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
			
			if ("��ȸ".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);
				
				String swnum = "";
				swnum = tf1.getText();				
				System.out.println("swnum >>> : " + swnum);

				try {
					
					SwingMemberService sms = new SwingMemberServiceImpl();
					SwingMemberVO svo = null;
					svo = new SwingMemberVO();
					svo.setSwnum(swnum);
					
					// ȭ�� �ؽ�Ʈ�ʵ� Ŭ���� 
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
					System.out.println("���� �� ������ >>> : " + ex.getMessage());
				}	
			}
			if ("����".equals(btnCmd)) {
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
					
					// ȭ�� �ؽ�Ʈ�ʵ� Ŭ���� 
					jtextFileClear();
					
					boolean bool = sms.smInsert(svo);
					
					if (bool) {
						System.out.println("ȸ�� ���� �Է� ���� >>> : " + bool);	
					}else {
						System.out.println("ȸ�� ���� �Է� ���� >>> : " + bool);
					}						
				}catch(Exception ex) {
					System.out.println("��� �� ������ >>> : " + ex.getMessage());
				}
				
			}
			if ("����".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);
				
				// �̸��� �����ϱ� 				
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
					
					// ȭ�� �ؽ�Ʈ�ʵ� Ŭ���� 
					jtextFileClear();
					
					boolean bool = sms.smUpdate(svo);
					
					if (bool) {
						System.out.println("ȸ�� ���� ���� ���� >>> : " + bool);	
					}else {
						System.out.println("ȸ�� ���� ���� ���� >>> : " + bool);
					}		
				}catch(Exception ex) {
					System.out.println("���� �� ������ >>> : " + ex.getMessage());
				}		
				
			}
			if ("����".equals(btnCmd)) {
				System.out.println("btnCmd >>> : " + btnCmd);
				
				String swnum = "";
				swnum = tf1.getText();				
				System.out.println("swnum >>> : " + swnum);
							
				try {
					
					SwingMemberService sms = new SwingMemberServiceImpl();
					SwingMemberVO svo = null;
					svo = new SwingMemberVO();
					svo.setSwnum(swnum);				
					
					// ȭ�� �ؽ�Ʈ�ʵ� Ŭ���� 
					jtextFileClear();
					
					boolean bool = sms.smDelete(svo);
					
					if (bool) {
						System.out.println("ȸ�� ���� ���� ���� >>> : " + bool);	
					}else {
						System.out.println("ȸ�� ���� ���� ���� >>> : " + bool);
					}				
					
				}catch(Exception ex) {
					System.out.println("���� �� ������ >>> : " + ex.getMessage());
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