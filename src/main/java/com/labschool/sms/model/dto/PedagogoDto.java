package com.labschool.sms.model.dto;

import com.labschool.sms.exception.NenhumPedagogoException;
import com.labschool.sms.model.Pedagogo;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PedagogoDto {

  private String nome;
  private String telefone;
  private LocalDate dataNascimento;
  private Long cpf;
  private Integer atendimentos;

  public PedagogoDto transformarEmDto(Pedagogo pedagogo) {
    var pedagogoDto = new PedagogoDto();

    pedagogoDto.setNome(pedagogo.getNome());
    pedagogoDto.setTelefone(pedagogo.getTelefone());
    pedagogoDto.setDataNascimento(pedagogo.getDataNascimento());
    pedagogoDto.setCpf(pedagogo.getCpf());
    pedagogoDto.setAtendimentos(pedagogo.getQntAtendimentos());

    return pedagogoDto;
  }

  public List<PedagogoDto> transformarEmListaDeDtos(List<Pedagogo> pedagogos) {
    if (pedagogos.isEmpty()) {
      throw new NenhumPedagogoException();
    }
    return pedagogos.stream().map(this::transformarEmDto).collect(Collectors.toList());
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

  public Integer getAtendimentos() {
    return atendimentos;
  }

  public void setAtendimentos(Integer atendimentos) {
    this.atendimentos = atendimentos;
  }
}
