package curs.banking.di;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MessageHolder {
	private MessageIntf mMessage;

	@Inject
	public void setMessageIntf(@ByOneCounter MessageIntf pMsg) {
		mMessage = pMsg;

	}

	@Log
	public String getMessage() {
		return mMessage.getMessage();
	}
}
