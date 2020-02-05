package com.tutorial.simple.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ExceptionResponse {
    private final Date timestamp;
    private final String message;
    private final List<String> details;
}
