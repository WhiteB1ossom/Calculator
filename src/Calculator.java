/**
 * Calculator Ŭ������ ������ ��Ģ���� ���⸦ �����մϴ�.
 * �� Ŭ������ ����, ����, ����, ������ ����� �����մϴ�.
 * 
 * @author Blossom
 * @version 1.0
 * @since 2024-10-20
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Calculator Ŭ������ ������ ���⸦ �����մϴ�.
 * <p>
 * �� Ŭ������ ��Ģ����� ���Ҿ� �齺���̽�, CE, C, ��/x, ����, ��Ʈ ���� ����� �����մϴ�.
 * ����ڴ� GUI�� ���� ���ڿ� �����ڸ� �����Ͽ� ������ ������ �� �ֽ��ϴ�.
 * </p>
 * 
 * @author Blossom
 * @version 1.0
 * @since 2024-10-20
 */
public class Calculator extends JFrame{

    /**
     * ���� ��ư�� �� ��ȣ�� �����ڵ��� �迭�� �����մϴ�.
     * �迭�� �� ��Ҵ� ��ư�� ǥ�õ� ���ڿ��Դϴ�.
     */
    String[] Btn = {
        "%", "CE", "C", "��",
        "��/x", "x��", "����x", "��",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "+/-", "0", ".", "="
    };

    /** 
     * ���� ��ư�� �����ϴ� �迭�Դϴ�. 
     * ��ư�� ���� Btn �迭�� ���̿� �����մϴ�.
     */
    JButton[] b = new JButton[Btn.length]; // ��ư ���� �� ��ư ���� ����

    /** 
     * ���� for������ �� ��ư�� �ش��ϴ� �ε����� �����ϴ� �����Դϴ�.
     */
    int index = 0;

    /**
     * ���� ��ư���� ��� �гΰ� ���� ǥ�� â�� ��� �г��� �����մϴ�.
     */
    JPanel BtnPanel, NumPanel;

    /**
     * ��� ����� ǥ�õ� JTextField�Դϴ�.
     * ����ڰ� �Է��� ���� ���� ����� ǥ�õ˴ϴ�.
     */
    JTextField NumSpace;

    /**
     * Calculator Ŭ������ �������Դϴ�.
     * <p>
     * �� �����ڴ� ������ GUI ��ҵ��� �ʱ�ȭ�ϰ� ȭ�鿡 ��ġ�մϴ�. 
     * ���� �Է� ������ ���� ��ư���� ��ġ�ϸ�, ������ ��ư�� ���� ���� �� ���̾ƿ��� �����մϴ�.
     * </p>
     */
    Calculator() {
        this.setTitle("����");
        this.setSize(520,720);

        // NumSpace ����
        NumSpace = new JTextField("0");
        NumSpace.setEditable(false);
        NumSpace.setBackground(Color.white);
        NumSpace.setHorizontalAlignment(JTextField.RIGHT);
        // ���� ũ�⸦ ũ�� ����
        NumSpace.setFont(NumSpace.getFont().deriveFont(70f));

        // NumSpace�� ���� JPanel ����
        NumPanel = new JPanel();
        NumPanel.setLayout(new BorderLayout());
        NumPanel.add(NumSpace, BorderLayout.CENTER);
        // ���ϴ� ũ��� ����
        NumPanel.setPreferredSize(new java.awt.Dimension(520, 150));

        // ���� ������� GridLayout ����
        BtnPanel = new JPanel();
        BtnPanel.setLayout(new GridLayout(6,4,2,2));

        // ��ư ���� �� �迭�� �߰�
        for(String text : Btn) {
            b[index] = new JButton(text);
            b[index].setBackground(Color.white);
            BtnPanel.add(b[index]);
            index++;
        }

        // ������Ʈ �߰�
        add(NumPanel, BorderLayout.NORTH);
        add(BtnPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Calculator Ŭ������ ���� �޼����Դϴ�.
     * <p>
     * �� �޼���� Calculator �ν��Ͻ��� �����Ͽ� ���� ���α׷��� �����մϴ�.
     * </p>
     *
     * @param args ���� �� ���޵Ǵ� ���ڵ� (������� ����)
     */
    public static void main(String[] args) {
        new Calculator();
    }
}
