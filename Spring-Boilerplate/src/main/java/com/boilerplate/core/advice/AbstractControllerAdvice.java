package com.boilerplate.core.advice;

import com.boilerplate.common.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * created by hyunwoo 21/06/23
 */
@Slf4j
public abstract class AbstractControllerAdvice {
    protected ResponseEntity<ErrorResponseDto<?>> handleException(Throwable e, HttpStatus status) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(status).body(ErrorResponseDto.of(e.getMessage()));
    }
}