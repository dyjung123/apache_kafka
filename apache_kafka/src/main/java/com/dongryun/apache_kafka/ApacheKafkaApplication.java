package com.dongryun.apache_kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ApacheKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 10_000_000; i++) {
				kafkaTemplate.send("mytopic", "hello kafka :) " + i);
			}
		};
	}
}
