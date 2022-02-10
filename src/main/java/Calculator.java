import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private TextField textField = new TextField();
    JButton buttons[] = new JButton[8];
    JButton numbers[] = new JButton[10];
    private JButton addButton , subButton, mulButton , divButton;
    private JButton dotButton, clearButton , deleteButton,equalsButton;

    private Font myFont = new Font("Times New Roman",Font.BOLD,30);

    char operator;
    double num1,num2;

    Calculator()
    {
        frame.setTitle("Calculator");
        frame.setSize(420,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        textField.setBounds(20,30,380,50);
        textField.setEditable(false);
        textField.setFont(myFont);
        frame.add(textField);
        frame.add(panel);
        panel.setBounds(20,125,380,380);
        panel.setLayout(new GridLayout(4,4));
        panel.setBackground(Color.gray);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        clearButton = new JButton("<-");
        deleteButton = new JButton("x");
        equalsButton = new JButton("=");





        buttons[0]= addButton;
        buttons[1]= subButton;
        buttons[2]= mulButton;
        buttons[3]= divButton;
        buttons[4]= dotButton;
        buttons[5]= clearButton;
        buttons[6]= deleteButton;
        buttons[7]= equalsButton;


        for (int i= 0 ;i<8;i++)
        {
            buttons[i].addActionListener(this);
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(myFont);
        }
        for (int i=0;i<10;i++)
        {

            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusPainted(false);
            numbers[i].setFont(myFont);
        }


        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(deleteButton);
        panel.add(numbers[0]);
        panel.add(equalsButton);
        panel.add(divButton);




        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0;i<10;i++)
        {
            if (e.getSource() == numbers[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
            if (e.getSource() == dotButton)
            {
                textField.setText(textField.getText().concat(String.valueOf(".")));
            }
            if (e.getSource() == addButton)
            {
                num1 = Double.parseDouble(textField.getText());
                System.out.println("Number 1 "+num1);
                operator='+';
                textField.setText("");
            }
            if (e.getSource() == subButton)
            {
                num1 = Double.parseDouble(textField.getText());
                System.out.println("Number 1 "+num1);
                operator='-';
                textField.setText("");
            }
            if (e.getSource() == mulButton)
            {
                num1 = Double.parseDouble(textField.getText());
                System.out.println("Number 1 "+num1);
                operator='*';
                textField.setText("");
            }
            if (e.getSource() == divButton)
            {
                num1 = Double.parseDouble(textField.getText());
                System.out.println("Number 1 "+num1);
                operator='/';
                textField.setText("");
            }

            if (e.getSource() == equalsButton)
            {
                num2=Double.parseDouble(textField.getText());
                System.out.println("Number 2 "+num2);
                switch (operator)
                {
                    case '+':
                    {
                        textField.setText(String.valueOf(num1+num2));
                        break;
                    }
                    case '-':
                    {
                        textField.setText(String.valueOf(num1-num2));
                        break;
                    }
                    case '*':
                    {
                        textField.setText(String.valueOf(num1*num2));
                        break;
                    }
                    case '/':
                    {
                        textField.setText(String.valueOf(num1/num2));
                        break;
                    }
                }
                break;
            }

            if (e.getSource() == deleteButton)
            {
                textField.setText("");
            }


        }

    }
}
