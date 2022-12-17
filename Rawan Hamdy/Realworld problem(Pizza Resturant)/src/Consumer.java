import java.util.List;

public class Consumer implements Runnable {

    List<Integer> Cookshelf=null;

    public Consumer(List<Integer> Cookshelf){
        this.Cookshelf=Cookshelf;
    }

    public void Servemeals() throws InterruptedException {
        synchronized (Cookshelf){
            while (Cookshelf.isEmpty()){
                System.out.println("No Pizza for serving......waiting for meal");
                Cookshelf.wait();
            }
        }
        synchronized (Cookshelf){
            Thread.sleep(5000);
            System.out.println("Here is the  pizza:"+Cookshelf.remove(0));
            Cookshelf.notify();
        }

    }

    @Override
    public void run() {
        while(true){
            try {
                Servemeals();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
