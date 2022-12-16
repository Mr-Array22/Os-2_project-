package Producer_Consumer_Problem;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Map;


public class WindowController {

    public WindowController() {

    }

    @FXML
    public void initialize () {
        initMap();
    }

    @FXML private TextArea textArea;

    @FXML private ImageView doughnut0;
    @FXML private ImageView doughnut1;
    @FXML private ImageView doughnut2;
    @FXML private ImageView doughnut3;
    @FXML private ImageView doughnut4;
    @FXML private ImageView doughnut5;
    @FXML private ImageView doughnut6;
    @FXML private ImageView doughnut7;
    @FXML private ImageView doughnut8;

    @FXML private ImageView cake0;
    @FXML private ImageView cake1;
    @FXML private ImageView cake2;
    @FXML private ImageView cake3;
    @FXML private ImageView cake4;
    @FXML private ImageView cake5;
    @FXML private ImageView cake6;
    @FXML private ImageView cake7;
    @FXML private ImageView cake8;


    private final Container container = new Container();

    protected Container.Dessert [] desserts = container.getDesserts();

    Map<String,ImageView> map = new HashMap<String,ImageView>();

    Producer producer1 = new Producer(container);
    Producer producer2 = new Producer(container);
    Consumer consumer1 = new Consumer(container);
    Consumer consumer2 = new Consumer(container);
    UpdateText updateText = new UpdateText(this);
    UpdateImage updateImage = new UpdateImage(this);

    Thread produceThread1 = new Thread(producer1, "Chef     1");
    Thread produceThread2 = new Thread(producer2, "Chef     2");
    Thread consumeThread1 = new Thread(consumer1, "Customer 1");
    Thread consumeThread2 = new Thread(consumer2, "Customer 2");
    Thread updateTextThread = new Thread(updateText,"Update TextArea");
    Thread updateImageThread = new Thread(updateImage,"Update Image");

    @FXML
    public void startPressed() throws InterruptedException {
        updateImageThread.setPriority(10);
        updateImageThread.start();

        if(!produceThread1.isAlive() && !produceThread2.isAlive()
                && !consumeThread1.isAlive() && !consumeThread2.isAlive()) {
            doughnut0.setVisible(true);
            cake0.setVisible(true);
            updateTextThread.start();
            produceThread1.start();
            produceThread2.start();
            consumeThread1.start();
            consumeThread2.start();

        }

    }

    @FXML
    public void stopPressed() {

        try {
            if(produceThread1.isAlive() && produceThread2.isAlive()
                    && consumeThread1.isAlive() && consumeThread2.isAlive()) {
                producer1.setExit(true);
                producer2.setExit(true);
                consumer1.setExit(true);
                consumer2.setExit(true);
                updateText.setExit(true);
                updateImage.setExit(true);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateText() {
        textArea.setText(container.getLog());
        textArea.setScrollTop(Double.MAX_VALUE);
    }

    public void updateImage() {
        for(int i = 0 ; i < container.getContainerSize() ; i++) {
            switch (desserts[i]) {
                case doughnut: {
                    map.get("doughnut"+i).setVisible(true);
                    map.get("cake"+i).setVisible(false);
                } break;
                case cake: {
                    map.get("cake"+i).setVisible(true);
                    map.get("doughnut"+i).setVisible(false);
                } break;
                case none: {
                    map.get("cake"+i).setVisible(false);
                    map.get("doughnut"+i).setVisible(false);
                } break;
                default: break;
            }
        }
    }

    private void initMap() {
        map.put("doughnut0",doughnut0);
        map.put("doughnut1",doughnut1);
        map.put("doughnut2",doughnut2);
        map.put("doughnut3",doughnut3);
        map.put("doughnut4",doughnut4);
        map.put("doughnut5",doughnut5);
        map.put("doughnut6",doughnut6);
        map.put("doughnut7",doughnut7);
        map.put("doughnut8",doughnut8);

        map.put("cake0",cake0);
        map.put("cake1",cake1);
        map.put("cake2",cake2);
        map.put("cake3",cake3);
        map.put("cake4",cake4);
        map.put("cake5",cake5);
        map.put("cake6",cake6);
        map.put("cake7",cake7);
        map.put("cake8",cake8);
    }
}


class UpdateText implements Runnable {

    private WindowController controller;

    public UpdateText(WindowController controller) {

        this.controller = controller;
    }

    private boolean exit = false;

    public void setExit(boolean flag) {
        exit = flag;
    }

    @Override
    public void run() {
        while (!exit) {
            try {
                controller.updateText();
                System.out.println("Text\n");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UpdateImage implements Runnable {
    private WindowController controller;

    public UpdateImage(WindowController controller) {

        this.controller = controller;
    }

    private boolean exit = false;

    public void setExit(boolean flag) {
        exit = flag;
    }

    @Override
    public void run() {
        while (!exit) {
            try {
                controller.updateImage();
                System.out.println("Image\n");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
