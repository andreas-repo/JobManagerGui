package org.printassist.jobmanagergui.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class JobServiceImpl {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public List<LinkedHashMap> getAllJobs(RestTemplate restTemplate) {
		List<LinkedHashMap> result = restTemplate.getForObject("http://localhost:8080/getAllJobs", List.class);
		if (result.isEmpty()) {
			return new ArrayList<>();
		}
		return result;
	}
}
