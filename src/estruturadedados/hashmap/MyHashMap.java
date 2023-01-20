package estruturadedados.hashmap;

public class MyHashMap<K, V> {

    private final Element<K, V>[] elements;
    private int length;
    private final int ALOCACAO = 16;

    public MyHashMap() {
        this.elements = new Element[ALOCACAO];
        this.length = 0;

    }

    public void put(K key, V value) {
        Element<K, V> newElement = new Element<>(key, value);
        int hash = myHashCode(key);
        
        if (elements[hash] != null) {
            newElement.setNext(elements[hash]);
        }
        elements[hash] = newElement;
        length++;
    }

    public Element<K, V> get(K key) {
        int hash = myHashCode(key);
        Element<K, V> e = elements[hash];

        while (e != null) {
            if (e.getKey() == key)
                break;
            e = e.getNext();
        }

        return e;
    }

    public int getLength() {
        return length;
    }

    public int myHashCode(K key) {
        int sum = 0;
        String keyToString = key.toString();

        for (int i = 0; i < keyToString.length(); i++) {
            if (keyToString.charAt(i) != ' ')
                sum += keyToString.charAt(i);
        }
        return sum % ALOCACAO;
    }

}