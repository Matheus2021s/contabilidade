package br.com.mariah.contabilidade.controller;

import br.com.mariah.contabilidade.dto.despesa.DespesaRequest;
import br.com.mariah.contabilidade.dto.despesa.DespesaResponse;
import br.com.mariah.contabilidade.service.DespesaService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/despesa")
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping
    public DespesaResponse create(@RequestBody @Valid DespesaRequest despesaRequest) {
        log.info("DespesaController.create -> {}", despesaRequest.toString());
        return DespesaResponse.of(this.despesaService.create(despesaRequest.toEntity()));
    }

    @GetMapping
    public Page<DespesaResponse> list(Pageable pageable) {
        log.info("DespesaController.list -> {}", pageable);
        return this.despesaService.list(pageable).map(DespesaResponse::of);

    }
}
