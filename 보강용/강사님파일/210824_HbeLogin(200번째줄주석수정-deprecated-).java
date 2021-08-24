package a.b.c.kosmo.login.scr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import a.b.c.kosmo.login.service.HbeLoginService;
import a.b.c.kosmo.login.service.HbeLoginServiceImpl;
import a.b.c.kosmo.mem.scr.HbeMember;
import a.b.c.kosmo.mem.service.HbeMemberService;
import a.b.c.kosmo.mem.service.HbeMemberServiceImpl;
import a.b.c.kosmo.mem.vo.HbeMemberVO;


public class HbeLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = -152326483017758029L;

	JPanel 			jp;
	JLabel[]        jlM;
	JTextField      jtM;
	JPasswordField  jpfM;
	JButton[]       jbM;
	JButton         jbMem;
	
	// ������ 
	public HbeLogin() {
		this.setTitle("ȸ�� �α���");
		
		this.getContentPane().setLayout(null);
		jp = new JPanel();
		jp.setBackground(Color.CYAN);
		jp.setBorder(new EtchedBorder());
		jp.setBounds(0, 0, 310, 280);
		
		jp.setLayout(null);
		
		JPanel jpM = new JPanel();
		jpM.setLayout(null);
		jpM.setBounds(10, 30, 275, 180);
		jpM.setBackground(Color.YELLOW);
		jpM.setBorder(new TitledBorder("�α���"));
		jp.add(jpM);
	
		jlM  = new JLabel[2];
		jtM  = new JTextField();
		jpfM = new JPasswordField();
		jbM  = new JButton[2];

		for (int j=0; j < jlM.length; j++ ){
			jlM[j] = new JLabel();
			jlM[j].setHorizontalAlignment(SwingConstants.CENTER);
			jbM[j] = new JButton();
			jbM[j].addActionListener(this);
			jpM.add(jlM[j]);
			jpM.add(jbM[j]);
		}
		jlM[0].setText("���̵�");
		jlM[1].setText("�н�����");
		
		jtM  = new JTextField(10);			
		jpfM = new JPasswordField(10);
		jpM.add(jtM);
		jpM.add(jpfM);

		jbM[0].setText("�α���");
		jbM[1].setText("�α׾ƿ�");
		
		jbMem = new JButton();
		jbMem.addActionListener(this);
		jbMem.setText("ȸ������");
		jpM.add(jbMem);

		jlM[0].setBounds(10, 20, 100, 30);
		jtM.setBounds(110, 20, 150, 30);
		
		jlM[1].setBounds(10, 55, 100, 30);
		jpfM.setBounds(110, 55, 150, 30);
		
		jbM[0].setBounds(40, 92, 100, 30);
		jbM[1].setBounds(150, 92, 100, 30);
		jbMem.setBounds(40, 130, 210, 30);
						
		this.getContentPane().add(jp);

		// ȭ�� �߾ӿ� ��ġ�ϱ� 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setLocation(screenSize.width/2 - 150, screenSize.height/2 - 100);
		
		this.setSize(310, 280);
		this.setResizable(false);
		this.setVisible(true);
		
		// JFrame �ݱ�
		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
		});	
	}
		
	// �α��� üũ
	public void hLoginCheck(String hid, String hpw) {
		System.out.println("HbeLogin :: hLoginCheck() ���� >>> : ");
		
		try {
			
			HbeLoginService hls = new HbeLoginServiceImpl();
			HbeMemberVO hvo = null;
			hvo = new HbeMemberVO();
			hvo.setHid(hid);
			hvo.setHpw(hpw);
			
			int nCnt = hls.hLoginCheck(hvo);
			
			if (nCnt == 1) {
				System.out.println("���̵� :: " + hvo.getHid() + " �� �α��� ���� !! ");
				
				JOptionPane.showMessageDialog(this, hvo.getHid() + " �� �α��� ����  !! ");
				
				this.jtMSetText();
			}else {
				System.out.println("���̵� :: " + hvo.getHid() + " �� �α��� ���� !! ");
				JOptionPane.showMessageDialog(this, hvo.getHid() + " �� �α��� ����  !! ");
				this.jtMSetText();
			}
		}catch(Exception ex) {
			System.out.println("�α���ó�� �� ������ >>> : " + ex.getMessage());
		}	
	}	
	
	// �α׾ƿ� üũ
	public void hLogOutCheck() {
		System.out.println("HbeLogin :: hLogOutCheck() ���� >>> : ");
		
		String message = "�α׾ƿ� �Ͻðڽ��ϱ� ? ";
		int conFirm = 0;
		try {
			
			conFirm = JOptionPane.showConfirmDialog(this, message);
			
			if (conFirm == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				this.dispose();
			} else if (conFirm == JOptionPane.NO_OPTION) {			
			}			
		}catch(Exception ex) {
			System.out.println("�α׾ƿ� ó�� �� ������ >>> : " + ex.getMessage());
		}	
	}
	
	// ȸ������ ȣ��
	public void hmMember() {
		System.out.println("SwingMemberLogin :: smMember() ���� >>> : ");
		
		try {			
			new HbeMember();
		}catch(Exception ex) {
			System.out.println("�α׾ƿ� ó�� �� ������ >>> : " + ex.getMessage());
		}	
	}
	
	// �α��� JTextField, JPasswordField �ʱ�ȭ 
	public void jtMSetText(){
		jtM.setText("");
		jpfM.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jbnt = (JButton)e.getSource();
		String loginCmd = jbnt.getText();

		if ("�α���".equals(loginCmd)){
			System.out.println("loginCmd >>> : " + loginCmd + " ���� >>> : ");
			
			String hid = "";
			String hpw = "";
			
			hid = jtM.getText();
			hpw = jpfM.getText();
			char[] hpwChar = jpfM.getPassword();
			hpw = new String(hpwChar);
			System.out.println("hid >>> : " + hid);
			System.out.println("hpw >>> : " + hpw);
			
			this.hLoginCheck(hid, hpw);
		}
		if ("�α׾ƿ�".equals(loginCmd)){
			System.out.println("loginCmd >>> : " + loginCmd + " ���� >>> : ");	
			this.hLogOutCheck();
		}
		if ("ȸ������".equals(loginCmd)){
			System.out.println("loginCmd >>> : " + loginCmd + " ���� >>> : ");	
			this.hmMember();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HbeLogin();
	}
}
