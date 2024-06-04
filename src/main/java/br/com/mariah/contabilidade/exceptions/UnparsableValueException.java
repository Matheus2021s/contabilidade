package br.com.mariah.contabilidade.exceptions;

public class UnparsableValueException extends RuntimeException {
    public UnparsableValueException(String msg) {
        super(msg);
    }
}
