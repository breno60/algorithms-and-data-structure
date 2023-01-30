package estruturadedados.tries;

public class MyTrie {

    private Element head;
    private int lenght;

    public MyTrie() {
        this.head = new Element();
    }

    public void insert(String value) {
        Element e = head;
        value = value.trim();

        for (int i = 0; i < value.length(); i++) {
            int index = value.charAt(i)%26;

            if (e.getChildren()[index] == null)
                e.insert(value.charAt(i), index);

            e = e.getChildren()[index];
        }

        if (value.length() > 0 && !e.isWord()) {
            lenght++;
            e.setWord(true);
            e.setValueWord(value);
        }
    }

    public void remove(String value) {
        Element e = head;
        value = value.trim();

        for (int i = 0; i < value.length(); i++) {
            int index = value.charAt(i)%26;
            e = e.getChildren()[index];
        }

        if (e.isWord()) {
            e.setWord(false);
            lenght--;
        }
    }

    public String get(String value) {
        Element e = head;
        value = value.trim();

        for (int i = 0; i < value.length(); i++) {
            int index = value.charAt(i)%26;
            e = e.getChildren()[index];
        }

        return e.isWord() ? e.getValueWord() : null;
    }

    public Element getHead() {
        return head;
    }

    public int getLenght() {
        return lenght;
    }
}
