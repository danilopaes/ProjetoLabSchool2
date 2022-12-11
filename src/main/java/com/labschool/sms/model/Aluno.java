package com.labschool.sms.model;

import com.labschool.sms.exception.DadosInvalidosException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa {

  @NotEmpty
  private String situacaoDaMatricula;

  @NotNull
  private Float notaProcessoSeletivo;
  private Integer totalAtendimentosPedagogicos = 0;

  public String getSituacaoDaMatricula() {
    return situacaoDaMatricula;
  }

  public void setSituacaoDaMatricula(String situacaoDaMatricula) {
    this.situacaoDaMatricula = situacaoDaMatricula;
  }

  public Float getNotaProcessoSeletivo() {
    return notaProcessoSeletivo;
  }

  public void setNotaProcessoSeletivo(Float notaProcessoSeletivo) {
    this.notaProcessoSeletivo = notaProcessoSeletivo;
  }

  public Integer getTotalAtendimentosPedagogicos() {
    return totalAtendimentosPedagogicos;
  }

  public void setTotalAtendimentosPedagogicos(Integer totalAtendimentosPedagogicos) {
    this.totalAtendimentosPedagogicos = totalAtendimentosPedagogicos;
  }

  @Override
  public void validar() {
    super.validar();

    if (this.situacaoDaMatricula == null || this.notaProcessoSeletivo == null
        || this.totalAtendimentosPedagogicos == null) {
      throw new DadosInvalidosException();
    }
  }

}
