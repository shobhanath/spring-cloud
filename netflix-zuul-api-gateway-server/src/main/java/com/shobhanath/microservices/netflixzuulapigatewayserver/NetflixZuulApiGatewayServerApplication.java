package com.shobhanath.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy // To enable Zuul API gateway in order to intercepts all the request before
					// hitting the actual micro services
@EnableDiscoveryClient // To register this micro services in naming server
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}

	/**
	 * we need to tell our application how often we want to sample our logs to be
	 * exported to Zipkin. Since this is a demo, lets tell our app that we want to
	 * sample everything. We can do this by creating a bean for the AlwaysSampler
	 * 
	 * if you want to trace all the request
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
