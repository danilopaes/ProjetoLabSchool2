package com.labschool.sms.model.dto;

import com.labschool.sms.model.Aluno;
import com.labschool.sms.model.Pedagogo;

public class AtendimentoDtoSaida {

  private Aluno aluno;
  private Pedagogo pedagogo;

  public Aluno getAluno() {
    return aluno;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  public Pedagogo getPedagogo() {
    return pedagogo;
  }

  public void setPedagogo(Pedagogo pedagogo) {
    this.pedagogo = pedagogo;
  }
}
