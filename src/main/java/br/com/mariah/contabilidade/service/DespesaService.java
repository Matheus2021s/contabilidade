package br.com.mariah.contabilidade.service;

import br.com.mariah.contabilidade.domain.Despesa;
import br.com.mariah.contabilidade.exceptions.EntityPersistenceIdentifierException;
import br.com.mariah.contabilidade.repository.DespesaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    private final CategoriaService categoriaService;

    public DespesaService(DespesaRepository despesaRepository, CategoriaService categoriaService) {
        this.despesaRepository = despesaRepository;
        this.categoriaService = categoriaService;
    }

    public Despesa create(Despesa despesa) {
        log.info("DespesaService.create -> {}", despesa.toString());

        Long idCategoria = despesa.getCategoria().getId();

        if (idCategoria == null) {
            throw new EntityPersistenceIdentifierException("A categoria da despesa informada é inválida!");
        }

        despesa.setCategoria(this.categoriaService.findById(idCategoria));

        return this.despesaRepository.save(despesa);
    }

    public Page<Despesa> list(Pageable pageable) {
        return this.despesaRepository.findAll(pageable);
    }
}
