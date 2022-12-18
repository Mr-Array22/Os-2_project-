import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Integer> meallist=new ArrayList<>();
        System.out.println("Enter the size of shelf:");
        Scanner input=new Scanner(System.in);
        int MAX_LIMIT= input.nextInt();
        Thread t1 =new Thread(new Producer(meallist,MAX_LIMIT));
        Thread t2 =new Thread(new Producer(meallist,MAX_LIMIT));
        Thread t3 =new Thread(new Consumer(meallist));
        Thread t4 =new Thread(new Consumer(meallist));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
