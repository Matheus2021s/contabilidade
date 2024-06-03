package br.com.mariah.contabilidade.dto.despesa;

import br.com.mariah.contabilidade.domain.Despesa;
import br.com.mariah.contabilidade.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DespesaDTO {

    @NotNull(message = "O valor não pode ser nulo")
    @JsonProperty(value = "valor")
    private Double valor;

    @JsonProperty(value = "data-horario")
    private String dataHorario;

    @NotEmpty(message = "Preencher a descrição da despesa!")
    @JsonProperty(value = "descricao")
    private String descricao;

    public Despesa toEntity() {
        return Despesa.builder()
                .valor(valor)
                .dataHorario(dataHorario != null && !dataHorario.isEmpty()
                        ? DateTimeUtil.toLocalDateTime(dataHorario)
                        : LocalDateTime.now())
                .descricao(descricao)
                .build();
    }
}
