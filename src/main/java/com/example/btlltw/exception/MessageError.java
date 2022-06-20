package com.example.btlltw.exception;

import lombok.Getter;

@Getter
public enum MessageError {
    NOT_FOUND(404001, "error.api.post-not-found");

    private final int code;
    private final String message;

    MessageError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "\n" +
                "Exception body:" + "{" + "\n" +
                "\t" + "code: " + code + "," + "\n" +
                "\t" + "message: \"" + message + '\"' + "\n" +
                "\t" + '}';
    }
}
