package dev.connellrobert.ims.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author RobertConnell
 *
 *	A catch-all for returning graceful error responses from the controller. 
 *	
 *	More specific advices will need to be added to ensure the client gets an
 *		appropriate response.
 *
 *TODO: add more advice for more graceful termination of requests.
 */
@ControllerAdvice
public class GeneralControllerErrorResponse{
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	public ResponseEntity<String> gracefulResponse(Exception e){
		e.printStackTrace();
		return new ResponseEntity<String>("{ \"status\":\"failed request\"}", HttpStatus.EXPECTATION_FAILED);
	}
}