import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private TextField textField = new TextField();
    private JMenuBar menuBar = new JMenuBar();

    JButton buttons[] = new JButton[9];
    JButton numbers[] = new JButton[10];
    private JButton addButton , subButton, mulButton , divButton;
    private JButton dotButton, clearButton , deleteButton,equalsButton,percentButton;
    int defaultFontSize = 25;
    private Font myFont = new Font("Times New Roman",Font.BOLD,defaultFontSize);

    char operator;
    double num1,num2;
    double result;



    public JMenu createFileMenu() {
        JMenu menu = new JMenu("File");
        JMenuItem item = new JMenuItem("Exit");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(item);
        return menu;
    }

    public void setButtonFont()
    {
        if (defaultFontSize>70)
        {
            defaultFontSize-=5;
            JOptionPane.showMessageDialog(null,"Maximum Size reached");
        }
        else if (defaultFontSize<20)
        {
            defaultFontSize+=5;
            JOptionPane.showMessageDialog(null,"Maximum Size reached");
        }
        else {
            Font f = new Font("Times new Roman", Font.BOLD, defaultFontSize);
            //System.out.println("This function is called with font size " + defaultFontSize);
            for (int i = 0; i < 8; i++) {
                buttons[i].setFont(f);
            }
            for (int i = 0; i < 10; i++) {
                numbers[i].setFont(f);
            }
        }
    }

    public JMenu createConvertMenu()
    {
        JMenu menu = new JMenu("Convert");
        JMenuItem temp = new JMenuItem("Temperature");
        JMenuItem weight = new JMenuItem("Weight");
        menu.add(temp);
        menu.add(weight);

        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame("Convert Temprature");
                JPanel panel = new JPanel();
                JPanel panel2 = new JPanel();
                panel.setLayout(new GridLayout(3,2));
                JButton convertButton = new JButton("Convert");
                JLabel label1 = new JLabel("Farenheit : ");
                JLabel label2 = new JLabel("Celcius :");
                JLabel label3 = new JLabel("xxxxxxxx",SwingConstants.CENTER);
                label3.setFont(myFont);
                JTextField ftextField = new JTextField("0");
                JTextField ctextField = new JTextField("0");
                frame1.setSize(420,200);
                frame1.setLayout(new GridLayout(2,0));
                ftextField.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();  // if it's not a number, ignore the event
                        }
                    }
                });
                ctextField.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();  // if it's not a number, ignore the event
                        }
                    }
                });
                frame1.add(panel);
                frame1.add(panel2);
                panel.add(label1);
                panel.add(ftextField);
                panel.add(label2);
                panel.add(ctextField);
                panel2.setLayout(new GridLayout(2,0));
                panel2.add(label3);
                label3.setVisible(false);
                panel2.add(convertButton);

                convertButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Integer.parseInt(ftextField.getText())!=0)
                        {
                            double f = Double.parseDouble(ftextField.getText());
                            float c = (float) ((f-32)*5/9);
                            String ans = String.format("%.02f",c);
                            String answer = ftextField.getText()+" Degree F is almost "+ans+" Degree C.";
                            label3.setText(answer);
                            label3.setVisible(true);
                            ctextField.setText("0");
                            ftextField.setText("0");
                        }
                        if (Integer.parseInt(ctextField.getText())!=0)
                        {
                            double c = Double.parseDouble(ctextField.getText());
                            float f = (float) ((1.8*c)+32);
                            String ans  = String.format("%.02f",f);
                            String answer = ctextField.getText()+" Degree C is almost "+ans+" Degree F";
                            label3.setText(answer);
                            label3.setVisible(true);
                            ctextField.setText("0");
                            ftextField.setText("0");
                        }
                    }
                });

                frame1.setVisible(true);
            }
        });

        weight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame("Convert Weight");
                JPanel panel = new JPanel();
                JPanel panel2 = new JPanel();
                panel.setLayout(new GridLayout(3,2));
                JButton convertButton = new JButton("Convert");
                JLabel label1 = new JLabel("Pounds : ");
                JLabel label2 = new JLabel("Kilogram :");
                JLabel label3 = new JLabel("xxxxxxxx",SwingConstants.CENTER);
                label3.setFont(myFont);
                JTextField ptextField = new JTextField("0");
                JTextField ktextField = new JTextField("0");
                frame1.setSize(420,200);
                frame1.setLayout(new GridLayout(2,0));
                ptextField.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();  // if it's not a number, ignore the event
                        }
                    }
                });
                ktextField.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();  // if it's not a number, ignore the event
                        }
                    }
                });
                frame1.add(panel);
                frame1.add(panel2);
                panel.add(label1);
                panel.add(ptextField);
                panel.add(label2);
                panel.add(ktextField);
                panel2.setLayout(new GridLayout(2,0));
                panel2.add(label3);
                label3.setVisible(false);
                panel2.add(convertButton);

                convertButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Integer.parseInt(ptextField.getText())!=0)
                        {
                            System.out.println(ptextField.getText()!=null);
                            double p = Double.parseDouble(ptextField.getText());
                            float k = (float) (p/2.2);
                            String ans = String.format("%.02f",k);
                            String answer = ptextField.getText()+" Pounds is almost "+ans+" Kilogram.";
                            label3.setText(answer);
                            label3.setVisible(true);
                            ptextField.setText("0");
                            ktextField.setText("0");
                        }
                        if (Integer.parseInt(ktextField.getText())!=0)
                        {
                            double k = Double.parseDouble(ktextField.getText());
                            float p = (float) (k*2.2);
                            String ans = String.format("%.02f",p);
                            String answer = ktextField.getText()+" Kilograms is almost "+ ans+" Pounds";
                            label3.setText(answer);
                            label3.setVisible(true);
                            ktextField.setText("0");
                            ptextField.setText("0");
                        }
                    }
                });

                frame1.setVisible(true);
            }
        });



        return menu;
    }

    public JMenu createFontMenu(){
        JMenu menu = new JMenu("Font");
        JMenuItem increase = new JMenuItem("Increase size");
        JMenuItem decrease = new JMenuItem("Decrease size");
        menu.add(increase);
        menu.add(decrease);

        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultFontSize+=5;
                setButtonFont();
                System.out.println("Font Size increased to "+defaultFontSize);
            }
        });
        decrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultFontSize-=5;
                setButtonFont();
                System.out.println("Font Size decreased to "+defaultFontSize);
            }
        });
        return menu;
    }
    Calculator()
    {

        menuBar.add(createFileMenu());
        menuBar.add(createFontMenu());
        menuBar.add(createConvertMenu());
        frame.setJMenuBar(menuBar);
        frame.setTitle("Calculator");
        frame.setSize(420,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        textField.setBounds(20,30,380,50);
        textField.setEditable(false);
        textField.setFont(myFont);
        frame.add(textField);
        frame.add(panel);
        frame.add(panel2);
        panel.setBounds(20,160,380,300);
        panel.setLayout(new GridLayout(4,4));
        panel.setBackground(Color.gray);
        panel2.setBounds(20,85,380,75);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new GridLayout(1,2));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        clearButton = new JButton("Clear");
        deleteButton = new JButton("Delete");
        equalsButton = new JButton("=");
        percentButton = new JButton("%");





        buttons[0]= addButton;
        buttons[1]= subButton;
        buttons[2]= mulButton;
        buttons[3]= divButton;
        buttons[4]= dotButton;
        buttons[5]= clearButton;
        buttons[6]= deleteButton;
        buttons[7]= equalsButton;
        buttons[8]=percentButton;


        for (int i= 0 ;i<9;i++)
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

        panel2.add(deleteButton);
        panel2.add(clearButton);
        panel2.add(equalsButton);
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
        panel.add(percentButton);
        panel.add(numbers[0]);
        panel.add(dotButton);
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
            if (e.getSource() == addButton)
            {
                System.out.println(textField.getText());
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

            if (e.getSource() == percentButton)
            {
                num1 = Double.parseDouble(textField.getText());
                System.out.println("Number 1 "+num1);
                operator='%';
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
                        result=num1+num2;
                        break;
                    }
                    case '-':
                    {
                        result=num1-num2;
                        break;
                    }
                    case '*':
                    {
                        result=num1*num2;
                        break;
                    }
                    case '/':
                    {
                        result=num1/num2;
                        break;
                    }
                    case '%':
                    {
                        result = (num1/100)*num2;
                        break;
                    }
                }

                int check = (int) result;
                if (check<result)
                {
                    textField.setText(String.valueOf(result));
                }
                else
                {
                    textField.setText(String.valueOf(check));
                }

                num2=result;
                break;
            }

            if (e.getSource() == deleteButton)
            {
                textField.setText("");
            }
        }
        if (e.getSource() == dotButton)
        {
            textField.setText(textField.getText()+".");
        }
        if (e.getSource()== clearButton)
        {
            String now = textField.getText();
            String newString = "";
            for (int j =0 ;j<(now.length()-1);j++)
            {
                //System.out.println("L:"+now.length());
                newString += now.charAt(j);
            }
            //System.out.println("NS:"+newString);
            textField.setText(newString);
        }

    }
}