package com.labschool.sms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "professores")
public class Professor extends Pessoa {

  @NotEmpty(message = "O estado é um campo obrigatório!")
  private String estado;

  @NotEmpty(message = "A experiencia é um campo obrigatório!")
  private String experiencia;

  @NotEmpty(message = "A formação academica é um campo obrigatório!")
  private String formacaoAcademica;

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(String experiencia) {
    this.experiencia = experiencia;
  }

  public String getFormacaoAcademica() {
    return formacaoAcademica;
  }

  public void setFormacaoAcademica(String formacaoAcademica) {
    this.formacaoAcademica = formacaoAcademica;
  }

}
