package com.userApi.demoApi.controllers;


import com.userApi.demoApi.domain.exception.NegocioExeception;
import com.userApi.demoApi.domain.model.Veiculo;
import com.userApi.demoApi.domain.repository.VeiculoRepository;
import com.userApi.demoApi.domain.service.RegistroVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@AllArgsConstructor
public class VeiculoControllers {
private final VeiculoRepository veiculoRepository;
private final RegistroVeiculoService registroVeiculoService;

@GetMapping
public List<Veiculo> lista(){
    return  veiculoRepository.findAll();
}

@GetMapping("/{VeiculoId}")
public ResponseEntity<Veiculo> busca(@PathVariable Long VeiculoId ){
return veiculoRepository.findById(VeiculoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Veiculo cadastra(@RequestBody Veiculo veiculo){
return registroVeiculoService.cadastra(veiculo);

}

    @ExceptionHandler(NegocioExeception.class)
    public ResponseEntity<String> capturar(NegocioExeception e){
        return  ResponseEntity.badRequest().body(e.getMessage());

    }




}



