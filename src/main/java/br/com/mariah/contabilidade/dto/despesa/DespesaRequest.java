package br.com.mariah.contabilidade.dto.despesa;

import br.com.mariah.contabilidade.domain.Categoria;
import br.com.mariah.contabilidade.domain.Despesa;
import br.com.mariah.contabilidade.dto.categoria.CategoriaIdentifier;
import br.com.mariah.contabilidade.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DespesaRequest {

    @NotNull(message = "O valor não pode ser nulo")
    @JsonProperty(value = "valor")
    private Double valor;

    @JsonProperty(value = "data-horario")
    private String dataHorario;

    @NotEmpty(message = "Preencher a descrição da despesa!")
    @JsonProperty(value = "descricao")
    private String descricao;

    @Valid
    @NotNull(message = "Preencher a categoria da despesa!")
    private CategoriaIdentifier categoria;

    public Despesa toEntity() {
        return Despesa.builder()
                .valor(valor)
                .dataHorario(dataHorario != null && !dataHorario.isEmpty()
                        ? DateTimeUtil.toLocalDateTime(dataHorario)
                        : LocalDateTime.now())
                .descricao(descricao)
                .categoria(Categoria.builder()
                        .id(categoria.getId())
                        .build())
                .build();
    }
}
