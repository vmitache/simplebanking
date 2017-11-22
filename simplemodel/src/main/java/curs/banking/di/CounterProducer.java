package curs.banking.di;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class CounterProducer {
	@Produces
	//@ApplicationScoped
	@ByOneCounter
	public CounterIntf getCounterSimplu() {
		return new Counter();
	}
	
	@Produces
	//@ApplicationScoped
	@ByTwoCounter
	public CounterIntf getCounterPar() {
		return new CounterPar();
	}
}
