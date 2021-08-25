package com.company.Error;

public class DivisionZeroError extends Exception {
    public DivisionZeroError() {
    }

    public DivisionZeroError(String message) {
        super(message);
        System.out.println(message);
    }

    public DivisionZeroError(String message, Throwable cause) {
        super(message, cause);
    }

    public DivisionZeroError(Throwable cause) {
        super(cause);
    }


}
