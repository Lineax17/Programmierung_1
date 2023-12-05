package ringbuffer;

class RingBuffer {
    private Element readElement;
    private Element writeElement;

    RingBuffer(int size) {
        Element element = new Element();
        element.next = element;

        for (int i = 1; i < size; i++) {
            Element nextElement = new Element();

            nextElement.next = element.next;
            element.next = nextElement;
            element = element.next;
        }

        readElement = element;
        writeElement = element;
    }

    Integer read() {
        Integer readInteger = readElement.integer;
        readElement = readElement.next;
        return readInteger;
    }

    void write(Integer integer) {
        writeElement.integer = integer;
        writeElement = writeElement.next;
    }

    @Override
    public String toString() {
        Element startElement = readElement;
        Element countElement = startElement;
        StringBuilder display = new StringBuilder();

        do {
            if (countElement == readElement) {
                display.append("r");
                if (countElement == writeElement) {
                    display.append("/w ");
                } else {
                    display.append("   ");
                }
            } else if (countElement == writeElement) {
                display.append("w   ");
            } else {
                display.append("    ");
            }

            display.append(countElement.integer).append("\n");

            countElement = countElement.next;
        } while (countElement != startElement);

        return display.toString();
    }

}

