package com.aws.estock.exception;

public class CompanyNotFoundException extends RuntimeException{
	
	public CompanyNotFoundException(String message) {
		super(message);
	}
}
