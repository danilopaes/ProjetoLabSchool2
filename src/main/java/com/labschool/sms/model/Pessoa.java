package com.labschool.sms.model;

import com.labschool.sms.exception.CpfInvalidoException;
import com.labschool.sms.exception.DadosInvalidosException;
import com.labschool.sms.utils.ValidadorDeCpf;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;

  @NotNull(message = "O nome não pode ser nulo!")
  @NotEmpty(message = "O nome é obrigatório!")
  private String nome;

  @NotNull(message = "O telefone não pode ser nulo!")
  @NotEmpty(message = "O telefone é obrigatório!")
  private String telefone;

  @NotNull(message = "A data de nascimento é obrigatória!")
  private LocalDate dataNascimento;

  @NotNull
  private Long cpf;

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

  public void validar() {
    if (this.nome == null || this.telefone == null || this.dataNascimento == null
        || this.cpf == null) {
      throw new DadosInvalidosException();
    }

    if (ValidadorDeCpf.isCpfInvalido(cpf.toString())) {
      throw new CpfInvalidoException();
    }
  }

}
