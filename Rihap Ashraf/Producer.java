import static java.lang.Thread.sleep;
import  java.util.Random;
public class Producer implements Runnable{
    Random r=new Random();
    Buffer buffer;
    String name;

    public Producer(Buffer buffer,String name){
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try
        {
            while(true) {
                Buffer.empty.acquire();
                Buffer.mutex.acquire();
                System.out.println(Thread.currentThread().getName () + " Enter in critical section");
                int item = (int) (Math.random()*100);
                System.out.println("Producer " + this.name + " produced: " + item);
                sleep((r.nextInt(100)*10));
                buffer.addItem(item);
                System.out.println(Thread.currentThread().getName () + " exit critical section");
                Buffer.mutex.release();
                Buffer.full.release();

            }
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}