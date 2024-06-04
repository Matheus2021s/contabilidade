package br.com.mariah.contabilidade.dto.categoria;


import br.com.mariah.contabilidade.domain.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaResponse {

    private Long id;

    private String nome;

    private String descricao;

    @JsonProperty(value = "data-hora-cadastro")
    private String dataHoraCadastro;

    public static CategoriaResponse of(Categoria categoria) {
        return CategoriaResponse.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .descricao(categoria.getDescricao())
                .dataHoraCadastro(categoria.getDataHoraCadastro().toString())
                .build();
    }
}
