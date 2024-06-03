package br.com.mariah.contabilidade.controller;

import br.com.mariah.contabilidade.dto.despesa.DespesaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesa")
public class DespesaController {


    @PostMapping
    public ResponseEntity create(@RequestBody DespesaDTO despesaDTO) {

        return ResponseEntity.ok("ok");
    }
}
