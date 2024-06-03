package br.com.mariah.contabilidade.repository;

import br.com.mariah.contabilidade.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
