package com.userApi.demoApi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
 private StatusVeiculo status;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
 private LocalDateTime datacadastro;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
 private LocalDateTime dataApreençao;
}
