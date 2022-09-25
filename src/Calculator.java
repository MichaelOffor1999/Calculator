
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

public class Calculator extends JFrame implements ActionListener {
    JTextField field;
    JButton[] numberButtons;
    JButton clearButton;
    JButton minusButton;
    JButton addButton;
    JButton divButton;
    JButton equalButton;
    JButton mulButton;
    char operator;
    int num1, num2, result;
    public Calculator(){
        field = new JTextField();
        field.setBounds(50, 20, 300, 50);

        numberButtons = new JButton[10];

        minusButton = new JButton("-");
        minusButton.addActionListener(this);

        addButton = new JButton("+");
        addButton.addActionListener(this);

        divButton = new JButton("/");
        divButton.addActionListener(this);

        equalButton = new JButton("=");
        equalButton.addActionListener(this);

        mulButton = new JButton("x");
        mulButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);


        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(minusButton);

        this.setTitle("Calculator");
        this.setSize(420, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.add(field);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       //this adds every button thats not a special button(number buttons basically) to the textfield
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }
        //replaces the content of the textfield with a space if clear button id clicked
        if(e.getSource() == clearButton){
            field.setText("");
        }

        if(e.getSource() == addButton){
            num1 = Integer.parseInt(field.getText());
            field.setText("");
            operator = '+';
            }

        if(e.getSource() == minusButton){
            num1 = Integer.parseInt(field.getText());
            field.setText("");
            operator = '-';
        }

        if(e.getSource() == divButton){
            num1 = Integer.parseInt(field.getText());
            field.setText("");
            operator = '/';
        }

        if(e.getSource() == mulButton){
            num1 = Integer.parseInt(field.getText());
            field.setText("");
            operator = '*';
        }

        //if equal button, store second input then depending on what special button was clicked a different operation is carried out
        if(e.getSource() == equalButton){
            num2 = Integer.parseInt(field.getText());

            switch(operator){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
            }
            //sets the textfiels with result
            field.setText(String.valueOf(result));
        }
    }
}
