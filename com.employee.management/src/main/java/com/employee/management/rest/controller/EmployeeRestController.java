package com.employee.management.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/management")
public class EmployeeRestController {
	Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	@GetMapping("/employee")
	public String getManagement() {
		System.out.println("---------Hello-----------");
		return "!! Welcome to Management Service!! ";
		
	}
	
	@GetMapping("/getMessage")
    @RateLimiter(name = "getMessageRateLimit", fallbackMethod = "getMessageFallBack")
    public ResponseEntity<String> getMessage(@RequestParam(value="name", defaultValue = "Hello") String name){
		
        return ResponseEntity.ok().body("Message from getMessage() :" +name);
    }

    public ResponseEntity<String> getMessageFallBack(RequestNotPermitted exception) {

    	System.out.println("Rate limit has applied, So no further calls are getting accepted");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
        .body("Too many requests : No further request will be accepted. Please try after sometime");
    }
    
    
    RestTemplate restTemplate= new RestTemplate();

   /* @GetMapping("/getInvoice")
    @Retry(name = "getInvoiceRetry", fallbackMethod = "getInvoiceFallback") 
    public String getInvoice() {
       logger.info("getInvoice() call starts here");
       ResponseEntity<String> entity= restTemplate.getForEntity("http://127.0.0.1:9090/v1/api/getUsers", String.class);
       logger.info("Response :" + entity.getStatusCode());
       return entity.getBody();
    }

    public String getInvoiceFallback(Exception e) {
       logger.info("---RESPONSE FROM FALLBACK METHOD---");
       return "SERVICE IS DOWN, PLEASE TRY AFTER SOMETIME !!!";
    }*/
    
    @GetMapping("/getInvoice")
    @CircuitBreaker(name = "getInvoiceCB", fallbackMethod = "getInvoiceFallback") 
    public String getInvoice() { 
       logger.info("getInvoice() call starts here");
       ResponseEntity<String> entity= restTemplate.getForEntity("http://127.0.0.1:9090/v1/api/getUsers", String.class);
       logger.info("Response :" + entity.getStatusCode());
       return entity.getBody();
    }

    public String getInvoiceFallback(Exception e) {
       logger.info("---RESPONSE FROM FALLBACK METHOD---");
       return "SERVICE IS DOWN, PLEASE TRY AFTER SOMETIME !!!";
    }

}
