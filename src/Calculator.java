import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Calculator Ŭ������ ������ ��Ģ���� ���⸦ GUI ������� �����մϴ�.
 * ����, ����, ����, ������ ����� �����ϸ�, ����ڰ� GUI�� ���� ������ ������ �� �ֽ��ϴ�.
 * �߰���, �齺���̽�, �ʱ�ȭ ��ɵ� �����մϴ�.
 * 
 * @author Blossom
 * @version 1.3.0
 * @since 2024-10-20
 */
public class Calculator extends JFrame implements ActionListener {

    String[] Btn = {
        "%", "CE", "C", "��",
        "��/x", "x��", "����x", "��",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "+/-", "0", ".", "="
    };

    double num1 = 0;
    double num2 = 0;
    String operator = "";
    boolean startNewNumber = true;

    JButton[] b = new JButton[Btn.length];
    int index = 0;

    JPanel BtnPanel, NumPanel;
    JTextField LogSpace, NumSpace;

    /**
     * Calculator Ŭ������ �������Դϴ�.
     * GUI �ʱ�ȭ �� ��ư ��ġ, �̺�Ʈ ó���� �����մϴ�.
     */
    public Calculator() {
        CalculatorGUI();
    }

    /**
     * GUI ��Ҹ� �ʱ�ȭ�ϰ�, ��ư �� �ؽ�Ʈ �ʵ带 �����ϴ� �޼����Դϴ�.
     */
    private void CalculatorGUI() {
        this.setTitle("����");
        this.setSize(520, 720);

        // �α׿� ���ڸ� ǥ���� ���� ����
        setupDisplayFields();

        // ��ư �г� ����
        BtnPanel = new JPanel();
        BtnPanel.setLayout(new GridLayout(6, 4, 2, 2));
        setupButtons();

        // ������Ʈ �߰�
        add(NumPanel, BorderLayout.NORTH);
        add(BtnPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * ���� �� �α� �ʵ带 �ʱ�ȭ�ϴ� �޼����Դϴ�.
     */
    private void setupDisplayFields() {
        LogSpace = new JTextField("");
        LogSpace.setEditable(false);
        LogSpace.setBackground(Color.lightGray);
        LogSpace.setHorizontalAlignment(JTextField.RIGHT);
        LogSpace.setFont(LogSpace.getFont().deriveFont(10f));

        NumSpace = new JTextField("0");
        NumSpace.setEditable(false);
        NumSpace.setBackground(Color.white);
        NumSpace.setHorizontalAlignment(JTextField.RIGHT);
        NumSpace.setFont(NumSpace.getFont().deriveFont(70f));

        NumPanel = new JPanel();
        NumPanel.setLayout(new BorderLayout());
        NumPanel.add(NumSpace, BorderLayout.NORTH);
        NumPanel.add(LogSpace, BorderLayout.CENTER);
        NumPanel.setPreferredSize(new java.awt.Dimension(520, 150));
    }

    /**
     * ���� ��ư�� �ʱ�ȭ�ϰ�, ��ư�� ActionListener�� �߰��ϴ� �޼����Դϴ�.
     */
    private void setupButtons() {
        for (String text : Btn) {
            b[index] = new JButton(text);
            b[index].setBackground(Color.white);
            b[index].setFont(b[index].getFont().deriveFont(20f));
            b[index].addActionListener(this);
            BtnPanel.add(b[index]);
            index++;
        }
    }

    /**
     * ActionListener �޼����, ��ư Ŭ�� �̺�Ʈ�� ó���մϴ�.
     * ������, ���� �Է� �� ��Ÿ ����� ����մϴ�.
     * 
     * @param e �߻��� ActionEvent
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
     * ���ڳ� ���� �Է����� �� ó���ϴ� �޼����Դϴ�.
     * 
     * @param input ����ڰ� �Է��� ���ڳ� ��
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
     * ������ �� ��Ÿ ����� ó���ϴ� �޼����Դϴ�.
     * 
     * @param operator ����ڰ� ������ ������ �Ǵ� ���
     */
    private void processOperatorInput(String operator) {
        switch (operator) {
            case "+": case "-": case "x": case "��":
                handleOperator(operator);
                break;
            case "=":
                Equal();
                break;
            case "C":
                clearAll();
                break;
            case "��":
                BackSpace();
                break;
        }
    }

    /**
     * �����ڸ� ó���ϰ� ������ �غ��ϴ� �޼����Դϴ�.
     * 
     * @param op ����ڰ� ������ ������
     * @see #handleOperator(String)
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
     * = ��ư�� ������ �� ���� ����� ó���ϴ� �޼����Դϴ�.
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
     * ��� �� �� ����� �ʱ�ȭ�ϴ� �޼����Դϴ�.
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
     * �齺���̽� ����� ó���ϴ� �޼����Դϴ�.
     * �������� �Է��� ���ڸ� �����մϴ�.
     * @see #BackSpace
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
     * ���� ������ �����ϰ� ����� NumSpace�� ǥ���ϴ� �޼����Դϴ�.
     * @see #calculate
     * @see * @see <a href="https://codegym.cc/ko/groups/posts/ko.622.jaba-floor-meseodeu">�ܺ� ��ũ ����</a>
     */
    private void calculate() {
        num2 = Double.parseDouble(NumSpace.getText());

        switch (operator) {
            case "+": num1 += num2; break;
            case "-": num1 -= num2; break;
            case "x": num1 *= num2; break;
            case "��": num1 /= num2; break;
            default: num1 = num2; break;
        }

        if (num1 == Math.floor(num1)) {
            NumSpace.setText("" + (int) num1);
        } else {
            NumSpace.setText("" + num1);
        }

        num1 = Double.parseDouble(NumSpace.getText());
    }

    /**
     * �Էµ� ���ڿ��� �����̰ų� �Ҽ������� Ȯ���ϴ� �޼����Դϴ�.
     * 
     * @param command �Էµ� ���ڿ�
     * @return ���� �Ǵ� �Ҽ����� ��� true, �ƴϸ� false
     * @see #isNumber
     * @see <a href="https://developer-talk.tistory.com/768"</a>
     */
    private boolean isNumer(String command) {
        return (command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".");
    }

    /**
     * Calculator Ŭ������ ���� �޼����Դϴ�.
     * Calculator �ν��Ͻ��� �����Ͽ� ���α׷��� �����մϴ�.
     * 
     * @param args ���� �� ���޵Ǵ� ���� (������� ����)
     */
    public static void main(String[] args) {
        new Calculator();
    }
}
