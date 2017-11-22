package curs.banking.di;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

public class Counter implements CounterIntf {
	private static Logger __logger = Logger.getLogger("Counter");
	
	
	private AtomicInteger mCounter = new AtomicInteger(0);
	
	
	
	@Override
	public int incrementAndGet() {
		__logger.log(Level.INFO, "incrementAndGet WAS CALLED");
		return mCounter.incrementAndGet();
	}

}
