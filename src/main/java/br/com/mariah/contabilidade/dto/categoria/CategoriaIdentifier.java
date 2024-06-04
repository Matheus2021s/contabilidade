package br.com.mariah.contabilidade.dto.categoria;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaIdentifier {

    @NotNull(message = "O id da categoria deve ser informado!")
    private Long id;

    private String nome;
}
