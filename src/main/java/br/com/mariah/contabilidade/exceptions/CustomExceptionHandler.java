package br.com.mariah.contabilidade.exceptions;

import br.com.mariah.contabilidade.exceptions.dto.ErrorDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final MessageSource messageSource;

    public CustomExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest()
                .body(
                        exception.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(fieldError ->
                                        ErrorDTO.builder().field(fieldError.getField())
                                                .message(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))
                                                .build()
                                ).collect(Collectors.toList())
                );
    }
}
