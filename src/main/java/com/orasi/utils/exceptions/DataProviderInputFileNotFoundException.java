package com.orasi.utils.exceptions;

import com.orasi.AutomationException;

public class DataProviderInputFileNotFoundException extends AutomationException {
    private static final long serialVersionUID = 8734638785785664287L;

    public DataProviderInputFileNotFoundException(String message) {
        super(message);
    }

    public DataProviderInputFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
