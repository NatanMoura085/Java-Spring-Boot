package com.userApi.demoApi.domain.exception;

public class NegocioExeception extends RuntimeException{
    public NegocioExeception(String message) {
        super(message);
    }
}
