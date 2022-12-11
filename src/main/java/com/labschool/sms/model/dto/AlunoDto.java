package com.labschool.sms.model.dto;

import com.labschool.sms.exception.NenhumAlunoException;
import com.labschool.sms.model.Aluno;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoDto {

  private String nome;
  private String telefone;
  private LocalDate dataNascimento;
  private Long cpf;
  private String situacao;
  private Float nota;
  private Integer atendimentos;

  public Aluno transformarEmEntidade() {
    var aluno = new Aluno();

    aluno.setNome(this.nome);
    aluno.setTelefone(this.telefone);
    aluno.setDataNascimento(this.dataNascimento);
    aluno.setCpf(this.cpf);
    aluno.setSituacaoDaMatricula(this.situacao);
    aluno.setNotaProcessoSeletivo(this.nota);

    if (this.atendimentos == null) {
      this.atendimentos = 0;
    }

    aluno.setTotalAtendimentosPedagogicos(this.atendimentos);

    return aluno;
  }

  public AlunoDto transformarEmDto(Aluno alunoSalvo) {
    var alunoDto = new AlunoDto();

    alunoDto.setCpf(alunoSalvo.getCpf());
    alunoDto.setNota(alunoSalvo.getNotaProcessoSeletivo());
    alunoDto.setSituacao(alunoSalvo.getSituacaoDaMatricula());
    alunoDto.setNome(alunoSalvo.getNome());
    alunoDto.setTelefone(alunoSalvo.getTelefone());
    alunoDto.setDataNascimento(alunoSalvo.getDataNascimento());
    alunoDto.setAtendimentos(alunoSalvo.getTotalAtendimentosPedagogicos());

    return alunoDto;
  }

  public List<AlunoDto> transformarEmListaDeDtos(List<Aluno> alunos) {
    if (alunos.isEmpty()) {
      throw new NenhumAlunoException();
    }
    return alunos.stream().map(this::transformarEmDto).collect(Collectors.toList());
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

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) {
    this.situacao = situacao;
  }

  public Float getNota() {
    return nota;
  }

  public void setNota(Float nota) {
    this.nota = nota;
  }

  public Integer getAtendimentos() {
    return atendimentos;
  }

  public void setAtendimentos(Integer atendimentos) {
    this.atendimentos = atendimentos;
  }
}
