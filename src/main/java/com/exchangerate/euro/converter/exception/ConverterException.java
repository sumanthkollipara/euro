package com.exchangerate.euro.converter.exception;

import java.util.List;

public class ConverterException extends RuntimeException
{
   
    private String message;
    private String errCode;
 
    public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
   
}
