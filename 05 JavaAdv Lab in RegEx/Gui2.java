import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gui2 extends JFrame {

    private JPanel panel;
    private JTextField input;
    private JTextArea output;
    private JButton button1;

    public Gui2(){
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
        this.panel.add(input);
        this.panel.add(output);
        this.panel.add(button1);
    }
    private void setUpElements(){
        this.panel = new JPanel(new GridLayout(3,1));
        this.input = new JTextField("input");
        this.output = new JTextArea("Output: ");

        this.output.setEditable(false);

        // ************************************************************************
        this.button1 = new JButton("Button"); //Default "commit"
        ActionListener inputListener1 = e -> {


            String space = "((\\s)+)?";
            String regExIf = "if((\\s)+)?\\([\\w]+[\\s]?([\\W]{1,3})?[\\s]?[\\w]+?\\)";
            String regExFor = "for((\\s)+)?\\((((\\s)+)?[A-Za-z]+(\\s)+[\\w]+((\\s)+)?\\:((\\s)+)?[\\w]+((\\s)+)?)|" +
                    "((\\s)+)?(int(\\s)+)?[\\w]+((\\s)+)?(\\=?((\\s)+)?[0-9])?((\\s)+)?\\;((\\s)+)?[\\w]+((\\s)+)?([\\W]{1,3})((\\s)+)?[0-9]+((\\s)+)?\\;((\\s)+)?(([\\w]+[\\W]{2})|" +
                    "([\\W]{2}[\\w]+)|([\\w]+((\\s)+)?\\=((\\s)+)?[\\w]+((\\s)+)?[\\W]((\\s)+)?[0-9]+)|" +
                    "([\\w]+" + space + "[\\W]{2}" + space + "[\\w]+))((\\s)+)?\\)";
            String doWhile = "do((\\s)+)?.((\\s)+)?{(?s)(.*)}((\\s)+)?while((\\s)+)?((.+));";

            //String result1 = validate(this.input.getText(), regExIf);
            String result2 = validate(this.input.getText(), regExFor);

            output.setText(result2);

        };
        button1.addActionListener(inputListener1);
    }

    public String validate(String input, String regEx) {

        String result = "Welcome!: ";

        if(findPattern(input, regEx)) {
            result += input + ", ";
        }   else {
            result += "\n Name is invalid, ";
        }
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









