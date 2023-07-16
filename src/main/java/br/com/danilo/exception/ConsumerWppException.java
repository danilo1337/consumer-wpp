package br.com.danilo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumerWppException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private HttpStatus status;

	public ConsumerWppException(String message) {
        super(message);
    }
    
    public ConsumerWppException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ConsumerWppException(String message, HttpStatus status) {
    	super(message);
    	this.status = status;
    }
    
    public ConsumerWppException(String message, Throwable cause, HttpStatus status) {
    	super(message, cause);
    	this.status = status;
    }
    
}
