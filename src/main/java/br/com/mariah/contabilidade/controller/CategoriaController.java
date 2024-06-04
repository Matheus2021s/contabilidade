package br.com.mariah.contabilidade.controller;

import br.com.mariah.contabilidade.dto.categoria.CategoriaRequest;
import br.com.mariah.contabilidade.dto.categoria.CategoriaResponse;
import br.com.mariah.contabilidade.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CategoriaResponse create(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        log.info("CategoriaController.create -> {}", categoriaRequest);
        return CategoriaResponse.of(this.categoriaService.create(categoriaRequest.toEntity()));
    }

    @GetMapping
    public Page<CategoriaResponse> list(Pageable pageable) {
        log.info("CategoriaController.list -> {}", pageable);
        return this.categoriaService.list(pageable).map(CategoriaResponse::of);
    }
}
