package curs.banking.rest.proxy;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ProxyUtils {
	public static <T> T getRestClient(Class<T> pInterface) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(
				UriBuilder.fromPath(Constants.BASE_URL));
		return target.proxy(pInterface);
	}

}
