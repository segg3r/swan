package com.segg3r.swan;

public class SwanException extends RuntimeException {

	public SwanException() {
	}

	public SwanException(String message) {
		super(message);
	}

	public SwanException(String message, Throwable cause) {
		super(message, cause);
	}

	public SwanException(Throwable cause) {
		super(cause);
	}

}
