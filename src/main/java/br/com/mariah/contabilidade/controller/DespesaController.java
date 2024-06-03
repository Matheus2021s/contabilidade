package br.com.mariah.contabilidade.controller;

import br.com.mariah.contabilidade.dto.despesa.DespesaDTO;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/despesa")
public class DespesaController {


    @PostMapping
    public ResponseEntity create(@RequestBody @Valid DespesaDTO despesaDTO) {
        log.info("DespesaController.create -> {}", despesaDTO.toString());


        return ResponseEntity.ok("ok");
    }
}
