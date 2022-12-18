import java.util.List;


public class Producer implements Runnable {

    List<Integer> Cookshelf=null;
    int limit;
    private int mealnumber;

    public Producer(List<Integer> Cookshelf,int limit){
        this.Cookshelf=Cookshelf;
        this.limit=limit;
    }

    public void getCookList(int cooknumber) throws InterruptedException {
        synchronized (Cookshelf){
            while (Cookshelf.size()==limit){
                System.out.println("Cook shelf has reached maximum, wait for free space");
                Cookshelf.wait();
            }
        }
        synchronized (Cookshelf){
            System.out.println("New Pizza:"+mealnumber);
            Cookshelf.add(mealnumber);
            Thread.sleep(100);
            Cookshelf.notify();
        }

    }

    @Override
    public void run() {
        while(true){
            try {
                getCookList(mealnumber++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
