package com.userApi.demoApi.domain.service;


import com.userApi.demoApi.domain.model.StatusVeiculo;
import com.userApi.demoApi.domain.model.Veiculo;
import com.userApi.demoApi.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor

public class RegistroVeiculoService {

    private VeiculoRepository veiculoRepository;

    @Transactional
    public  Veiculo cadastra(Veiculo Novoveiculo){
        Novoveiculo.setStatus(StatusVeiculo.REGULAR);
        Novoveiculo.setDatacadastro(LocalDateTime.now());
    return veiculoRepository.save(Novoveiculo);
    }
}
