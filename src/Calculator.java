import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame{

	//버튼에 들어갈 문자들 배열
	String[] Btn = {
			"%", "CE", "C", "←",
			"¹/x", "x²", "²√x", "÷",
			"7", "8", "9", "x",
			"4", "5", "6", "-",
			"1", "2", "3", "+",
			"+/-", "0", ".", "="
			};
	
	JButton[] b = new JButton[Btn.length]; //버튼 생성 및 버튼 개수 설정
	int index = 0; //향상된 for문에서 쓰일 b의 인덱스
	
	JPanel p;
	
	Calculator() {
		this.setTitle("계산기");
		this.setSize(520,720);
		
		//계산기 모양으로 GridLayout 설정
		p = new JPanel(new GridLayout(6, 4, 2, 2));
		
		//버튼 생성 for문
		for(String text : Btn) {
			b[index] = new JButton(text);
			b[index].setBackground(Color.white);
			p.add(b[index]);
		}
		
		add(p);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
