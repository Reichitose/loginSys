package com.reiuy.exception;

public class UserException extends Exception {
    //此处用来记录检查类异常

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}
