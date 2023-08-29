package com.userApi.demoApi.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private  Long id;
    @ManyToMany
    private Proprietario proprietario;
    private String marca;
    private String modelo;
    private String placa;
 private StatusVeiculo status;
 private LocalDateTime datacadastro;
 private LocalDateTime dataApreençao;
}
