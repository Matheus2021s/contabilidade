package br.com.mariah.contabilidade.dto.categoria;

import br.com.mariah.contabilidade.domain.Categoria;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaRequest {

    private String nome;

    private String descricao;

    public Categoria toEntity() {
        return Categoria.builder()
                .nome(nome)
                .descricao(descricao)
                .build();
    }
}
