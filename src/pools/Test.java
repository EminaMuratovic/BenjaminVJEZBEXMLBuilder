package pools;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ba.BITCamp.logger.Logger;

public class Test extends Thread {
	public static void main(String[] args) {

		HashMap<String, String> logs = new HashMap<String, String>();
		logs.put("threadLog", "threadLog");

		try {
			new Logger(logs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExecutorService es = Executors.newFixedThreadPool(4);

		for (int i = 1; i < 5; i++) {
			es.submit(new Greetings(i));
			//new Thread(new Greetings(i)).start();
		}
		es.shutdown();
		while(!es.isTerminated()) {};
		Logger.log("threadLog", "Sve gotovo");
	}

}
