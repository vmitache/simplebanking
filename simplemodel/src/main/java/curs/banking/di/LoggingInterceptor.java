package curs.banking.di;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Log
public class LoggingInterceptor implements Serializable {
	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

	@AroundInvoke
	public Object logMethodEntry(InvocationContext ctx) throws Exception {
		logger.info("Before entering method:" + ctx.getMethod().getName());
		long startTime = System.currentTimeMillis();
		try {
			return ctx.proceed();
		} finally {
			logger.info("After exiting method:" + ctx.getMethod().getName() + " duration ms:" + (System.currentTimeMillis()-startTime)) ;

		}
	}
}
