import java.util.*;
import java.util.stream.Collectors;

public class MyObject {

    String name;
    int value;
    boolean bool;

    public MyObject(String inputName, int inputValue, boolean inputBool) {
        this.name = inputName;
        this.bool = inputBool;
        this.value = inputValue;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getBool() {
        return this.bool;
    }

    public void setValues(String inputName, int inputValue, boolean inputBool) {
        this.name = inputName;
        this.bool = inputBool;
        this.value = inputValue;
    }
    public void setName(String inputName) {
        this.name = inputName;
    }

    public String toString() {
        return this.name + ", " + this.value + ", " + this.bool;
    }

    public static void main(String[] args) {

        MyObject[] instanceOf = new MyObject[50]; //Declare array of objects

        for (int i = 0; i < instanceOf.length; i++) { //initialize randomized values for all 50
            instanceOf[i] = new MyObject(randomName(), randomNr(1, 50), randomBool());
        }

        System.out.println("The values of the random array: ");
        for (int i = 0; i < instanceOf.length; i++) {  //print the entire array to show.

            System.out.print((i + 1) + ". ");
            System.out.println(instanceOf[i]);
        }

        System.out.println("\nPart 3 answers: ");

        //Part 3.1-3.3
        part31(instanceOf);
        part32(instanceOf);
        part33(instanceOf);

    }

    public static int randomNr(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }

    public static boolean randomBool() {
        Random random = new Random();

        return random.nextBoolean();
    }

    public static String randomName() {

        StringBuilder buildingWord = new StringBuilder();
        Random random = new Random();

        // all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int wordLength = 7; //All randomNames are this length.

        for (int i = 0; i < wordLength; i++) {
            int index = random.nextInt(alphabet.length());// random index
            char randomChar = alphabet.charAt(index); //pick the letter from random index above
            buildingWord.append(randomChar);
        }
        return buildingWord.toString();
    }

    static void part31(MyObject[] inputObjectArray) {

        List<MyObject> resultList = Arrays.asList(inputObjectArray);

        System.out.println("3.1 - All objects whose values are above 20 are: " + resultList
                .stream()
                .filter(x -> x.getValue() > 20) //just show objects with the getValue above 20
                .sorted(Comparator.comparingInt(MyObject::getValue)) //compare sorting by .getValue integer
                .collect(Collectors.toList())

        );
    }
    static void part32(MyObject[] inputObjectArray) {

        List<MyObject> resultList = Arrays.asList(inputObjectArray);

        System.out.println("3.2 - Average of all values are: " + resultList
                .stream()
                .mapToInt(o -> o.getValue())
                .average()
                .getAsDouble()

                + " -> and the total sum of them are: " +
                resultList
                        .stream()
                        .mapToInt(o -> o.getValue())
                        .sum()
        );
    }
    static void part33(MyObject[] inputObjectArray) {

        List<MyObject> resultList = Arrays.asList(inputObjectArray);

        System.out.println("3.3 - These are all the true boolean objects: " + resultList
                .stream()
                .filter(MyObject::getBool) //get all objects where bool is true
                .peek(e -> e.setName("this is true")) //Replace all names in selected objects
                .collect(Collectors.toList()) //show as list
        );
    }


}
