package com.labschool.sms.controller;

import com.labschool.sms.model.dto.PedagogoDto;
import com.labschool.sms.service.PedagogoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedagogos")
public class PedagogoController {

  private final PedagogoService service;

  public PedagogoController(PedagogoService service) {
    this.service = service;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PedagogoDto> consulta() {
    var pedagogos = service.buscarTodos();
    var pedagogoDto = new PedagogoDto();
    return pedagogoDto.transformarEmListaDeDtos(pedagogos);
  }

}
