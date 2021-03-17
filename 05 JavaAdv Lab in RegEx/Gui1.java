import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gui1 extends JFrame {

    private JPanel panel;
    private JTextField name;
    private JTextField phoneNr;
    private JTextField email;
    private JTextArea output;
    private JButton button1;

    public Gui1(){
        this.setTitle("JavaAdv Lab in RegEx");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUpElements();
        setUpPanel();
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void setUpPanel(){
        this.panel.add(name);
        this.panel.add(phoneNr);
        this.panel.add(email);
        this.panel.add(output);
        this.panel.add(button1);
    }
    private void setUpElements(){
        this.panel = new JPanel(new GridLayout(5,1));
        this.name = new JTextField("Name: ");
        this.phoneNr = new JTextField("Phone nr: ");
        this.email = new JTextField("Email: ");
        this.output = new JTextArea("Output: ");

        this.output.setEditable(false);

        // ************************************************************************
        this.button1 = new JButton("Button"); //Default "commit"
        ActionListener inputListener1 = e -> {

            String[] myArray = new String[3];
            myArray[0] = name.getText();
            myArray[1] = phoneNr.getText();
            myArray[2] = email.getText();

            String result = validate(myArray);

            output.setText(result);

        };
        button1.addActionListener(inputListener1);
    }

    public String validate(String[] input) {

        String[] regEx = new String[3];

        regEx[0] = "[A-Z][a-z]+[\\s][A-Z][a-z]+";
        regEx[1] = "0[0-9]{1,3}[\\s/-]?[0-9]{5,}";
        regEx[2] = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}";

        boolean valid = true;
        String result = "Welcome!: ";

        if(findPattern(input[0], regEx[0])) {
            result += input[0] + ", ";
        }   else {
            result += "\n Name is invalid, ";
            valid = false;
        }
        if(findPattern(input[1], regEx[1])) {
            result += input[1] + ", ";
        }   else {
            result += "\n phone number is invalid, " + input[1] + "   ";
            valid = false;
        }
        if(findPattern(input[2], regEx[2])) {
            result += input[2] + ", ";
        }   else {
            result += "\n email is invalid, " + input[2] + "   ";
            valid = false;
        }
        if(valid) result += "\n Everything is Valid!";

        return result;
    }

    public static boolean findPattern(String text, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(text);

        return matcher.find();
    }

    /*
    public List getText() {
        List myList = new List();

        myList.add(this.name);

        return myList;
    }


     */
}









