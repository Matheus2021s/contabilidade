package br.com.mariah.contabilidade.controller;

import br.com.mariah.contabilidade.dto.categoria.CategoriaRequest;
import br.com.mariah.contabilidade.dto.categoria.CategoriaResponse;
import br.com.mariah.contabilidade.service.CategoriaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CategoriaResponse create(CategoriaRequest categoriaRequest) {
        log.info("CategoriaController.create -> {}", categoriaRequest);
        return CategoriaResponse.of(this.categoriaService.create(categoriaRequest.toEntity()));
    }

    @GetMapping
    public Page<CategoriaResponse> list(Pageable pageable) {
        log.info("CategoriaController.list -> {}", pageable);
        return this.categoriaService.list(pageable).map(CategoriaResponse::of);
    }
}
