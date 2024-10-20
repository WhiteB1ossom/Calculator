import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame{

	//��ư�� �� ���ڵ� �迭
	String[] Btn = {
			"%", "CE", "C", "��",
			"��/x", "x��", "����x", "��",
			"7", "8", "9", "x",
			"4", "5", "6", "-",
			"1", "2", "3", "+",
			"+/-", "0", ".", "="
			};
	
	JButton[] b = new JButton[Btn.length]; //��ư ���� �� ��ư ���� ����
	int index = 0; //���� for������ ���� b�� �ε���
	
	JPanel p;
	
	Calculator() {
		this.setTitle("����");
		this.setSize(520,720);
		
		//���� ������� GridLayout ����
		p = new JPanel(new GridLayout(6, 4, 2, 2));
		
		//��ư ���� for��
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
