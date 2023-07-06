package com.userApi.demoApi.controllers;

import com.userApi.demoApi.domain.model.Proprietario;
import com.userApi.demoApi.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController
public class ProprietarioController {


     private final ProprietarioRepository proprietarioRepository;
    @GetMapping(value="/owner")
    public List<Proprietario> proprietarios(){

  return  proprietarioRepository.findAll();



    }
}
