import java.util.List;

@SuppressWarnings("ALL")
public class Producer implements Runnable {

    List<Integer> Cookshelf=null;
    final int limit=10;
    private int mealnumber;

    public Producer(List<Integer> Cookshelf){
        this.Cookshelf=Cookshelf;
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
