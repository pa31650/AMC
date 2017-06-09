package com.orasi.utils.exceptions;

import com.orasi.AutomationException;

public class InvalidFileException extends AutomationException {
    /**
     *
     */
    private static final long serialVersionUID = 1861535540217015795L;

    public InvalidFileException(String message) {
        super(message);
    }

    public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
