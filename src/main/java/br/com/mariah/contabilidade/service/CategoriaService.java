package br.com.mariah.contabilidade.service;


import br.com.mariah.contabilidade.domain.Categoria;
import br.com.mariah.contabilidade.repository.CategoriaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(Categoria categoria) {
        log.info("CategoriaService.create -> {}", categoria);
        return this.categoriaRepository.save(categoria);
    }

    public Page<Categoria> list(Pageable pageable) {
        log.info("CategoriaService.list -> {}", pageable);
        return this.categoriaRepository.findAll(pageable);
    }
}
