package com.shobhanath.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * This method is used to decide whether the run() should be invoked in real
	 * project here we can decide based on some condition whether the run should
	 * call or not
	 * 
	 * true - should execute run false - should not execute run
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* Here we can write logging or security related code */
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	/**
	 * Based on filterType value it will call run() method
	 * 
	 * PRE 
	 * Filters execute before routing to the origin. Examples include request
	 * authentication, choosing origin servers, and logging debug info. 
	 * 
	 * ROUTING
	 * Filters handle routing the request to an origin. This is where the origin
	 * HTTP request is built and sent using Apache HttpClient or Netflix Ribbon.
	 * 
	 * POST
	 * Filters execute after the request has been routed to the origin.
	 * Examples include adding standard HTTP headers to the response, gathering
	 * statistics and metrics, and streaming the response from the origin to the
	 * client. 
	 * 
	 * ERROR 
	 * Filters execute when an error occurs during one of the other
	 * phases.
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * Based on order it will execute filter class. if filterOrder is 1 then it
	 * executes first then filterOrder value 2 executes filters in below order 0 -
	 * first 1 - 2nd 2 - 3rd etc.
	 * 
	 */
	@Override
	public int filterOrder() {
		return 1;
	}
}
