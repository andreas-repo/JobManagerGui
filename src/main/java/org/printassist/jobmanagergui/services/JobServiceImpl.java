package org.printassist.jobmanagergui.services;

import java.util.List;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.printassist.jobmanagergui.Job;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.UriBuilder;

public class JobServiceImpl {
	UriBuilder FULL_PATH = UriBuilder.fromPath("http://localhost:8080/getAllJobs");


	public List<Job> getAllJobs() {
		ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(FULL_PATH);
		ServicesInterface proxy = target.proxy(ServicesInterface.class);
		List<Job> result = proxy.getAllJobs();

		return result;
	}

}
