package br.com.mariah.contabilidade.repository;

import br.com.mariah.contabilidade.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
