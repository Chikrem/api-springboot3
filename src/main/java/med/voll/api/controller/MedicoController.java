package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosAtualizacaoMedico;
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

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        System.out.println("Listando médicos");
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody DadosAtualizacaoMedico dados) {
        System.out.println("Atualizando médico");
        System.out.println(dados);
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        System.out.println("Médico atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        System.out.println("Excluindo médico com ID: " + id);
        var medico = repository.getReferenceById(id);
        medico.excluir();
        System.out.println("Médico excluído com sucesso");
    }

}