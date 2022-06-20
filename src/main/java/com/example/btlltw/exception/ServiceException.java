package com.example.btlltw.exception;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -6662460118306199774L;

    private final MessageError error;
    private Map<String, Object> params;

    protected ServiceException(MessageError error, Throwable ex, LinkedHashMap<String, Object> params) {
        super(error.getMessage(), ex);
        this.params = Objects.nonNull(params) ? params: Collections.emptyMap();
        this.error = error;
    }
}
