package com.userApi.demoApi.controllers;

import com.userApi.demoApi.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping(value="/owner")
    public List<Proprietario> proprietarios(){
    var proprietario1 = new Proprietario();
    proprietario1.setId(1L);
    proprietario1.setNome("Natan");
    proprietario1.setEmail("email@gmail.com");
    proprietario1.setTelefone("45445435435");

    return List.of(proprietario1);
    }
}
