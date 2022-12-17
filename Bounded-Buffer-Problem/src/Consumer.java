import static java.lang.Thread.sleep;
import  java.util.Random;
public class Consumer implements Runnable{
    Buffer buffer;
    Random r=new Random();
    String name;
    int data;

    public Consumer(Buffer buffer,String name){
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try
        {
            //int i = 0;
            while(true) {
                Buffer.full.acquire();
                Buffer.mutex.acquire();
                System.out.println(Thread.currentThread().getName () + " Enter in critical section");
                data = buffer.removeItem();
                System.out.println("Consumer " + this.name + " consumed data : " + data);
                System.out.println(Thread.currentThread().getName () + " exit critical section");
                sleep((r.nextInt(100)*10));
                Buffer.mutex.release();
                Buffer.empty.release();
            }
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }
}