import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
    private final Font mainFont = new Font("Segos print", Font.BOLD, 18);
    private JTextField tfFirstNumber, tfLastNumber;
    private JLabel lbWelcome;

    public void initialize() {
        // Form Panel
        JLabel lbFirstNumber = new JLabel("First Number");
        lbFirstNumber.setFont(mainFont);
        tfFirstNumber = new JTextField();
        tfFirstNumber.setFont(mainFont);

        JLabel lbLastNumber = new JLabel("Second Number");
        lbLastNumber.setFont(mainFont);
        tfLastNumber = new JTextField();
        tfLastNumber.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbFirstNumber);
        formPanel.add(tfFirstNumber);
        formPanel.add(lbLastNumber);
        formPanel.add(tfLastNumber);

        // Welcome Label
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        // Buttons Panel
        JButton btnAdd = createOperationButton("Add", "+");
        JButton btnSubtract = createOperationButton("Subtract", "-");
        JButton btnMultiply = createOperationButton("Multiply", "*");
        JButton btnDivide = createOperationButton("Divide", "/");
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(e -> clearFields());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnAdd);
        buttonsPanel.add(btnSubtract);
        buttonsPanel.add(btnMultiply);
        buttonsPanel.add(btnDivide);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(120, 120, 120));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Calculator");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createOperationButton(String label, String operator) {
        JButton btn = new JButton(label);
        btn.setFont(mainFont);
        btn.addActionListener(e -> performOperation(operator));
        return btn;
    }

    private void performOperation(String operator) {
        try {
            int num1 = Integer.parseInt(tfFirstNumber.getText());
            int num2 = Integer.parseInt(tfLastNumber.getText());
            switch (operator) {
                case "+":
                    lbWelcome.setText(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case "-":
                    lbWelcome.setText(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case "*":
                    lbWelcome.setText(num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case "/":
                    if (num2 == 0) {
                        lbWelcome.setText("Cannot divide by zero.");
                    } else {
                        lbWelcome.setText(num1 + " / " + num2 + " = " + ((float) num1 / num2));
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            lbWelcome.setText("Please enter valid numbers.");
        }
    }

    private void clearFields() {
        tfFirstNumber.setText("");
        tfLastNumber.setText("");
        lbWelcome.setText("");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.initialize();
    }
}
