import java.util.concurrent.Semaphore;

public class Buffer {
    static Semaphore full;
    static Semaphore empty;
    static Semaphore mutex;
    int addPos = 0,removePos=0;
    int[] arr;

    public Buffer(int size){
        this.arr = new int[size];
        full = new Semaphore(0);
        empty = new Semaphore(size);
        mutex = new Semaphore(1);
    }

    public void addItem(int item) throws InterruptedException {
        arr[addPos] = item;
        if (++addPos == arr.length)
            addPos=0;
    }

    public int removeItem() throws InterruptedException {
        int item = arr[removePos];
        if (++removePos == arr.length)
            removePos=0;
        return item;
    }

}