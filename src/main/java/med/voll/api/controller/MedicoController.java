package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody DadosCadastroMedico dados) {
        System.out.println("Cadastrando médico");
        System.out.println(dados);
        repository.save(new Medico(dados));
    }
}
