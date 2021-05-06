import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//CALCULATOR CLASS IMPLEMENTING ACTION LISTENER
public class Calculator implements ActionListener {

    //CREATING FRAME
    JFrame frame;

    //CREATING TEXT FIELD
    JTextField textfield;

    //ARRAY FOR NUMBER BUTTONS
    JButton[] numberButtons = new JButton[10];

    //ARRAY FOR FUNCTION BUTTONS
    JButton[] functionButtons = new JButton[9];

    //CREATING VAR FOR NUMBER BUTTONS
    JButton addButton , subButton , mulButton , divButton;

    ///CREATING VAR FOR FUNCTION BUTTONS
    JButton decButton , equButton , delButton , clrButton , negButton;

    //CREATING PANEL
    JPanel panel;

    //CUSTOMIZING OWN FONT THROUGH FONT CLASS
    Font myFont = new Font("SanSerif" ,Font.PLAIN , 30);

    //VARIABLES FOR OPERATIONS
    double num1=0 , num2=0 , result=0 ;
    char operator;

    //CONSTRUCTOR
    Calculator(){

        //SETTING FRAME VAR AS INSTANCE OF JFRAME CLASS
        frame = new JFrame("Calculator");

        //FOR EXIT
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //SETTING FRAME SIZE
        frame.setSize(420 , 550);

        //SETTING LAYOUT AS NULL
        frame.setLayout(null);

        //TEXT FIELD SETUP

        //SETTING TEXTFIELD VAR AS INSTANCE OF JTEXTFIELD CLASS
        textfield =  new JTextField();

        //SETTING DIMENSION AND POSITION OF TEXT FIELD
        textfield.setBounds(50 ,25 , 300 , 50 );

        //SETTING THE FONT FOR TEXT FIELD
        textfield.setFont(myFont);

        //DISABLING THE EDITIBILITY OF TEXTFIELD FROM KEYBOARD
        textfield.setEditable(false);

        //SETTING FUNCTION BUTTON VAR AS INSTANCE OF JBUTTON CLASS AND SETTING PARTICULAR TEXT
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        //SETTING EACH FUNCTION VAR TO THE FUNCTION BUTTON ARRAY
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = delButton;
        functionButtons[6] = equButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        //SETTING UP THE PROPERTIES OF FUNCTION BUTTON ARRAY
        for(int i=0;i<9;i++){

            //ADDING ACTION LISTENER
            functionButtons[i].addActionListener(this);

            //SETTING UP FONT
            functionButtons[i].setFont(myFont);

            //REMOVING THE FOCUSABILITY
            functionButtons[i].setFocusable(false);

        }

        //SETTING UP PROPERTIES OF NUMBER BUTTON ARRAY
        for(int i=0;i<10;i++){

            //SETTING NUMBER BUTTONS AS INSTANCE FOR JBUTTON AND SETTING THEIR VALUE AS INDEX VALUE
            numberButtons[i] = new JButton(String.valueOf(i));

            //ADDING ACTION LISTENER
            numberButtons[i].addActionListener(this);

            //SETTING UP FONT
            numberButtons[i].setFont(myFont);

            //REMOVING THE FOCUSABILITY
            numberButtons[i].setFocusable(false);

        }

        //SETTING BOUNDARIES OF BUTTON WITH NEGATIVE SIGN
        negButton.setBounds(50 , 430 , 100 , 50);

        //SETTING BOUNDARIES OF DELETE BUTTON
        delButton.setBounds(150 , 430 , 100 , 50);

        //SETTING BOUNDARIES OF CLEAR BUTTON
        clrButton.setBounds(250 , 430 , 100 , 50);

        //SETTING PANEL VAR AS INSTANCE OF JPANEL CLASS
        panel = new JPanel();

        //SETTING BOUNDARIES OF PANEL
        panel.setBounds(50 , 100 , 300 , 300);

        //SETTING THE LAYOUT FOR PANEL AS NO. OF ROWS AND COLUMNS
        panel.setLayout(new GridLayout(4 ,4 ,10 , 10));

        //SETTING THE BACKGROUND COLOR OF PANEL
//        panel.setBackground(Color.lightGray);

        //ADDING ALL THE BUTTONS TO THE PANEL

        //ROW 1
        //COLUMN 1
        panel.add(numberButtons[1]);
        //COLUMN 2
        panel.add(numberButtons[2]);
        //COLUMN 3
        panel.add(numberButtons[3]);
        //COLUMN 4
        panel.add(addButton);

        //ROW2
        //COLUMN 1
        panel.add(numberButtons[4]);
        //COLUMN 2
        panel.add(numberButtons[5]);
        //COLUMN 3
        panel.add(numberButtons[6]);
        //COLUMN 4
        panel.add(subButton);

        //ROW 3
        //COLUMN 1
        panel.add(numberButtons[7]);
        //COLUMN 2
        panel.add(numberButtons[8]);
        //COLUMN 3
        panel.add(numberButtons[9]);
        //COLUMN 4
        panel.add(mulButton);


        //ROW 4
        //COLUMN 1
        panel.add(decButton);
        //COLUMN 2
        panel.add(numberButtons[0]);
        //COLUMN 3
        panel.add(equButton);
        //COLUMN 4
        panel.add(divButton);

        //ADDING THE NEGATIVE BUTTON TO THE FRAME
        frame.add(negButton);

        //ADDING THE PANEL TO THE FRAME
        frame.add(panel);

        //ADDING THE DELETE BUTTON TO THE FRAME
        frame.add(delButton);

        //ADDING THE CLEAR BUTTON TO THE FRAME
        frame.add(clrButton);

        //ADDING THE TEXT FIELD TO THE FRAME
        frame.add(textfield);

        //SETTING THE VISIBILITY OF THE FRAME TO TRUE
        frame.setVisible(true);

    }

