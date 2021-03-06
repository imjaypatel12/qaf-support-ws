package com.qmetry.qaf.automation.rest.client;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ws.rest.DefaultRestClient;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class BasicAuthRestClient extends DefaultRestClient {

	public static final String REST_CLIENT_BASIC_AUTH_USER = "rest.client.basic.auth.username";
	public static final String REST_CLIENT_BASIC_AUTH_PASSWORD = "rest.client.basic.auth.password";

	@Override
	protected Client createClient() {
		Client client = super.createClient();
		client.addFilter(
				new HTTPBasicAuthFilter(ConfigurationManager.getBundle().getString(REST_CLIENT_BASIC_AUTH_USER, ""),
						ConfigurationManager.getBundle().getString(REST_CLIENT_BASIC_AUTH_PASSWORD, "")));
		return client;
	}
}