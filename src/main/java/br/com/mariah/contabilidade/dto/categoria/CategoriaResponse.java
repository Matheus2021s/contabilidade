package br.com.mariah.contabilidade.dto.categoria;


import br.com.mariah.contabilidade.domain.Categoria;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaResponse {

    public static CategoriaResponse of(Categoria categoria) {
        return null;
    }
}
