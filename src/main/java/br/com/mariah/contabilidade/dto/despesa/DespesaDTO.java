package br.com.mariah.contabilidade.dto.despesa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DespesaDTO {

    @JsonProperty(value = "valor")
    private Double valor;

    @JsonProperty(value = "data-horario")
    private String dataHorario;

    @JsonProperty(value = "descricao")
    private String descricao;
}
