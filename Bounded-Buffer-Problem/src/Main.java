import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter The Size of Buffer:");
        Scanner input=new Scanner(System.in);
        int Size=input.nextInt();

        Buffer buffer = new Buffer(Size);


        Producer p1=new Producer(buffer,"A");
        Producer p3=new Producer(buffer,"e");
        Producer p4=new Producer(buffer,"f");
        Consumer c1=new Consumer(buffer,"C");
        Producer p2=new Producer(buffer,"B");
        Consumer c2=new Consumer(buffer,"D");
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p2);
        Thread t5=new Thread(p3);
        Thread t6=new Thread(p4);
        Thread t3=new Thread(c1);
        Thread t4=new Thread(c2);
        t1.start();
        t2.start();
        t3.start();
        t5.start();
        t6.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}