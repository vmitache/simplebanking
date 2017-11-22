package curs.banking.di;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ByOneCounter
public class BadMessage implements MessageIntf {

	@Override
	public String getMessage() {
		return "Naspa";
	}

}
