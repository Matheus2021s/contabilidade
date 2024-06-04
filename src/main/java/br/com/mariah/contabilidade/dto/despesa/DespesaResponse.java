package br.com.mariah.contabilidade.dto.despesa;

import br.com.mariah.contabilidade.domain.Despesa;
import br.com.mariah.contabilidade.dto.categoria.CategoriaIdentifier;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private CategoriaIdentifier categoria;

    public static DespesaResponse of(Despesa despesa) {
        return DespesaResponse.builder()
                .id(despesa.getId())
                .valor(despesa.getValor())
                .descricao(despesa.getDescricao())
                .dataHorario(despesa.getDataHorario().toString())
                .categoria(CategoriaIdentifier.builder()
                        .id(despesa.getCategoria().getId())
                        .nome(despesa.getCategoria().getNome())
                        .build())
                .build();
    }
}
