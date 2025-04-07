import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JTextField textField = new JTextField();
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
            "."
        };

        textField.setEditable(false);
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(e -> handleButtonClick(e, textField));
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void handleButtonClick(ActionEvent e, JTextField textField) {
        String command = e.getActionCommand();
        String currentText = textField.getText();

        if (command.equals("C")) {
            textField.setText("");
        } else if (command.equals("=")) {
            try {
                double result = eval(currentText);
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        } else {
            textField.setText(currentText + command);
        }
    }

   
    private static double eval(String expression) {
        if (expression.isEmpty()) return 0;

        try {
            String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])"); 
            double result = Double.parseDouble(tokens[0].trim());

            for (int i = 1; i < tokens.length; i += 2) {
                String operator = tokens[i].trim();
                double next = Double.parseDouble(tokens[i + 1].trim());

                switch (operator) {
                    case "+":
                        result += next;
                        break;
                    case "-":
                        result -= next;
                        break;
                    case "*":
                        result *= next;
                        break;
                    case "/":
                        result /= next;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }
            }


            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }
}
