package Producer_Consumer_Problem;


public class Consumer implements Runnable {

	private final Container container;

	private boolean exit = false;

	public Consumer(Container container) {

		this.container = container;
	}

	public void setExit(boolean flag) {

		exit = flag;
	}

	@Override
	public void run() {
		while (!exit) {
				try {  
					container.consume();
					Thread.sleep(3000);
				} catch (InterruptedException e) {  
					e.printStackTrace();  
				}
			}
	}
}
