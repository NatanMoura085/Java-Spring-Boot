package com.userApi.demoApi.domain.service;


import com.userApi.demoApi.domain.exception.NegocioExeception;
import com.userApi.demoApi.domain.model.Proprietario;
import com.userApi.demoApi.domain.model.StatusVeiculo;
import com.userApi.demoApi.domain.model.Veiculo;
import com.userApi.demoApi.domain.repository.ProprietarioRepository;
import com.userApi.demoApi.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor

public class RegistroVeiculoService {

    private  final VeiculoRepository veiculoRepository;
    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public  Veiculo cadastra(Veiculo Novoveiculo){
        if(Novoveiculo.getId() != null){
      throw  new NegocioExeception("Veiculo ser registrado deve possui um codigo");
        }
        boolean placaUso = VeiculoRepository.findByPlaca(Novoveiculo.getPlaca())
                        .filter(Veiculo -> !Veiculo.equals(Novoveiculo))
                                .isPresent();

        if(placaUso){
            throw  new NegocioExeception("Ja existe essa placa");
        }

        Proprietario proprietario = proprietarioRepository.findById(Novoveiculo.getProprietario().getId())
                        .orElseThrow(()-> new NegocioExeception("Proprietario nao encontra"));
        Novoveiculo.setProprietario(proprietario);
        Novoveiculo.setStatus(StatusVeiculo.REGULAR);
        Novoveiculo.setDatacadastro(LocalDateTime.now());
    return veiculoRepository.save(Novoveiculo);
    }
}
