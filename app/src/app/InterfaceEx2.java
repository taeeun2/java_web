package app;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//public class InterfaceEx2 extends WindowAdapter{

public class InterfaceEx2 extends Frame{
	
	public InterfaceEx2() {
//		Frame f = new Frame();
		Button btn1, btn2, btn3;
		Panel panel1 = new Panel();
		panel1.setBackground(Color.yellow);
		
		setTitle("은행 애플리케이션");
		
		btn1 = new Button("회원가입");
		btn2 = new Button("로그인");
		
		panel1.add(btn1); 
		panel1.add(btn2);
		add(panel1);
		setSize(500,500);//윈도우 크기
		setVisible(true);

		addWindowListener(new WindowAdapter() {//내부 익명 클래스
			//이벤트 등록, 상속관계이기 때문에 this가 허용된다.
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
//	public void	windowActivated(WindowEvent e) {}
//	public void	windowClosed(WindowEvent e) {}
//	public void	windowClosing(WindowEvent e) {
//		System.exit(0);
//	}
//	public void	windowDeactivated(WindowEvent e) {}
//	public void	windowDeiconified(WindowEvent e) {}
//	public void	windowIconified(WindowEvent e) {}
//	public void	windowOpened(WindowEvent e) {}
	
	
	public static void main(String[] args) {
		new InterfaceEx2();
		
	}

}
