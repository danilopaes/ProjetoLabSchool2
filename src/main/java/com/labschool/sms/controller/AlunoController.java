package com.labschool.sms.controller;

import com.labschool.sms.model.dto.AlunoDto;
import com.labschool.sms.service.AlunoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

  private final AlunoService alunoService;

  public AlunoController(AlunoService alunoService) {
    this.alunoService = alunoService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AlunoDto cadastraAluno(@RequestBody AlunoDto alunoDto) {
    var aluno = alunoDto.transformarEmEntidade();
    var alunoSalvo = alunoService.criarNovoAluno(aluno);

    return alunoDto.transformarEmDto(alunoSalvo);
  }

  @PutMapping("/{codigoDoAluno}")
  @ResponseStatus(HttpStatus.OK)
  public AlunoDto atualizarSituacaoCadastral(
      @PathVariable(value = "codigoDoAluno") Long codigoDoAluno, @RequestBody AlunoDto alunoDto) {
    var alunoAtualizado = alunoService.atualizarSituacaoCadastral(codigoDoAluno,
        alunoDto.getSituacao());
    return alunoDto.transformarEmDto(alunoAtualizado);
  }

  @GetMapping("/{codigoDoAluno}")
  @ResponseStatus(HttpStatus.OK)
  public AlunoDto consulta(@PathVariable(value = "codigoDoAluno") Long codigoDoAluno) {
    var aluno = alunoService.buscarPeloCodigo(codigoDoAluno);
    var alunoDto = new AlunoDto();
    return alunoDto.transformarEmDto(aluno);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<AlunoDto> consulta() {
    var alunos = alunoService.buscarTodos();
    var alunoDto = new AlunoDto();
    return alunoDto.transformarEmListaDeDtos(alunos);
  }

  @DeleteMapping("/{codigoDoAluno}")
  @ResponseStatus(HttpStatus.OK)
  public void excluirAluno(@PathVariable(value = "codigoDoAluno") Long codigoDoAluno) {
    alunoService.excluirAluno(codigoDoAluno);
  }

}
