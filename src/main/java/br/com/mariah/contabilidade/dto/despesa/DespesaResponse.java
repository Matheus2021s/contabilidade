package br.com.mariah.contabilidade.dto.despesa;

import br.com.mariah.contabilidade.domain.Despesa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DespesaResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "valor")
    private Double valor;

    @JsonProperty(value = "data-horario")
    private String dataHorario;

    @JsonProperty(value = "descricao")
    private String descricao;

    public static DespesaResponse of(Despesa despesa) {
        return DespesaResponse.builder()
                .id(despesa.getId())
                .valor(despesa.getValor())
                .descricao(despesa.getDescricao())
                .dataHorario(despesa.getDataHorario().toString())
                .build();
    }
}
