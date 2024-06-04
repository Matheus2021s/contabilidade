package br.com.mariah.contabilidade.dto.categoria;

import br.com.mariah.contabilidade.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaRequest {

    @NotEmpty(message = "O nome deve ser preenchido")
    private String nome;

    @NotEmpty(message = "A descrição deve ser preenchida")
    private String descricao;

    public Categoria toEntity() {
        return Categoria.builder()
                .nome(nome)
                .descricao(descricao)
                .build();
    }
}
