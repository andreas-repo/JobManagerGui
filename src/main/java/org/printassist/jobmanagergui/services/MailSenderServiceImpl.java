package org.printassist.jobmanagergui.services;

import org.printassist.jobmanagergui.services.models.Email;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MailSenderServiceImpl {

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public Email sendEmail(Email email) {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        restTemplate.postForObject("http://localhost:8080/sendEmail", email, Email.class);
        return email;
    }
}

