package org.printassist.jobmanagergui.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.printassist.jobmanagergui.models.Job;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class JobServiceImpl {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public List<Job> getAllJobs(RestTemplate restTemplate) {
		@SuppressWarnings("unchecked") //save because backend endpoint returns a List<Job> object
		List<Job> result = restTemplate.getForObject("http://localhost:8080/getAllJobs", List.class);
        assert result != null;
        if (result.isEmpty()) {
			return new ArrayList<>();
		}
		return result;
	}

	public void createJob(Job job, RestTemplate restTemplate) {
		restTemplate.postForObject("http://localhost:8080/createJob", job, Job.class);
	}

	public void deleteJobThroughEmailAddress(String emailAddress, RestTemplate restTemplate) {
		if (emailAddress != null && !emailAddress.isEmpty()) {
			restTemplate.delete("http://localhost:8080/deleteJobThroughEmailAddress/" + emailAddress);
		}
	}

	public Optional<Job> findJobByEmailAddress(String emailAddress, RestTemplate restTemplate) {
		if (emailAddress != null && !emailAddress.isEmpty()) {
			return Optional.ofNullable(restTemplate.getForObject("http://localhost:8080/findJob/" + emailAddress, Job.class));
		}
		return Optional.empty();
	}

	private List<Job> convertLinkedHashMapToJob(List<LinkedHashMap> jobEntities) {
		List<Job> jobs = new ArrayList<>();
		jobEntities.forEach(jobObject -> {
			Job job = new Job();
			job.setFirstName(jobObject.get("firstName").toString());
			job.setLastName(jobObject.get("lastName").toString());
			job.setPhoneNumber(jobObject.get("phoneNumber").toString());
			job.setPrinterType(jobObject.get("printerType").toString());
			job.setEmailAddress(jobObject.get("emailAddress").toString());
			jobs.add(job);
		});

		return jobs;
	}

	public Optional<Job> findJobByPhoneNumber(String phoneNumber, RestTemplate restTemplate) {
		return Optional.ofNullable(restTemplate.getForObject("http://localhost:8080/findJobByPhoneNumber/" + phoneNumber, Job.class));
	}
}
