package br.com.mariah.contabilidade.controller;

import br.com.mariah.contabilidade.domain.Despesa;
import br.com.mariah.contabilidade.dto.despesa.DespesaDTO;
import br.com.mariah.contabilidade.dto.despesa.DespesaResponse;
import br.com.mariah.contabilidade.service.DespesaService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DespesaResponse> create(@RequestBody @Valid DespesaDTO despesaDTO) {
        log.info("DespesaController.create -> {}", despesaDTO.toString());

        Despesa despesa = despesaDTO.toEntity();

        Despesa saved = this.despesaService.create(despesa);

        return ResponseEntity.ok(DespesaResponse.of(saved));
    }

    @GetMapping
    public ResponseEntity<Page<DespesaResponse>> list(Pageable pageable){
        log.info("DespesaController.list -> {}", pageable);

        Page<Despesa> list = this.despesaService.list(pageable);

        return ResponseEntity.ok(list.map(DespesaResponse::of));

    }
}
