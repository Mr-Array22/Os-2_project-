package Producer_Consumer_Problem;

public class Producer implements Runnable {
	
	private Container container;

	private boolean exit = false;
	
	public Producer(Container container) {

		this.container = container;
	}

	public void setExit(boolean flag) {

		exit = flag;
	}
	@Override
	public void run() {
		while (!exit) {
				try {  
					container.produce();
					Thread.sleep(1500);
				} catch (InterruptedException e) {  
					e.printStackTrace();  
				}
			}
		}	
}
