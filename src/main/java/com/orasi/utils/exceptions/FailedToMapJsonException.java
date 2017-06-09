package com.orasi.utils.exceptions;

import com.orasi.AutomationException;

public class FailedToMapJsonException extends AutomationException {
    private static final long serialVersionUID = 8734638785785664287L;

    public FailedToMapJsonException(String message) {
        super(message);
    }

    public FailedToMapJsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