    //MAIN
    public static void main(String[] args) {

        //CREATING INSTANCE OF THE CALCULATOR CLASS
        Calculator calc = new Calculator();

    }

    //OVERRIDING ACTION PERFORMED METHOD
    @Override
    public void actionPerformed(ActionEvent e){

        //FOR LOOP TRAVERSING THE NUMBER BUTTON
        for(int i=0;i<10;i++){

            //IF THE OBJECT RETURNED IS SAME AS THE NUMBER BUTTON OF PARTICULAR INDEX
            if(e.getSource() == numberButtons[i]){

                //TEXT OF THE TEXT FIELD WILL BE SET TO THE
                // TEXT ALREADY ON THE TEXTFIELD CONCATINATING WITH THE TEXT OF NUMBER BUTTON
                textfield.setText(textfield.getText().concat(String.valueOf(i)));

            }
        }

        //IF THE OBJECT RETURNED IS SAME AS THE DECIMAL BUTTON
        if(e.getSource() == decButton){

            //SETTING THE TEXT FIELD TEXT TO DECIMAL BUTTON TEXT
            textfield.setText(textfield.getText().concat("."));

        }

        //IF THE OBJECT RETURNED IS SAME AS THE ADD BUTTON
        if(e.getSource() == addButton){

            //STORING THE DOUBLE VALUE OF TEXT FIELD IN NUM 1
            num1 = Double.parseDouble(textfield.getText());

            //SETTING THE OPERATOR VAR AS THE PLUS SIGN
            operator = '+';

            //SETTING THE TEXT FIELD EMPTY
            textfield.setText("");

        }

        //IF THE RETURNED OBJECT IS SAME AS THE SUBTRACT BUTTON
        if(e.getSource() == subButton){

            //STORING THE DOUBLE VALUE OF TEXT FIELD IN NUM 1
            num1 = Double.parseDouble(textfield.getText());

            //SETTING THE OPERATOR VAR AS THE MINUS SIGN
            operator = '-';

            //SETTING THE TEXT FIELD EMPTY
            textfield.setText("");

        }

        //IF THE RETURNED OBJECT IS SAME AS THE MULTIPLY BUTTON
        if(e.getSource() == mulButton){

            //STORING THE DOUBLE VALUE OF TEXT FIELD IN NUM 1
            num1 = Double.parseDouble(textfield.getText());

            //SETTING THE OPERATOR VAR AS THE MULTIPLY SIGN
            operator = '*';

            //SETTING THE TEXT FIELD EMPTY
            textfield.setText("");

        }

        //IF THE RETURNED OBJECT IS SAME AS THE DIVISION BUTTON
        if(e.getSource() == divButton){

            //STORING THE DOUBLE VALUE OF TEXT FIELD IN NUM 1
            num1 = Double.parseDouble(textfield.getText());

            //SETTING THE OPERATOR VAR AS THE FORWARD SLASH SIGN
            operator = '/';

            //SETTING THE TEXT FIELD EMPTY
            textfield.setText("");

        }

        //IF THE RETURNED OBJECT IS SAME AS THE EQUAL BUTTON
        if(e.getSource() == equButton){

            //STORING THE DOUBLE VALUE OF TEXT FIELD IN NUM 2
            num2 = Double.parseDouble(textfield.getText());

            //SWITCH FUNCTION FOR OPERATOR
            switch(operator){

                //CASE 1
                case'+':

                    //ADDITION
                    result = num1 + num2;
                    break;

                //CASE 2
                case'-':

                    //SUBTRACTION
                    result = num1 - num2;
                    break;

                //CASE 3
                case'*':

                    //MULTIPLICATION
                    result = num1 * num2;
                    break;

                //CASE 4
                case'/':

                    //DIVISION
                    result = num1 / num2;
                    break;

            }

            //SETTING THE TEXT OF TEXT FIELD AS RESULT
            textfield.setText(String.valueOf(result));

            //STORING THE RESULT IN NUM 1 FOR FURTHER CALCULATIONS
            num1 = result;

        }

        //IF THE RETURNED OBJECT IS SAME AS THE CLEAR BUTTON
        if(e.getSource() == clrButton){

            //SETTING THE TEXT FIELD EMPTY
            textfield.setText("");

        }

        //IF THE RETURNED OBJECT IS SAME AS THE DELETE BUTTON
        if(e.getSource() == delButton){

            //STORING THE TEXT OF TEXT FIELD IN NEW VARIABLE STRING
            String string = textfield.getText();

            //SETTING THE TEXT FIELD EMPTY
            textfield.setText("");

            //LOOP FOR DELETING  LAST INDEX
            for(int i=0;i<string.length()-1;i++){

                //SETTING THE TEXT FIELD TEXT AS THE STRING AT INDICES 0 TO ONE LESS THAN THE LAST
                textfield.setText(textfield.getText()+string.charAt(i));

            }
        }

        //IF THE RETURNED OBJECT IS SAME AS THE NEGATIVE BUTTON
        if(e.getSource() == negButton){

            //STORING THE DOUBLE TYPE TEXT OF THE TEXT FIELD IN NEW TEMPORARY VARIABLE TEMP
            double temp = Double.parseDouble(textfield.getText());

            //MULTIPLYING THE TEMP VAL WITH NEGATIVE ONE
            // THAT IS MAKING THE NUMBER ON TEXT FIELD NEGATIVE OR POSITIVE ACCORDINGLY
            temp *= -1;

            //SETTING THE TEMP VALUE TO THE TEXT IN TEXT FIELD
            textfield.setText(String.valueOf(temp));

        }
    }
}
