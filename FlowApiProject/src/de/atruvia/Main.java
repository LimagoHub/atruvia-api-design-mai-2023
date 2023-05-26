package de.atruvia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception{
		new Main().run();
	}

	private void run() throws Exception{
		List<String> liste = List.of("1","2","drei","4","fünf","1","2","drei","4","fünf");

		EndSubscriber<String> endSubscriber = new EndSubscriber<>();



		SubmissionPublisher<String> publisher ;

		publisher = new SubmissionPublisher<String>(/*service, 100*/);


		publisher.subscribe(endSubscriber);

		liste.forEach(publisher::submit);

		publisher.close();


		Thread.sleep(100);
//		ExecutorService  service = (ExecutorService) publisher.getExecutor();
//		service.shutdown();
//		service.awaitTermination(1000, TimeUnit.DAYS);

		System.out.println("Ende");
		
		

	}
	

}
