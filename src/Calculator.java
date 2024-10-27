import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;	
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Calculator 클래스는 간단한 사칙연산 계산기를 GUI 기반으로 구현합니다.
 * 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 제공하며, 사용자가 GUI를 통해 연산을 수행할 수 있습니다.
 * 추가로, 백스페이스, 초기화 기능도 지원합니다.
 * 
 * @author Blossom
 * @version 1.4.2
 * @since 2024-10-20
 */
public class Calculator extends JFrame implements ActionListener {

    String[] Btn = {
    	"Blossom", "C", "←", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "　", "0", ".", "="
    };

    double num1 = 0;
    double num2 = 0;
    String operator = "";
    boolean startNewNumber = true;

    JButton[] b = new JButton[Btn.length];
    int index = 0;

    JPanel BtnPanel, NumPanel;
    JTextField LogSpace, NumSpace;
    Font font;

    /**
     * Calculator 클래스의 생성자입니다.
     * GUI 초기화 및 버튼 배치, 이벤트 처리를 설정합니다.
     */
    public Calculator() {
        CalculatorGUI();
    }

    /**
     * GUI 요소를 초기화하고, 버튼 및 텍스트 필드를 설정하는 메서드입니다.
     */
    private void CalculatorGUI() {
        this.setTitle("계산기");
        this.setSize(420, 620);

        // 로그와 숫자를 표시할 영역 설정
        setupDisplayFields();

        // 버튼 패널 설정
        BtnPanel = new JPanel();
        BtnPanel.setLayout(new GridLayout(5, 4, 2, 2));
        setupButtons();

        // 컴포넌트 추가
        add(NumPanel, BorderLayout.NORTH);
        add(BtnPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * 숫자 및 로그 필드를 초기화하는 메서드입니다.
     */
    private void setupDisplayFields() {
    	font = new Font("Serif", Font.BOLD, 0);
    	
        LogSpace = new JTextField("");
        LogSpace.setEditable(false);
        LogSpace.setBackground(Color.lightGray);
        LogSpace.setHorizontalAlignment(JTextField.RIGHT);
        LogSpace.setFont(font.deriveFont(20f));

        NumSpace = new JTextField("0");
        NumSpace.setEditable(false);
        NumSpace.setBackground(Color.white);
        NumSpace.setHorizontalAlignment(JTextField.RIGHT);
        NumSpace.setFont(font.deriveFont(70f));

        NumPanel = new JPanel();
        NumPanel.setLayout(new BorderLayout());
        NumPanel.add(NumSpace, BorderLayout.NORTH);
        NumPanel.add(LogSpace, BorderLayout.CENTER);
        NumPanel.setPreferredSize(new java.awt.Dimension(520, 150));
    }

    /**
     * 계산기 버튼을 초기화하고, 버튼에 ActionListener를 추가하는 메서드입니다.
     */
    private void setupButtons() {
        for (String text : Btn) {
        	
        	font = new Font("Serif", Font.BOLD, 30);
        	
            b[index] = new JButton(text);
            b[index].setBackground(Color.white);
            b[index].setFont(font);
            b[index].addActionListener(this);
            BtnPanel.add(b[index]);
            
            if(index <= 3 || index % 4 == 3) {
            	b[index].setBackground(new Color(243,243,243));
            }
            if (index == 19) {
            	b[index].setBackground(new Color(0,90,158));
            	b[index].setForeground(Color.white);
            }
            if (index == 0) {
            	b[index].setFont(font.deriveFont(15f));
            }
            index++;
        }
    }

    /**
     * ActionListener 메서드로, 버튼 클릭 이벤트를 처리합니다.
     * 연산자, 숫자 입력 및 기타 기능을 담당합니다.
     * 
     * @param e 발생한 ActionEvent
     * @see #processNumericInput(String)
     * @see #processOperatorInput(String)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (isNumer(command)) {
            processNumericInput(command);
        } else {
            processOperatorInput(command);
        }
    }

    /**
     * 숫자나 점을 입력했을 때 처리하는 메서드입니다.
     * 
     * @param input 사용자가 입력한 숫자나 점
     */
    private void processNumericInput(String input) {
        if (startNewNumber) {
            NumSpace.setText(input);
            LogSpace.setText(LogSpace.getText() + input);
            startNewNumber = false;
        } else {
            NumSpace.setText(NumSpace.getText() + input);
            LogSpace.setText(LogSpace.getText() + input);
        }
    }

    /**
     * 연산자 및 기타 기능을 처리하는 메서드입니다.
     * 
     * @param operator 사용자가 선택한 연산자 또는 기능
     */
    private void processOperatorInput(String operator) {
        switch (operator) {
            case "+": case "-": case "x": case "÷":
                handleOperator(operator);
                break;
            case "=":
                Equal();
                break;
            case "C":
                clearAll();
                break;
            case "←":
                BackSpace();
                break;
        }
    }

    /**
     * 연산자를 처리하고 연산을 준비하는 메서드입니다.
     * 
     * @param op 사용자가 선택한 연산자
     * @see #handleOperator(String)
     * @see <a href="https://comain.tistory.com/14">계산기 기호 작동 참고 외부링크</a>
     */
    private void handleOperator(String op) {
        if (!startNewNumber) {
            calculate();
        }
        this.operator = op;
        LogSpace.setText(LogSpace.getText() + " " + operator + " ");
        startNewNumber = true;
    }

    /**
     * = 버튼을 눌렀을 때 최종 계산을 처리하는 메서드입니다.
     */
    private void Equal() {
        if (!startNewNumber) {
            calculate();
            operator = "";
            LogSpace.setText("");
            startNewNumber = true;
        } else {
            LogSpace.setText("");
        }
    }

    /**
     * 모든 값 및 기록을 초기화하는 메서드입니다.
     * @see #clearAll
     */
    private void clearAll() {
        NumSpace.setText("0");
        LogSpace.setText("");
        num1 = num2 = 0;
        operator = "";
        startNewNumber = true;
    }

    /**
     * 백스페이스 기능을 처리하는 메서드입니다.
     * 마지막에 입력한 문자를 삭제합니다.
     * @see #BackSpace
     * @see <a href="https://0rcticfox.tistory.com/entry/822-%EC%9E%90%EB%B0%94Java-GUI-%ED%99%9C%EC%9A%A9-JPanel-%ED%99%9C%EC%9A%A9-%EA%B3%84%EC%82%B0%EA%B8%B0-%EC%98%A4%EB%AA%A9-%EA%B2%8C%EC%9E%84">BackSpace 및 다른 변수 이름 참고 외부링크</a>
     */
    private void BackSpace() {
        String currentText = NumSpace.getText();
        if (currentText.length() > 1) {
            NumSpace.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            NumSpace.setText("0");
        }
    }

    /**
     * 현재 연산을 수행하고 결과를 NumSpace에 표시하는 메서드입니다.
     * @see #calculate
     * @see <a href="https://developer-hm.tistory.com/229">BigDecimal 참고 외부링크</a>
     */
    private void calculate() {
        BigDecimal BDnum1 = new BigDecimal(Double.toString(num1));
        BigDecimal BDnum2 = new BigDecimal(NumSpace.getText());

        BigDecimal result = switch (operator) {
            case "+" -> BDnum1.add(BDnum2);
            case "-" -> BDnum1.subtract(BDnum2);
            case "x" -> BDnum1.multiply(BDnum2);
            case "÷" -> BDnum1.divide(BDnum2, 10, BigDecimal.ROUND_HALF_UP);  // 10자리 소수점까지 표시
            default -> BDnum2;
        };
        
        num1 = result.doubleValue();  // num1에 결과값 저장
        NumSpace.setText(result.stripTrailingZeros().toPlainString());
    }

    /**
     * 입력된 문자열이 숫자이거나 소수점인지 확인하는 메서드입니다.
     * 
     * @param command 입력된 문자열
     * @return 숫자 또는 소수점일 경우 true, 아니면 false
     * @see #isNumber
     * @see <a href="https://developer-talk.tistory.com/768">문자열 판별 참고 외부링크</a>
     */
    private boolean isNumer(String command) {
        return (command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".");
    }

    /**
     * Calculator 클래스의 메인 메서드입니다.
     * Calculator 인스턴스를 생성하여 프로그램을 실행합니다.
     * 
     * @param args 실행 시 전달되는 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        new Calculator();
    }
}
