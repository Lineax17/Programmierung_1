package ringbuffer;

class RingBufferTest {

    public static void main(String[] args) {
        new RingBufferTest().printTests();
    }

    private void printTests() {
        int[] contents = {5, 10, 15, 20};
        RingBuffer ringBuffer = new RingBuffer(3);
        for (int content : contents) {
            ringBuffer.write(content);
        }
        ringBuffer.read();
        ringBuffer.read();
        System.out.println(ringBuffer);
    }
}
