package estruturadedados.listaencadeada;

public class ListNo {
    private No first;
    private No last;
    private int length;
    private No cacheNo;
    private int cacheNoPosition;


    public ListNo() {
        this.length = 0;
        this.cacheNoPosition = 0;
    }

    public void addElement(int value) {
        No newNo = new No(value);
        if (first == null && last == null) {
            this.first = newNo;
        } else {
            last.setNext(newNo);
        }
        this.last = newNo;
        length++;
    }

    public No get(int position) {
        No currentNo = first;
        int start = cacheNoPosition;

        if (position < start)
            start = 0;

        for (int i = start; i < position; i++) {
            if (currentNo.getNext() != null) {
                currentNo = currentNo.getNext();
            }
        }

        if (position != start) {
            cacheNo = currentNo;
            cacheNoPosition = position;
        } else {
            currentNo = cacheNo;
        }

        return currentNo;
    }

    public void remove(int position) {
        if (position == 0) {
            No aux = new No(-1);
            aux.setNext(first.getNext());
            first = aux.getNext();
        } else {
            No previousNo = get(position - 1);
            previousNo.setNext(previousNo.getNext().getNext());
            if (position == length) {
                last = previousNo;
            }
        }
        length--;
    }

    public void read() {
        No currentNo = first;
        for (int i = 0; i < length; i++) {
            System.out.println(currentNo.getValue());
            if (currentNo.getNext() != null) {
                currentNo = currentNo.getNext();
            }
        }
    }

    public No getFirst() {
        return first;
    }

    public void setFirst(No first) {
        this.first = first;
    }

    public No getLast() {
        return last;
    }

    public void setLast(No last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
