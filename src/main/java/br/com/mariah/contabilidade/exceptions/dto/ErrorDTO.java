package br.com.mariah.contabilidade.exceptions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

    String field;
    String message;
}
