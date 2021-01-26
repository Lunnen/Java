public class Answers {
    int inputRow;
    int inputStart;
    int inputEnd;
    String inputValue;
    int amountValue;
    String part;

    public Answers(String part, int amountValue) {
        this.part = part;
        this.amountValue = amountValue;
    }
    public Answers(String part, String inputValue, int inputRow, int inputStart, int inputEnd) {
        this.part = part;
        this.inputValue = inputValue;
        this.inputRow = inputRow;
        this.inputStart = inputStart;
        this.inputEnd = inputEnd;
    }

    @Override
    public String toString() {

        if(amountValue > 0) {
            return "\n" + part + " Found: " + amountValue + " of these values";
        }
        else {
            return "\n" + part + " Found: " + inputValue +
                    " At row: " + inputRow +
                    " starting at: " + inputStart +
                    " ending at: " + inputEnd;
        }
    }
}
