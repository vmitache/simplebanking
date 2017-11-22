package curs.banking.di;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ByTwoCounter
public class NiceMessage implements MessageIntf {

	@Override
	public String getMessage() {
		return "Bravo";
	}

}
