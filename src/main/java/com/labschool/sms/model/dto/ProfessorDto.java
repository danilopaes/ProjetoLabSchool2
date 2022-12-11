package com.labschool.sms.model.dto;

import com.labschool.sms.exception.NenhumProfessorException;
import com.labschool.sms.model.Professor;
import com.labschool.sms.model.enums.EstadoProfessor;
import com.labschool.sms.model.enums.ExperienciaEmDesenvolvimento;
import com.labschool.sms.model.enums.FormacaoAcademica;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorDto {

  private String nome;
  private String telefone;
  private LocalDate dataNascimento;
  private Long cpf;
  private FormacaoAcademica formacao;
  private ExperienciaEmDesenvolvimento experiencia;
  private EstadoProfessor estado;

  public ProfessorDto transformarEmDto(Professor professor) {
    var professorDto = new ProfessorDto();

    professorDto.setNome(professor.getNome());
    professorDto.setTelefone(professor.getTelefone());
    professorDto.setDataNascimento(professor.getDataNascimento());
    professorDto.setCpf(professor.getCpf());
    professorDto.setFormacao(FormacaoAcademica.valueOf(professor.getFormacaoAcademica()));
    professorDto.setExperiencia(ExperienciaEmDesenvolvimento.valueOf(professor.getExperiencia()));
    professorDto.setEstado(EstadoProfessor.valueOf(professor.getEstado()));

    return professorDto;
  }

  public List<ProfessorDto> transformarEmListaDeDtos(List<Professor> professores) {
    if (professores.isEmpty()) {
      throw new NenhumProfessorException();
    }
    return professores.stream().map(this::transformarEmDto).collect(Collectors.toList());
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }

  public FormacaoAcademica getFormacao() {
    return formacao;
  }

  public void setFormacao(FormacaoAcademica formacao) {
    this.formacao = formacao;
  }

  public ExperienciaEmDesenvolvimento getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(ExperienciaEmDesenvolvimento experiencia) {
    this.experiencia = experiencia;
  }

  public EstadoProfessor getEstado() {
    return estado;
  }

  public void setEstado(EstadoProfessor estado) {
    this.estado = estado;
  }
}
