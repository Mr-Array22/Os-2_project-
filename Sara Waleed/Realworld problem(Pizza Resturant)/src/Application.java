import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> meallist=new ArrayList<>();
        Thread t1 =new Thread(new Producer(meallist));
        Thread t2 =new Thread(new Producer(meallist));
        Thread t3 =new Thread(new Consumer(meallist));
        Thread t4 =new Thread(new Consumer(meallist));
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
