package pools;

import ba.BITCamp.logger.Logger;

public class Greetings implements Runnable {
	private int id;

	public Greetings(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String message = String.format("Hey! I'm thread number %2d and i have counted to %2d", this.id, i);
			if(i > 0  && i % 2 == 0)
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Logger.log("threadLog", message);
		}

	}

}
