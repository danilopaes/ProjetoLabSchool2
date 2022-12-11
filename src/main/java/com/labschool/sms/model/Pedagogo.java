package com.labschool.sms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pedagogos")
public class Pedagogo extends Pessoa {

  @NotNull(message = "A quantidade de atendimentos é um campo obrigatório!")
  private Integer qntAtendimentos = 0;

  public Integer getQntAtendimentos() {
    return qntAtendimentos;
  }

  public void setQntAtendimentos(Integer qntAtendimentos) {
    this.qntAtendimentos = qntAtendimentos;
  }

}
