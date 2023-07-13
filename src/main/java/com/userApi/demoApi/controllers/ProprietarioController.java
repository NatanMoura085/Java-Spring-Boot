package com.userApi.demoApi.controllers;

import com.userApi.demoApi.domain.exception.NegocioExeception;
import com.userApi.demoApi.domain.model.Proprietario;
import com.userApi.demoApi.domain.repository.ProprietarioRepository;
import com.userApi.demoApi.domain.service.RegistroProprietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class ProprietarioController {

     private final RegistroProprietarioService registroProprietarioService;
     private final ProprietarioRepository proprietarioRepository;

     @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/owner")
    public List<Proprietario> proprietarios(){

  return  proprietarioRepository.findAll();

    }
@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/owner")
    public Proprietario Create(@Valid @RequestBody Proprietario proprietario){
        return registroProprietarioService.salvar(proprietario);
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id ){
        registroProprietarioService.exluir(id);
         return ResponseEntity.noContent().build();

    }

    @ExceptionHandler(NegocioExeception.class)
    public ResponseEntity<String> capturar(NegocioExeception e){
         return  ResponseEntity.badRequest().body(e.getMessage());

    }
}
