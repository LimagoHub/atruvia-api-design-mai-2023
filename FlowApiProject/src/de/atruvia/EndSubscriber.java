package de.atruvia;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class EndSubscriber<T> implements Subscriber<T>{

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
		
	}

	@Override
	public void onNext(T item) {
		

		System.out.println(item.getClass().getSimpleName());
		System.out.println("Received: " + item);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
		System.out.println("Kaputt");
		
	}

	@Override
	public void onComplete() {
		System.out.println("Wir haben fertig!");
		
	}

}
