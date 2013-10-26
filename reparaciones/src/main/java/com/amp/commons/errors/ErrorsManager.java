package com.amp.commons.errors;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorsManager {

	private BindingResult result;

	public ErrorsManager(BindingResult result) {
		this.result = result;
	}

	public boolean existError() {

		boolean error = false;
		if (result.getErrorCount() > 0) {
			error = true;
		}

		return error;
	}

	public String getErrorMessage() {

		String errorMessage = "";
		if (existError()) {
			errorMessage = buildErrorMessage();
		}
		return errorMessage;
	}

	private String buildErrorMessage() {
		String message = "Complete los campos obligatorios:\n" + "\n";
		List<FieldError> errorList = result.getFieldErrors();
		for (int i = 0; i < errorList.size(); i++) {
			message = message + "-" + errorList.get(i).getField();
		}
		return message;
	}

}
