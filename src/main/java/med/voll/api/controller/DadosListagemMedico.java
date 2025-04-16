package med.voll.api.controller;

import med.voll.api.medico.Especialidade;

public record DadosListagemMedico(
    String nome, 
    String crm, 
    String email, 
    Especialidade especialidade) {} 