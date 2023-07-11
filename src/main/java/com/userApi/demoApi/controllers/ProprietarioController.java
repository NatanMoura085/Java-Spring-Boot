package com.userApi.demoApi.controllers;

import com.userApi.demoApi.domain.model.Proprietario;
import com.userApi.demoApi.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class ProprietarioController {


     private final ProprietarioRepository proprietarioRepository;

     @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/owner")
    public List<Proprietario> proprietarios(){

  return  proprietarioRepository.findAll();

    }
@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/owner")
    public Proprietario Create(@RequestBody Proprietario proprietario){
        return proprietarioRepository.save(proprietario);
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id ){
         proprietarioRepository.deleteById(id);
         return ResponseEntity.noContent().build();

    }

}
