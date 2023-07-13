package com.userApi.demoApi.domain.service;


import com.userApi.demoApi.domain.exception.NegocioExeception;
import com.userApi.demoApi.domain.model.Proprietario;
import com.userApi.demoApi.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;


     @Transactional
    public Proprietario  salvar(Proprietario proprietario){

         boolean  useEmail =  proprietarioRepository.findByEmail(proprietario.getEmail())
                 .filter(p-> !p.equals(proprietario))
                 .isPresent();


         if(useEmail){

             throw new NegocioExeception("ja existe proprietario cadastrado com esse email");
         }
       return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void exluir(Long ProprietarioId){
         proprietarioRepository.deleteById(ProprietarioId);
    }
}
