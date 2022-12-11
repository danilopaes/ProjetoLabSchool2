package com.labschool.sms.controller;

import com.labschool.sms.model.dto.AlunoDto;
import com.labschool.sms.model.dto.ProfessorDto;
import com.labschool.sms.service.AlunoService;
import com.labschool.sms.service.ProfessorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

  private final ProfessorService service;

  public ProfessorController(ProfessorService service) {
    this.service = service;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProfessorDto> consulta() {
    var professores = service.buscarTodos();
    var professorDto = new ProfessorDto();
    return professorDto.transformarEmListaDeDtos(professores);
  }

}
