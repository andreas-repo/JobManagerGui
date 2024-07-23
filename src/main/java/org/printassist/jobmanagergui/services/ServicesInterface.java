package org.printassist.jobmanagergui.services;

import java.util.List;

import org.printassist.jobmanagergui.Job;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface ServicesInterface {

	@GET
	@Path("/getinfo")
	@Produces(MediaType.APPLICATION_JSON)
	List<Job> getAllJobs();
}
