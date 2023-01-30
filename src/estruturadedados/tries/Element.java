package estruturadedados.tries;

public class Element {

    private char valueChar;
    private Element[] children;
    private String valueWord;
    private boolean isWord;

    public Element(char valueChar) {
        this.valueChar = valueChar;
        this.children = new Element[26];
        this.valueWord = null;
        this.isWord = false;
    }

    public Element() {
        this.children = new Element[26];
        this.valueWord = null;
    }

    protected void insert(char caractere, int index) {
        children[index] = new Element(caractere);
    }

    public char getValueChar() {
        return valueChar;
    }

    public void setValueChar(char valueChar) {
        this.valueChar = valueChar;
    }

    public Element[] getChildren() {
        return children;
    }

    public String getValueWord() {
        return valueWord;
    }

    public void setValueWord(String valueWord) {
        this.valueWord = valueWord;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
