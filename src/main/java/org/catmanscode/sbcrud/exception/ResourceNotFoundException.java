package org.catmanscode.sbcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final String resource;
	private final String fieldName;
	private final Object fieldValue;

	public ResourceNotFoundException(final String resource, final String fieldName, final Object fieldValue) {
		super(String.format("%s is not found with %s: '%s'", resource, fieldValue, fieldValue));
		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResource() {
		return this.resource;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public Object getFieldValue() {
		return this.fieldValue;
	}

}
