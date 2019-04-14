package com.shobhanath.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * Feign is a declarative web service client. It makes writing web service
 * clients easier. To use Feign create an interface and annotate it. It has
 * pluggable annotation support including Feign annotations and JAX-RS
 * annotations. Feign also supports pluggable encoders and decoders. Spring
 * Cloud adds support for Spring MVC annotations and for using the same
 * HttpMessageConverters used by default in Spring Web. Spring Cloud integrates
 * Ribbon and Eureka to provide a load balanced http client when using Feign.
 * 
 * 
 */
//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server") // here it will fetch url of zuul api gateway server from naming server
@RibbonClient(name = "currency-exchange-service") // decides which instance of currency exchange service is available and to be used
public interface CurrencyExchangeServiceProxy {
	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
