package br.com.mariah.contabilidade.dto.despesa;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DespesaIdentifier {

    @NotNull(message = "O id da despesa deve ser informado!")
    private Long id;

    private String nome;
}
