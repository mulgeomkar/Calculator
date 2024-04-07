import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    // Declaration of GUI components
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    // Font for the calculator display
    Font myFont = new Font("Comic Sans MS",Font.BOLD,30);

    // Variables to hold operands, result, and operator
    double num1=0,num2=0,result=0;
    char operator;

    // Constructor for initializing the calculator
    Calculator(){

        // Creating the main frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Creating the text field for display
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        // Creating buttons for arithmetic operations and other functionalities
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("-/+");

        // Assigning buttons to the functionButtons array for easier management
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Adding ActionListener to function buttons and setting font
        for(int i =0;i<9;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Creating number buttons, adding ActionListener, and setting font
        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Setting bounds for functional buttons
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        // Creating panel for arranging number and functional buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Adding buttons to the panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Adding components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    // Main method to launch the calculator
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    // ActionListener method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {

        // Handling number button clicks
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // Handling decimal button click
        if(e.getSource()==decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        // Handling arithmetic operation buttons
        if(e.getSource()==addButton || e.getSource()==subButton || e.getSource()==mulButton || e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = e.getActionCommand().charAt(0); // Getting the operator from button's text
            textfield.setText("");
        }

        // Handling equals button click
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());

            // Performing calculation based on the operator
            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }

            // Displaying the result
            textfield.setText(String.valueOf(result));
            num1=result;
        }

        // Handling clear button click
        if(e.getSource()==clrButton) {
            textfield.setText("");
        }

        // Handling delete button click
        if(e.getSource()==delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

        // Handling negate button click
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
