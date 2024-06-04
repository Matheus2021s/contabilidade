package br.com.mariah.contabilidade.exceptions;

import br.com.mariah.contabilidade.exceptions.dto.ErrorDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestControllerAdvice
public class CustomExceptionHandler {

    private final MessageSource messageSource;

    public CustomExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<ErrorDTO> list = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError ->
                        ErrorDTO.builder().field(fieldError.getField())
                                .message(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))
                                .build()
                ).collect(Collectors.toList());

        log.error(exception);
        return ResponseEntity.badRequest()
                .body(list);
    }


    @ExceptionHandler(EntityPersistenceIdentifierException.class)
    public ResponseEntity<ErrorDTO> handleEntityPersistenceIdentifierException(EntityPersistenceIdentifierException exception){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(exception.getLocalizedMessage())
                .build();
        log.error(errorDTO);
        return ResponseEntity.badRequest()
                .body(errorDTO);
    }



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(exception.getLocalizedMessage())
                .build();
        log.error(errorDTO);
        return ResponseEntity.badRequest()
                .body(errorDTO);
    }


    @ExceptionHandler(UnparsableValueException.class)
    public ResponseEntity<ErrorDTO> handleUnparsableValueException(UnparsableValueException exception){
        return ResponseEntity.badRequest()
                .body(
                        ErrorDTO.builder()
                                .message(exception.getLocalizedMessage())
                                .build()
                );
    }
}
