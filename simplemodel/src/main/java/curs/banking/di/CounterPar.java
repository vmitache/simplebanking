package curs.banking.di;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

public class CounterPar implements CounterIntf {
	private AtomicInteger mCounter = new AtomicInteger(0);

	@Override
	public int incrementAndGet() {
		return mCounter.addAndGet(2);
	}

}
