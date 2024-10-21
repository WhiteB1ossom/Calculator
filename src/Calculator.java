/**
 * Calculator 클래스는 간단한 사칙연산 계산기를 구현합니다.
 * 이 클래스는 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 제공합니다.
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
 * Calculator 클래스는 간단한 계산기를 구현합니다.
 * <p>
 * 이 클래스는 사칙연산과 더불어 백스페이스, CE, C, ¹/x, 제곱, 루트 등의 기능을 제공합니다.
 * 사용자는 GUI를 통해 숫자와 연산자를 선택하여 연산을 수행할 수 있습니다.
 * </p>
 * 
 * @author Blossom
 * @version 1.0
 * @since 2024-10-20
 */
public class Calculator extends JFrame{

    /**
     * 계산기 버튼에 들어갈 기호와 연산자들을 배열로 정의합니다.
     * 배열의 각 요소는 버튼에 표시될 문자열입니다.
     */
    String[] Btn = {
        "%", "CE", "C", "←",
        "¹/x", "x²", "²√x", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "+/-", "0", ".", "="
    };

    /** 
     * 계산기 버튼을 저장하는 배열입니다. 
     * 버튼의 수는 Btn 배열의 길이와 동일합니다.
     */
    JButton[] b = new JButton[Btn.length]; // 버튼 생성 및 버튼 개수 설정

    /** 
     * 향상된 for문에서 각 버튼에 해당하는 인덱스를 추적하는 변수입니다.
     */
    int index = 0;

    /**
     * 계산기 버튼들이 담길 패널과 숫자 표시 창이 담길 패널을 정의합니다.
     */
    JPanel BtnPanel, NumPanel;

    /**
     * 계산 결과가 표시될 JTextField입니다.
     * 사용자가 입력한 값과 연산 결과가 표시됩니다.
     */
    JTextField NumSpace;

    /**
     * Calculator 클래스의 생성자입니다.
     * <p>
     * 이 생성자는 계산기의 GUI 요소들을 초기화하고 화면에 배치합니다. 
     * 숫자 입력 영역과 계산기 버튼들을 배치하며, 각각의 버튼에 대해 색상 및 레이아웃을 설정합니다.
     * </p>
     */
    Calculator() {
        this.setTitle("계산기");
        this.setSize(520,720);

        // NumSpace 설정
        NumSpace = new JTextField("0");
        NumSpace.setEditable(false);
        NumSpace.setBackground(Color.white);
        NumSpace.setHorizontalAlignment(JTextField.RIGHT);
        // 글자 크기를 크게 설정
        NumSpace.setFont(NumSpace.getFont().deriveFont(70f));

        // NumSpace를 담을 JPanel 설정
        NumPanel = new JPanel();
        NumPanel.setLayout(new BorderLayout());
        NumPanel.add(NumSpace, BorderLayout.CENTER);
        // 원하는 크기로 설정
        NumPanel.setPreferredSize(new java.awt.Dimension(520, 150));

        // 계산기 모양으로 GridLayout 설정
        BtnPanel = new JPanel();
        BtnPanel.setLayout(new GridLayout(6,4,2,2));

        // 버튼 생성 및 배열에 추가
        for(String text : Btn) {
            b[index] = new JButton(text);
            b[index].setBackground(Color.white);
            BtnPanel.add(b[index]);
            index++;
        }

        // 컴포넌트 추가
        add(NumPanel, BorderLayout.NORTH);
        add(BtnPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Calculator 클래스의 메인 메서드입니다.
     * <p>
     * 이 메서드는 Calculator 인스턴스를 생성하여 계산기 프로그램을 실행합니다.
     * </p>
     *
     * @param args 실행 시 전달되는 인자들 (사용하지 않음)
     */
    public static void main(String[] args) {
        new Calculator();
    }
}
