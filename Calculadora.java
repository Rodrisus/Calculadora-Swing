package com.calculadora2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField textField;
    private double num1, num2;
    private int operacion;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        String[] buttonLabels = {"7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-9]")) {
                textField.setText(textField.getText() + command);
            } else if (command.matches("[+\\-*/]")) {
                num1 = Double.parseDouble(textField.getText());
                operacion = command.equals("+") ? 1 : command.equals("-") ? 2 : command.equals("*") ? 3 : 4;
                textField.setText("");
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                if (operacion == 1) {
                    textField.setText(String.valueOf(num1 + num2));
                } else if (operacion == 2) {
                    textField.setText(String.valueOf(num1 - num2));
                } else if (operacion == 3) {
                    textField.setText(String.valueOf(num1 * num2));
                } else if (operacion == 4) {
                    textField.setText(String.valueOf(num1 / num2));
                }
            } else if (command.equals("C")) {
                textField.setText("");
                num1 = 0;
                num2 = 0;
                operacion = 0;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Calculadora calculadora = new Calculadora();
                calculadora.setVisible(true);
            }
        });
    }
    
}





