package com.labschool.sms.controller;

import com.labschool.sms.model.dto.AtendimentoDtoEntrada;
import com.labschool.sms.model.dto.AtendimentoDtoSaida;
import com.labschool.sms.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

  private final AtendimentoService atendimentoService;

  public AtendimentoController(AtendimentoService atendimentoService) {
    this.atendimentoService = atendimentoService;
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public AtendimentoDtoSaida atualizarSituacaoCadastral(
      @RequestBody AtendimentoDtoEntrada atendimentoDtoEntrada) {
    return atendimentoService.realizaAtendimento(atendimentoDtoEntrada.getCodigoAluno(),
        atendimentoDtoEntrada.getCodigoPedagogo());
  }

}
