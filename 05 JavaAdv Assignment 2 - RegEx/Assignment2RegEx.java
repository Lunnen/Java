import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment2RegEx {

    static List<Answers> myAnswers = new ArrayList<>();
    private static int howManyFound = 0;
    public boolean findPosition = true; //the bool value sent to method, if you want to find position or valueOf result.

    public static void main(String[] args) throws FileNotFoundException {

        // Part 1 - At what row is the alphabet located?
        String alphabet = "[Aa][Bb][Cc][Dd][Ee][Ff][Gg][Hh][Ii][Jj][Kk][Ll][Mm][Nn][Oo][Pp][Qq][Rr][Ss][Tt][Uu][Vv][Xx][Yy][Zz]";
        readFile(alphabet, "Part 1", true); //Find value, at row, start and end position and add it to myAnswers object-list.

        // Part 2 - Where can you find the name Ola?
        String ola = "[Oo][Ll][Aa]";
        readFile(ola, "Part 2", true);

        // Part 3 - At how many places can you find a consecutive row of 3-5 a's?
        String allA35 = "[Aa]{3,5}"; //All a between 3-5 in length.
        readFile(allA35, "Part 3", false); //Starting with Aa and length of 3-5.
        myAnswers.add(new Answers("Part 3", howManyFound));
        howManyFound = 0;
        readFile(allA35, "Part 3", true); //Starting with Aa and length of 3-5.

        // Part 4 - Amount of non-alphanumeric strings [A-Za-z0-9]
        String noAlphaNumericValues = "[\\W]{2,}"; //All words longer than 2.
        readFile(noAlphaNumericValues, "Part 4", false); //Find amount of
        myAnswers.add(new Answers("Part 4", howManyFound));
        howManyFound = 0; //reset

        // Part 5 - How many email-addresses are there in the text file? Where and what are they?
        String emails = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}";
        readFile(emails, "Part 5", false); //find amount of
        myAnswers.add(new Answers("Part 5", howManyFound));
        howManyFound = 0; //reset
        readFile(emails, "Part 5", true); //Find positions

        // Part 6 - How many phone numbers are there that's a (01812345, 018 123456,018/123456, 018-123456)? And where are they?
        String allPhoneNr = "0{1,2}[0-9]{1,3}[\\s/-]?[0-9]{5,}"; // All mobile and home numbers are accepted. 020 or 0454 and 5-6 numbers after that.
        readFile(allPhoneNr, "Part 6", false);
        myAnswers.add(new Answers("Part 6", howManyFound));
        howManyFound = 0; //reset
        readFile(allPhoneNr, "Part 6", true);

        // Part 7 - How many words where the letters are four-of-a-kind exists?
        String fourOfAKind = "([A-Za-z])\\1{3}"; //Capture group 1, length of 3 (4, starts at 0). Bracketed to show its a group.
        readFile(fourOfAKind, "Part 7", false);
        myAnswers.add(new Answers("Part 7", howManyFound));
        howManyFound = 0; //reset

        // Part 8 - license plates in the form of abc/123 and abc_123 are hidden. Where?
        String licensePlates = "[A-Za-z]{3}[/_][0-9]{3}"; // I accept all license plates, even if they mix capital and common letters.
        readFile(licensePlates, "Part 8", true);

        // Part 9 - find the perfectly matching parenthesis containing just tex, numbers or whitespace.
        // Where are they and what do they contain?
        String matchingParenthesis = "[(][A-Za-z]+[)]|[(][0-9]+[)]|[(][\\s]+[)]"; //all letters, numbers or white spaces in all sizes. Example. (Abc), (123), (   ).
        readFile(matchingParenthesis, "Part 9", false);
        myAnswers.add(new Answers("Part 9", howManyFound));
        howManyFound = 0; //reset
        readFile(matchingParenthesis, "Part 9", true);

        // Part 10 - where are the if and for loops located?
        String ifOrFor = "if[\\s]?[(]|for[\\s]?[(]"; // if, with an optional white-space and ( bracket. or for with same options.
        readFile(ifOrFor, "Part 10", true);

        System.out.println(myAnswers); //Print my answer from object-array

    }

    public static void finder(String inputString, String pattern, String showPart, int currentLine, boolean gettingPosition) throws FileNotFoundException {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(inputString);


        while (matcher.find()) { //searches for string
            if (matcher.group().length() != 0) { //print unless length is empty.
                if (gettingPosition) {
                    myAnswers.add(new Answers(showPart, matcher.group(), currentLine, matcher.start(), matcher.end()));
                } else {
                    howManyFound++;
                }

            }
        }
    }

    public static void readFile(String inputPattern, String showPart, boolean gettingPosition) throws FileNotFoundException {
        File file = new File("text.txt");
        Scanner fileRead = new Scanner(file);

        int counter = 1; //starting counter at 1 as first row, not 0.

        while (fileRead.hasNextLine()) { //Read line from text-file and search pattern.
            String thisLineAsString = fileRead.nextLine();

            finder(thisLineAsString.toString(), inputPattern, showPart, counter, gettingPosition); //value, pattern and counter

            counter++;
        }
        fileRead.close();
    }

}


