package org.yenbo.awssdkdemo;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.apache.commons.lang3.exception.ExceptionContext;

public class AwsDemoException extends ContextedRuntimeException {

	private static final long serialVersionUID = 8954537229784534081L;

	public AwsDemoException() {
		super();
	}

	public AwsDemoException(String message) {
		super(message);
	}

	public AwsDemoException(Throwable cause) {
		super(cause);
	}

	public AwsDemoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AwsDemoException(String message, Throwable cause, ExceptionContext context) {
		super(message, cause, context);
	}

}
