package br.com.mariah.contabilidade.service;

import br.com.mariah.contabilidade.domain.Despesa;
import br.com.mariah.contabilidade.repository.DespesaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesa create(Despesa despesa) {
        log.info("DespesaService.create -> {}", despesa.toString());

        Despesa save = this.despesaRepository.save(despesa);

        log.info("despesa saved -> {}", save);

        return save;
    }

    public Page<Despesa> list(Pageable pageable) {
        return this.despesaRepository.findAll(pageable);
    }
}
